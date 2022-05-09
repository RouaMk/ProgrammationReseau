package programmationReseau;
// 	Classe Serveur pour la calculatrice (en mode TCP)
import java.io.*;
import java.net.*;
import java.util.*;

public class ServeurCalcul {
	
		public static void main(String args[]) throws IOException
		{
			try {
		
			// Etape 1 : Etablir la connection socket 
			ServerSocket ss = new ServerSocket(4444);
			Socket s = ss.accept();

			// Etape 2 : Traitement de la demande .
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());

			while (true)
			{
				// attend le input 
				String input = dis.readUTF();

				if(input.equals("bye"))
					break;

				System.out.println("Equation received:-" + input);
				int result;

				//utiliser le StringTokenizer pour diviser l'equation en operande et equation
				StringTokenizer st = new StringTokenizer(input);

				int oprnd1 = Integer.parseInt(st.nextToken());
				String operation = st.nextToken();
				int oprnd2 = Integer.parseInt(st.nextToken());

				// effectuer l'opération requise.
				if (operation.equals("+"))
				{
					result = oprnd1 + oprnd2;
				}

				else if (operation.equals("-"))
				{
					result = oprnd1 - oprnd2;
				}
				else if (operation.equals("*"))
				{
					result = oprnd1 * oprnd2;
				}
				else
				{
					result = oprnd1 / oprnd2;
				}
				System.out.println("Sending the result...");

				// renvoyer le résultat au client.
				dos.writeUTF(Integer.toString(result));
			}
		
	}
		catch(Exception e) {
			System.out.println("-1");
		}
	}	
}

