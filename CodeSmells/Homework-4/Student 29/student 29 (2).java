package omok.gui;

/**
 *  @author Christian Revilla
 *	Created February 20th 2023
 */

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/** Board for OmokGame */
public class OmokBoard {
	private int[][] gameBoard;
	private int gameBoardSize;
	public static enum WinType { LROW, RROW, UCOL, DCOL, UDR, DDR, UDL, DDL };
 
	/** Default constructor */
	public OmokBoard() {  
	} 
  
	/** Constructor when passed a board size */
	public OmokBoard ( int size ) {
		this.gameBoard = new int[size][size];    
		this.gameBoardSize = size; 
	}  
  
	/** @return int[][] representing the board */ 
	public int[][] getOmokBoard() {    
		return this.gameBoard;  
	}
  
	/** @return int of board size */
	public int getOmokBoardSize() {
		return this.gameBoardSize;
	}

	/** @return boolean indicating if board is full or not */
	public Boolean isBoardFull() {
		for (int i=0; i<gameBoardSize; ++i)
			for (int j=0; j<gameBoardSize; ++j)
				if ( isFree(i,j) ) return false;
		return true;
	}
  
  /**
   * A winning row is a consecutive sequence of five or more stones placed by the same 
   * player in a horizontal, vertical, or diagonal direction
   * @return boolean indicating if the given player has won the game or not. 
   * @param int representing the player number
   */
	public boolean isWonBy(int pNum ) {
		if ( getRowsOfLength(pNum, OmokGame.WIN_LEN).size() > 0 ) return true;
		return false;
	}

	/** @return List<Point> The list includes all points occupied by the given player 
	 *  @param int representing the player number 
	 */
	public List<Point> getOccupiedMoves(int pNum ) {
		List<Point> usedMoves = new ArrayList<Point>();
		for (int row = 0; row < gameBoardSize; row++) {
			for (int col = 0; col < gameBoardSize; col++) {
				if (isOccupiedBy(row,col,pNum) ){
					usedMoves.add(new Point(row, col));
				}
			}
		}
		return usedMoves;
	}
	
	/** @return List<OmokPoint> The list includes all points occupied on the board */
	public List<OmokPoint> getOccupiedMoves() {
		List<OmokPoint> usedMoves = new ArrayList<OmokPoint>();
		for (int row = 0; row < gameBoardSize; row++) {
            for (int col = 0; col < gameBoardSize; col++) {
            	if ( isFree(row,col) == false )
            		usedMoves.add(new OmokPoint(row,col,gameBoard[row][col]));
            }
        }
        return usedMoves;		
	}
	
	/** @return boolean a boolean that indicates whether the given coordinates are on the board*/
	public boolean inRange(int x, int y) {
		if ( x<0 || y<0 || x >=gameBoardSize || y >= gameBoardSize) return false;
		return true;
	}
	
	/** @return boolean a boolean that indicates whether the position is valid and empty 
	 *  @param int x representing the x position on board
	 *  @param int y representing the y position on board
	 */
	public boolean isFree( int x, int y) {
		return inRange(x,y) && gameBoard[x][y] == OmokGame.FREE;
	}
	

	/** @return ArrayList<List<Point>> a ArrayList of rows (List of points) of the specified length for the given player 
	 *  @param int representing the player number
	 *  @param int len representing the consecutive points of desired length* for requested player 
	 */
	public ArrayList<List<Point>> getRowsOfLength( int pNum, int len ) {
		ArrayList<List<Point>> allRows = new ArrayList<List<Point>>();
		
		for (int x=0; x<gameBoardSize; ++x) {
			for (int y=0; y<gameBoardSize; ++y) {
				OmokPoint np = new OmokPoint(x, y, pNum);
				if ( isOccupiedBy(np) == false ) continue;
				for ( WinType wt : WinType.values() ) {
					List<Point> aSequence = getRowFromPoint(np, wt);
					if ( aSequence.size() == len ) {		
						allRows.add(aSequence);
					}
				}
			}
		}
		return allRows;
	}
	
	/** @return boolean representing if the position is occupied by the given player 
	 *  @param int x representing the x position on board
	 *  @param int y representing the y position on board
	 *  @param int representing the player  
	 */
	public boolean isOccupiedBy ( int x, int y, int player ) {
		return inRange(x,y) && gameBoard[x][y] == player;
	}
	
	/** @return boolean representing if the position is occupied by the player given in OmokPoint
	 *  @param OmokPoint p with coordinates and player value
	 */
	public boolean isOccupiedBy ( OmokPoint p ) {
		return isOccupiedBy(p.x(),p.y(),p.val());
	}
	
