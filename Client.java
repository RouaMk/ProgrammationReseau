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
	
	// données à envoyer : chaîne de caractères saisie au clavier
	Scanner sc= new Scanner(System.in);  
	System.out.print("Enter a string: ");  
	String str= sc.nextLine();              
	
	byte[] data = (str).getBytes();
	
	// création du paquet avec les données et en précisant l'adresse du serveur (@IP et port sur lequel il écoute : 4036)
	packet = new DatagramPacket(data, data.length, adr, 4036);
	// création d'une socket, sans la lier à un port particulier
	socket = new DatagramSocket();
	// envoi du paquet via la socket
	socket.send(packet);
	}
	catch(Exception e){
		e.printStackTrace();
	}
  }	
}
