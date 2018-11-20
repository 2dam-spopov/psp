public class HiloEspera extends Thread {
	public void run() {
		System.out.println("Soy el " + getName() + " empezando, espera 3 segundos.");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(getName() + " interrumpido.");
			return;
		}
		System.out.println(getName() + " acabado.");
	}
}