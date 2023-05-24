package Misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class OmokInfo {
    public static void main(String[] args) {
        try {
            // Set up the connection
            URL url = new URL("http://omok.atwebpages.com/info/");
            URLConnection conn = url.openConnection();
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();

            if(HttpURLConnection.HTTP_OK == httpConn.getResponseCode()){
                var is = httpConn.getInputStream();
                var in = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = in.readLine()) != null){
                    System.out.println(line);
                }
                in.close();
            }

            // Disconnect
            httpConn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
