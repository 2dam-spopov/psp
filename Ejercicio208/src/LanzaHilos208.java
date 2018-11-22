
public class LanzaHilos208 {

	public static void main(String[] args) {
		HiloEspera Hilo1 = new HiloEspera(3);
		HiloEspera Hilo2 = new HiloEspera(5);
		Hilo1.setName("hilo 1");
		Hilo2.setName("hilo 2");
		
		
		Hilo1.start();
		Hilo2.start();
		try {
			System.out.println("Soy el hilo principal y voy a esperar a que esperen los hilos");
			Hilo1.join();
			Hilo2.join();
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrumpido. ");
			return;
		}
System.out.println("Soy el hilo principal y he terminado");
	}

}
class HiloEspera extends Thread {
	
	
	private int espera;

	public HiloEspera(int espera) {
		this.espera = espera*1000;
	}

	@Override
	public void run() {
		System.out.println("Soy el " + Thread.currentThread().getName() + " empezando.");
		System.out.println("Soy el " + Thread.currentThread().getName() + " y voy a parar "+ espera +" ms");
		try {
			Thread.sleep(espera);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrumpido.");
			return;
		}
		System.out.println(Thread.currentThread().getName() + " acabado.");
	}
}