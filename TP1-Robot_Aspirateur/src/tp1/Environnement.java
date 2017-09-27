package tp1;


import java.util.Arrays;
import java.util.Random;

public class Environnement implements Runnable {
	
	public int carte[][]= new int [10][10];
	public static int poussiere = 1;
	public static int bijoux = 2;
	public static int performance = 0;
	
	public void run() {
		while(true) {
		genererElement(carte);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	public void genererElement(int[][] carte) {
		Random ChoixCase = new Random();
		int nb = ChoixCase.nextInt(10);
		Random ChoixCase2 = new Random();
		int nb2 = ChoixCase2.nextInt(10);
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
	public static int[][] voirCarte(int[][] carte) {
		return carte;
	}
	/*public static void main(String[] args) {
		 
		genererElement(carte);
		System.out.println(Arrays.deepToString(carte));

	}*/
}
