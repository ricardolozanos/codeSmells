package src.noapplet.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
class ConsoleUITest {
    private ConsoleUI console;
    private ByteArrayInputStream in;
    private ByteArrayOutputStream out;
    private Board board;

    @BeforeEach
    void setUp() {
        String input = "1\n5\n";
        in = new ByteArrayInputStream(input.getBytes());
        out = new ByteArrayOutputStream();
        console = new ConsoleUI(in, new PrintStream(out));
    }

    @Test
    void testPromptPlace() {
        Board board = new Board();
        Player player = new Player("X");
        Index index = console.promptPlace(player, board);
        assertEquals(1, index.x);
        assertEquals(5, index.y);
    }

    @Test
    void testDisplayMessage() {
        console.displayMessage("Hello World!");
        assertEquals("Hello World!\n", out.toString());
    }
    @Test
    void testDisplayMessageComp() {
        console.displayMessageComp("Hello Computer!");
        assertEquals("Hello Computer!\n", out.toString());
    }

    @Test
    void testDisplayMenu() {
        String expectedOutput = "Welcome to Omok!\n\nMAIN MENU\nChoose Game Mode:\n1.\tHuman Vs Human\n2.\tHuman Vs Computer\n";
        int expectedInput = 1;
        assertEquals(expectedInput, console.displayMenu());
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    void testDisplayBoardSize() {
        String expectedOutput = "Pick Board Size\n";
        int expectedInput = 12;
        assertEquals(expectedInput, console.displayBoardSize());
        assertEquals(expectedOutput, out.toString());
    }
}
