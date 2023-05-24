package omok;

import java.awt.Color;

public class AI extends Player {
	
	private Game game;
	private Game_Board board;

	public AI(String name, Color color) {
		super(name, color);
		
	}
	
	public int[] play(Game game) {
		this.game = game;
		this.board = game.board();
		return getCoord();
	}

	private int[] getCoord() {
		int[] coord = {-1, -1};
		
		//Going for the Fifth
		coord = stragedyStone(4);
		if(coord[0] != -1) {
			return coord;
		}
		
		//Blocks enemy from fifth stone
		coord = enemyFour();
		if(coord[0] != -1) {
			return coord;
		}
		
		//Going for the Fourth
		coord = stragedyStone(3);
		if(coord[0] != -1) {
			return coord;
		}
		
		//Blocks enemy from fourth stone
		coord = enemyThree();
		if(coord[0] != -1) {
			return coord;
		}
		
		
		//Basic move
		coord = basicMove();
		if(coord[0] == -1) {
			return coord;
		}
		
		
		return coord;
	}

	private int[] stragedyStone(int stones) {
		int[] coord = {-1, -1};
		int count = 0;
		int[] start = new int[2];
		
		for(int y = 0; y < board.size(); y++) { // horizontal check
			for(int x = 0; x < board.size(); x++) {
				if(board.player(y, x) == game.activePlayer()) {
					if(count == 0) {
						start[0] = y;
						start[1] = x;
					}
					count++;
					if(count == stones) {
						if(x < board.size() - 1 && board.player(y, x+1) == null) {
							coord[0] = x + 1;
							coord[1] = y;
							return coord;
						}
						if(start[1] > 0 && board.player(y, start[1]-1) == null) {
							coord[0] = start[1] - 1;
							coord[1] = y;
							return coord;
						}
					}
				}else { count = 0; }
			}
			count = 0;
		}
		
		for(int x = 0; x < board.size(); x++) { // vertical check
			for(int y = 0; y < board.size(); y++) {
				if(board.player(y, x) == game.activePlayer()) {
					if(count == 0) {
						start[0] = y;
						start[1] = x;
					}
					count++;
					if(count == stones) {
						if(y < board.size() - 2 && board.player(y+1, x) == null) {
							coord[0] = x;
							coord[1] = y + 1;
							return coord;
						}
						if(start[0] > 0 && board.player(start[0]-1, x) == null) {
							coord[0] = x;
							coord[1] = start[0]-1;
							return coord;
						}
					}
				}else { count = 0; }
			}
			count = 0;
		}
		
		
		
		//Diagonal Check(/)
		
		int index = 0;
		
		while(index < board.size()) {
			for(int y = index;  y >= 0; ) {
				for(int x = 0; x <= index; x++) {
					if(board.player(y, x) == game.activePlayer()) {
						if(count == 0) {
							start[0] = y;
							start[1] = x;
						}
						count++;
						if(count == stones) {
							if(y > 0 && x < board.size()-1 && board.player(y-1, x+1) == null) {
								coord[0] = x + 1;
								coord[1] = y - 1;
								return coord;
							}
							if(start[0] < index && start[1] > 0 && board.player(start[0]+1, start[1]-1) == null) {
								coord[0] = start[1] - 1;
								coord[1] = start[0] + 1;
								return coord;
							}
						}
					}else { count = 0; }
					y--;
				}
				count = 0;
				index++;
			}
		}
		
		index = 1;
		while(index < board.size()) {
			for(int y = 4; y >= index;) {
				for(int x = index; x <= 4; x++) {
					if(board.player(y, x) == game.activePlayer()) {
						if(count == 0) {
							start[0] = y;
							start[1] = x;
						}
						count++;
						if(count == stones) {
							if(y > index && x < board.size()-1 && board.player(y-1, x+1) == null ) {
								coord[0] = x + 1;
								coord[1] = y - 1;
								return coord;
							}
							if(start[0] < board.size()-1 && start[1] > index && board.player(start[0]+1, start[1]-1) == null) {
								coord[0] = start[1] - 1;
								coord[1] = start[0] + 1;
								return coord;
							}
						}
					}else { count = 0; }
					y--;
				}
			}
			count = 0;
			index++;
		}
		
		//diagonal check (\)
		index = board.size()-1;
		while(index >= 0) {
			for(int y = index; y < board.size(); ) {
				for(int x = 0; x < board.size()-index; x++) {
					if(board.player(y, x) == game.activePlayer()) {
						if(count == 0) {
							start[0] = y;
							start[1] = x;
						}
						count++;
						if(count == stones) {
							if(y < board.size()-1 && x < board.size()-index && board.player(y+1, x+1) == null ) {
								coord[0] = x + 1;
								coord[1] = y + 1;
								return coord;
							}
							if(start[0] < index && start[1] < 0 && board.player(start[0]-1, start[1]-1) == null) {
								coord[0] = start[1] - 1;
								coord[1] = start[0] - 1;
								return coord;
							}
						}
					}else { count = 0; }
					y++;
				}
			}
			count = 0;
			index--;
		}
		
		index = 1;
		while(index < 5) {
			for(int y = 0; y < board.size() - index;) {
				for(int x = index; x < board.size(); x++) {
					if(board.player(y, x) == game.activePlayer()) {
						if(count == 0) {
							start[0] = y;
							start[1] = x;
						}
						count++;
						if(count == stones) {
							if(y < board.size()-index && x < board.size()-1 && board.player(y+1, x+1) == null ) {
								coord[0] = x + 1;
								coord[1] = y + 1;
								return coord;
							}
							if(start[0] > 0 && start[1] > index && board.player(start[0]-1, start[1]-1) == null) {
								coord[0] = start[1] - 1;
								coord[1] = start[0] - 1;
								return coord;
							}
						}
					}else { count = 0; }
					y++;
				}
			}
			count = 0;
			index++;
		}
		
		return coord;
	}

