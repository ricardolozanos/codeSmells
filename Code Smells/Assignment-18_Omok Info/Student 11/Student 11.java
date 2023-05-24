import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // synchronous
        String address = "http://omok.atwebpages.com/info/";
        try{
            URL url = new URL(address);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.setRequestMethod("GET");
            request.setRequestProperty("Content-Type","text/json"); // not necessary in this case but defines the content
            Scanner stream = new Scanner(new InputStreamReader(request.getInputStream()));
            StringBuilder builder = new StringBuilder();
            while(stream.hasNextLine()){
                builder.append(stream.nextLine());
            }
            System.out.printf("""
                    Response
                    Status Code : %d (%s)
                    Content : %s""",
                    request.getResponseCode(),request.getResponseMessage(),builder);
            request.disconnect();
        }
        catch (MalformedURLException e){
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}