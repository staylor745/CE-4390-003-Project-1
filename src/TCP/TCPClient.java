package TCP;

import java.io.*;
import java.net.*;


class TCPClient {

    public static void main(String argv[]) throws Exception
    {
        String sentence;
        String modifiedSentence;

        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        // Create new connection to 127.0.0.1:6789
        Socket clientSocket = new Socket("127.0.0.1", 6789);

        // Create writer to server
        PrintWriter outToServer =
                new PrintWriter(clientSocket.getOutputStream(),true);

        // Create reader from server
        BufferedReader inFromServer =
                new BufferedReader(new
                        InputStreamReader(clientSocket.getInputStream()));

        String userInput;
        String serverInput;

        // Wait for user input
        while((userInput = inFromUser.readLine()) != null){
            // Send user input to server
            outToServer.println(userInput);
            // Wait for response from server
            serverInput = inFromServer.readLine();
            // Print out response from server
            System.out.println(serverInput);
            // If the server said goodbye, close program
            if(serverInput.startsWith("GOODBYE")) break;
        }

    }
}

        