package ContarUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class servidor {
	 public static void main(String[] args) {
		try {
			System.out.println("=============================\n\tSERVIDOR INICIADO");
			DatagramSocket socketUDP = new DatagramSocket(8888);
			byte[] bufer = new byte[1024];
			
			while(true) {
				DatagramPacket peticion = new DatagramPacket(bufer,bufer.length);
				socketUDP.receive(peticion);
				
				String men = new String(peticion.getData());
				System.out.println("Datos: "+men);
				String cadena = recuperadato(men, peticion.getLength());
				Scanner sc=new Scanner(cadena);
				int cantidad = contar(sc);				
				String env = "Tiene: "+cantidad+" palabras"; 
				byte[] enviar = env.getBytes();
				DatagramPacket mensaje = new DatagramPacket(enviar, env.length(), peticion.getAddress(), peticion.getPort());
				socketUDP.send(mensaje);
				
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	 public static int contar(Scanner x) {
		 int n=0;
		 while(x.hasNext()) {
			 n++;
			 x.next();
		 }
		 return n;
	 }
	 public static String recuperadato(String cad, int tam) {
		 String res = " ";
		 for(int i = 0; i<tam; i++) {
			 res += cad.charAt(i);
		 }
		 return res;
	 }

}