package tp1;

import java.util.Vector;

// Effecteur de l'agent
public class Effecteur {

	// Réalise les actions qui correspondent à l'intention de l'agent
	public synchronized void work(Vector<Noeud> graph) {
		for (int i = 1; i < graph.size(); i++) {
			int cout = graph.get(i - 1).position.calculDistance(graph.get(i).position);
			bouge(graph.get(i).position.getX(), graph.get(i).position.getY(), cout);
			switch (graph.get(i).position.getObjet()) {
			case "Poussiere":
				aspire();
				break;
			case "Bijoux":
				ramasse();
				break;
			case "Poussiere et Bijoux":
				ramasse();
				aspire();
				break;
			}
		}
	}

	public synchronized static void aspire() {
		Environnement.testAspire();
	}

	public synchronized static void ramasse() {
		Environnement.testRamasse();
	}

	public synchronized static void bouge(int x, int y, int cout) {
		Environnement.setX(x);
		Environnement.setY(y);
		Environnement.addCout(cout);
	}

	public synchronized void resetPerf() {
		Environnement.resetPerf();
	}
}