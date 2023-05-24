package noapplet.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class omokInfo {
    URL omokUrl = new URL("http://omok.atwebpages.com/");

    public omokInfo() throws MalformedURLException {
    }

    public static void main(String[] args) throws IOException {

        try{
            URL omokUrl = new URL("http://omok.atwebpages.com/");
            URL infoOmok = new URL(omokUrl, "info/index.php");
            java.awt.Desktop.getDesktop().browse(infoOmok.toURI());
            System.out.print("Website has been successfully opened.");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
