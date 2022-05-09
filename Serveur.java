package programmationReseau;

import java.net.*;
import java.io.*;

//classe serveur pour socket UDP
public class Serveur {

	public static void main(String args[]) {
		
		try {
			DatagramSocket socket;
			DatagramPacket packet;
			
			// cr�ation d'une socket li�e au port 4036
			
			socket = new DatagramSocket(4036);
			
			// tableau de 15 octets qui contiendra les donn�es re�ues
			
			byte[] data = new byte[15];
			// cr�ation d'un paquet en utilisant le tableau d'octets
			packet = new DatagramPacket(data, data.length);
			// attente de la r�ception d'un paquet. Le paquet re�u est plac� dans
			// packet et ses donn�es dans data.
			socket.receive(packet);
			// r�cup�ration et affichage des donn�es (une cha�ne de caract�res)
			
			String chaine = new String(packet.getData(), 0,packet.getLength());
			System.out.println(" recu : "+chaine);		
		}
	
	   catch(Exception e) { 
		   e.printStackTrace();
	   }	
	}
}
