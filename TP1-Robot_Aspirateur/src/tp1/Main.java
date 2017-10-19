package tp1;

public class Main {

	// Creation de l'environnement et de l'agent
	public static void main(String[] args) {
		Thread agent = new Thread(new Agent());
		Thread environnement = new Thread(new Environnement());

		environnement.start();
		agent.start();
	}
}
