
public class LanzaHilos {
	public static void main(String[] args) {
		//creamos los hilos con los segundos que esperarán
				HiloEspera hiloEsperaDaemon = new HiloEspera(15);
				HiloEspera HiloEsperahilo1 = new HiloEspera(3);
				HiloEspera HiloEsperahilo2 = new HiloEspera(5);
				//ponemos el nombre al hilo utilizando setName() de la clase Thread
				HiloEsperahilo1.setName("hilo 1");
				HiloEsperahilo2.setName("hilo 2");
				hiloEsperaDaemon.setName("demonio");
				
				//Convierto el hilo en tipo daemon
				hiloEsperaDaemon.setDaemon(true);
				
				//Inicializamos el los hilos
				HiloEsperahilo1.start();
				HiloEsperahilo2.start();
				hiloEsperaDaemon.start();
				
				//Hacemos que el hilo principal espere 4 sec con el metodo .sleep(segundos)
				try {
					System.out.println("Soy el hilo principal y voy a esperar 4 segundos");
					Thread.currentThread().sleep(4000);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " interrumpido. ");
				}
				System.out.println("Soy el hilo principal y he terminado");
				//HiloEsperahilo1.interrupt();
				
				//* se puede hacer que el main tambien herede de Thread, y se puede ejecutar igualmente con normalidad
			}
}
class HiloEspera extends Thread {
	//para metro necesario para el objeto
		private int espera;
		//constructor de la clase
		public HiloEspera(int espera) {
			//recibe los segundos como parametro y se multiplica por 1000 para obtener los milisegundos
			this.espera = espera * 1000;
		}

		@Override
		public void run() {
			// se puede quitar Thread.currentThread() porque desciende de la propia clase Thread
			System.out.println("Soy el " + Thread.currentThread().getName() + " empezando.");
			System.out.println("Soy el " + getName() + " y voy a parar "+ espera +" ms");
			if(this.isDaemon()) {
				System.out.println("Es un demonio");
			}
			try {
				Thread.sleep(espera);//
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrumpido.");
			}
			System.out.println(Thread.currentThread().getName() + " acabado.");
		}
}