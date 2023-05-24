import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UITest {

    @Test
    void printBoard() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("".getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        UI ui = new UI(byteArrayInputStream, byteArrayOutputStream);
        Board board = new Board(15);
        ui.printBoard(board);
        String brd = "  X\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t14\t15\r\n" +
                "Y\r\n" +
                "1\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t\r\n" +
                "2\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t\r\n" +
                "3\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t\r\n" +
                "4\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t\r\n" +
                "5\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t\r\n" +
                "6\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t\r\n" +
                "7\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t\r\n" +
                "8\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t\r\n" +
                "9\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t\r\n" +
                "10\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t\r\n" +
                "11\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t\r\n" +
                "12\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t\r\n" +
                "13\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t\r\n" +
                "14\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t\r\n" +
                "15\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t\r\n";
        assertEquals(brd, byteArrayOutputStream.toString());
    }

    @Test
    void selectMode() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1".getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        UI ui = new UI(byteArrayInputStream, byteArrayOutputStream);
        String sM = ui.selectMode();
        assertEquals("1", sM);
    }

    @Test
    void modeSelected() {
        UI ui = new UI();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        ui.modeSelected(1);
        String testOut = "Player vs Computer has been selected \n To exit the game at any time, input a negative value as one of the  coordinate values and press enter.\r\n";
        assertEquals(testOut, byteArrayOutputStream.toString());
    }

    @Test
    void inputInt() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1".getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        UI ui = new UI(byteArrayInputStream, byteArrayOutputStream);
        int in = ui.inputInt();
        assertEquals(1, in);
    }

}