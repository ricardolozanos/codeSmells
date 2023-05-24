
public class PVP extends Game{
	private final int boardSize;
	private Board board;
	private boolean open = true;
	private Player player1;
	private Player player2;
	
	public Player getPlayer1() {
		return this.player1;
	}
	public Player getPlayer2() {
		return this.player2;
	}
	
	public Board getBoard() {
		return this.board;
	}
	public PVP() {
		this.board = new Board();
		this.boardSize = board.size();
		
	}

	public void start() {
		System.out.println("You have Chosen PVP so you will both take turns deciding where to put your stones!");
		this.player1 = new Player('x');
		this.player2 = new Player('o');
		//this.run();
	}
	
	
	public void run() {
		while(open) {
			
			board.printBoard();
			board = player1.turn(this.board);
			
			board.printBoard();
			open = player1.checkWin();
			if(open == false) {
				break;
			}
			board = player2.turn(this.board);
			board.printBoard();
			open = player2.checkWin();
			if(open == false) {
				break;
			}
		}
	}
}
