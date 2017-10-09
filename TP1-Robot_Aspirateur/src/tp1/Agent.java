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
			BDI.updateEtat(Capteur.observer());
			Vector<Position> positions= BDI.trouverPositionTruc();
			Vector<GraphNode> init=creerNodes(positions);
			DFS(init.get(0));

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public Vector<GraphNode> creerNodes(Vector<Position> positions) {
		GraphNode node = new GraphNode(positions.get(0));
		Vector<GraphNode> graph = new Vector<GraphNode>();
		graph.add(node);
		for (int i = 1; i < positions.size(); i++) {
			graph.add(new GraphNode(positions.get(i)));
		}
		Vector<GraphNode> voisins = new Vector<GraphNode>();
		for (int k = 0; k < graph.size(); k++) {
			if (!node.equals(graph.get(k))) {
				Position current = node.position;
				Position compare = graph.get(k).position;
				int distance = current.calculDistance(compare);
				graph.get(k).position.setDistance(distance);
				voisins.add(graph.get(k));
			}
		}
		node.neighbors = voisins;
		for (int n = 0; n < node.neighbors.size(); n++) {
			System.out.println(node.neighbors.get(n).position.toString()); // Affiche les voisins du node courant
		}

		return graph;
	}

	// Algorithme exploration non informée, recherche en profondeur
	private void DFS(GraphNode graph) {
		Stack<GraphNode> stack = new Stack<GraphNode>();
		stack.push(graph);
		while (!stack.isEmpty()) {
			GraphNode v = stack.pop();
			GraphNode choix=v;
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
	
	private void DFSReccursif(GraphNode node) {
		node.visited = true;
		GraphNode choix= node;
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

	private void display(Vector<GraphNode> graph) {
		System.out.println(graph.get(0).position.toString());
	}
}
