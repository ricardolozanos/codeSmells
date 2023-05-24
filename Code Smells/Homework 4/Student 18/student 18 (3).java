
public class Computer extends Player{
	private Player tempPlayer = new Player('x');
	private Board b;
	
	public Board getBoard() {
		return this.b;
	}
	
	public Computer(char x, Board b) {
		super(x);
		this.b = b;
	}
	public Board turn(Board b, int x, int y) {
		if (HumanWinOnPosition('x',x-1,y-1)) {
			b.placeStone(x-1, y-1, this);
			this.pastX = x-1;
			this.pastY = y-1;
			this.won = this.HaveIWon(b, x-1,y-1);
			return b;
		}
		if (HumanWinOnPosition('x',x-1,y)) {
			b.placeStone(x-1, y, this);
			this.pastX = x-1;
			this.pastY = y;
			this.won = this.HaveIWon(b, x-1,y);
			return b;
		}
		if (HumanWinOnPosition('x',x-1,y+1)) {
			b.placeStone(x-1, y+1, this);
			this.pastX = x-1;
			this.pastY = y+1;
			this.won = this.HaveIWon(b, x-1,y+1);
			return b;
		}
		if (HumanWinOnPosition('x',x,y-1)) {
			b.placeStone(x, y-1, this);
			this.pastX = x;
			this.pastY = y-1;
			this.won = this.HaveIWon(b, x,y-1);
			return b;
		}
		if (HumanWinOnPosition('x',x,y+1)) {
			b.placeStone(x, y+1, this);
			this.pastX = x;
			this.pastY = y+1;
			this.won = this.HaveIWon(b, x,y+1);
			return b;
		}
		if (HumanWinOnPosition('x',x+1,y-1)) {
			b.placeStone(x+1, y-1, this);
			this.pastX = x+1;
			this.pastY = y-1;
			this.won = this.HaveIWon(b, x+1,y-1);
			return b;
		}
		if (HumanWinOnPosition('x',x+1,y)) {
			b.placeStone(x+1, y, this);
			this.pastX = x+1;
			this.pastY = y;
			this.won = this.HaveIWon(b, x+1,y);
			return b;
		}
		if (HumanWinOnPosition('x',x+1,y+1)) {
			b.placeStone(x+1, y+1, this);
			this.pastX = x+1;
			this.pastY = y+1;
			this.won = this.HaveIWon(b, x+1,y+1);
			return b;
		}
		for (int i = 0; i < b.size();i++) {
			for (int j = 0; j < b.size(); j++) {
				if(b.getCharAtXY(i, j) == '.') {
					b.placeStone(i, j, this);
					this.pastX = i;
					this.pastY = j;
					this.won = this.HaveIWon(b, i, j);
					return b;
				}
			}
		}
		return b;
	}
	
	public boolean HumanWinOnPosition (char c, int x, int y) {
		if(x < 0 || x >= b.size()) {
			return false;
		}
		if(y < 0 || y >= b.size()) {
			return false;
		}
		if(b.getCharAtXY(x, y)!= '.') {
			return false;
		}
		b.placeStone(x, y, this.tempPlayer);
		boolean temp = b.Won(new Player(c), x, y);
		b.resetMoveBoard(x,y,'.');
		return temp;
	}
}
