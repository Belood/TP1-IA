package tp1;

// chaque element de la carte de l'environnement possede une position
public class Position {
	private String id;
	private int x;
	private int y;
	private int distance;
	private String objet; // Poussiere, Bijoux ou les deux

	public Position(int x, int y, String objet, int distance, String id) {
		this.x = x;
		this.y = y;
		this.objet = objet;
		this.distance = distance;
		this.id = id;
	}

	// Retourne la distance entre 2 positions
	public int calculDistance(Position compare) {
		return (Math.abs(this.x - compare.x) + Math.abs(this.y - compare.y));
	}

	public void setDistance(int distance) {
		this.distance = distance;
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

	public String getId() {
		return this.id;
	}

	// Test si 2 positions sont egales
	public boolean equals(Position position) {
		if (this.x == position.x && this.y == position.y) {
			return true;
		} else
			return false;
	}

	@Override
	public String toString() {
		String text = "Position X: " + this.x + " Y: " + this.y + " Objet: " + this.objet + " distance: " + distance;
		return text;
	}

}