	private int[] enemyFour() {
		int[] coord = {-1, -1};
		int count = 0;
		int[] start = new int[2];
		
		for(int y = 0; y < board.size(); y++) { // horizontal check
			for(int x = 0; x < board.size(); x++) {
				if(board.player(y, x) != null && board.player(y, x) != game.activePlayer()) {
					if(count == 0) {
						start[1] = x;
					}
					count++;
					if(count == 4) {
						if( x < board.size() - 2 && board.player(y, x + 1) == null) {
							coord[0] = x + 1;
							coord[1] = y;
							return coord;
						}
						if(start[1] > 0 && board.player(y, start[1]-1) == null) {
							coord[0] = start[1] - 1;
							coord[1] = y;
							return coord;
						}
					}
				}else { count = 0; }
			}
		}
		
		for(int x = 0; x < board.size(); x++) { // vertical check
			for(int y = 0; y < board.size(); y++) {
				if(board.player(y, x) != null && board.player(y, x) != game.activePlayer()) {
					if(count == 0) {
						start[0] = y;
					}
					count++;
					if(count == 4) {
						if(y < board.size() - 2 && board.player(y+1, x) == null) {
							coord[0] = x;
							coord[1] = y + 1;
							return coord;
						}
						if(start[0] > 0 && board.player(start[0]-1, x) == null) {
							coord[0] = x;
							coord[1] = start[0] - 1;
							return coord;
						}
					}
				}else { count = 0; }
			}
		}
		
		//Diagonal Check(/)
		
				int index = 0;
				
				while(index < board.size()) {
					for(int y = index;  y >= 0; ) {
						for(int x = 0; x <= index; x++) {
							if(board.player(y, x) != null && board.player(y, x) != game.activePlayer()) {
								if(count == 0) {
									start[0] = y;
									start[1] = x;
								}
								count++;
								if(count == 4) {
									if(y > 0 && x < board.size()-1 && board.player(y-1, x+1) == null) {
										coord[0] = x + 1;
										coord[1] = y - 1;
										return coord;
									}
									if(start[0] < index && start[1] > 0 && board.player(start[0]+1, start[1]-1) == null) {
										coord[0] = start[1] - 1;
										coord[1] = start[0] + 1;
										return coord;
									}
								}
							}else { count = 0; }
							y--;
						}
						count = 0;
						index++;
					}
				}
				
				index = 1;
				while(index < board.size()) {
					for(int y = 4; y >= index;) {
						for(int x = index; x <= 4; x++) {
							if(board.player(y, x) != null && board.player(y, x) != game.activePlayer()) {
								if(count == 0) {
									start[0] = y;
									start[1] = x;
								}
								count++;
								if(count == 4) {
									if(y > index && x < board.size()-1 && board.player(y-1, x+1) == null ) {
										coord[0] = x + 1;
										coord[1] = y - 1;
										return coord;
									}
									if(start[0] < board.size()-1 && start[1] > index && board.player(start[0]+1, start[1]-1) == null) {
										coord[0] = start[1] - 1;
										coord[1] = start[0] + 1;
										return coord;
									}
								}
							}else { count = 0; }
							y--;
						}
					}
					count = 0;
					index++;
				}
				
				//diagonal check (\)
				index = board.size()-1;
				while(index >= 0) {
					for(int y = index; y < board.size(); ) {
						for(int x = 0; x < board.size()-index; x++) {
							if(board.player(y, x) != null && board.player(y, x) != game.activePlayer()) {
								if(count == 0) {
									start[0] = y;
									start[1] = x;
								}
								count++;
								if(count == 4) {
									if(y < board.size()-1 && x < board.size()-index && board.player(y+1, x+1) == null ) {
										coord[0] = x + 1;
										coord[1] = y + 1;
										return coord;
									}
									if(start[0] < index && start[1] < 0 && board.player(start[0]-1, start[1]-1) == null) {
										coord[0] = start[1] - 1;
										coord[1] = start[0] - 1;
										return coord;
									}
								}
							}else { count = 0; }
							y++;
						}
					}
					count = 0;
					index--;
				}
				
				index = 1;
				while(index < 5) {
					for(int y = 0; y < board.size() - index;) {
						for(int x = index; x < board.size(); x++) {
							if(board.player(y, x) != null && board.player(y, x) != game.activePlayer()) {
								if(count == 0) {
									start[0] = y;
									start[1] = x;
								}
								count++;
								if(count == 4) {
									if(y < board.size()-index && x < board.size()-1 && board.player(y+1, x+1) == null ) {
										coord[0] = x + 1;
										coord[1] = y + 1;
										return coord;
									}
									if(start[0] > 0 && start[1] > index && board.player(start[0]-1, start[1]-1) == null) {
										coord[0] = start[1] - 1;
										coord[1] = start[0] - 1;
										return coord;
									}
								}
							}else { count = 0; }
							y++;
						}
					}
					count = 0;
					index++;
				}
		
		return coord;
	}

