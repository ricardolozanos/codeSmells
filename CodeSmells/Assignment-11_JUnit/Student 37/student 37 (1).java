package omok;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConsoleUITest {
	  @Test
	  public void constructorshouldreturnScannerGameControllerandOutput() {
		  String testInput="1/n";
		   InputStream input=new ByteArrayInputStream(testInput.getBytes());
		   ByteArrayOutputStream result = new ByteArrayOutputStream();
		   PrintStream output=new PrintStream(result, true);
		   ConsoleUI c=new ConsoleUI(input,output);
		   assertEquals(input,c);
		   assertEquals(output,c);
	  }
	  @Test
	    public void testIntroWithValidInput() {
	        String input = "1\n";
	        InputStream in = new ByteArrayInputStream(input.getBytes());
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        ConsoleUI consoleUI = new ConsoleUI(in, new PrintStream(out));

	        consoleUI.intro();

	        String expectedOutput = "Welcome\nChoose game mode 1 for computer 2 for PVP, or 3 to quit game\n";
	        assertEquals(expectedOutput, out.toString());
	    }

	    @Test
	    public void testIntroWithInvalidInput() {
	        String input = "invalid input\n1\n";
	        InputStream in = new ByteArrayInputStream(input.getBytes());
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        ConsoleUI consoleUI = new ConsoleUI(in, new PrintStream(out));

	        consoleUI.intro();

	        String expectedOutput = "Welcome\nChoose game mode 1 for computer 2 for PVP, or 3 to quit game\nInvalid input\n";
	        assertEquals(expectedOutput, out.toString());
	    }

}
