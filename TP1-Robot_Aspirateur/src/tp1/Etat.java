package tp1;

import java.util.Vector;

public class Etat {
	private static Vector<Object> croyance = new Vector<Object>();
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
	

	private static void updateCroyance(Vector<Object> obs) {
		croyance.clear();
		croyance = obs;
	}

	private static void updateDesir() {

	}

	private static void updateIntention() {

	}

	public static void updateEtat(Vector<Object> obs) {
		updateCroyance(obs);
		updateDesir();
		updateIntention();
	}
	public static Vector<Position> trouverPositionTruc(){
		Vector<Position> liste_position= new Vector<Position>();
		liste_position.add(new Position((int)croyance.get(1),(int)croyance.get(2)));
		int[][] env=(int[][])croyance.get(0);
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(env[i][j]!=0) {
					liste_position.add(new Position(i,j));
				}
			}
		}
		return liste_position;
	}
}

