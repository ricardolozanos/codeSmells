package omok;

public class Game_Board {
	private int size;
	private Player[][] boardDisplay;
	
	public Game_Board(int size) {
		this.size = size;
		boardDisplay = new Player[this.size][this.size];
	}
	
	public void placeStone(Player activePlayer, int[] coord) {
		boardDisplay[coord[1]][coord[0]] = activePlayer;
	}
	
	public Player[][] boardDisplay(){
		return boardDisplay;
	}
	
	public int size() {
		return size;
	}

	public boolean checkWin(Player activePlayer, int[] coord) {
		int count = 0;
		//horizontal win check
		for(int i = 0; i < boardDisplay[coord[1]].length; i++) {
			if(boardDisplay[coord[1]][i] == activePlayer) {
				count++;
				if(count == 5) {
					return true;
				}
			}else { count = 0; }
		}
		
		//Vertical win check
		for(int i = 0; i < boardDisplay[coord[0]].length; i++) {
			if(boardDisplay[i][coord[0]] == activePlayer) {
				count++;
				if(count == 5) {
					return true;
				}
			}else { count = 0; }
		}
		
		//Diagonal(\) win check
		int x = coord[0];
		int y = coord[1];
		if(x >= y) {
			x -= y;
			y = 0;
		}else { 
			y -= x;
			x = 0;
		}
		while( x < size && y < size) {
			if(boardDisplay[y][x] == activePlayer) {
				count++;
				if(count == 5) {
					return true;
				}
			}else { count = 0; }
			x++;
			y++;
		}
		
		//Diagonal(/) win check
		x = coord[0];
		y = coord[1];
		if(x + y < size) {
			y += x;
			x = 0;
		}else { 
			x -= size - y;
			y = size - 1;
		}
		while( x < size && y >= 0) {
			if(boardDisplay[y][x] == activePlayer) {
				count++;
				if(count == 5) {
					return true;
				}
			}else { count = 0; }
			x++;
			y--;
		}
		
		
		return false;
	}

	public Player player(int y, int x) {
		Player player = boardDisplay[y][x];
		return player;
	}
}
