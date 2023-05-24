package exercises.OmokInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebServiceAccess {
    public static void main(String[] args) throws IOException {
        // Specify the URL of the web service
        String url = "http://omok.atwebpages.com/info/";

        // Create a URL object for the web service
        URL conn = new URL(url);

        // Open a connection to the web service
        HttpURLConnection con = (HttpURLConnection) conn.openConnection();

        // Set the request method to GET
        con.setRequestMethod("GET");

        // Read the response from the web service
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Print the response JSON string to the console
        System.out.println(response.toString());
    }
}
