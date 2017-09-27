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
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public static void setX(int x) {
		Environnement.x=x;
	}
	
	public static void setY(int y) {
		Environnement.y=y;
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
		
		System.out.println(Arrays.deepToString(carte));
		
	}
	public static int[][] voirCarte() {
		return carte;
	}
	
	public static void testAspire() {
		switch(carte[x][y]) {
		case 0 :
			System.out.println("Aspire case vide");
			break;
		case 1 :
			System.out.println("bravo! poussiere ramassée");
			carte[x][y]=0;
			break;
		case 2 :
			System.out.println("bijoux aspiré :/");
			carte[x][y]=0;
			break;
		case 3 :
			System.out.println("de la poussiere et des bijoux ont été aspirés :/");
			carte[x][y]=0;
			break;
		}
	}
	
	public static void testRamasse() {
		switch(carte[x][y]) {
		case 0 :
			System.out.println("Ramasse case vide");
			break;
		case 1 :
			System.out.println("ramassage de poussiere :/");
			carte[x][y]=0;
			break;
		case 2 :
			System.out.println("bravo! bijoux ramassé");
			carte[x][y]=0;
			break;
		case 3 :
			System.out.println("bravo! bijoux ramassé mais il reste de la poussiere");
			carte[x][y]=1;
			break;
		}
	}
	
	
	/*public static void main(String[] args) {
		 
		genererElement(carte);
		System.out.println(Arrays.deepToString(carte));

	}*/
}
