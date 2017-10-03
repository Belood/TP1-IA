package tp1;

import java.util.Vector;

public class Etat {
	private Vector<Object> croyance = new Vector<Object>();
	private Vector<Object> desir = new Vector<Object>();
	private Vector<Action> intention;

	Etat() {
		this.croyance.add(new int[10][10]);
		this.croyance.add(0);
		this.croyance.add(0);
		this.desir.add(new int[10][10]);
		this.desir.add(10000);
		this.intention = new Vector<Action>();

	}
	

	private void updateCroyance(Vector<Object> obs) {
		croyance.clear();
		croyance = obs;
	}

	private void updateDesir() {

	}

	private void updateIntention() {

	}

	public static void updateEtat(Vector<Object> obs) {
		updateCroyance(obs);
		updateDesir();
		updateIntention();
	}
}
