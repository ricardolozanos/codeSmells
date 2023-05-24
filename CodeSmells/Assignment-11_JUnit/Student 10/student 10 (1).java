package jUnitHW;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class ConsoleUI {
	public Board bd;
	public InputStream in;
	public PrintStream out;
	private int mode;
	private static int move;
	
	public ConsoleUI(Board bd,InputStream in, PrintStream out) {
		this.bd = bd;
		this.in = in;
		this.out = out;

	}
	
	public void printMessage(String msg) {
		System.out.print(msg);
	}
	
	public int promptMode() throws IOException {
		this.printMessage("CHOSE A GAME MODE");
		mode = in.read();
		return mode;
		
	}
	
	public void printBoard() {
		bd.drawBoard();
	}
	
	public int promptMove(Player p) throws IOException {
		this.printMessage("index of place");
		move = in.read();
		return move;
		
	}
	

}
