/**
 * @author Christian Revilla
 * Created February 20th 2023
 */

import java.util.Scanner;

/** Class to control all user interactions in Omok game */
public class OmokUI extends OmokGame {
  private Boolean uiEnabled;
  
  /**  Default constructor */
  public OmokUI() {	  
  }

  /** @paramBoolean constructor accepts status of UI and sets it */
  public OmokUI( Boolean s ) {
    this.uiEnabled = s;
  }
  
  /** @return status of UI */
  public Boolean getOmokUIStatus() {
    return this.uiEnabled;
  }
  
  /** @paramBoolean s accepts status of UI and sets it */
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
      if ( gameSize  > 14 ) break;
    }

    omokGame.setOmokBoard( new OmokBoard(gameSize) ) ;
    while (true) {
      System.out.print("Please enter game type: 1 -h vs h or 2- h vs ai: ");
      gameType = in.nextInt();
      in.nextLine();
      if ( gameType == 1 || gameType == 2 || gameType == 3 ) break;
    }
    
    // AI vs AI used to test if code doesn't crash
    if ( gameType == 3 ) {
    	omokGame.setOmokPlayer1 ( new OmokAI("AI1",false , false , false));
    	omokGame.setOmokPlayer2 ( new OmokAI("AI2",false , false , false));
    	return;
    }
    
    System.out.print("Please enter your name: ");
    omokGame.setOmokPlayer1 (new OmokPlayer(in.nextLine(),true)); //p1 is always human...

    if ( gameType == 2 ) {
      omokGame.setOmokPlayer2 ( new OmokAI("AI",false , false , false));
    } else {
      System.out.print("Please enter opponent's name: ");
      omokGame.setOmokPlayer2 (new OmokPlayer(in.nextLine(),true));
    }
  }

  /** Finds correct players turn, takes in point input, if valid updates, if not try new point */
  @SuppressWarnings("resource")
  public int executePlayerTurn ( OmokGame g , int pNum) {
    int x, y;
    String[] s = new String[2];
    Scanner in = new Scanner (System.in);
    OmokPlayer p = pNum == 1 ? g.getPlayer1() : g.getPlayer2();
 
    if ( p.getPlayerType() ) {
      while (true) {
        System.out.print(p.getPlayerName() + " Please enter coordinate (x, y) of point selected, -1 to quit, e.g. 1 5: ");
        s = in.nextLine().split(" ");
        if ( s.length != 2 && Integer.parseInt(s[0]) == -1) return -1;
        else if ( s.length != 2 ) continue;
        x = Integer.parseInt(s[0])-1;
        y = Integer.parseInt(s[1])-1;
        if ( g.getOmokBoard().updateBoard(x,y,pNum,true) ) break;
      }
    } else {
      ((OmokAI) p).aiPlayer(g.getOmokBoard(),pNum);
    }
    return 0;
  }

  /** Displays current status of Omok board to user */
  public void drawOmokBoard ( OmokBoard b ) {
	    int i, j;

	    b.setBoardFull(true);
	    System.out.print("y/x");
	    for (i=0; i<b.getOmokBoardSize(); ++ i) {
	      System.out.printf("%2d ", (i+1));
	    }
	    System.out.println();
	    for (i=0; i<b.getOmokBoardSize(); ++i ) {
	      System.out.printf("%2d ", (i+1));
	      for (j=0; j<b.getOmokBoardSize(); ++j) {
	        if ( b.getOmokBoard()[i][j] == 0 ) {
	          b.setBoardFull(false);
	          System.out.print(" . ");
	        } else if ( b.getOmokBoard()[i][j] == 1 ) {
	          System.out.print(" X ");
	        } else if ( b.getOmokBoard()[i][j] == 2 ) {
	          System.out.print(" * ");
	        } else {
	          System.out.print("!error invalid player: " + b.getOmokBoard()[i][j]);
	        }
	      }
	      System.out.println();
	    }
	  }

}
