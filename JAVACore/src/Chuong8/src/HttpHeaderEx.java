import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class HttpHeaderEx {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://cooc.net/");
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            System.out.println("Http method " + connection.getRequestMethod());
            Map<String, List<String>> headers = connection.getHeaderFields();
            BiConsumer<String,List<String>> header = (key, values) -> {
                System.out.println("key : " + key + "Values : " + values);
            };
            headers.forEach(header);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
