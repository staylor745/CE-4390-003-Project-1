package TCP;

import Backend.MathHelper;

import java.io.*;
import java.net.*;
import java.util.logging.Logger;

class TCPServer {

    public static Logger logger = Logger.getLogger(TCPServer.class.getName());

    public static void main(String argv[]) throws Exception
    {
        // Create TCP Server socket on 6789
        ServerSocket welcomeSocket = new ServerSocket(6789);

        // Accept all connections
        while(true) {
            // Create a new thread for every connection
            new TCPConnection(welcomeSocket.accept()).start();
        }
    }

    static class TCPConnection extends Thread {

        Socket socket;

        String name;

        // Log connection time
        final long connectionTime = System.currentTimeMillis();
        long disconnectTime;
        public TCPConnection(Socket socket){
            this.socket = socket;
            // Report new connection
            logger.info("Accepted Connection from " + socket.getInetAddress() + ":" + socket.getPort());
        }

        public void run(){

            try {
                // Create a writer to client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                // Create a reader from client
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String message;

                // Get messages from client
                while((message = in.readLine()) != null){
                    // We cant process any request until we get a name, and you can only set name once
                    if(name == null){
                        // Client is requesting to set name
                        if(message.startsWith("NAME ")) {
                            name = "[" + socket.getInetAddress() + ":" + socket.getPort() + "] " + message.replaceFirst("NAME ", "");
                            // Report clients name
                            logger.info("Bound name: " + name);
                            // Inform client that we have set name
                            out.println("RECEIVED NAME");
                        }else{
                            // Inform client that they must set name
                            out.println("PLEASE SET NAME");
                        }
                        // Client wants to terminate connection
                    }else if(message.toUpperCase().equals("EXIT")){
                        // Report to client that we accept termination
                        out.println("GOODBYE");
                        // Close connection
                        socket.close();
                        // Cleanup thread
                        break;
                        // Client wants to process math
                    }else if(message.startsWith("MATH ")){
                        // Get math request
                        String req = message.replaceFirst("MATH ","");
                        // Evaluate math
                        String resp = MathHelper.eval(req);
                        // Report request and response
                        logger.info(name + " requested to calculate " + req + ". Sent " + resp);
                        // Inform client of response
                        out.println(resp);
                    }else{
                        // Inform client of invalid command
                        out.println("UNKNOWN COMMAND");
                    }
                }

                // Get time of disconnect
                disconnectTime = System.currentTimeMillis();

                // Log that connection was terminated and how long connection lasted
                logger.info(name + " has terminated connection. Connection duration: " + (disconnectTime - connectionTime) + " ms");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
} 
 

           