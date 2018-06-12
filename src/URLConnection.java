import java.io.InputStream;
import java.net.URL;

public class URLConnection {
    public static void main(String[] args) {
        try{
            URL url = new URL("http://www.tutorialspoint.com/java/java_networking.htm");
            java.net.URLConnection urlCon = url.openConnection();
            InputStream stream = urlCon.getInputStream();
            int i;
            while((i=stream.read()) != -1){
                System.out.print((char)i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
