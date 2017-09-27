package tp1;

import java.util.Arrays;

public class Agent implements Runnable {
	private Capteur capteur;
	private Effecteur effecteur;
	private Etat BDI;
	private Boolean isAlive;

	Agent() {
		this.capteur = new Capteur();
		this.effecteur = new Effecteur();
		this.BDI = new Etat();
		this.isAlive = true;

	}

	@Override
	public void run() {
		while (true) {
			BDI.updateEtat(Capteur.observer());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
