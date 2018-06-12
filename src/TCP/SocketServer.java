package TCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        SocketServer socket = new SocketServer();
        try {
            socket.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() throws Exception{
        ServerSocket serversock = new ServerSocket(444);
        Socket sock = serversock.accept();
        InputStreamReader IR = new InputStreamReader(sock.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        String message = BR.readLine();
        System.out.println(message);

        if(message!=null){
            PrintStream PS = new PrintStream(sock.getOutputStream());
            PS.println("Message Received!!");
        }

    }
}
