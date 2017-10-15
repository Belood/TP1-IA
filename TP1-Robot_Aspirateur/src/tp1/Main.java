package tp1;

public class Main {
	public static void main(String[] args) {
		Thread agent = new Thread(new Agent());
		Thread environnement = new Thread(new Environnement());

		environnement.start();
		agent.start();
	}
}
