package omok;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private List<Player> players;
	private Player activePlayer;
	private Game_Board board;
	private AI computer;

	public Game() {
		players = new ArrayList<>(2);
		activePlayer = new Player("Black", Color.black);
		players.add(activePlayer);
		board = new Game_Board(15);
	}
	
	public boolean play(int[] coord, Player activePlayer) {
		board.placeStone(activePlayer, coord);
		if(board.checkWin(activePlayer, coord)) {
			return true;
		}
		changePlayer();
		return false;
	}
	
	public void changePlayer() {
		for(var player: players) {
			if(player != activePlayer) {
				activePlayer = player;
				return;
			}
		}
		System.out.println(players);
		
	}

	public void humanPlayer() {
		players.add(new Player("White", Color.white));		
	}


	public void computerPlayer() {
		computer = new AI("White", Color.white);
		players.add(computer);
		
	}

	public Game_Board board() {
		return board;
	}
	
	public Player activePlayer() {
		return activePlayer;
	}
	
	public AI computer() {
		return computer;
	}

}
