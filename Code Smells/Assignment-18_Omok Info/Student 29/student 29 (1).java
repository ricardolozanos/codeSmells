package counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OmokInfoEx {
	
    public String sendGet(String urlString) {
    	HttpURLConnection con = null;
        try {
            URL url = new URL(urlString);
            con = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        } catch (IOException e) {
            //e.printStackTrace();
	} finally {
	    if (con != null) {
		con.disconnect();
	    }
	}
        return null;
    }
    
    public static void main(String[] args) {
    	
    	String url = "http://omok.atwebpages.com/info/";
        String response = new OmokInfoEx().sendGet(url);
        System.out.println(response);
    	
        //String FORMAT = "http://omok.atwebpages.com/new/";
    	String FORMAT = "http://omok.atwebpages.com/new/?strategy=%s";
        //String FORMAT = "http://omok.atwebpages.com/new/?strategy=t";
        String strategy = "Random";
        String url1 = String.format(FORMAT, strategy);
        String response1 = new OmokInfoEx().sendGet(url1);
        System.out.println(response1);
        
        String FORMAT1 = "http://omok.atwebpages.com/play/?pid=%s&x=%d&y=%d";
        String pid = "6434a6622ac71";
        int x = 7;
        int y = 6;
        String url2 = String.format(FORMAT1, pid, x, y);
        String response2 = new OmokInfoEx().sendGet(url2);
        System.out.println(response2);
    }
}
	

