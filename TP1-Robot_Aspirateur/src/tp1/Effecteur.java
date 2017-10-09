package tp1;

import java.util.Vector;

public class Effecteur {
	public static synchronized void work (Vector<GraphNode> graph) {
		for(int i =1;i<graph.size();i++) {
			int cout = graph.get(i-1).position.calculDistance(graph.get(i).position);
			//System.out.println("nb d'elements : " + (graph.size()-1));
			System.out.println("distance : " + cout);
			bouge(graph.get(i).position.getX(),graph.get(i).position.getY(),cout);
			switch(graph.get(i).position.getObjet()) {
			case "Poussiere" :
				aspire();
				break;
			case "Bijoux" :
				ramasse();
				break;
			case "Poussiere et Bijoux" :
				ramasse();
				aspire();
				break;
			}
			
		}
		System.out.println("performance : "+Environnement.getPerf());
		Environnement.setPerf();
		
	}
	
	public static void aspire() {
		Environnement.testAspire();
	}
	public static void ramasse() {
		Environnement.testRamasse();
	}
	public static void bouge(int x, int y,int cout) {
		System.out.println("robot en " + Environnement.getX()+" "+Environnement.getY()+" puis bouge");
		Environnement.setX(x);
		Environnement.setY(y);
		Environnement.addCout(cout);
		System.out.println("robot en "+x+" "+y);
	}
}