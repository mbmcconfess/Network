package UDP;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        try{
            System.out.println("The server is starting");
            DatagramSocket socket = new DatagramSocket(7500);
            boolean serverActive = true;
            byte[] buffer = new byte[256];

            DatagramPacket incomepacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(incomepacket);
            InetAddress clientAddress = incomepacket.getAddress();
            int clientPrt = incomepacket.getPort();
            String message = new String(buffer, 0, incomepacket.getLength());
            System.out.println("Server Recieved: " + message);

            String reply = message + " is sent to server.";
            byte[] replybytes = reply.getBytes();
            DatagramPacket replypacket = new DatagramPacket(replybytes, replybytes.length, clientAddress, clientPrt);
            socket.send(replypacket);
            socket.close();
        }catch (SocketException ex){

            ex.printStackTrace();
        }

    }
}
