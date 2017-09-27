package tp1;

public class Effecteur {
	static void aspire() {
		Environnement.testAspire();
	}
	static void ramasse() {
		Environnement.testRamasse();
	}
	static void bouge(int x, int y) {
		Environnement.setX(x);
		Environnement.setY(y);
	}
}
