package client_server_project;
import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        final String serverAddress = "192.168.1.20"; // Command Prompt > ipconfig to get IPv4
        final int port = 8081;

        try(Socket socket = new Socket(serverAddress, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Successfully connected to server. \n Send a message or send `end` to terminate.");

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                String response = in.readLine();
                System.out.println("Received response: " + response);
                if (userInput.equals("end") || response.equals("dne")) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("An error was made. Could not start client: " + e);
            e.printStackTrace();
        }
    }
}
