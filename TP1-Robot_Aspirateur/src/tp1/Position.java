package tp1;

public class Position {
	private int x;
	private int y;
	private int distance;
	
	public Position(int x,int y) {
		this.x=x;
		this.y=y;
		this.distance = 0;
	}
	public static int calculDistance(Position a, Position b) {
		return Math.abs((a.x-b.x)+(a.y-b.y));
	}
	
	public void setDistance(int distance) {
		this.distance=distance;
	}
	public int getDistance() {
		return this.distance;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	
}
