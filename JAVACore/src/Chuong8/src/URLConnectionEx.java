import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;

public class URLConnectionEx {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://cooc.net/");
        try {
            URLConnection connection =  url.openConnection();
          InputStream stream = connection.getInputStream();
          int read;
          byte[] bytes = new byte[600];
          while ((read = stream.read(bytes)) != -1){
              System.out.println(new String(bytes,0,read));
              break;
          }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
