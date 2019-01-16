
public class LanzaHilos {
	public static void main(String[] args) {
		Contador contador = new Contador(100);
		
		HiloSumador hiloSumador = new HiloSumador("Hilo sumador", contador, 300);
		HiloRestador hiloRestador = new HiloRestador("Hilo Restador", contador, 300);
		
		hiloSumador.start();
		hiloRestador.start();
		
		try {
			hiloSumador.join();
			hiloRestador.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Valor del contador: " + contador.mostrarValor());
		System.out.println("Programa finalizado");
	}
}
class HiloSumador extends Thread {

	private String nombre;
	private int numero;
	private Contador contador;
	public HiloSumador(String nombre, Contador contador, int numero) {
		super(nombre);
		this.contador = contador;
		this.numero = numero;
	}
	public void run() {
		System.out.println("Hilo en ejecución: " + this.getName());
		for(int i = 0;i < this.numero;i++) {
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				System.out.println("Error al hacer esperar al hilo");
//				e.printStackTrace();
//			}
			contador.incrementa();
		}
		System.out.println("Resultado del hilo en ejecución: " + this.getName() + " : " + this.contador.mostrarValor());
	}
}
class HiloRestador extends Thread {

	private String nombre;
	private int numero;
	private Contador contador;
	public HiloRestador(String nombre, Contador contador, int numero) {
		super(nombre);
		this.contador = contador;
		this.numero = numero;
	}
	public void run() {
		System.out.println("Hilo en ejecución: " + this.getName());
		for(int i = 0;i < this.numero;i++) {
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				System.out.println("Error al hacer esperar al hilo");
//				e.printStackTrace();
//			}
			contador.decrementa();
		}
		System.out.println("Resultado del hilo en ejecución: " + this.getName() + " : " + this.contador.mostrarValor());
	}
}
class Contador {
	
	private int numero = 0;
	
	public Contador(int numero) {
		this.numero = numero;
	}
	public void incrementa() {
		this.numero = this.numero + 1;
	}
	public void decrementa() {
		this.numero = this.numero - 1;
	}
	public int mostrarValor() {
		return this.numero;
	}
}
