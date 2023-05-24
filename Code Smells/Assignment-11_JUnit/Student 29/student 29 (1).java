import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class OmokUITest {

	@Test
	void testConstructor() {
		OmokUI u = new OmokUI();
		assertEquals(null,u.getOmokUIStatus());
	}

	@Test
	void testContructorBoolean() {
		OmokUI u = new OmokUI(true);
		assertEquals(true,u.getOmokUIStatus());
		assertNotEquals(false,u.getOmokUIStatus());
	}
	
	@Test
	void testgetOmokUIStatus() {
		OmokUI u = new OmokUI(true);
		assertEquals(true,u.getOmokUIStatus());
		assertNotEquals(false,u.getOmokUIStatus());
	}
	
	@Test
	void testsetOmokUIStatus() {
		OmokUI u = new OmokUI();
		u.setOmokUIStatus(true);
		assertEquals(true,u.getOmokUIStatus());
		u.setOmokUIStatus(false);
		assertEquals(false,u.getOmokUIStatus());
	}
	
	@Test
	void testsetupOmokGame() {
		OmokGame g = new OmokGame();
		g.setUI(true);
		String []userInput = new String[3];
		String []names = { "chris", "sam" };
		int [] size = { 25, 20, 15 };
		
		userInput[0] = String.format("%d%s1%s%s%s%s%s-1%s",
				size[0],
				System.lineSeparator(),
				System.lineSeparator(),
				names[0],
				System.lineSeparator(),
				names[1],
				System.lineSeparator(),
				System.lineSeparator());
		
		userInput[1] = String.format("%d%s2%s%s%s-1%s", 
				size[1],
				System.lineSeparator(),
				System.lineSeparator(),
				names[0],
				System.lineSeparator(),
				System.lineSeparator(),
				System.lineSeparator());

		userInput[2] = String.format("%d%s3%s", 
				size[2],
				System.lineSeparator(),
				System.lineSeparator());
		
		for (int i=0; i<3; ++i) {
			ByteArrayInputStream in = new ByteArrayInputStream(userInput[i].getBytes());
			System.setIn(in);
		
			ByteArrayOutputStream result = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(result,true);
			System.setOut(out);
		
			g.getUI().setupOmokGame(g);
		
			assertEquals(size[i],g.getOmokBoard().getOmokBoardSize());
			
			switch (i) {
			case 2:
				assertEquals(false,g.getGameType());
				assertEquals(false,g.getPlayer1().getPlayerType());
				assertEquals(false,g.getPlayer2().getPlayerType());
				break;
			case 1:
				assertEquals(true,g.getGameType());
				assertEquals(true,g.getPlayer1().getPlayerType());
				assertEquals(names[0],g.getPlayer1().getPlayerName());
				assertEquals(false,g.getPlayer2().getPlayerType());
				break;
			case 0:
				assertEquals(true,g.getGameType());
				assertEquals(true,g.getPlayer1().getPlayerType());
				assertEquals(names[0],g.getPlayer1().getPlayerName());
				assertEquals(true,g.getPlayer2().getPlayerType());
				assertEquals(names[1],g.getPlayer2().getPlayerName());
				break;

			}
		}
	}

	@Test
	void testexecutePlayerTurn() {
		OmokGame g = new OmokGame();
		OmokPlayer p = new OmokPlayer("chris",true);//, true);
		
		g.setOmokBoard(new OmokBoard(2));
		g.setUI(true);
		g.setOmokPlayer1(p);
		
		String userInput = String.format("1 1%s",
				System.lineSeparator());
		
		ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
	
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(result,true);
		System.setOut(out);
		
		g.getUI().executePlayerTurn(g, 1);
		int [][] b = g.getOmokBoard().getOmokBoard();
		
		assertEquals(false,g.getOmokBoard().getBoardFull());
		assertEquals(1,b[0][0]);
		assertEquals(0,b[0][1]);
		assertEquals(0,b[1][0]);
		assertEquals(0,b[1][1]);
	}

	@Test
	void testexecutePlayerTurnQuit() {
		OmokGame g = new OmokGame();
		OmokPlayer p = new OmokPlayer("chris",true);
		String expectedOutput = "Game ended by user with no winner!";
		
		g.setOmokBoard(new OmokBoard(2));
		g.setUI(true);
		g.setOmokPlayer1(p);
		
		String userInput = String.format("-1%s ",
				System.lineSeparator());
		
		ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
	
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(result,true);
		System.setOut(out);
		
		g.getUI().executePlayerTurn(g, 1);
		int [][] b = g.getOmokBoard().getOmokBoard();
		
		String[] lines = result.toString().split(System.lineSeparator());
		String actual = lines[lines.length-1];	
		
		//assertEquals(false,g.getOmokBoard().getBoardFull());
		assertEquals(0,b[0][0]);
		assertEquals(0,b[0][1]);
		assertEquals(0,b[1][0]);
		assertEquals(0,b[1][1]);
		assertEquals(expectedOutput,actual);
	}
	
	@Test
	void testexecutePlayerTurnHint() {
		OmokGame g = new OmokGame();
		OmokPlayer p = new OmokAI("hint",true);
		String expectedOutput = "hint: (1,1)";
		
		g.setOmokBoard(new OmokBoard(1));
		g.setUI(true);
		g.setOmokPlayer1(p);
		
		String userInput = String.format("-99%s-1%s",
				System.lineSeparator(),
				System.lineSeparator());
		
		ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
	
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(result,true);
		System.setOut(out);
		
		g.getUI().executePlayerTurn(g, 1);
		
		
		String[] lines = result.toString().split(System.lineSeparator());
		String actual = lines[lines.length-3];
		
		
		//assertEquals(false,g.getOmokBoard().getBoardFull());
		assertEquals(expectedOutput,actual);
	}
	
	@Test
	void testdrawOmokBoard() {
		OmokUI u = new OmokUI();
		OmokBoard b = new OmokBoard(2);
		String expectedOutput = "y/x 1  2 "
				+ " 1  .  . "
				+ " 2  .  . ";

		ByteArrayOutputStream result = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(result,true);
		System.setOut(out);
		
		u.drawOmokBoard(b,0,null);
		
		String[] lines = result.toString().split(System.lineSeparator());
		String actual = "";
		for (int i=0; i<lines.length; ++i)
			actual += lines[i];	
		assertEquals(expectedOutput,actual);				
	}
	
	@Test
	void testgameOver() {
		OmokGame g = new OmokGame();
		OmokPlayer p = new OmokPlayer("chris",true);
		
		g.setOmokBoard(new OmokBoard(5));
		g.setUI(true);
		g.setOmokPlayer1(p);
				
		g.getOmokBoard().updateBoard(0, 0, 1, true);
		g.getOmokBoard().updateBoard(0, 1, 1, true);
		g.getOmokBoard().updateBoard(0, 2, 1, true);
		g.getOmokBoard().updateBoard(0, 3, 1, true);
		g.getOmokBoard().updateBoard(0, 4, 1, true);

		ByteArrayOutputStream result = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(result,true);
		System.setOut(out);
		
		g.getUI().gameOver(1,g);
		
		String expectedOutput = "chris has won the game!";
		
		String[] lines = result.toString().split(System.lineSeparator());
		String actual = lines[lines.length-1];
		assertEquals(expectedOutput,actual);
	}

}
