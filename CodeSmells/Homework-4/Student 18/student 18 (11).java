import java.util.Scanner;

public class UI {
	private int gameMode;
	private Scanner scnr = new Scanner(System.in);
	public void display(char[][] board) {
		
	}
	
	public UI() {
	}
	public void askGameMode() {
		System.out.println("What Game Mode Will You Be Playing?\nType 1 for (PVP Local) Type 2 for (PVC Local)");
		
		//chosen gameMode
		this.gameMode = scnr.nextInt();
	}
	
	public int getGameMode() {
		return this.gameMode;
	}
	
	public int askForTurnX() {
		System.out.println("what is the x value for the current move?");
		int move = scnr.nextInt();
		return move;
	}
	public int askForTurnY() {
		System.out.println("what is the y value for the current move?");
		int move = scnr.nextInt();
		return move;
	}
	public void printMoveNotAvailable() {
		System.out.println("That move is not available please enter different coordinates");
	}
	public void playerWon(Player p) {
		System.out.println("Game Has Ended! Player: "+p.getSymbol()+" Has Won!");
	}
	public void promptWhoseTurn(Player p) {
		System.out.println("It is Player: "+p.getSymbol()+"'s turn!");
	}
}
