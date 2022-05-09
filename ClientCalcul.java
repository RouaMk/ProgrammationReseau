package programmationReseau;

//	Classe Client pour la calculatrice (en mode TCP)
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientCalcul {

		public static void main(String[] args) throws IOException
		{ try {
			InetAddress ip = InetAddress.getLocalHost();
			int port = 4444;
			Scanner sc = new Scanner(System.in);

			// Etape1 : ouvrir la connection socket .
			Socket s = new Socket(ip, port);

			// Etape2 : Communication-obtenir le flux d'entrée et de sortie
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());

			while (true)
			{
				// Entrer l'equation sous la forme "operand1 operation operand2"
				System.out.print("Enter the equation in the form: ");
				System.out.println("'operand operator operand'");
				
				String inp = sc.nextLine();

				if (inp.equals("bye"))
					break;

				// envoyer l'equation au serveur 
				dos.writeUTF(inp);

				// attendre que la demande soit traitée et renvoyée au client
				String ans = dis.readUTF();
				System.out.println("Answer=" + ans);
			}
		}
		catch(Exception e) {
			System.out.println("-1");
		}
	}
}


