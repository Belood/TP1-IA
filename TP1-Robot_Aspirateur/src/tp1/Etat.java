package tp1;

import java.util.Vector;

public class Etat {
	private static Vector<Object> croyance = new Vector<Object>();
	private static Vector<Object> desir = new Vector<Object>();
	private static Vector<Action> intention;

	Etat() {
		this.croyance.add(new int[10][10]);
		this.croyance.add(0);
		this.croyance.add(0);
		this.desir.add(new int[10][10]);
		this.desir.add(10000);
		this.intention = new Vector<Action>();

	}

	private static void updateCroyance(Vector<Object> obs) {
		croyance.clear();
		croyance = obs;
	}

	private static void updateDesir() {

	}

	private static void updateIntention() {

	}

	public static void updateEtat(Vector<Object> obs) {
		updateCroyance(obs);
		updateDesir();
		updateIntention();
	}
}
