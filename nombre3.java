import java.util.Scanner;
import java.io.*;
public class nombre3{
	public static void main (String args[]){
	System.out.println("Introduce tu nombre");
	Scanner sc = new Scanner(System.in);
	String nombre = sc.nextLine();
	FileWriter fichero = null;
	PrintWriter pw = null;
try {
	fichero =new FileWriter("FicheroNombreHolaMundo.txt");
	pw=new PrintWriter(fichero);
	for(int i=0;i<21;i++){
	System.out.println("Hola "+nombre);
	pw.println( "Hola "+nombre + "\n");
	}
	fichero.close();
	} catch (Exception ex) {
		System.out.println("Mensaje de la excepción: " + ex.getMessage());
	}

}
}
