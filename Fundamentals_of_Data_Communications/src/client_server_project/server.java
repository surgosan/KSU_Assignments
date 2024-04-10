package client_server_project;
import java.io.*;
import java.net.*;


public class server {
    public static void main(String[] args) {
        final int portNumber = 8081;

        try(ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Waiting for connection...");

            while(true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected at: " + clientSocket);

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String inLine;
                while ((inLine = in.readLine()) != null) {
                    if(inLine.equals("end")) {
                        out.println("dne");
                        return;
                    }
                    out.println(new StringBuilder(inLine).reverse().toString());
                }

                in.close();
                out.close();
                clientSocket.close();
            }

        } catch (IOException e) {
            System.out.println("There was an error with server socket");
            e.printStackTrace();
        }
    }
}
