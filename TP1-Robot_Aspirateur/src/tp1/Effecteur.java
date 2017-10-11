package tp1;

import java.util.List;
import java.util.Vector;

public class Effecteur {
	public synchronized void work (Vector<Noeud> intentions) {
		for(int i =1;i<intentions.size();i++) {
			int cout = intentions.get(i-1).position.calculDistance(intentions.get(i).position);
			
			//System.out.println("nb d'elements : " + (intentions.size()-1));
			System.out.println("distance : " + cout);
			bouge(intentions.get(i).position.getX(),intentions.get(i).position.getY(),cout);
			switch(intentions.get(i).position.getObjet()) {
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