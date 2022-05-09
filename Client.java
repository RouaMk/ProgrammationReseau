package programmationReseau;

import java.net.*;
import java.io.*;
import java.util.*;

//class client pour socket UDP
public class Client {
	public static void main(String [] args)
	{
	try {	
	InetAddress adr;
	DatagramPacket packet;
	DatagramSocket socket;
	
	// adr contient l'@IP de la partie serveur
	
	adr = InetAddress.getByName("localhost");
	
	// donn�es � envoyer : cha�ne de caract�res saisie au clavier
	Scanner sc= new Scanner(System.in);  
	System.out.print("Enter a string: ");  
	String str= sc.nextLine();              
	
	byte[] data = (str).getBytes();
	
	// cr�ation du paquet avec les donn�es et en pr�cisant l'adresse du serveur (@IP et port sur lequel il �coute : 4036)
	packet = new DatagramPacket(data, data.length, adr, 4036);
	// cr�ation d'une socket, sans la lier � un port particulier
	socket = new DatagramSocket();
	// envoi du paquet via la socket
	socket.send(packet);
	}
	catch(Exception e){
		e.printStackTrace();
	}
  }	
}
