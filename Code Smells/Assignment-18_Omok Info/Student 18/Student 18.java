package webServerExcercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class main {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://omok.atwebpages.com/info/");
			var in = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			while((line = in.readLine()) != null) {
				System.out.println(line);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println();
		}
	}
}

