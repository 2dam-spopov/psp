
public class LanzaHilo210 {

	public static void main(String[] args) {
		// Creamos los hilos
		HiloEspera Hilo1 = new HiloEspera();
		HiloEspera Hilo2 = new HiloEspera();

		// Añadimos nombre del hilo con setName()
		Hilo1.setName("hilo 1");
		Hilo2.setName("hilo 2");

		// Iniciamos los hilos con start()
		Hilo1.start();
		Hilo2.start();
		try {
			//El hilo principal esperará 5 segundos
			//Thread.currentThread().interrupt();
			Thread.currentThread().sleep(5000);
			//En caso de que el hilo principal lanzara excepción sería capturada
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + "\t lanzahilos interrumpido. ");
			return;
		}
		//Interrumpimos el hilo 1
		

		Hilo1.interrupt();
		//Mostramos mensaje de fin de programa
		System.out.println("Soy el hilo principal y he terminado");

	}

}

class HiloEspera extends Thread {

	public void run() {
		// Mostramos el nombre del hilo actual
		System.out.println("Soy el " + getName() + " empezando.");
		// Al poder ser interrumpido el hilo mientras duerme, puede lanzar una ecxepción
		try {
			// Tiempo de espera
			Thread.sleep(10000);

			// Capturamos la excepción y el hilo termina gracias al return
		} catch (InterruptedException e) {
			System.out.println(getName() + " interrumpido.");
			return;
		}
		//Mostramos 
		finally{System.out.println(getName() + " acabado.");}
	}
}