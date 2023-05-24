package noapplet.assignments.HW2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConsoleUITest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    private ConsoleUI consoleUI;

    @BeforeEach
    void setUp() {
        consoleUI = new ConsoleUI();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testConstructors() {
        // Test default constructor
        ConsoleUI consoleUI1 = new ConsoleUI();
        assertNotNull(consoleUI1);

        // Test constructor with streams
        InputStream inputStream = new ByteArrayInputStream("2".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ConsoleUI consoleUI2 = new ConsoleUI(inputStream, new PrintStream(outputStream));
        assertNotNull(consoleUI2);
    }

    @Test
    void testChooseGameMode() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        consoleUI = new ConsoleUI(in, System.out);
        int result = consoleUI.chooseGameMode();
        assertEquals(2, result);
    }

    @Test
    void testGetPlayerName() {
        String input = "Diego";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        consoleUI = new ConsoleUI(in, System.out);
        String result = consoleUI.getPlayerName(1);
        assertEquals("Diego", result);
    }

    @Test
    void testShowBoard() {
        Board board = new Board(3);
        board.initializeBoard();
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'O');
        board.makeMove(1, 1, 'X');
        board.makeMove(1, 0, 'O');
        consoleUI.showBoard(board);
        String expected = "  \nX O - \nO X - \n- - - \n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    void testPlayerMove() {
        Board board = new Board(3);
        board.initializeBoard();
        Player player = new HumanPlayer("Diego", 'X', consoleUI);
        String input = "1 2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        consoleUI = new ConsoleUI(in, System.out);
        Coordinate result = consoleUI.playerMove(player);
        Coordinate expected = new Coordinate(1, 2);

        // Testing X
        assertEquals(expected.getX(), result.getX());
        // Testing Y
        assertEquals(expected.getY(), result.getY());
    }

    @Test
    void testChooseMove() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        consoleUI = new ConsoleUI(in, System.out);
        int result = consoleUI.chooseMove();
        assertEquals(2, result);
    }

    @Test
    void testChooseBoardSize() {
        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        consoleUI = new ConsoleUI(in, System.out);
        int result = consoleUI.chooseBoardSize();
        assertEquals(4, result);
    }

    @Test
    void testShowInvalidMove() {
        consoleUI.showInvalidMove();
        assertEquals("Invalid move. Please try again.\n", outContent.toString());
    }

    @Test
    void testShowWinner() {
        Player player = new HumanPlayer("Diego", 'O', consoleUI);
        consoleUI.showWinner(player);
        assertEquals("Diego wins!\n", outContent.toString());
    }

    @Test
    void testShowTie() {
        consoleUI.showTie();
        assertEquals("It's a tie!\n", outContent.toString());
    }

    @Test
    void testGameModeError() {
        consoleUI.GameModeError();
        assertEquals("Please choose a valid option!\n", outContent.toString());
    }
}


