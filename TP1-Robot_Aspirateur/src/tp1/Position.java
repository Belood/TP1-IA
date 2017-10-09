package tp1;

public class Position {
	private int x;
	private int y;
	private int distance; 
	private String objet; // 1 = Poussiere 2= Bijoux, 3=les deux
	
	public Position(int x,int y,String objet,int distance) {
		this.x=x;
		this.y=y;
		this.objet=objet;
		this.distance=distance;
	}
	public int  calculDistance(Position compare) {
		return Math.abs((this.x-compare.x)+(this.y-compare.y));
	}
	
	public void setDistance(int distance) {
		this.distance=distance;
	}
	public int getDistance() {
		return this.distance;
	}
	public String getObjet() {
		return this.objet;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	@Override 
	public String toString() {
		String text="Position X: "+this.x+" Y: "+this.y+" Objet: "+this.objet + " distance: "+distance;
		return text;
	}
	
}
