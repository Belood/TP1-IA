package tp1;

import java.util.Vector;

public class Capteur {

	/*
	 * static int getPerformance(Environnement env) { return env.getperformance(); }
	 */
	public Vector<Object> observer() {
		Vector<Object> obs = new Vector<Object>();
		obs.add(carte());
		// System.out.println(Arrays.deepToString(carte()));
		obs.add(positionX());
		obs.add(positionY());
		obs.addElement(perf());
		return obs;
	}

	private synchronized static int[][] carte() {
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
		System.out.println("performance: " + i);
		Environnement.setPerf();
		return i;

	}


}
