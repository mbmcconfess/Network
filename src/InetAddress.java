import java.net.UnknownHostException;

public class InetAddress {
    public static void main(String[] args) {
        java.net.InetAddress ip = null;
        try {
            ip = java.net.InetAddress.getByName("www.merolagani.com");

            System.out.println("Hostname: " + ip.getHostName());
            System.out.println("IP Address: " + ip.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
