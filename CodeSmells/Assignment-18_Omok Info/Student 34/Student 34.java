package excs;
import java.net.*;
import java.io.*;

public class omokInfo {
    public static void main(String[] args) throws Exception {
        String stringRead;

        URL omokLink = new URL("http://omok.atwebpages.com/info/");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(omokLink.openStream()));
        while ((stringRead = in.readLine()) != null)
            System.out.println(stringRead);
        in.close();
    }

}
