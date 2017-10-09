package tp1;

import java.util.Vector;

public class GraphNode implements Comparable<GraphNode> {
	public Vector<GraphNode> neighbors;
    public Position position;
    public boolean visited;

    public GraphNode(Position position) {
        this.position=position;
        this.visited = false;
    }

	public int compareTo(GraphNode o) {
		if((this.position.getX()==o.position.getX()) && (this.position.getY()==o.position.getY())) {
			return 0;
		}
		else return 1;
		
	}
	
	public void neighborsUpdate() {
		this.position.setDistance(0);
		for (int k = 0; k < this.neighbors.size(); k++) {
				if(!neighbors.get(k).visited) {
					Position current = this.position;
					Position compare = this.neighbors.get(k).position;
					int distance = current.calculDistance(compare);
					this.neighbors.get(k).position.setDistance(distance);	
				}				
		}

	}
}



