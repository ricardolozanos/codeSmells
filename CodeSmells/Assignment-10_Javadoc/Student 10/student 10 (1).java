package omok;
/** a class representing a Board
 * @author julieta
 * 
 *  */
public class Board {
	/** array for the spots in the board */
	public String[][] spots;
	/** size of the board */
	public int n;

	/** default constructor to create board */
	public Board(){
		n= 15 ;
		spots = new String[n][n];
	    for(int row = 0;row <n;row++){
	    	for(int col = 0 ;col<n;col++){
	    		spots[row][col]= "*";
	    	}
	    }
	}
	
	/** optional constructor to create custom board
	 *  @param n size of board
	 *  */
	public Board(int n) {
		this.n=n;
		spots = new String[n][n];
		for(int row = 0;row <n;row++){
			for(int col = 0 ;col<n;col++){
				spots[row][col]= "*";
			}
		}
	 }
	
	/** draws board/array spots
	 *  */
	public void drawBoard() {
		for(int row = 0;row <n;row++){
			for(int col = 0 ;col<n;col++){
				System.out.print(spots[row][col]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/** return board size
	 *  @return n size of board
	 *  */
	public int getSize(){
		return this.n;
	}
	
	/** return array with spots
	 *  @return spots array with coordinates
	 *  */
	public String[][] getSpots(){
		return this.spots;
	}
	
}