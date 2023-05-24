import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

public class ConsoleUITest {
    ByteArrayInputStream input;
    ByteArrayOutputStream output;
    ConsoleUI ui;
    GameMain<GoPuck> game;
    @Before
    public void initializeTest(){
        game = new GameMain();
        output = new ByteArrayOutputStream();
    }
    /**
     * This function test the Player Class and
     */
    @Test
    public void testPlayer(){
        Player player1 = new HumanPlayer("PLAYER1", UUID.randomUUID().toString());
        assertEquals("Player name assignment failed","PLAYER1",player1.getName());
    }

    /**
     * This method tests the ConsoleUI's game setup prompt to validate that the mapping is correct
     * @throws IOException
     */
    @Test
    public void testGameSetupPrompt() throws IOException {
        input = new ByteArrayInputStream("l\nB\n".getBytes());
        ui = new ConsoleUI(input,output);
        ui.setUpGameMode(0);
        assertEquals("GameMode mode setup failed!", GameMain.GameMode.DUO_LOCAL,ui.getGameMode());
        output.reset();
    }

    /**
     * This method tests the ConsoleUI's board setup prompt to validate that the mapping is correct
     * @throws IOException
     */
    @Test
    public void testGameBoardSetupPrompt() throws IOException{
        input = new ByteArrayInputStream("k\nB\n".getBytes());
        ui = new ConsoleUI(input,output);
        ui.setUpBoardSize(0);
        assertEquals("BoardSize size setup failed!", GameBoard.BoardSize.MEDIUM,ui.getBoardSize());
        output.reset();
    }

    /**
     * This method checks if the players are setup is properly implemented
     */
    @Test
    public void testPlayerPrompt(){
        input = new ByteArrayInputStream("PLAYER1\nPLAYER2".getBytes());
        ui = new ConsoleUI(input,output,game);
        ui.setUpPlayers(2);
        assertEquals("Setting up player\"Player\" failed!", "PLAYER1",game.getPlayer().getName());
        assertEquals("Setting up Opponent\"Opponent\" failed!","PLAYER2",game.getOpponent().getName());
        output.reset();
    }

    /**
     * This method tests if the game plays out as intended and also checks if ends after a win.
     */
    @Test
    public void testGame(){
        String setupCommand = """
                B
                A
                PLAYER1
                PLAYER2
                A1
                B1
                A2
                B2
                A3
                B3
                A4
                B4
                A5
                """;
        input = new ByteArrayInputStream(setupCommand.getBytes());
        ui = new ConsoleUI(input,output);
        ui.run();
        assertEquals("Game didnt end as expected", true,output.toString().contains("@  @  @  @  @"));
    }
    @After
    public void closeTest() throws IOException{
        output.close();
    }

}
