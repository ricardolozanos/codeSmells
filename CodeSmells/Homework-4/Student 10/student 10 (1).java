package omokGUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	
	private Board board = new Board();
	private List<int[]> spots = new ArrayList<int[]>();
	public Color c;
	private List<int[]> winning= new ArrayList<int[]>();
	
	
	BoardPanel(){
		setPreferredSize(new Dimension(320,320));
	};
	
	
	@Override
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.setColor(new Color(252,248,249));		
		g.fillRect(0, 0, d.width, d.height);
		g.setColor(Color.BLACK);
		for(int i = 20;i<320;i+=20) {
			g.drawLine(i,0, i, 320);
			g.drawLine(0,i, 320, i);
		}
		for(int[] s: spots) {
			if (s[2]==1) {
				g.setColor(Color.BLACK);
			}else {
				g.setColor(Color.PINK);
			}
			//g.fillOval(s[0]-10, s[1]-10, 15, 15);
			g.fillOval(s[0]-10, s[1]-10, 20, 20);
		}
		for(int[] w: winning) {
			g.setColor(Color.RED);
			System.out.println(w[0]+" "+w[1]);
			g.drawOval(w[0]*20+20, w[1]*20+20, 25, 25);
			
		}

	}
	
	Board getBoard(){
		return board;
	}
	
	void addPlace(int x,int y,Player p){
		int[] coord = {x,y,0};
		if(p.getPiece()=="X") {
			coord[2] = 1; 
			}
		else {
			coord[2] = 2;
		}
		
		spots.add(coord);
		board.addMove(x, y, p);
	}
	
	Player getPlayer(){
		int player = board.getWhichPlayer();
		if (player%2==0) {
			return board.players.get(0);
		}
		return board.players.get(1);
	}
	
	void winningRow(List<int[]> w){
		winning = w ;
	}
	
	

}
