import java.io.*;
import java.net.*;

public class Client {
	
	public static void main(String[] args) throws IOException {
		try {
			Socket server = new Socket("localhost", 4000);
			System.out.println("Connected to server");

			ObjectOutputStream output = new ObjectOutputStream(server.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(server.getInputStream());
			
			System.out.println("Starting game on client");
			Pokemon.main(args);
			
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
