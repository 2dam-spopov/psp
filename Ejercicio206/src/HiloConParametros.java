import java.util.Scanner;

public class HiloConParametros{
	public static void main(String [] args) throws Exception {
		//Pedimos un número al usuario usado la clase Scanner
		Scanner tcl = new Scanner(System.in);	
		//Creamos Array de hilos 
		System.out.println("Hilos a crear: ");
		int numHilos= tcl.nextInt();
		HiloEspera[] arrayHilos;
		arrayHilos = new HiloEspera[numHilos];
		//Con el bucle se crean los elementos del array 
		for (int i=0;i<numHilos;i++) {
			arrayHilos[i]=new HiloEspera();
			arrayHilos[i].start();
		}
		//Creo objeto hilo
		
		HiloEspera h1=new HiloEspera();
		//Imprime por pantalla
		System.out.println("Soy lanzahilos y lanzo hilo espera: ");
		//Ejecuto  el hilo
		h1.start();
		
		
		
		
		
		
		
	}
}
