package tp1;

import java.util.ArrayList;
import java.util.List;

public class Noeud {
	 public Position position;
	 public Noeud parent;
	 public List<Noeud> enfants;
	 
	 public Noeud() {
		 super();
	 }
	 
	 public Noeud(Position position) {
	        this.position=position;
	    }
	 
	 public void setEnfants(List<Noeud> enfants) {
	        this.enfants = enfants;
	    }
	 
	 public void addEnfant(Noeud enfant) {
		 if (enfants == null) {
	            enfants = new ArrayList<Noeud>();
	        }
		enfants.add(enfant);
	 }
	 
	 public Position getPosition() {
		 return this.position;
	 }
	 
	 public void setParent(Noeud parent) {
		 this.parent=parent;
	 }
	 
	 public Noeud getParent() {
		 return this.parent;
	 }
	 
	 public void show() {
		 System.out.println(position.getId());
	 }
}
