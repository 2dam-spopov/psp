import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EjemploStream2 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args )throws IOException {
		ProcessBuilder pb = new ProcessBuilder("ls","-a");
		//ProcessBuilder pb = new ProcessBuilder("java","HolaMundo");
		//pb.directory(new File("/home/serpop/psp/HolaMundo/bin/"));
		Process process = pb.start();
		//Process process = new ProcessBuilder("java","Holamundo1").start();
		InputStream is = process.getInputStream() ;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		InputStream is2 = process.getErrorStream() ;
		InputStreamReader isr2 = new InputStreamReader(is2);
		BufferedReader br2 = new BufferedReader(isr2);
		
		
		String line;
		
		System.out.println("Salida del proceso: " );
		
		while((line=br.readLine())!= null ) {
			System.out.println(line);
	        }

		System.out.println("Salida de error del proceso: " );
		
		while((line=br2.readLine())!= null ) {
			System.out.println(line);
	        }
		
		
}
}