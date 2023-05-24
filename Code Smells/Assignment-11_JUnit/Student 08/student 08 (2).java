import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ConsoleUITest {
    ByteArrayOutputStream result;
    InputStream input;
    PrintStream out;
    ConsoleUI console;

    @BeforeEach
    void setup() {
        result = new ByteArrayOutputStream();
        console = new ConsoleUI(new PrintStream(result, true));
    }
    @Test
    void testConsoleUI() {
    }
    @Test
    void testWelcome() {
        console.welcome();
        Assertions.assertEquals(result.toString(), "~~~~ Welcome To Omok ~~~~ \r\n Please select Gamemode (Input number): \r\n 1. Play versus Computer \r\n 2. Play versus Player \r\n");
    }
    @Test
    void testPrintBoard(Board board) {}
    @Test
    void testBoardSize(int x) {

    }
    @Test
    void testEnd() {
        console.end();
        Assertions.assertEquals(result.toString(), "Thanks For playing!!\r\n");
        input = new ByteArrayInputStream("end".getBytes());
    }
    @Test
    void testPrintBoardSize() {
        console.printBoardSize();
        Assertions.assertEquals(result.toString(), "Please Select Board size (minimum 15x15)\r\n");
        input = new ByteArrayInputStream("15".getBytes());
    }

}
