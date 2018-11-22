
public class LanzaHilos207{
	public static void main(String args[]) {
		//Declaro los objetos Hilos te tipo HiloEsperaNseg pasando cómo parámetro 3 y 5 seg.
		HiloEsperaNseg Hilo1 = new HiloEsperaNseg(3);
		HiloEsperaNseg Hilo2 = new HiloEsperaNseg(5);
		
		//Definimos los nombres de los hilos utilizando el método setName() de la clase HiloEsperaNseg
		Hilo1.setName("hilo 1");
		Hilo2.setName("hilo 2");
		
		//Inicializamos los dos hilos
		Hilo1.start();
		Hilo2.start();
		
		//El hilo principal espera 4 seg con el método sleep()
		try {
			System.out.println("Soy el hilo principal y voy a esperar 4 segundos");
			Thread.currentThread().sleep(4000);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrumpido. ");
			return;
		}
		System.out.println("Soy el hilo principal y he terminado");
		
		
		
}
}
