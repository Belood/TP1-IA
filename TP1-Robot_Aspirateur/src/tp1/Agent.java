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
			Etat.updateEtat(Capteur.observer());
			display(creerGraph(BDI));
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public Vector<GraphNode> creerGraph(Etat BDI) {
		Vector<Position> positions=BDI.trouverPositionTruc();
		Vector<GraphNode> graph= new Vector<GraphNode>();
		for(int i=0;i<positions.size();i++) {
			graph.add(new GraphNode(positions.get(i)));
		}
		
		for(int n=0;n<graph.size();n++) {
			Vector<GraphNode> voisins=new Vector<GraphNode>();
			for(int k=0;k<graph.size();k++) {
				if (!graph.get(k).equals(graph.get(n))){
					voisins.add(graph.get(k));
				}
			}
			graph.get(n).neighbors=voisins;
		}
		return graph;
	}
	private void display(Vector<GraphNode> graph) {
		for(int i=0;i<graph.size();i++) {
			int x = graph.get(i).position.getX();
			int y = graph.get(i).position.getY();
			System.out.println("X: "+x+" Y: "+y + " nombre de voisin : "+graph.get(i).neighbors.size());
		}
	}
}
