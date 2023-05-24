package omokGUI;

import java.util.ArrayList;
import java.util.List;

/** a class representing a Board
 * @author julieta
 * 
 *  */
public class Board {
	/** array for the spots in the board */
	public String[][] spots;
	/** size of the board */
	public int size;
	protected java.util.List<Player> players;
	int whichPlayer = 0;
	private String line;
	public String p1Win="XXXXX";
	public String p2Win= "OOOOO";
	private List<int[]> winningRow = new ArrayList<int[]>();

	/** default constructor to create board */
	public Board(){
		size= 15 ;
		spots = new String[size][size];
	    for(int row = 0;row <size;row++){
	    	for(int col = 0 ;col<size;col++){
	    		spots[row][col]= "*";
	    	}
	    }
	    players = new ArrayList<>();
		players.add(new Player("X"));
	    players.add(new Player("O"));
	}
	
	
	/** return board size
	 *  @return n size of board
	 *  */
	public int getSize(){
		return this.size;
	}
	
	/** return array with spots
	 *  @return spots array with coordinates
	 *  */
	public String[][] getSpots(){
		return this.spots;
	}
	
	public void addMove(int x,int y,Player p){
		String player = p.getPiece();
		whichPlayer++;
		int r = convertToIndex(x);
		int c = convertToIndex(y);
		spots[r][c]= player;
	}
	
	public int convertToIndex(int x){
		float valid = 0;
		float valid2=0;
		for(int i = 0;i<=3;i++){
		      valid = x+i;
		      valid2 = x-i;
		      valid = valid/2;
		      valid2 = valid2/2;
		      if (valid % 10==0){
		        return ((int) valid/10)-1;
		      }
		      if (valid2 % 10==0){
		        return ((int) valid2/10)-1;
		      }
		    }
		    return 0 ;
	}
	
	
	int getWhichPlayer(){
		return whichPlayer;
	}
	
	public boolean isWin(){
		   int t = 15-4;
		   int[] coord= {0,0};
		   line="";
		   // for row wins
		  for (int l=0;l<t;l++){
		    for(int i= 0;i<15;i++){
		      for (int j=0;j<5;j++){
		        line+=spots[i][j+l];
		        coord[0]=i;
		        coord[1]=j+l;
				winningRow.add(coord);
		      }
		      if(line.equals(p1Win)){
		        return true ;
		      }
		      if(line.equals(p2Win)){
		        return true;
		      }
		      line="";
		      winningRow.clear();
		    }
		  }
		  //for column wins
		  for (int l=0;l<t;l++){
		    for(int i= 0;i<15;i++){
		      for (int j=0;j<5;j++){
		        line+=spots[j+l][i];
		        coord[0]=j+l;
		        coord[1]=i;
				winningRow.add(coord);
		      }
		      if(line.equals(p1Win)){
		        return true ;
		      }
		      if(line.equals(p2Win)){
		        return true;
		      }
		      line="";
		      winningRow.clear();
		    }
		  }
		  //for horizontal wins
		  for (int i=0;i<t;i++){
		    for (int j= 0;j<t;j++){
		      for (int k=0;k<5;k++){
		        line+=spots[i+k][j+k];
		        coord[0]=i+k;
		        coord[1]=j+k;
				winningRow.add(coord);
		      }
		      if(line.equals(p1Win)){
		        return true ;
		      }
		      if(line.equals(p2Win)){
		        return true;
		      }
		      line="";
		      winningRow.clear();
		    }
		  }
		  for (int i=4;i<15;i++){
		    for (int j= 0;j<t;j++){
		      for(int k=0;k<5;k++){
		        line+=spots[i-k][j+k];
		        coord[0]=i-k;
		        coord[1]=j+k;
				winningRow.add(coord);
		      }
		      if(line.equals(p1Win)){
		        return true ;
		      }
		      if(line.equals(p2Win)){
		        return true;
		      }
		      line="";
		      winningRow.clear();
		   }  
		  }
		   return false;
		 }


	public List<int[]> getWinningRow() {
		// TODO Auto-generated method stub
		return winningRow;
	}
}
	
	