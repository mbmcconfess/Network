package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPCleint {
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("The client is starting.");
            DatagramSocket socket = new DatagramSocket();
            System.out.println("Enter your message");
            Scanner input = new Scanner(System.in);
            String requestMessage = input.nextLine();

            byte[] requestbyte = requestMessage.getBytes();
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            DatagramPacket requestpacket = new DatagramPacket(requestbyte, requestbyte.length, serverAddress, 7500);

            socket.send(requestpacket);
            byte[] responsebuffer = new byte[256];
            DatagramPacket responsetpacket = new DatagramPacket(responsebuffer, responsebuffer.length);

            socket.receive(responsetpacket);
            String responsemessage = new String(responsebuffer, 0, responsetpacket.getLength());

            System.out.println("Server Response" + responsemessage);
            socket.close();
        }catch (SocketException ex){
            ex.printStackTrace();
        }
    }
}
