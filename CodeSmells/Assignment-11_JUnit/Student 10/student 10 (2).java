package jUnitHW;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
class ConsoleUITest {

	private Board board;
	private InputStream in;
	private PrintStream out;

	@Test
	void test() {
		Board bd = new Board();
		ConsoleUI ui = new ConsoleUI(bd, in, out);
		ui.printMessage("hello");
		ui.printBoard();
	}

}
