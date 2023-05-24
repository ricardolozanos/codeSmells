package omokGUI;


public class Player {
	private String piece;

	public Player(String piece){
	    this.piece = piece;
	  }
	
	public String getPiece(){
	    return piece;
	  }
	
	public int getNextPlayerNum(){
		if (piece =="X") {
			return 2;
		}
		return 1;
	}

}
