
public class LanzaHilos {
	public static void main(String[] args) {
	Reloj reloj = new Reloj();
		
		HiloTic hiloTic = new HiloTic("HiloTic", reloj, 6);
		HiloTac hiloTac = new HiloTac("HiloTac", reloj, 6);
		
		hiloTic.start();
		hiloTac.start();
		
	}
}

class HiloTic extends Thread{
	
	Reloj reloj;
	int repeticiones;

	public HiloTic(String nombre, Reloj reloj, int repeticiones) {
		super(nombre);
		this.reloj = reloj;
		this.repeticiones = repeticiones;
	}
	
	public void run() {
		for(int i = 0; i < repeticiones; i++) {
			reloj.tic();
		}
	}
}
class HiloTac extends Thread{
	Reloj reloj;
	int repeticiones;
	
	public HiloTac(String nombre, Reloj reloj, int repeticiones) {
		super(nombre);
		this.reloj = reloj;
		this.repeticiones = repeticiones;
	}
	
	public void run() {
		for(int i = 0; i < repeticiones; i++) {
			reloj.tac();
		}
	}
}
class Reloj {
	
	public boolean tic = true;

	public synchronized void tic() {
		
		while(tic == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Tic");
		tic = false;
		notifyAll();
	}
	
	public synchronized void tac() {
		
		while(tic == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Tac");
		tic = true;
		notifyAll();
	}
}