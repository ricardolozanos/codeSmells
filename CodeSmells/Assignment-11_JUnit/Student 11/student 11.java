package omok;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConsoleUITest {
	Board board = new Board();
	Players  activePlayer = new Players("3,4");
	Players nextActivePlayer = new Players("adios");

	@Test
	public void showBoardtest() {
		Board expected = new Board();
		
	}
	
	@Test
	public void showBoadTest() {
		String expected = "3,4";
		String[] location = {"3","4"};
		String[] run = ConsoleUI.promptPlayer(activePlayer);
	}


}
