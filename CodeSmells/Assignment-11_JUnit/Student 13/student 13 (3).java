import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class UserInterfaceTest {
    @Test
    public void testConstructor(){
        String correctOutput = "";
        String inputStr = "";
        ByteArrayInputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        UserInterface UI = new UserInterface(input, output);
        assertEquals(UI.outputStream, output);
        assertEquals(UI.inputStream, input);
    }
    @Test
    public void testDrawBoard(){
        int[][] board = new int[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board[i][j] = 0;
            }
        }
        String correctOutput = "| | | |\r\n" + "| | | |\r\n" + "| | | |\r\n" ;
        String inputStr = "";
        ByteArrayInputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        UserInterface UI = new UserInterface(input, output);
        UI.drawBoard(board);
        assertEquals(output.toString(), correctOutput);
    }

    @Test
    public void testGetStonePlacement(){
        String correctOutput = "Tadeo's turn, please input the column you would like to place a stone in:\r\n" + "Tadeo's turn, please input the row you would like to place a stone in:\r\n";
        String inputStr = "0\n2";
        ByteArrayInputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        UserInterface UI = new UserInterface(input, output);
        int[] place = UI.getStonePlacement("Tadeo");
        assertTrue(place[0] == 2 && place[1] == 0);
        assertEquals(output.toString(), correctOutput );
    }

    @Test
    public void testDisplayString(){
        String correctOutput = "Hello!\r\n";
        String inputStr = "";
        ByteArrayInputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        UserInterface UI = new UserInterface(input, output);
        UI.displayString("Hello!");
        assertEquals(output.toString(), correctOutput);
    }

    @Test
    public void testGetGameMode(){
        String correctOutput = "Welcome to Super Omok 3000!\r\n" +
                "Please enter your desired GameMode:\r\n" +
                "- Player vs Player (1)\r\n" +
                "- Strategy (2)\r\n" +
                "- Exit Game (3)\r\n" +
                "You selected Player vs Player!\r\n";
        String inputStr = "1\n";
        ByteArrayInputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        UserInterface UI = new UserInterface(input, output);
        int mode = UI.getGameMode();
        assertEquals(mode, 1);
        assertEquals(output.toString(), correctOutput);
    }

    @Test
    public void testGetPlayerName(){
        String correctOutput = "Please enter name of player 1:\r\n";
        String inputStr = "Tadeo\n";
        ByteArrayInputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        UserInterface UI = new UserInterface(input, output);
        String playerName = UI.getPlayerName(1);
        assertEquals("Tadeo", playerName);
        assertEquals(correctOutput, output.toString());
    }

    @Test
    public void testDrawVictoryScreen(){
        String correctOutput = "Tadeo has won!\r\n" + "Enter anything to continue\r\n";
        String inputStr = "1";
        ByteArrayInputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        UserInterface UI = new UserInterface(input, output);
        UI.drawVictoryScreen("Tadeo");
        assertEquals(output.toString(), correctOutput);
    }

    @Test
    public void testDrawDefeatScreen(){
        String correctOutput = "You have lost, OMOKFISH reigns supreme!\r\n" + "Enter anything to continue\r\n";
        String inputStr = "1";
        ByteArrayInputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        UserInterface UI = new UserInterface(input, output);
        UI.drawDefeatScreen();
        assertEquals(output.toString(), correctOutput);
    }
}