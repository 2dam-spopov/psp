public class LanzaHilos {
	public static void main(String[] args) {
		//Se crean los hilos HiloConParametros
		HiloConParametros hilo1 = new HiloConParametros("Carles", 7 );
		HiloConParametros hilo2 = new HiloConParametros("Pablo",  5 );
		HiloConParametros hilo3 = new HiloConParametros("Jordi", 3 );
		
		System.out.println("Lanzando los hilos...");
		//Lanzamos los hilos
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		try {
			//El proceso padres esperará a los hilos hijos
			hilo1.join();
			hilo2.join();
			hilo3.join();
		}catch(Exception e) {
			System.out.println("Error al esperar a los hilos secundarios");
		}
		
		System.out.println("Hilos finalizados");
		System.out.println("Fin del programa principal");
}
}
class HiloConParametros extends Thread {
	//Creamos una clase que hereda de Thread y cremos una variable de la clase
	public String parametro;
	public int repeticion;
	//Constructor con parametros donde recoge el nombre y las iteraciones
	public HiloConParametros(String parametro, int repeticion) {
		//Se llama al constructor de la superclase Thread pasando nombre como parámetro
		super(parametro);
		//this.setName(parametro);
		//Y al constructor de la subclase el numero de repeticiones
		this.repeticion = repeticion;
	}
	public void run() {
		for(int i = 1; i <= this.repeticion; i++) {
			//También podría ser posible poner simplemente getName()
			System.out.println(" Nombre del hilo: " +Thread.currentThread().getName()+ " ->  iteración: " + i);
		}
	}
}