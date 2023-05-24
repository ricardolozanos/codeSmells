package omokGUI;

import javax.swing.JLabel;

public class Human implements Mode {

	@Override
	public void start(BoardPanel board,JLabel label,int x,int y ) {
		// TODO Auto-generated method stub
		Player p = board.getPlayer();
   	 	label.setText("Player "+p.getNextPlayerNum() +" turn");
   	 	board.addPlace(x,y, p);
   	 	board.repaint();
   	 if (board.getBoard().isWin()==true) {
   		if (p.getNextPlayerNum()==2) {
   		label.setText("Player "+ 2 +" win!");
   		}
   		label.setText("Player "+ 1 +" win!");
   	}
		
	}
	
	

}
