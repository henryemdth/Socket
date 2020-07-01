package MenuTCP;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

public class Cliente {
	//instanciamos el logger
	public static void main(String[] args) throws IOException {
		
		Socket socketcliente = null;
		
		BufferedReader entrada = null;
		PrintWriter salida = null;
		BufferedReader lee = null;		
		
		System.out.println("\tCLIENTE TCP");
		try {
			
			socketcliente = new Socket("localhost", 8888);		
			
			entrada = new BufferedReader(new InputStreamReader(socketcliente.getInputStream()));
			salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketcliente.getOutputStream())), true);			
			String opcion;
			String respuesta;
			
			while(true) {
				System.out.println("=================================");
				System.out.println("****MENU****\n Selecciona una opcion\n Opcion 1 \n Opcion 2 \n Opcion 3.\n Salir (cualquier teclas)\n----------");				
				System.out.print("-->>Ingrese su opcion:\t");
				lee = new BufferedReader(new InputStreamReader(System.in));
				opcion = lee.readLine();
				
				if(opcion.equals("1") || opcion.equals("2") || opcion.equals("3")) {
					salida.println(opcion);
					respuesta = entrada.readLine();
					System.out.println("Respuesta del Servidor: "+respuesta);
					System.out.println("----------------");
				}
				else {
					break;
				}	
			}
			System.out.println("=================================");
			System.out.println("Saliendo......");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//liberamos recursos de los flujos de entrada y salida
		socketcliente.close();
			salida.close();
			entrada.close();
			lee.close();
			
	}
}