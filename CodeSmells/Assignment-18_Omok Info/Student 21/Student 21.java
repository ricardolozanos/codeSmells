package noapplet.example;

import java.io.*;
import java.net.*;

public class OmokInfo {
	public static void main(String[]args) throws IOException{
		var url = new URL("http://omok.atwebpages.com/info/");
		URLConnection conn = url.openConnection();
	
		HttpURLConnection httpConn = (HttpURLConnection) conn;
		httpConn.setAllowUserInteraction(false);
		httpConn.setInstanceFollowRedirects(true);
		httpConn.setRequestMethod("GET");
		httpConn.connect();
	
		if (HttpURLConnection.HTTP_OK == httpConn.getResponseCode()) {
		    var is = httpConn.getInputStream();
		    var in = new BufferedReader(new InputStreamReader(is));
		    String line;
		    while ((line = in.readLine()) != null) {
		        System.out.println(line);
		    }
		    in.close();
		}
	}
}
