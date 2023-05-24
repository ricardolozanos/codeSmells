package pack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Scanner;

public class Omok_Info {
	   public static void main(String[] args) throws IOException {
	      URL url = new URL("http://omok.atwebpages.com/info/");
	      Scanner scnr = new Scanner(url.openStream());
	      StringBuffer sb = new StringBuffer();
	      while(scnr.hasNext()) {
	         sb.append(scnr.next());
	      }
	      String re = sb.toString();
	      System.out.println("This is the contents of the given URL: "+re);
	   }

}
