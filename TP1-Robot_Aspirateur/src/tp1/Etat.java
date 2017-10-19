package tp1;

import java.util.Vector;

// Etat mental de l'agent
public class Etat {
	private Vector<Object> croyance = new Vector<Object>();
	private Vector<Object> desir = new Vector<Object>();
	private Vector<Noeud> intention = new Vector<Noeud>();

	// mise a jour des croyances de l'agent
	public void updateCroyance(Vector<Object> obs) {
		croyance.clear();
		croyance = obs;

	}

	// mise a jour des desirs de l'agent
	public boolean updateDesir(int nbElem, int distance) {
		boolean choix = false;
		int evalPerf = 4 * (nbElem - 1) - distance;
		if (desir.isEmpty()) {
			choix = true;
			desir.add(evalPerf);
		}

		else {

			desir.add(evalPerf);
			if (evalPerf >= 0) {

				choix = true;
			}
		}
		System.out.println("nombre d'elements: " + (nbElem - 1));
		return choix;
	}

	// mise a jour des intentions de l'agent
	public void updateIntention(Vector<Noeud> solution) {
		this.intention = solution;
	}

	// Retourne un vecteur contenant toutes les positions des elements de la carte
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
					break;
				case 2:
					Position bijoux = new Position(i, j, "Bijoux", 0, Integer.toString(i) + Integer.toString(j));
					liste_position.add(bijoux);
					break;
				case 3:
					Position poussiereEtBijoux = new Position(i, j, "Poussiere et Bijoux", 0,
							Integer.toString(i) + Integer.toString(j));
					liste_position.add(poussiereEtBijoux);
					break;
				}
			}
		}
		return liste_position;
	}
}
