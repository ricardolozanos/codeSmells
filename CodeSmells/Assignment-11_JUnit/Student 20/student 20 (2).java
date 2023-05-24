
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
class ConsoleUITest {
    @Test
    void testConsoleUI(){
        Board board = new Board();
        ConsoleUI ui = new ConsoleUI(board, System.in, System.out);
        assertEquals(System.in,ui.getIn());
        assertEquals(System.out,ui.getOut());
    }
    @Test
    void testWelcome() {
        String testInput = "";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result, true); // true for auto flushing
        Board board = new Board();
        ConsoleUI ui = new ConsoleUI(board, in, out);
        ui.welcome();
        assertEquals("""
                Welcome to Omok.
                This is a two-player strategy game typically played with go pieces --- black and
                white stones --- on a go board with 15x15 intersections (or places)
                [Wikipedia]. The two players alternate and place a stone of their color
                on an empty intersection. The game objective is to put one's stones in
                a row of five consecutive places vertically, horizontally, or
                diagonally. The winner is the first player to create an unbroken row
                of five stones.""",result.toString());

    }

    @Test
    void testGetGameMode() {
        Board board = new Board();
        String testIn = "1";
        InputStream in = new ByteArrayInputStream(testIn.getBytes());

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result, true); // true for auto flushing

        ConsoleUI ui = new ConsoleUI(board, in, out);
        int index = ui.getGameMode();
        assertEquals(1,index);
       assertEquals("Please enter the number of the game mode you choose: \n1 - Human vs human \n2 - Human vs computer",result.toString());


    }

    @Test
    void testGetNextMoveX() {
        Board board = new Board();
        Player player = new Player('x',"player1");
        String testIn = "6";
        InputStream in = new ByteArrayInputStream(testIn.getBytes());

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result, true); // true for auto flushing

        ConsoleUI ui = new ConsoleUI(board, in, out);
        int index = ui.getNextMoveX(player);
        assertEquals(6,index);
        assertEquals("Please enter next move in x for " + player.getPlayerName() + ":",result.toString());

    }

    @Test
    void testGetNextMoveY() {
        Board board = new Board();
        Player player = new Player('x',"player1");
        String testIn = "9";
        InputStream in = new ByteArrayInputStream(testIn.getBytes());

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result, true); // true for auto flushing

        ConsoleUI ui = new ConsoleUI(board, in, out);
        int index = ui.getNextMoveY(player);
        assertEquals("Please enter next move in y for " + player.getPlayerName() + ":",result.toString());
        assertEquals(9,index);
    }

    @Test
    void testPrintBoard() {
        String testInput = "";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result, true); // true for auto flushing
        Board board = new Board();
        ConsoleUI ui = new ConsoleUI(board, in, out);
        ui.printBoard();
        assertEquals(
                "  0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 \n" +
                "0 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" +
                "1 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" +
                "2 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" +
                "3 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" +
                "4 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" +
                "5 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" +
                "6 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" +
                "7 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" +
                "8 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" +
                "9 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" +
                "10 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" +
                "11 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" +
                "12 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" +
                "13 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" +
                "14 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n",result.toString());

    }
    @Test
    public void testGameOver(){
        Board board = new Board();
        String testIn = "";
        InputStream in = new ByteArrayInputStream(testIn.getBytes());

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result, true); // true for auto flushing

        ConsoleUI ui = new ConsoleUI(board, in, out);
        ui.gameOver();
        assertEquals("GAME OVER",result.toString());
    }
}