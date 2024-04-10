package client_server_project;
import java.io.*;
import java.net.*;

class fundCOMECHOClient {
    public static void main(String[] args) {
        final String serverAddress = "192.168.1.20"; // Command Prompt > ipconfig to get IPv4
        final int port = 8081;

        try(Socket ksufunccomclientsocket = new Socket(serverAddress, port);
            PrintWriter ksuFundComSeverWriter = new PrintWriter(ksufunccomclientsocket.getOutputStream(), true);
            BufferedReader ksuFundCOmServerReader = new BufferedReader(new InputStreamReader(ksufunccomclientsocket.getInputStream()));
            BufferedReader myTerminalReaderSSA = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Successfully connected this machine to the server. \n Send a message or send `end` to terminate.");

            String myMachineTerminalInputSSA;
            while ((myMachineTerminalInputSSA = myTerminalReaderSSA.readLine()) != null) {
                ksuFundComSeverWriter.println(myMachineTerminalInputSSA);
                String ksuFundComResponseSSA = ksuFundCOmServerReader.readLine();
                System.out.println("Received response: " + ksuFundComResponseSSA);
                if (myMachineTerminalInputSSA.equals("end") || ksuFundComResponseSSA.equals("dne")) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("An error was made. Could not start client: " + e);
            e.printStackTrace();
        }
    }
}

class KSUFunComECHOServerSSA {
    public static void main(String[] args) {
        final int portNumber = 8081;

        try(ServerSocket ksuFundComServerSocketSSA = new ServerSocket(portNumber)) {
            System.out.println("Waiting for connection...");

            while(true) {
                Socket ksuFundComClientSocketSSA = ksuFundComServerSocketSSA.accept();
                System.out.println("New message user connected at: " + ksuFundComClientSocketSSA);

                BufferedReader ksuFundComServerReaderSSA = new BufferedReader(new InputStreamReader(ksuFundComClientSocketSSA.getInputStream()));
                PrintWriter ksuFundComServerWriterSSA = new PrintWriter(ksuFundComClientSocketSSA.getOutputStream(), true);

                String inLine;
                while ((inLine = ksuFundComServerReaderSSA.readLine()) != null) {
                    if(inLine.equals("end")) {
                        ksuFundComServerWriterSSA.println("dne");
                        return;
                    }
                    ksuFundComServerWriterSSA.println(new StringBuilder(inLine).reverse().toString());
                }

                ksuFundComServerReaderSSA.close();
                ksuFundComServerWriterSSA.close();
                ksuFundComClientSocketSSA.close();
            }

        } catch (IOException e) {
            System.out.println("There was an error with server socket");
            e.printStackTrace();
        }
    }
}
