package HomeWork2.OmokGame;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
// really weird to test since it's from project rather than a collective one everyone has
class ConsoleUITest{

    //test the constructor
    @org.junit.jupiter.api.Test
    void consoleUI() {
        String input = "example in";
        String expectedOutput = "example out";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);
        ConsoleUI consoleUI = new ConsoleUI(in, ps);
        consoleUI.out.println(expectedOutput);
        String actualOutput = out.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }

    @org.junit.jupiter.api.Test
    void askMove() {
        // Create a new game
        Game game = new Game();
        //input 1 to play player vs player
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //input board size
        input = "15\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));


        // Set up the board to have X at (1,1) and O at (2,2)
        game.Board[0][0] = Game.PieceType.X;
        game.Board[1][1] = Game.PieceType.O;

        // Call AskMove for X's turn, entering (3,3)
        System.setIn(new ByteArrayInputStream("3 3".getBytes()));
        ConsoleUI.AskMove(game, 0);

        // Check that (3,3) now contains X
        assertEquals(Game.PieceType.X, game.Board[2][2]);

        // Call AskMove for O's turn, entering (2,2)
        System.setIn(new ByteArrayInputStream("2 2".getBytes()));
        ConsoleUI.AskMove(game, 1);

        // Check that the board hasn't changed
        assertEquals(Game.PieceType.O, game.Board[1][1]);

        // Call AskMove for X's turn, entering (1,1)
        System.setIn(new ByteArrayInputStream("1 1".getBytes()));
        ConsoleUI.AskMove(game, 0);

        // Check that the move is invalid and the board hasn't changed
        assertEquals(Game.PieceType.X, game.Board[0][0]);
    }

    @org.junit.jupiter.api.Test
    void askModePlayer() {
        String input = "1\n"; // Player vs Player mode
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        Game.ModeType result = ConsoleUI.AskMode();
        assertEquals(Game.ModeType.Player, result);

    }
    @org.junit.jupiter.api.Test
    void askModeComputer() {
        String input = "2\n"; // Player vs Computer mode
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        Game.ModeType result = ConsoleUI.AskMode();
        assertEquals(Game.ModeType.Computer, result);
    }


    @org.junit.jupiter.api.Test
    void askSize() {
        // Simulate user input of "20"
        System.setIn(new ByteArrayInputStream("20\n".getBytes()));
        int size = ConsoleUI.AskSize();
        assertEquals(20, size);
    }

    @org.junit.jupiter.api.Test
    void draw() {
        // Create game
        Game game = new Game();
        // Set up the board
        game.Board[0][0] = Game.PieceType.X;
        game.Board[1][1] = Game.PieceType.O;
        // Draw
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ConsoleUI.Draw(game.Board);
        String expectedOutput = "This Part was kinda fuzzy to me, I don't know how to test this part";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void padRight() {
        // is this even working correctly
        assertEquals("hello   ", ConsoleUI.PadRight("hello", 8));
        assertEquals("test    ", ConsoleUI.PadRight("test", 8));
        assertEquals("world   ", ConsoleUI.PadRight("world", 8));
        assertEquals("1234567890", ConsoleUI.PadRight(1234567890, 10));
        assertEquals("", ConsoleUI.PadRight("", 2));
    }
}