	private int[] enemyThree() {
		int[] coord = {-1, -1};
		int count = 0;
		int[] start = new int[2];
		
		for(int y = 0; y < board.size(); y++) { // horizontal check
			for(int x = 0; x < board.size(); x++) {
				if(board.player(y, x) != null && board.player(y, x) != game.activePlayer()) {
					if(count == 0) {
						start[1] = x;
					}
					count++;
					if(count == 3) {
						if( x < board.size() - 2 && board.player(y, x + 1) == null) {
							coord[0] = x + 1;
							coord[1] = y;
							return coord;
						}
					}
				}else { count = 0; }
			}
		}
		
		for(int x = 0; x < board.size(); x++) { // vertical check
			for(int y = 0; y < board.size(); y++) {
				if(board.player(y, x) != null && board.player(y, x) != game.activePlayer()) {
					if(count == 0) {
						start[0] = y;
					}
					count++;
					if(count == 3) {
						if(y < board.size() - 2 && board.player(y+1, x) == null) {
							coord[0] = x;
							coord[1] = y + 1;
							return coord;
						}
					}
				}else { count = 0; }
			}
		}
		
		
		//Diagonal Check(/)
		
		int index = 0;
		
		while(index < board.size()) {
			for(int y = index;  y >= 0; ) {
				for(int x = 0; x <= index; x++) {
					if(board.player(y, x) != null && board.player(y, x) != game.activePlayer()) {
						if(count == 0) {
							start[0] = y;
							start[1] = x;
						}
						count++;
						if(count == 3) {
							if(y > 0 && x < board.size()-1 && board.player(y-1, x+1) == null) {
								coord[0] = x + 1;
								coord[1] = y - 1;
								return coord;
							}
						}
					}else { count = 0; }
					y--;
				}
				count = 0;
				index++;
			}
		}
		
		index = 1;
		while(index < board.size()) {
			for(int y = 4; y >= index;) {
				for(int x = index; x <= 4; x++) {
					if(board.player(y, x) != null && board.player(y, x) != game.activePlayer()) {
						if(count == 0) {
							start[0] = y;
							start[1] = x;
						}
						count++;
						if(count == 3) {
							if(y > index && x < board.size()-1 && board.player(y-1, x+1) == null ) {
								coord[0] = x + 1;
								coord[1] = y - 1;
								return coord;
							}
						}
					}else { count = 0; }
					y--;
				}
			}
			count = 0;
			index++;
		}
		
		//diagonal check (\)
		index = board.size()-1;
		while(index >= 0) {
			for(int y = index; y < board.size(); ) {
				for(int x = 0; x < board.size()-index; x++) {
					if(board.player(y, x) != null && board.player(y, x) != game.activePlayer()) {
						if(count == 0) {
							start[0] = y;
							start[1] = x;
						}
						count++;
						if(count == 3) {
							if(y < board.size()-1 && x < board.size()-index && board.player(y+1, x+1) == null ) {
								coord[0] = x + 1;
								coord[1] = y + 1;
								return coord;
							}
						}
					}else { count = 0; }
					y++;
				}
			}
			count = 0;
			index--;
		}
		
		index = 1;
		while(index < 5) {
			for(int y = 0; y < board.size() - index;) {
				for(int x = index; x < board.size(); x++) {
					if(board.player(y, x) != null && board.player(y, x) != game.activePlayer()) {
						if(count == 0) {
							start[0] = y;
							start[1] = x;
						}
						count++;
						if(count == 3) {
							if(y < board.size()-index && x < board.size()-1 && board.player(y+1, x+1) == null ) {
								coord[0] = x + 1;
								coord[1] = y + 1;
								return coord;
							}
						}
					}else { count = 0; }
					y++;
				}
			}
			count = 0;
			index++;
		}
		
		return coord;
	}

