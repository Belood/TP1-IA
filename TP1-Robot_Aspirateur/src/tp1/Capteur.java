package tp1;

import java.util.Vector;

// Capteur de l'agent
public class Capteur {

	// Observe l'environnement. Retourne la carte, la position initial de l'agent et sa performance actuelle
	public Vector<Object> observer() {
		Vector<Object> obs = new Vector<Object>();
		obs.add(carte());
		obs.add(positionX());
		obs.add(positionY());
		obs.addElement(perf());
		return obs;
	}

	public synchronized int[][] carte() {
		return Environnement.voirCarte();
	}

	private static int positionX() {
		return Environnement.getX();

	}

	private static int positionY() {
		return Environnement.getY();
	}

	public synchronized int perf() {
		int i = Environnement.getPerf();
		return i;
	}

}
