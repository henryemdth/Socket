package MenuTCP;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servidor {
	public static void main(String[] args) throws IOException {
		ServerSocket socketservidor = null;
		Socket socketcliente = null;		
		BufferedReader entrada = null;
		PrintWriter salida = null;
		System.out.println("=====================");
		System.out.println("\tSERVIDOR INICIADO");
		try {
			socketservidor = new ServerSocket(8888);
			while(true) {				
				socketcliente = socketservidor.accept();				
				entrada = new BufferedReader(new InputStreamReader(socketcliente.getInputStream()));				
				salida = new PrintWriter( new BufferedWriter(new OutputStreamWriter(socketcliente.getOutputStream())), true);
				String respuesta;				
					while(true) {			
					String opcion = entrada.readLine();
					System.out.println("Opcion "+opcion);
					switch(opcion) {
					case "1":
						respuesta = "PAPEL";
						salida.println(respuesta);
						break;
					case "2":
						respuesta = "PIEDRA";
						salida.println(respuesta);
					case "3":
						respuesta = "TIJERA";
						salida.println(respuesta);
					default:						
						break;
					}
					}
				
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		salida.close();
		entrada.close();		
		socketservidor.close();
		socketcliente.close();
	}
}