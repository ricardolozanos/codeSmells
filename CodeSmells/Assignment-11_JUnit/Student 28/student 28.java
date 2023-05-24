import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class ConsoleUITest {

    @Test
    void consoleUI() {
    }

    @Test
    void printMessage() {
        Board board = new Board();

        String testInput = "Welcome to Omok!";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result, true);

        ConsoleUI ui = new ConsoleUI(board, in, out);
        ui.printMessage(in, out);

        assertEquals("Welcome to Omok!", result.toString());
    }

    @Test
    void promptMode() {
        Board board = new Board();
        String testInput = "1\n";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result, true);
        ConsoleUI ui = new ConsoleUI(board, in, out);
        int index = ui.promptMode(in, out);

        assertEquals(1, index);
    }

    @Test
    void printBoard() {
        String board = new Board.printBoard();
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result, true);
        ConsoleUI ui = new ConsoleUI(board, in, result);
        assertEquals(board, ui.printBoard(result));
    }

    @Test
    void promptMove() {
        Player player = new Player();
        String testInput = "13 6\n";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result, true);

        ConsoleUI ui = new ConsoleUI(board, in, out);
        int index = ui.promptMove(player, in, out);
        assertEquals(1306, index);
    }
}