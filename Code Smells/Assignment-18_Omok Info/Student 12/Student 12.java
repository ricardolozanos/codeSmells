import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebService {
    public static void main(String[] args) {
        try {
            URL infoURL = new URL("http://omok.atwebpages.com/info/");
            HttpURLConnection httpConn = (HttpURLConnection) infoURL.openConnection();
            httpConn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
