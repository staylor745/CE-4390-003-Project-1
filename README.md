# CE-4390-003-Project-1

This is the group GitHub for Bradley Johnson, Gehrig Wilcox, and Shane Taylor.

Due: April 27, 2023 @ 11:59PM



In this project, you are required to implement a network application using JAVA. It should use
key concepts of intercommunication between programs running on different computers in the
network by using Java Sockets. The application consists of a centralized Math server and two
or more clients. The server will provide basic math calculation services to the client(s


# Requirements
You need to write a server application with following requirements:
1. The server keeps track of all users – track who, when, how long the user attached to the
   server.
2. The server should wait for the client’s request. Upon attachment, the server should log
   the details about the client.
3. The server can have connections simultaneously with multiple clients.
4. The server should be able to accept the string request for basic math calculations and
   show who has sent what request.
5. The server should respond to clients in order of requests it gets from different clients.
6. The server should close connection with client upon request from the client and log it.

You need to write a client application with following requirements:
1. The client gives name during initial attachment to the server and waits till it gets
   acknowledgement from the server for a successful connection.
2. After a successful connection, the client can send basic math calculation requests (at
   least 3) to the server at random times.
3. Another client can join during this time and start sending its requests.
4. The client should sends a close connection request to the server and the application
   terminates. 

Design your protocol:
1. Message format for sending and receiving math calculations.
2. Message format for joining and terminating connection.
3. Format for keeping logs of clients’ activities at server side. 


# Notes:

• You do not need to design GUI for server and client application.

• Specify your assumptions clearly.

• The requirements mentioned above are for open interpretation but with acceptable  reasoning. You should reach out to TA/me in case you need more clarification on
requirements.

    • This project will count for 100 points.
        •  30 points: Design and implementation of Server application.
        •  30 points: Design and implementation of Client application.
        •  20 points: Design and use of communication protocol/format.
        •  20 points: Documentation and quality of code.


# Submission requirements:

At end of semester, you must submit a zip file containing
1. Project report (Word/PDF) format covering

        a. Names and NetIDs for the group members b. Protocol design 
        c. The programming environment you used;
        d. How to compile and execute your programs; 
        e. Parameters needed during execution (i.e., IP, port, may be name)
        f. Good use of comments throughout your files and code
        g. If your application is not complete, specify what works and what doesn't.
        h. Challenges faced
        i. What you have learned doing project
        j. The output screenshots of the application
2. All codes are needed to run your application and a Makefile
3. A design document describing your implementation of the network application.
   Please reach out to TA or me in case of any questions or concerns.