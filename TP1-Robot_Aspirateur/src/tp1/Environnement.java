package tp1;


import java.util.Arrays;
import java.util.Random;

public class Environnement implements Runnable {
	
	private static int carte[][]= new int [10][10];
	private static int poussiere = 1;
	private static int bijoux = 2;
	private static int performance = 0;
	private static int x = 0;
	private static int y = 0;
	
	public void run() {
		while(true) {
		genererElement(carte);
		//testAspire();
		//testRamasse();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public static int getX() {
		return x;
	}
	
	public static int getY() {
		return y;
	}
	public static int getPerf() {
		return performance;
	}
	
	public synchronized static void setX(int valeur) {
		x=valeur;
	}
	
	public synchronized static void setY(int valeur) {
		y=valeur;
	}
	
	public void genererElement(int[][] carte) {
		Random ChoixCase = new Random();
		int nb = ChoixCase.nextInt(10);
		Random ChoixCase2 = new Random();
		int nb2 = ChoixCase2.nextInt(10);
		//setX(nb);
		//setY(nb2);
		Random element = new Random();
		int elem = element.nextInt(2)+1;
		if(carte[nb][nb2]==0) {
			carte[nb][nb2]=elem;
		}
		else {
			carte[nb][nb2]=3;
		}
		
		
		
	}
	public synchronized static int[][] voirCarte() {
		return carte;
	}
	
	public static synchronized void testAspire() {
		System.out.println(Arrays.deepToString(carte));
		switch(carte[x][y]) {
		case 0 :
			System.out.println("Aspire case vide");
			performance--;
			break;
		case 1 :
			System.out.println("bravo! poussiere ramassée");
			carte[x][y]=0;
			performance+=2;
			break;
		case 2 :
			System.out.println("bijoux aspiré :/");
			performance--;
			carte[x][y]=0;
			break;
		case 3 :
			System.out.println("de la poussiere et des bijoux ont été aspirés :/");
			carte[x][y]=0;
			performance--;
			break;
		}
		performance--;
	//	System.out.println("cout :" + performance);
		System.out.println(Arrays.deepToString(carte));
	}
	
	public static synchronized void testRamasse() {
		System.out.println(Arrays.deepToString(carte));
		switch(carte[x][y]) {
		case 0 :
			System.out.println("Ramasse case vide");
			performance--;
			break;
		case 1 :
			System.out.println("ramassage de poussiere :/");
			performance--;
			carte[x][y]=0;
			break;
		case 2 :
			System.out.println("bravo! bijoux ramassé");
			carte[x][y]=0;
			performance+=3;
			break;
		case 3 :
			System.out.println("bravo! bijoux ramassé mais il reste de la poussiere");
			performance+=3;
			carte[x][y]=1;
			break;
		}
		performance--;
		//System.out.println("cout :" + performance);
		System.out.println(Arrays.deepToString(carte));
	}

	public static void addCout(int cout2) {
		performance-=cout2;
		
	}

	public static synchronized void setPerf() {
		performance=0;
		
	}
	
	
	/*public static void main(String[] args) {
		 
		genererElement(carte);
		System.out.println(Arrays.deepToString(carte));

	}*/
}
