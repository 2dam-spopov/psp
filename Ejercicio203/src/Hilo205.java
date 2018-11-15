
public class Hilo205 extends Thread {
	private int numHilo;
	public Hilo205(int numHilo) {
		this.numHilo=numHilo;
	}
	public void run() {
		System.out.println("Comienza el hilo "+numHilo);
		System.out.println("Finaliza el hilo "+numHilo);
	}
}
