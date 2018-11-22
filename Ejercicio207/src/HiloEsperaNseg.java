import java.util.Scanner;


//Declaramos una clase HiloEsperaNseg que ejecutaremos como un hilo
public class HiloEsperaNseg extends Thread{
	
	//Prámetro espera
	private int espera;
	
	//Constructor de la clase, se pasa por parámetro número de segundos.
	public HiloEsperaNseg(int espera) {
		
		//Recibe segundos y los pasa a milisegundos
		this.espera = espera*1000;
	}

	public void run() {
		
		//getname es un método de la clase thread no es necesario poner Thread.currentThread()
		System.out.println("Soy el " + getName() + " empezando.");
		System.out.println("Soy el " + getName() + " y voy a parar "+ espera +" ms");
		try {
			sleep(espera);
		} catch (InterruptedException e) {
			System.out.println(getName() + " interrumpido.");
			return;
		}
		System.out.println(getName() + " acabado.");
}
}
