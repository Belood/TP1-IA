package tp1;

public class Agent implements Runnable {
	private Capteur capteur = new Capteur();
	private Effecteur effecteur = new Effecteur();
	private Etat BDI = new Etat();
	
	@Override
	public void run() {
		while(true) {
			capteur.observer(environnement)
		}
		
	}
	
	
	
}
