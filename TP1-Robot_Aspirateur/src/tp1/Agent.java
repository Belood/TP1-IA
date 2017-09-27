package tp1;

import java.util.Arrays;

public class Agent implements Runnable {
	private Capteur capteur = new Capteur();
	private Effecteur effecteur = new Effecteur();
	private Etat BDI = new Etat();
	
	@Override
	public void run() {
		while(true) {
			BDI.updateBelieve(Capteur.observer());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
