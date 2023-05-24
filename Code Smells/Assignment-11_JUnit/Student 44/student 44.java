
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConsoleTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream inContent = new ByteArrayInputStream("1\n2\n3\n".getBytes());
    private Console console;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        console = new Console();
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setIn(System.in);
    }

    @Test
    public void testWelcome() {
        console.printWelcome();
        assertEquals("Welcome to Omok!\n", outContent.toString());
    }

    @Test
    public void testScanMode() {
        int mode = console.scanMode();
        assertEquals(0, mode);
    }

    @Test
    public void testGetInput() {
        int[] input = console.getInput();
        assertEquals(2, input[0]);
        assertEquals(3, input[1]);
    }

    @Test
    public void testVictoryMessage() {
        console.victoryMessage(1);
        assertEquals("Player 1 wins!\n", outContent.toString());
    }

    @Test
    public void testAskCoordinates() {
        console.askCoordinates();
        assertEquals("Enter the coordinates (x,y): ", outContent.toString());
    }

    @Test
    public void testInvalidInput() {
        console.invalidInput();
        assertEquals("Invalid input. Please try again.\n", outContent.toString());
    }

    @Test
    public void testDrawMessage() {
        console.drawMessage();
        assertEquals("It's a draw!\n", outContent.toString());
    }

    @Test
    public void testEndMessage() {
        console.endMessage();
        assertEquals("Thanks for playing!\n", outContent.toString());
    }

    @Test
    public void testBoard() {
        int[][] board = {{0, 0, 0}, {0, 1, 2}, {0, 2, 1}};
        console.printBoard(board);
        assertEquals("  0 1 2 \n0 - - - \n1 - X O \n2 - O X \n", outContent.toString());
    }
}
