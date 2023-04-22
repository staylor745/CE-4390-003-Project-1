package TCP;

import java.io.*;
import java.net.*;
import java.util.Random;


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



        String userInput;    //Message sent
        String serverInput;  //Message received
        Random random  = new Random();
        int j = random.nextInt(50);

        // Wait for user input
        while((userInput = inFromUser.readLine()) != null){
            // Send user input to server
            outToServer.println(userInput);
            // Wait for response from server
            serverInput = inFromServer.readLine();


            // Print out response from server
            System.out.println(serverInput);

            // the client can send basic math calculation requests (at least 3) to the server at random times.
            for (int i = 0; i< j+3; i++)
            {
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
                System.out.println( inFromServer.readLine());

            }//end for (int i = 0; i< j+3; i++)





            // If the server said goodbye, close program
            if(serverInput.startsWith("GOODBYE")) break;
        }

    }
}

        