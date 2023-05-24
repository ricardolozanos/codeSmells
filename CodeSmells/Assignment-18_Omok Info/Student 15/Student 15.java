import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class OmokInfo {

    public OmokInfo() throws IOException{
        try {
            URL url = new URL("http://omok.atwebpages.com/info/");

            URLConnection conn = url.openConnection();
            HttpURLConnection connection = (HttpURLConnection) conn;
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String input;
                StringBuilder pageContent = new StringBuilder();
                while ((input = in.readLine()) != null) {
                    pageContent.append(input);
                }
                in.close();
                System.out.println(pageContent.toString());
            } else {
                System.out.println("Error: couldn't data");
            }

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new OmokInfo();

    }
}
