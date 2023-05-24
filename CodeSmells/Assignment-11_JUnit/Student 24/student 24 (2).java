package noapplet.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleUITest {

    ByteArrayOutputStream result;
    InputStream in;
    PrintStream out;
    ConsoleUI console;

    @BeforeEach
    void setUp(){
        result = new ByteArrayOutputStream();
        console = new ConsoleUI(new PrintStream(result, true));
    }


    @Test
    void testgreeting() {
        console.Greeting();
        assertEquals(result.toString(), "*****\" + \"OMOK\" + \"*****\r\nDesignate the desired size of the board\r\nMust be at least size 15\r\n");
        in = new ByteArrayInputStream("15".getBytes(StandardCharsets.UTF_8));

    }

    @Test
    void testgameMode() {
        console.GameMode();
        assertEquals(result.toString(), "Please select a game mode:\r\n1. Human  |  2. Strategy");
        in = new ByteArrayInputStream("1".getBytes(StandardCharsets.UTF_8));
    }

    @Test
    void testdisplayRules() {
        console.DisplayRules();
        assertEquals(result.toString(), "Make selection by first entering the number for the desired ROW\r\nThen enter the number for the desired COLUMN\r\nThe first person to go will have the designation 'X' and the other will have the designation 'O'\r\nThe first player to have an unbroken line of 5 wins!\r\n");
    }

    @Test
    void testplay() {
    }

    @Test
    void testdisplayWin() {
    }

    @Test
    void testdraw() {
        console.Draw();
        assertEquals(result.toString(), "No moves left, it's a draw!\r\n");
    }

    @Test
    void testrematch() {
        console.rematch();
        assertEquals(result.toString(), "Play again?\r\n1: Yes | 2: No\r\n");
    }
}