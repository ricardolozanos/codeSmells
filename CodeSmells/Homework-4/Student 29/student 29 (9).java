package omok.gui;

/**
 * @author Christian Revilla
 * Created February 20th 2023
 */

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Class to control all user interactions in Omok game */
public class OmokUI extends OmokGame {
  private Boolean uiEnabled;
  
  /**  Default constructor */
  public OmokUI() {	  
  }

  /** @param boolean constructor accepts status of UI and sets it */
  public OmokUI( Boolean s ) {
    this.uiEnabled = s;
  }
  
  /** @return status of UI */
  public Boolean getOmokUIStatus() {
    return this.uiEnabled;
  }
  
  /** @param boolean s accepts status of UI and sets it */
  public void setOmokUIStatus ( Boolean s ) {
    this.uiEnabled = s;
  }
  
  /** Sets correct board size, game mode, and player types for Omok game */
  @SuppressWarnings("resource")
  public void setupOmokGame( OmokGame omokGame ) {
    int gameSize, gameType;
    System.out.println("Welcome to Omok!");

    Scanner in = new Scanner (System.in);
    while(true) {
      System.out.print("Please enter board size (min 15): ");
      gameSize = in.nextInt();
      in.nextLine();
      if ( gameSize  > 0 ) break;
    }

    omokGame.setOmokBoard( new OmokBoard(gameSize) ) ;
    while (true) {
      System.out.print("Please enter game type: 1 -h vs h or 2- h vs ai: ");
      gameType = in.nextInt();
      in.nextLine();
      if ( gameType == 1 || gameType == 2 || gameType == 3 ) break;
    }
    
    //NEW CODE
    omokGame.setGameType(false);
    
    // AI vs AI used to test if code doesn't crash
    if ( gameType == 3 ) {
    	omokGame.setOmokPlayer1 ( new OmokAI("AI1",false));// , false ));
    	omokGame.setOmokPlayer2 ( new OmokAI("AI2",false));// , false ));
    	return;
    }
    
    //NEW CODE
    omokGame.setGameType(true);

    System.out.print("Please enter your name: ");
    omokGame.setOmokPlayer1 (new OmokPlayer(in.nextLine(),true)); //p1 is always human...

    if ( gameType == 2 ) {
      omokGame.setOmokPlayer2 ( new OmokAI("AI",false ));//, false ));
    } else {
      System.out.print("Please enter opponent's name: ");
      omokGame.setOmokPlayer2 (new OmokPlayer(in.nextLine(),true));
    }
  }

  /** Finds correct players turn, takes in point input, if valid updates, if not try new point */
  @SuppressWarnings("resource")
  public Boolean executePlayerTurn ( OmokGame g , int pNum) {
	String[] s = new String[2];
    Scanner in = new Scanner (System.in);
    OmokPlayer p = pNum == 1 ? g.getPlayer1() : g.getPlayer2();
    OmokAI h = new OmokAI("hint",false);
    OmokPoint m;

    drawOmokBoard(g.getOmokBoard(), null);
   
	if ( g.getOmokBoard().isBoardFull() == true ) {
		System.out.println("Game ended with a full board with no winner!");
		return false;  
	}
	
    while (true) {
    	if ( p.getPlayerType() ) {
    		System.out.print(p.getPlayerName() + " Please enter coordinate (x, y) of point selected, -1 to quit, -99 for hint e.g. 1 5: ");
            s = in.nextLine().split(" ");
            if ( s.length == 1 ) {
            	//Extra credit bonus points 
            	if ( Integer.parseInt(s[0]) == -99 ) {
            		m = h.aiPlayer(g.getOmokBoard(),pNum);
            		System.out.println("");
            		System.out.println(h.getPlayerName() + ": (" + (m.x()) + "," + (m.y()) + ")");
            		//System.out.println("we are here");
            		continue;
            	} else if (Integer.parseInt(s[0]) == -1) {
            		System.out.println("");
            		System.out.println("Game ended by user with no winner!");
            		return false;
                	//System.exit(0);
            	} else continue;
            } else if ( s.length == 2 ) {
            	m = new OmokPoint(Integer.parseInt(s[0])-1,Integer.parseInt(s[1])-1,pNum);
            } else continue;
    	} else {
    		m = ((OmokAI) p).aiPlayer(g.getOmokBoard(),pNum);
    		System.out.println(p.getPlayerName() + " selected: (" + (m.x()) + "," + (m.y()) + ")");
    	}
    	if ( g.getOmokBoard().placePoint(m) ) break;
    }
    
    	ArrayList<List<Point>> win;
    	win = g.getOmokBoard().getRowsOfLength(pNum, OmokGame.WIN_LEN);
    	if ( win.size() > 0 ) {
    		drawOmokBoard(g.getOmokBoard(),win.get(0));
    		System.out.println(p.getPlayerName() + " has won the game!");
    		System.out.println("Winning row: " + win.get(0).toString());
    		return false;
    	}
    	return true;
    }
 
  
  /** Displays current status of Omok board to user */
	public void drawOmokBoard(OmokBoard board, List <Point> p) {
		int i, j, k, size;
		size = board.getOmokBoardSize();
		int [][]b = board.getOmokBoard();
		String ANSI_RESET = "\u001b[0m";
		String ANSI_REVERSE = "\u001b[7m";
		String ANSI_BOLD = "\u001b[1m";
		
		System.out.print(ANSI_BOLD + "     x ");
		for (i=0; i<size; ++ i) System.out.printf("%2d ", i);
		System.out.println(ANSI_RESET);
		
		for (i=0; i<size; ++i) {
			System.out.print(ANSI_BOLD);
			if ( i==0 ) System.out.print("y "); else System.out.print("  ");
			System.out.printf("%2d | ", i);
			System.out.print(ANSI_RESET);
			for (j=0; j<size; ++j) {
				if ( p != null && p.size() > 0 ) {
					for (k=0; k<p.size(); ++k) {
						if (j == p.get(k).x && i == p.get(k).y) {
							System.out.print(ANSI_REVERSE);
							break;
						}
					}
				}
				if ( b[j][i] == OmokGame.FREE ) {
					System.out.print(" . ");
				} else if ( b[j][i] == OmokGame.PLAYER_ONE ) {
					System.out.print(" x ");
				} else if ( b[j][i] == OmokGame.PLAYER_TWO ) {
					System.out.print(" o ");
				}
				System.out.print(ANSI_RESET);
			}
			System.out.println();
		}
		System.out.println();
	}
}

