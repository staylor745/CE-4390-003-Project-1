package TCP;

import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.UUID;

class TCPClient {

    public static void main(String argv[]) throws Exception
    {

        String sentence;            //Message sent
        String modifiedSentence;    //Message received

        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        // Create new connection to 127.0.0.1:6789
        Socket clientSocket = new Socket("127.0.0.1", 6789);

        // Create writer to server
        PrintWriter outToServer =
                new PrintWriter(clientSocket.getOutputStream(),true);

        // Create reader from server
        BufferedReader inFromServer =
                new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // set name of client
        UUID clientID = UUID.randomUUID();
        outToServer.println("NAME client-" + clientID);
        System.out.println(inFromServer.readLine());

        String serverInput = "";  //Message received
        // the client can send basic math calculation requests (at least 3) to the server at random times.
        Random random = new Random();
        int j = random.nextInt(8) + 3; // random number of 3 to 10 iterations
        for (int i = 0; i< j; i++)
        {
            // sleep for random amount of time from 0-5 seconds
            Thread.sleep(random.nextInt(5000));

            int a = random.nextInt(100);
            int b = random.nextInt(100);

            switch (random.nextInt(4))
            {
                case 0:
                    outToServer.println("MATH " + a + "+" + b);
                    break;
                case 1:
                    outToServer.println("MATH "+ a + "-" + b);
                    serverInput = inFromServer.readLine();
                    break;
                case 2:
                    outToServer.println("MATH " + a + "*" + b);
                    serverInput = inFromServer.readLine();
                    break;
                case 3:
                    outToServer.println("MATH " + a + "/" + b);
                    serverInput = inFromServer.readLine();
                    break;

            }//end switch (random.nextInt(4))
            //print out result
            System.out.println(serverInput);

        }//end for (int i = 0; i< j+3; i++)

        // request to disconnect from server
        outToServer.println("EXIT");
        System.out.println(inFromServer.readLine());
    }
}

        