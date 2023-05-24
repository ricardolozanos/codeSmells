package omokGUI;

import java.util.Random;

import javax.swing.JLabel;

public class Computer implements Mode {


	Random rand = new Random(); 

	@Override
	public void start(BoardPanel board, JLabel label, int x, int y) {
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
      	
      	
      	int x2 = rand.nextInt(15);
      	int y2 = rand.nextInt(15);
      	if(board.getBoard().getSpots()[x2][y2]!="*"){
           x2 = rand.nextInt(15); 
           y2 = rand.nextInt(15);
         }
      	p = board.getPlayer();
     	label.setText("Player "+p.getNextPlayerNum() +" turn");
      	board.addPlace(x2*20+20, y2*20+20, p);
      	board.repaint();
      	if (board.getBoard().isWin()==true) {
      		if (p.getNextPlayerNum()==2) {
      		label.setText("Player "+ 2 +" win!");
      		}
      		label.setText("Player "+ 1 +" win!");
      	}
      	
		
	}

}
