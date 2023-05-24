package omok.gui;

/**
 *  @author Christian Revilla
 *	Created February 20th 2023
 */

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/** Main class to control Omok game */
public class OmokGame {
	public static final int FREE = 0, PLAYER_ONE = 1, PLAYER_TWO = 2;
	public static final int WIN_LEN = 5;
	private boolean gameOver = false;
	private OmokUI ui;
	private OmokBoard board;
	private Boolean humanOpponent; //gametype
	private OmokPlayer p1, p2;

  /** Default constructor */
  public OmokGame() {
  }

  /** Constructor takes in board and game type 
   * @param OmokBoard b
   * @param boolean h 
   */
  public OmokGame ( OmokBoard b, Boolean h ) {
    this.board = b;
    this.humanOpponent = h;
  }
  
  /**
   * Constructor takes in size and opponent 
   * @param int size,
   * @param boolean h,
   */
  public OmokGame ( int size , boolean h) {
	  this.board = new OmokBoard(size);
	  this.humanOpponent = h;
  }
  
  /** @return boolean if game is over */
  public boolean getGameOver() {
	  return this.gameOver;
  }
  
  /** @param boolean b, setter for gameOver */ 
  public void setGameOver(boolean b) {
	  this.gameOver = b;
  }
  
  /** @return OmokUI , called in console implementation */
  public OmokUI getUI () {
	  return this.ui;
  }
  
  /** @return game board */
  public OmokBoard getOmokBoard() {
    return this.board;
  }

  /** @return the gameType of game */
  public Boolean getGameType() {
    return this.humanOpponent;
  }

  /** @return Player 1 type */
  public OmokPlayer getPlayer1 () {
    return this.p1;
  }
  
  /** @return Player 2 type */
  public OmokPlayer getPlayer2 () {
    return this.p2;
  }
  
  /** @param boolean that sets user interface for game */
  public void setUI( Boolean u) {
	  this.ui = new OmokUI(u);
  }

  /** @param OmokBoard that sets board that will be used */
  public void setOmokBoard( OmokBoard b ) {
    this.board = b;
  }
  
  /** @param boolean that sets game type that'll be played */
  public void setGameType ( Boolean h ) {
    this.humanOpponent = h;
  }
  
  /** @param OmokPlayer that sets Player 1 */
  public void setOmokPlayer1 ( OmokPlayer p ) {
    this.p1 = p;
  }

  /** @param OmokPlayer that sets Player 2 */
  public void setOmokPlayer2 ( OmokPlayer p ) {
    this.p2 = p;
  }

  /** Initializes game, alternates player turns, and exit while when board is full */
  public void startOmokGame () {
    this.ui = new OmokUI(true);
    this.ui.setupOmokGame(this);
    int pNum;
 
    pNum = 1;
    while (this.board.isBoardFull() == false ) {
    	if ( this.ui.executePlayerTurn(this, pNum) == false ) break;
    	pNum = ((++pNum) % 2)==0 ? 2 : 1;
    }
  }
  
  /**
   * @param int player, represents the player
   * @return boolean if game has reached a winner or all board spots are taken
   */
  public boolean testEndOfGame(int player) {
		if ( board == null ) return false;
		
		ArrayList<List<Point>> w;
		w = board.getRowsOfLength(player, WIN_LEN);
		if ( w.size() > 0 ) {
			setGameOver(true);
		}	
		return gameOver || board.isBoardFull();
	}
  /**
   * Function to get the the current player 
   * @param int p, representing the player
   * @return OmokPlayer
   */
  public OmokPlayer getPlayer(int p) {
	  if(p== PLAYER_ONE) return this.p1;
	  else if(p == PLAYER_TWO) return this.p2;
	  return null;
  }
  /** Function meant to be overridden in subclasses, will perform a complete reset of game */
  public void resetOmokGame() {}
  
  /** Function to be overridden in subclasses, will stop the game */
  public void stopOmokGame() {}
  
  /** Function to be overridden in subclasses, will set up the game */
  public void setOmokGame() {}
  
  /** Function to be overridden, will execute the players turn */
  public void playTurn() {}

}
