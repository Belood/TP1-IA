package tp1;

import java.util.Arrays;
import java.util.Vector;

// L'agent observe l'environnement et agit en conséquence
public class Agent implements Runnable {
	private Capteur capteur;
	private Effecteur effecteur;
	private Etat BDI;
	private Boolean isAlive;

	Agent() {
		this.capteur = new Capteur();
		this.effecteur = new Effecteur();
		this.BDI = new Etat();
		this.isAlive = true;

	}

	@Override
	public void run() {

		int sleepTime = 0;
		int perturbation = 1000;
		boolean converge = false;
		while (isAlive) {

			BDI.updateCroyance(capteur.observer());
			Vector<Position> positions = BDI.trouverPositionTruc();
			Vector<Noeud> solution = creerArbreBFS(positions); // Utilisation de Best-First Search
			// Vector<Noeud> solution = creerArbreDFS(positions); // Decommenter pour tester l'algorithme Deep-First Search

			// L'agent ne travail que si c'est en accord avec ses desirs et si l'evaluation
			// de sa performance est suffisante
			if (BDI.updateDesir(solution.size(), testPerf(solution))) {
				System.out.println("Environnement observé: " + Arrays.deepToString(capteur.carte()));
				BDI.updateIntention(solution);
				int a = capteur.perf();
				effecteur.work(solution);
				int b = capteur.perf();
				System.out.println("performance : " + (b - a));
				System.out.println("Environnement nettoyé: " + Arrays.deepToString(capteur.carte()));
				;
				if (sleepTime > perturbation) {
					sleepTime -= perturbation;
					if (perturbation / 2 > 1 && converge == false)
						perturbation = perturbation / 2;
					else {
						perturbation = 0;
						converge = true;
					}
				} else {
					sleepTime += perturbation;
				}
				System.out.println(
						"temps de repos : " + sleepTime + " ms \n" + "perturbation : " + perturbation + " ms \n");

			} else {
				System.out.println("Environnement observé: " + Arrays.deepToString(capteur.carte()));
				;
				System.out.println("Performance négative, le robot ne bouge pas \n");
				perturbation += 5;
				sleepTime += perturbation;
			}

			try {

				Thread.sleep(sleepTime); // Permet de modifier la frequence d'exploration jusqu'a converger vers une
											// valeur optimale

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	// Retourne le cout de deplacement de l'agent pour une intention donnée
	public int testPerf(Vector<Noeud> solution) {

		int distance = 0;
		for (int i = 0; i < solution.size() - 1; i++) {
			distance += solution.get(i).position.calculDistance(solution.get(i + 1).position);
		}
		return distance;
	}

	// Deep-First Search
	public Vector<Noeud> DFS(Noeud noeud, Vector<Position> positions, Vector<Position> addedPosition,
			Vector<Noeud> solution) {

		for (Position position : positions) {
			if (!addedPosition.contains(position)) {
				Noeud enfant = new Noeud(position);
				enfant.setParent(noeud);
				noeud.addEnfant(enfant);
				addedPosition.add(position);
				solution.add(enfant);
				DFS(enfant, positions, addedPosition, solution);

			}
		}
		return solution;
	}

	// Retourne le vecteur d'intention avec DFS
	public Vector<Noeud> creerArbreDFS(Vector<Position> positions) {
		Noeud racine = new Noeud(positions.get(0));
		Vector<Position> addedPosition = new Vector<Position>();
		addedPosition.add(positions.get(0));
		Vector<Noeud> solution = new Vector<Noeud>();
		solution.add(racine);
		DFS(racine, positions, addedPosition, solution);
		return solution;
	}

	// Best-First Search
	public Vector<Noeud> BFS(Noeud noeud, Vector<Position> positions, Vector<Position> addedPosition,
			Vector<Noeud> solution) {

		int heuristique = 20;
		int min = 0;
		for (int i = 1; i < positions.size(); i++) {
			if (!addedPosition.contains(positions.get(i))) {
				if (positions.get(i).calculDistance(noeud.position) < heuristique) {
					heuristique = positions.get(i).calculDistance(noeud.position);
					min = i;
				}

			}
		}
		if (addedPosition.size() < positions.size()) {
			Noeud enfant = new Noeud(positions.get(min));
			enfant.setParent(noeud);
			noeud.addEnfant(enfant);
			addedPosition.add(positions.get(min));
			solution.add(enfant);
			BFS(enfant, positions, addedPosition, solution);

		}

		return solution;
	}

	// Retourne le vecteur d'intention avec BFS
	public Vector<Noeud> creerArbreBFS(Vector<Position> positions) {
		Noeud racine = new Noeud(positions.get(0));
		Vector<Position> addedPosition = new Vector<Position>();
		addedPosition.add(positions.get(0));
		Vector<Noeud> solution = new Vector<Noeud>();
		solution.add(racine);
		BFS(racine, positions, addedPosition, solution);
		return solution;
	}
}
