package OmokInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class OmokInfo {

    public static void main(String[] args){
        try {
            var url = new URL("http://omok.atwebpages.com/info/");
            var in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while((line = in.readLine()) != null){
                System.out.println(line);
            }
        } catch (MalformedURLException e){
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
