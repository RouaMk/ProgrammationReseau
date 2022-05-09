package programmationReseau;

import java.net.*;
import java.io.*;

//classe serveur pour socket UDP
public class Serveur {

	public static void main(String args[]) {
		
		try {
			DatagramSocket socket;
			DatagramPacket packet;
			
			// création d'une socket liée au port 4036
			
			socket = new DatagramSocket(4036);
			
			// tableau de 15 octets qui contiendra les données reçues
			
			byte[] data = new byte[15];
			// création d'un paquet en utilisant le tableau d'octets
			packet = new DatagramPacket(data, data.length);
			// attente de la réception d'un paquet. Le paquet reçu est placé dans
			// packet et ses données dans data.
			socket.receive(packet);
			// récupération et affichage des données (une chaîne de caractères)
			
			String chaine = new String(packet.getData(), 0,packet.getLength());
			System.out.println(" recu : "+chaine);		
		}
	
	   catch(Exception e) { 
		   e.printStackTrace();
	   }	
	}
}
