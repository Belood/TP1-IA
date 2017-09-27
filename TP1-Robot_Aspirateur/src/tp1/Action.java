package tp1;

public class Action {
	static void seDeplacer(int x,int y) {
		Effecteur.bouge(x,y);
	}

	static void aspirer() {
		Effecteur.aspire();
	}

	static void ramasser() {
		Effecteur.ramasse();
	}
}
