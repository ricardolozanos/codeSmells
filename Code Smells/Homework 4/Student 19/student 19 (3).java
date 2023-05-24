package omok;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller {
	
	private final static Rectangle DEFAULT_DIMENSION = new Rectangle(0, 0, 494, 812);
	
	private GUI GUI;
	private Game game;
	
	public Controller() {
		GUI = new GUI();
		GUI.setTitle("Omok");
		GUI.setBounds(DEFAULT_DIMENSION);
		GUI.setVisible(true);
		game = new Game();
	}
	
	public void Start() {
		GUI.board().setBoard(game.board().boardDisplay());
		if(GUI.mode() == 0) {
			game.computerPlayer();
		}else {
			game.humanPlayer();
		}
		PlayGame();
	}
	
	public void PlayGame() {
		for(int i = 0; i < 20; i++) {
			GUI.board().paintStones();
			int[] coords = {-1, -1};
			
			if(game.activePlayer().getClass() == AI.class) {
				coords = game.computer().play(game);
				if(game.play(coords, game.activePlayer())) {
					GUI.board().paintStones();
					GUI.gameOver(game.activePlayer().name() + " Wins!");
					if(GUI.newGame() == 0) {
						reset();
					}else {
						return;
					}
				}
			}else {
				while(coords[0] == -1) {
					System.out.println();
					coords = GUI.board().getPiece();
				}
				GUI.board().resetCoords();
				if(game.play(coords, game.activePlayer())) {
					GUI.board().paintStones();
					GUI.gameOver(game.activePlayer().name() + " Wins!");
					return;
				}
			}

		}
		
	}//PlayGame()	

	private void reset() {
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				game.board().boardDisplay()[i][j] = null;
			}
		}
		GUI.board().reset();
	}

}
