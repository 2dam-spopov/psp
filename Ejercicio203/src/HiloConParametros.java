import java.util.Scanner;

public class HiloConParametros{
	public static void main(String [] args) throws Exception {
		//Pedimos un número al usuario usado la clase Scanner
		Scanner tcl = new Scanner(System.in);	
		//Creamos Array de hilos 
		System.out.println("Hilos a crear: ");
		int numHilos= tcl.nextInt();
		Hilo205[] arrayHilos;
		arrayHilos = new Hilo205[numHilos];
		//Con el bucle se crean los elementos del array 
		for (int i=0;i<numHilos;i++) {
			arrayHilos[i]=new Hilo205(i+1);
			arrayHilos[i].start();
		}
		
		
		
	}
}
