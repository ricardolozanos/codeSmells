package omok;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel{
	
		private Player[][] board;
		
		private int[] coords = new int[2];
		private int x = -1;
		private int y = -1;
	
		private int space = 30;
		
		public BoardPanel() {
			addMouseListener(new MouseAdapter() {
	            @Override
	            public void mousePressed(MouseEvent e) {
		            if(e.getX() > 15 && e.getX() < 465 && e.getY() > 135 && e.getY() < 585) {
		            	x = e.getX();
			            y = e.getY();
		            	setX();
		            	setY();
		            	paintTester();
	            	}
	            }
	        });
		}
		
		public void paintTester() {
			getGraphics().drawOval(20 + x*space, 140 + y*space, 20, 20);
		}
		
		public void paintStones() {
			for(int i = 0; i < 15; i++) {
				for(int j = 0; j < 15; j++) {
					if(board[i][j] != null) {
						getGraphics().setColor(board[i][j].color());
						getGraphics().fillOval(20 + j*space, 140 + i*space, 20, 20);
					}
				}
			}
		}
		
		public void setBoard(Player[][] board) {
			this.board = board;
		}
		
		public int[] getPiece() {
			coords[0] = x;
			coords[1] = y;
			return coords;
		}
		
		public void resetCoords() {
			x = -1;
			y = -1;
			System.out.println("Done");
		}
		
		public void setX() {
			for(int i = 1; i < 30; i += 2) {
    			if(x < (30 + (i*15))) {
    				x = (i - 1) / 2;
    				return;
    			}
        	}
		}
		
		public void setY() {
			for(int i = 1; i < 30; i += 2) {
    			if(y < (150 + (i*15))) {
    				y = (i - 1) / 2;
    				return;
    			}
    		}
		}
		
		public void reset() {
			getGraphics().setColor(Color.orange);
			getGraphics().fillRect(30, 150, 420, 420);
			getGraphics().setColor(Color.black);
			for(int i = 0; i < 15; i++) {
				getGraphics().drawLine(30 + i*space, 150, 30 + i*space, 570);
				getGraphics().drawLine(30, 150 + i*space, 450, 150 + i*space);
			}
		}
		
		
		protected void paintComponent(Graphics g) {
			g.setColor(Color.orange);
			g.fillRect(30, 150, 420, 420);
			g.setColor(Color.black);
			for(int i = 0; i < 15; i++) {
				g.drawLine(30 + i*space, 150, 30 + i*space, 570);
				g.drawLine(30, 150 + i*space, 450, 150 + i*space);
			}
		}
		
		
		
	}
