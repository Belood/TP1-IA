package tp1;

import java.util.Vector;

public class Etat {
	private Vector<Object> croyance = new Vector<Object>();
	private Vector<Object> desir = new Vector<Object>();
	private Vector<Noeud> intention = new Vector<Noeud>();

	public void updateCroyance(Vector<Object> obs) {
		croyance.clear();
		croyance = obs;
		
	}

	public boolean updateDesir(int elem, int eval, int perf) {
		boolean choix = false;
		int evalPerf = 9*(elem-1) - eval;
		System.out.println("evaluation : "+evalPerf);
		if (desir.isEmpty()) {
			choix = true;
			desir.add(evalPerf);
		}

		else {

			desir.add(perf);
			if (evalPerf >= perf) {

				choix = true;
			}
		}
		System.out.println("nb elements: " + (elem-1) + "\ndistance a parcourir: " + eval);
		return choix;
	}


	public void updateIntention(Vector<Noeud> solution) {
		this.intention=solution;
	}
	
	public Vector<Noeud> exprimerIntention(){
		return this.intention;
	}

	/*
	 * public void updateEtat(Vector<Object> obs) { updateCroyance(obs);
	 * updateDesir(); updateIntention(); }
	 */

	public Vector<Position> trouverPositionTruc() {
		Vector<Position> liste_position = new Vector<Position>();
		Position robot = new Position((int) croyance.get(1), (int) croyance.get(2), "Robot", 0, "0");
		liste_position.add(robot);
		int[][] env = (int[][]) croyance.get(0);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int test = env[i][j];
				switch (test) {
				case 1:
					Position poussiere = new Position(i, j, "Poussiere", 0, Integer.toString(i) + Integer.toString(j));
					liste_position.add(poussiere);
					// System.out.println(poussiere.toString());
					break;
				case 2:
					Position bijoux = new Position(i, j, "Bijoux", 0, Integer.toString(i) + Integer.toString(j));
					liste_position.add(bijoux);
					// System.out.println(bijoux.toString());
					break;
				case 3:
					Position poussiereEtBijoux = new Position(i, j, "Poussiere et Bijoux", 0,
							Integer.toString(i) + Integer.toString(j));
					liste_position.add(poussiereEtBijoux);
					break;
				// System.out.println(poussiereEtBijoux.toString());
				}
			}
		}
		return liste_position;
	}
}
