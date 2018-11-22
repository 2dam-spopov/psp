
public class RunThread {

	public static void main(String[] args) {
		HelloThread hilo = new HelloThread();
		hilo.start();
		System.out.println("Hola desde el hilo principal");
		System.out.println("Proceso acabando");

	}

}
class HelloThread extends Thread {
	//el metodo tun define lo que hace este hilo
	public void run() {
		System.out.println("Hola desde el hilo creado");
	}
}