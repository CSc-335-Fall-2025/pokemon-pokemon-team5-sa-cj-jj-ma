import java.io.*;
import java.net.*;

public class Server {

	public static void main(String[] args) throws IOException {
		try {
			ServerSocket server = new ServerSocket(4000);
			System.out.println("Server started - waiting for connection...");

			Socket connection = server.accept();
			System.out.println("Client accepted");
			ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(connection.getInputStream());
			// Do some IO.
			System.out.println("Starting game on server");
			Pokemon.main(args);
			
			output.writeObject(input);
			System.out.println("Closing conenction");
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
}
