import org.junit.Test;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleUserInteractionTest {

    @Test
    public void testCreatePlayers() {
        PlayerOne playerone = new PlayerOne();
        PlayerTwo playertwo = new PlayerTwo();
        String inputOne = "Alan";
        String inputTwo = "Arath";
        Scanner in = new Scanner(System.in);
        playerone.setName(in.nextLine());
        playerone.setStoneType(in.nextLine());
        playertwo.setNameTwo(in.nextLine());
        playertwo.setStoneTypeTwo(in.nextLine());
        System.setIn(new ByteArrayInputStream(inputOne.getBytes()));
        System.setIn(new ByteArrayInputStream(inputTwo.getBytes()));
        //Get the names of the players
        assertEquals("Alan",playerone.getName());
        assertEquals("Arath",playertwo.getNameTwo());
        //Get the types of stone of the players
        assertEquals("X",playerone.getStoneType());
        assertEquals("O",playertwo.getStoneTypeTwo());
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result,true);
    }

    @Test
    public void testGomokuGame() {

    }
}