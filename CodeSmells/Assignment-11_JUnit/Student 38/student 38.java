import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class ConsoleInterfaceTest {
    private final String testInput = "1\nplayer1\nA1\n";
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    private ConsoleInterface ui;
    private Board board;

    @BeforeEach
    public void setUp(){
        board = new Board(15);
        ui = new ConsoleInterface(board);
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }
    @AfterEach
    public void tearDown(){
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
    @Test
    void testPromptGameMode() {
        GameMode gameMode1 = new GameMode("Game Mode 1");
        GameMode gameMode2 = new GameMode("Game Mode 1");
        String input = "1\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        assertEquals(gameMode1, testIn.toString());
    }

    @Test
    void testPromptName() {
        String input = "player1";
        testIn = new ByteArrayInputStream(input.getBytes());
        assertEquals("player1", testIn.toString());
    }
    @Test
    void testDisplayMessage() {
        final String message = "test message";
        final String expectedOutput = message + "\n";
        ui.displayMessage(message);
        assertEquals(expectedOutput, testOut.toString());
    }
    @Test
    void testPromptMove() {
        testIn = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(testIn);
        int[] expected = new int[]{0, 0};
        assertArrayEquals(expected, ui.promptMove("player 1",Stone.RED));
    }
    @Test
    void testDisplayBoard() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        ui.displayBoard();
        assertEquals(outputStreamCaptor.toString(), outputStreamCaptor.toString());
    }
}