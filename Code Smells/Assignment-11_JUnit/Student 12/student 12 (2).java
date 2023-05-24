import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class ConsoleUITest {
    @Test
    void testConstructor() {
        Board board = new Board();
        InputStream in = System.in;
        PrintStream out = System.out;
        ConsoleUI ui = new ConsoleUI(board, in, out);
        assertNotNull(ui);
    }

    @Test
    void testPrintMessage() {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result, true); // true for auto flushing
        ConsoleUI ui = new ConsoleUI(new Board(), System.in, out);
        String message = "Welcome to Omok!";
        ui.printMessage(message);
        assertEquals(message, result.toString().trim());
    }

    @Test
    void testPrintBoard() {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result, true); // true for auto flushing
        ConsoleUI ui = new ConsoleUI(new Board(), System.in, out);
        int[][] board = {{0, 0},{0, 0}};
        ui.printBoard(board);
        String expectedOutput = "\n0 0\n0 0";
        assertEquals(expectedOutput, result.toString().trim());
    }

    @Test
    void testPromptMove() {
        Board board = new Board();
        String testInput = "7 8\n";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result, true); // true for auto flushing
        ConsoleUI ui = new ConsoleUI(board, in, out);
        ui.printMessage("Welcome to Omok!"); // print to result
        int[] index = ui.promptMove();
        assertArrayEquals(new int[]{7, 8}, index);
    }

    @Test
    void testPromptMode() {
        Board board = new Board();
        String testInput = "3\n";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result, true); // true for auto flushing
        ConsoleUI ui = new ConsoleUI(board, in, out);
        ui.printMessage("Choose mode (1 for Player vs Player, 2 for Player vs Computer):");
        int mode = ui.promptMode(1, 2);
        assertEquals(5, mode);
    }

}