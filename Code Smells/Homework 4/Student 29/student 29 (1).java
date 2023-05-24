package omok.gui;

/**
 *  @author Christian Revilla
 *	Created February 20th 2023
 */

import java.awt.Point;
import java.util.List;
import java.util.Random;

/** subclass of OmokPLayer to represent AI opponent */
public class OmokAI extends OmokPlayer {
	
	/** Default constructor obtained from super class */
	protected OmokAI(String name, Boolean human) {
		super(name, human);
	}

	/** 
	 * Collects free points on the edges of rows, columns, or diagonals that are suggested as moves.
	 * It prioritizes longer sequences as they provide the most danger
	 * @param OmokBoard b
	 * @param int pNum, player number
	 * @return a suggested point for the AI to place on board or for hint to human player
	 */
	public OmokPoint aiPlayer (OmokBoard b, int pNum) {
		
		int opp = pNum == OmokGame.PLAYER_ONE ? OmokGame.PLAYER_TWO : OmokGame.PLAYER_ONE;
		int n = OmokGame.WIN_LEN-1;
		List<Point> moves;
		Random r = new Random();
		
		//--- safety check
		if ( b == null || pNum == OmokGame.FREE || b.isWonBy(opp) || b.isBoardFull() ) return null;
		
		//AI: Can AI win in this turn?
		moves=b.findFreeRowEnds(b.getRowsOfLength(pNum,n));

		//AI: If necessary, attempt to block opponents rows, longer rows have priority
		while ( moves.size() == 0 && n > 2 ) {
			moves=b.findFreeRowEnds(b.getRowsOfLength(opp,n));
			n--;		
		}
		
		//AI: If all else fails, pick randomly from free options...
		if (moves.size() == 0 )
			moves = b.getOccupiedMoves(OmokGame.FREE);
		
		//System.out.println("Moves: " + moves.size() + " " + moves.toString());
		
		int index = r.nextInt(moves.size());	// pick one at random
		return new OmokPoint (moves.get(index).x, moves.get(index).y, pNum);
	}
}