	private int[] basicMove() {
		int[] coord = {-1, -1};
		
		//Collective move
				for(int y = 0; y < board.size(); y++) {
					for(int x = 0; x < board.size(); x++) {
						if(board.player(y, x) == game.activePlayer()) {
							if(x < board.size() - 2 && board.player(y, x+1) == null) {
								coord[0] = x + 1;
								coord[1] = y;
								return coord;
							}
							if(y < board.size() - 2 && board.player(y+1, x) == null) {
								coord[0] = x;
								coord[1] = y + 1;
								return coord;
							}
							if(y > 0 && board.player(y-1, x) == null) {
								coord[0] = x;
								coord[1] = y - 1;
								return coord;
							}
							if(x > 0 && board.player(y, x-1) == null) {
								coord[0] = x - 1;
								coord[1] = y;
								return coord;
							}
						}
					}
				}
				
				//Basic Move
				for(int y = 0; y < board.size(); y++) {
					for(int x = 0; x < board.size(); x++) {
						if(board.player(y, x) != null) {
							if(x < board.size() - 2 && board.player(y, x+1) == null) {
								coord[0] = x + 1;
								coord[1] = y;
								return coord;
							}
							if(x > 0 && board.player(y, x-1) == null) {
								coord[0] = x - 1;
								coord[1] = y;
								return coord;
							}
						}
					}
				}//Basic Move
				
		return coord;
	}


}
