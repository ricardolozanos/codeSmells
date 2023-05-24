
public class PVC extends Game{
	private final int boardSize;
	private Board board;
	private boolean open = true;
	public UI ui = new UI();
	private Player player1;
	private Computer player2;
	
	public Player getPlayer1() {
		return this.player1;
	}
	public Player getPlayer2() {
		return this.player2;
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	public PVC() {
		this.board = new Board();
		this.boardSize = board.size();
		
	}

	public void start() {
		System.out.println("You have Chosen PVC so you will be fighting against an easy computer");
		this.player1 = new Player('x');
		this.player2 = new Computer('o', board);
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
			board = player2.turn(this.board, player1.getPastX(), player1.getPastY());
			board.printBoard();
			open = player2.checkWin();
			if(open == false) {
				break;
			}
		}
	}
}
