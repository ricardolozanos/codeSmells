import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;


public class ConsoleUI {

    private final BufferedReader reader;
    

    public ConsoleUI(InputStream inputStream, OutputStream outputStream) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
        this.writer = new PrintWriter(outputStream, true);
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

    
}
