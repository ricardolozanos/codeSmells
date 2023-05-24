package noapplet.OmokTerminal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class Console_UI_Test {
    private Board b;
    private Console_UI ui;
    private String test_input;
    private ByteArrayOutputStream result;
    private InputStream in;
    private PrintStream out;

    @BeforeEach
    void set_up() {
        b = new Board(15);
        test_input = """
                1
                F,F
                """;
        in = new ByteArrayInputStream(test_input.getBytes());
        result = new ByteArrayOutputStream();
        out = new PrintStream(result, true);
        ui = new Console_UI(b, in, out);
    }

    @AfterEach
    void tear_down() {
        b = null;
        test_input = null;
        in = null;
        out = null;
        ui = null;
    }

    @Test
    void prompt_for_string() {
        assertEquals("1", ui.prompt_for_str("Make A Move"));
        assertEquals("F,F", ui.prompt_for_str("Make A Move:"));
    }

    @Test
    void display_board() {
        assertEquals("1", ui.prompt_for_str("Make A Move"));
        assertEquals("F,F", ui.prompt_for_str("Make A Move:"));
    }

    @Test
    void mode_menu() {
        assertNotNull(ui.mode_menu());
        assertEquals("Input Not Recognized - Try Again", result.toString());
    }

    @Test
    void take_turn() {
        assertEquals("1", ui.prompt_for_str("Make A Move"));
        ui.mode_menu();
        assertEquals("Input Not Recognized - Try Again", result.toString());
    }

    @Test
    void welcome_msg() {
        ui.welcome_msg();
        assertEquals("Welcome! Let's Play Some Omok :)", result.toString());
    }

    @Test
    void congrats_msg() {
        ui.congrats_msg("Ben");
        assertEquals("Congratulations Ben! You have won the game!", result.toString());
    }

    @Test
    void draw_msg() {
        ui.draw_msg();
        assertEquals("A draw has been reached. Players are equally good - or equally bad", result.toString());
    }
}