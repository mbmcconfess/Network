import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        try{
            URL url = new URL("http://tutorials.jenkov.com:80/java-networking/udp-datagram-sockets.html");

            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Hostname: " + url.getHost());
            System.out.println("Port Number: " + url.getPort());
            System.out.println("Filename: " + url.getFile());
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
