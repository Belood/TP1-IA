package tp1;

import java.util.*;

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
		while (isAlive) {
			BDI.updateEtat(Capteur.observer ());
			Vector<Position> positions = BDI.trouverPositionTruc();
			List<Noeud> solution=creerArbre(positions);
			for(Noeud noeud : solution) {
				noeud.show();
			}
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public List<Noeud> DFS(Noeud noeud, Vector<Position> positions, Vector<Position> addedPosition,List<Noeud> solution) {
		
		for (Position position : positions) {
			if (!addedPosition.contains(position)) {
				Noeud enfant = new Noeud(position);
				enfant.setParent(noeud);
				noeud.addEnfant(enfant);
				addedPosition.add(position);
				solution.add(enfant);
				DFS(enfant, positions, addedPosition,solution);
				
			}
			
			
		}
		return solution;
		//addedPosition.clear();
		
	}
	
	public List<Noeud> creerArbre(Vector<Position> positions) {
		Noeud racine=new Noeud(positions.get(0));
		Vector<Position> addedPosition=new Vector<Position>();
		addedPosition.add(positions.get(0));
		List<Noeud> solution=new Vector<Noeud>();
		DFS(racine,positions,addedPosition,solution);
		return solution;
	}

	// Algorithme exploration non informée, recherche en profondeur
	/*private void DFS(Arbre graph) {
		Stack<Arbre> stack = new Stack<Arbre>();
		stack.push(graph);
		while (!stack.isEmpty()) {
			Arbre v = stack.pop();
			Arbre choix = v;
			if (!v.visited) {
				System.out.println(graph.position.toString());
				for (int n = 0; n < graph.neighbors.size(); n++) {
					System.out.println(graph.neighbors.get(n).position.toString()); // Affiche les voisins du node
																					// courant
				}
				v.visited = true;
				int min = v.neighbors.get(0).position.getDistance();
				for (int i = 0; i < v.neighbors.size(); i++) {
					if (v.neighbors.get(i).position.getDistance() < min) {
						choix = v.neighbors.get(i);
						// On enregistre le node le plus proche
					}
				}
				choix.neighborsUpdate();
				stack.push(choix);
			}
		}
	}

	private void DFSReccursif(Arbre node) {
		node.visited = true;
		Arbre choix = node;
		choix.neighborsUpdate();
		int min = node.neighbors.get(0).position.getDistance();
		System.out.println(choix.position.toString());
		for (int i = 0; i < node.neighbors.size(); i++) {
			if (node.neighbors.get(i).position.getDistance() < min) {
				choix = node.neighbors.get(i);
				// On enregistre le node le plus proche
			}
		}

		DFSReccursif(choix);
	}

	private void display(Vector<Arbre> graph) {
		System.out.println(graph.get(0).position.toString());
	}*/
}
