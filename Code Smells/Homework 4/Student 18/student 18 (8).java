
public class Player {
	protected UI ui = new UI();
	protected char Symbol;
	protected boolean won = false;
	protected int pastX = 0;
	protected int pastY = 0;
	protected final String name;
	
	public Player(char x, String name) {
		this.Symbol = x;
		this.name = name;
	}
	
	public Player(String name) {
		this.Symbol = 'x';
		this.name = name;
	}
	
	public Player(char x) {
		this.Symbol = x;
		this.name = "Unknown";
	}
	
	public String name() {
		return this.name;
	}
	
	public char getSymbol() {
		return this.Symbol;
	}
	
	public Board turn(Board board){
		ui.promptWhoseTurn(this);
		int tempX = ui.askForTurnX();
		
		while(tempX >= board.size() || tempX < 0) {
			ui.printMoveNotAvailable();
			tempX = ui.askForTurnX();
		}
		int tempY = ui.askForTurnY();
		
		while(tempY >= board.size() || tempY < 0) {
			ui.printMoveNotAvailable();
			tempY = ui.askForTurnY();
		}
		
		while (board.getCharAtXY(tempX, tempY) != '.') {
			ui.printMoveNotAvailable();
			tempX = ui.askForTurnX();
			while(tempX >= board.size() || tempX < 0) {
				ui.printMoveNotAvailable();
				tempX = ui.askForTurnX();
			}
			tempY = ui.askForTurnY();
			while(tempY >= board.size() || tempY < 0) {
				ui.printMoveNotAvailable();
				tempY = ui.askForTurnY();
			}
		}
		board.placeStone(tempX, tempY, this);
		this.pastX = tempX;
		this.pastY = tempY;
		this.won = this.HaveIWon(board, tempX,tempY);
		
		return board;
	}
	
	public int getPastX() {
		return this.pastX;
	}
	
	public int getPastY() {
		return this.pastY;
	}
	
	public boolean HaveIWon(Board board, int x, int y) {
		boolean temp = board.Won(this, x, y);
		if(temp) {
			return true;
		}
		return false;
	}
	
	public boolean checkWin() {
		if (this.won == true) {
			ui.playerWon(this);
			return false;
		}
		return true;
	}

	public void setPastY(int yforBoard) {
		// TODO Auto-generated method stub
		this.pastY = yforBoard;
		
	}

	public void setPastX(int xforBoard) {
		// TODO Auto-generated method stub
		this.pastX = xforBoard;
	}
}