	/** @return Point returns the next point in the direction specified. 
	 *  @param Point p representing the specific coordinate on board 
	 *  @param Enum d representing the sequence in which searching for winner 
	 * UDL	UCOL UDR
	 * LROW	  *  RROW
	 * DDL	DCOL DDR
	 */
	private Point nextPoint ( Point p, WinType d ) {
		int x = p.x;
		int y = p.y;
		
		switch (d) {
		case LROW: x -=1;  break;
		case RROW: x +=1;  break;
		case UCOL: y -=1;  break;
		case DCOL: y +=1;  break;
		case UDR:  x +=1; y -=1; break;
		case DDR:  x +=1; y +=1; break;
		case UDL:  x -=1; y -=1; break;
		case DDL:  x -=1; y +=1; break;
		}
		return new Point(x,y);
	}	
	
	/** @return List<Point> returns a list of points (row) from the given position in the direction specified 
	 *  @param OmokPoint op representing the point on the board
	 *  @param Enum d representing the sequence direction to check for
	 */
	private List<Point> getRowFromPoint ( OmokPoint op, WinType d) {
		List<Point> row = new ArrayList<Point>();
		Point np = new Point (op.x(),op.y());
		
		do {
			row.add(np);
			np = nextPoint(np,d);
	    } while ( isOccupiedBy(new OmokPoint(np.x,np.y,op.val())) );
		return row;		
	}	

	/** @return boolean if the position is free. It's value will be set to the given player 
	 *  @param int x, representing the x coordinate on the board
	 *  @param int y, representing the y coordinate on the board
	 *  @param int player, representing the player intending to place the point
	 *  */
	private boolean placePoint ( int x, int y, int player ) {
		if ( isFree(x,y) == false ) return false;
		gameBoard[x][y] = player;
		return true;
	}

	/** @return boolean if the position is free. 
	 *  @param OmokPoint p, representing the point on the board */
	public boolean placePoint ( OmokPoint p ) {
		return isFree(p.x(), p.y()) && placePoint ( p.x(), p.y(), p.val());
	}
	
	/** Clears all points on a board */
	public void boardClear() {
		for (int x=0; x<gameBoardSize; ++x)
			for (int y=0; y<gameBoardSize; ++y)
				gameBoard[x][y] = OmokGame.FREE;
	}

	/** this function will return a list of list with the available free spots on either side 
	 * of specific row, col, or diagonal that is given
	 *  @return List<Point> a list of points at the end of a row that are free 
	 *  @param Array<List<Point>> contains the sequence of specific player 
	 *  */
	public List<Point> findFreeRowEnds( ArrayList<List<Point>> rows ) {
		List<Point> moves = new ArrayList<Point>();
		int n, dx, dy;
		Point p1 = null;
		
		for ( List<Point> lp : rows ) {
			n = lp.size()-1;
			dx = lp.get(n).x - lp.get(0).x;
			dy = lp.get(n).y - lp.get(0).y;		
			
			if ( dx > 0 && dy == 0 ) {
				p1 = nextPoint(lp.get(n),WinType.RROW);
			} else if ( dx == 0 && dy > 0 ) {
				p1 = nextPoint(lp.get(n),WinType.DCOL);				
			} else if ( dx > 0  && dy > 0 ) {
				p1 = nextPoint(lp.get(n),WinType.DDR);
			} else if ( dx < 0 && dy > 0 ) {
				p1 = nextPoint(lp.get(n),WinType.DDL);
			} else if ( dx < 0 && dy == 0 ) {
				p1 = nextPoint(lp.get(n),WinType.LROW);
			} else if ( dx == 0 && dy < 0 ) {
				p1 = nextPoint(lp.get(n),WinType.UCOL);
			} else if ( dx < 0 && dy < 0 ) {
				p1 = nextPoint(lp.get(n),WinType.UDL);
			} else if ( dx > 0 && dy < 0 ) {
				p1 = nextPoint(lp.get(n),WinType.UDR);
			} else {
				System.err.println("Unsupportted quadrant!");
			}
			if ( isFree(p1.x,p1.y) ) moves.add(p1);
		}
		return moves;		
	}
	
	@Override
	/** Standard toString function to display contents in specific format */
	public String toString() {
		String str = "";
		if ( gameBoard == null ) return str;
		
		str += "     x ";
		for (int i=0; i<gameBoardSize; ++ i) str += String.format("%2d ", i);
		str += "\n";
		
		for (int i=0; i<gameBoardSize; ++i) {
			if ( i==0 ) str += "y "; else str +="  ";
			str += String.format("%2d | ",i);
			for (int j=0; j<gameBoardSize; ++j) {
				if ( isFree(j,i) ) {
					str += " . ";
				} else if ( isOccupiedBy(j,i,OmokGame.PLAYER_ONE) ) {
					str += " x ";
				} else if ( isOccupiedBy(j,i,OmokGame.PLAYER_TWO)) {
					str += " o ";
				}		
			}
			str += "\n";
		}
		return str;
	}
}
