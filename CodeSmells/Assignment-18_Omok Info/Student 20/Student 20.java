import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        omokInfo();
    }
    public static void omokInfo() throws IOException {
       var omURL = new URL("http://omok.atwebpages.com/info/") ;
       var doc = new BufferedReader(new InputStreamReader(omURL.openStream()));
       String currLine;
       while((currLine = doc.readLine()) != null){
           System.out.println(currLine);
       }
    }
}