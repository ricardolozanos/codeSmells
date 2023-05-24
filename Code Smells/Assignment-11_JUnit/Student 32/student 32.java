import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.*;

public class consoleTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final InputStream in = new ByteArrayInputStream("7 8\n".getBytes());
    private console consoleUI;

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(out));
        consoleUI = new console(in, System.out);
    }
    @AfterEach
    public void cleanUp() {
        System.setOut(null);
        System.setIn(System.in);
    }
    @Test
    void welcome() {
        consoleUI.welcome();
        assertEquals("Welcome to the game!\n", out.toString());
    }

    @Test
    void victoryMessage() {
        consoleUI.victoryMessage(1);
        assertEquals("Player 1 wins!\n", out.toString());
    }

    @Test
    void askCoordinates() {
        consoleUI.askCoordinates();
        assertEquals("Enter the coordinates (x,y): ", out.toString());
    }

    @Test
    void invalidInput() {
        consoleUI.invalidInput();
        assertEquals("Invalid input. Please try again.\n", out.toString());
    }

    @Test
    void drawMessage() {
        consoleUI.drawMessage();
        assertEquals("It's a draw!\n", out.toString());
    }

    @Test
    void endMessage() {
        consoleUI.endMessage();
        assertEquals("Thanks for playing!\n", out.toString());
    }

}