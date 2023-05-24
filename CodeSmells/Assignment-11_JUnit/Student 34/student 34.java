package HomeWork2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class consoleUITest {

    @Test
    void testprintText() {
        String input = "hello world";
        consoleUI.printText(input);
    }

    @Test
    void testpromtMode(){
        String testInput = "2\n";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result, true);

        consoleUI.promptMode(in,out);

    }


}