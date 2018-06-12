package TCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SocketClient{
    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        try {
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() throws Exception{
        Socket sock = new Socket("localhost", 444);
        PrintStream PS = new PrintStream(sock.getOutputStream());
        PS.println("Hello to Server!");

        InputStreamReader IR= new InputStreamReader(sock.getInputStream());

        BufferedReader BR = new BufferedReader(IR);
        String message = BR.readLine();
        System.out.println(message);
    }
}
