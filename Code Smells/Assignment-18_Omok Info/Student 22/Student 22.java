import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class main {
        private static final String SERVICE_URL = "http://omok.atwebpages.com/info/";

        public static void main(String[] args) {
            try {
                URL url = new URL(SERVICE_URL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept", "application/json");

                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

                String output;
                System.out.println("Output from the server:");
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }

                connection.disconnect();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
