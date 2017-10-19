package tp1;

import java.util.Random;

/*L'environnement genere des elements aleatoires dans une case aleatoire toutes les 10ms. 1 correspond à une poussiere, 2 à un bijoux et 3 aux deux. */

public class Environnement implements Runnable {

	private static int carte[][] = new int[10][10]; // carte 10x10 initialement vide
	private static int performance = 0;
	private static int x = 0; /* position initial */
	private static int y = 0; /* du robot */

	public void run() {
		while (true) {
			genererElement(carte);

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
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

	public synchronized static int getPerf() {
		return performance;
	}

	public synchronized static void setX(int valeur) {
		x = valeur;
	}

	public synchronized static void setY(int valeur) {
		y = valeur;
	}

	// fonction permettant de generer des elements aleatoires.
	public void genererElement(int[][] carte) {
		Random ChoixCase = new Random();
		int nb = ChoixCase.nextInt(10);
		Random ChoixCase2 = new Random();
		int nb2 = ChoixCase2.nextInt(10);
		Random element = new Random();
		int elem = element.nextInt(2) + 1;
		if (carte[nb][nb2] == 0) {
			carte[nb][nb2] = elem;
		} else {
			carte[nb][nb2] = 3;
		}

	}

	// le robot peut voir la carte à l'aide de ses capteurs.
	public synchronized static int[][] voirCarte() {

		return carte;
	}

	// Le robot aspire l'element d'une case
	public static synchronized void testAspire() {
		switch (carte[x][y]) {
		case 0:
			// Aspire case vide
			performance--;
			break;
		case 1:
			// poussiere aspirée
			carte[x][y] = 0;
			performance += 5;
			break;
		case 2:
			// bijoux aspiré
			performance -= 100;
			carte[x][y] = 0;
			break;
		case 3:
			// de la poussiere et des bijoux ont été aspirés
			carte[x][y] = 0;
			performance -= 100;
			break;
		}
		performance--;

	}

	// Le robot ramasse l'element d'une case
	public static synchronized void testRamasse() {
		switch (carte[x][y]) {

		case 2:
			// bijoux ramassé
			carte[x][y] = 0;
			performance += 5;
			break;
		case 3:
			// bijoux ramassé mais il reste de la poussiere
			carte[x][y] = 1;
			break;
		default:
			break;
		}
	}

	// ajoute le cout de deplacement de l'intention du robot à l'indice de
	// performance
	public static void addCout(int cout2) {
		performance -= cout2;

	}
}
