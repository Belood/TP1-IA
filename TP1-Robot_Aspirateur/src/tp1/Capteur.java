package tp1;

import java.util.Vector;

public class Capteur {

	/*
	 * static int getPerformance(Environnement env) { return env.getperformance(); }
	 */
	public static Vector<Object> observer() {
		Vector<Object> obs = new Vector<Object>();
		obs.add(carte());
		obs.add(positionX());
		obs.add(positionY());
		return obs;
	}

	private static int[][] carte() {
		return Environnement.voirCarte();
	}

	private static int positionX() {
		return Environnement.getX();

	}

	private static int positionY() {
		return Environnement.getY();
	}

}
