import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class BoardPanel extends JPanel{
	private Game game;
	private int size;
	private JPanel boardpanel;
	private JButton[][] Buttons;
	private JPanel B1;
	private Board b;
	private int turn;
	private JTextArea area;
	private Player player1;
	private Player player2;
	private Computer p2 = null;
	
	public void setTurn(int a) {this.turn = a;}
	public BoardPanel() {super();}
	public BoardPanel(Game g, JTextArea area, Player p1, Player p2) {
		this.player1 = p1;
		this.player2 = p2;
		if(p2 instanceof Computer) {
			this.p2 = (Computer)p2;
		}
		this.area = area;
		this.game = g;
		this.turn = 1;
		this.b = game.getBoard();
		JPanel Board= new JPanel(new BorderLayout(3,3));
		this.add(Board);
		
		this.size = g.getBoard().size();
		Buttons = new JButton[size][size];	
		this.B1 = new JPanel(new GridLayout(0,size));
		B1.setBorder(new LineBorder(Color.black));
		
		Board.add(B1);
		
		for(int i = 0; i < Buttons.length; i++) {
			for(int j = 0; j < Buttons[i].length; j++) {
				boardButton b = new boardButton(i,j);
				b.setMargin(new Insets(7,7,7,7));
				b.addMouseListener(new ClickAction(b,this.b, this));
				Buttons[i][j] = b;
			}
		}
		for(int i = 0; i < Buttons.length; i++) {
			for(int j = 0; j < Buttons.length; j++) {
				B1.add(Buttons[i][j]);
			}
		}
	}
	
	public class ClickAction implements MouseListener {
		private Board b;
		private boardButton button;
		private BoardPanel boardPanel;
		
		public ClickAction() {
			super();
		}
		public ClickAction(boardButton j, Board b, BoardPanel BP) {
			super();
			this.b = b;
			this.button = j;
			this.boardPanel = BP;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if(boardPanel.turn == 1) {
				if(b.isOccupied(button.getXforBoard(),button.getYforBoard())) {
					area.append("That Spot Is Occupied Please choose another");
				}else {
					b.placeStone(button.getXforBoard(),button.getYforBoard(), boardPanel.player1);
					button.setBackground(Color.BLACK);
					player1.setPastX(button.getXforBoard());
					player1.setPastY(button.getYforBoard());
					if(b.isWonBy(player1)) {
						area.setText("Player 1 Has Won!");
						boardPanel.setTurn(0);
					}
					if(p2 != null) {
						area.setText("Have Fun Against The Computer!");
						b = p2.turn(b, player1.getPastX(),player1.getPastY());
						int tempx = p2.pastX;
						int tempy = p2.pastY;
						Buttons[tempx][tempy].setBackground(Color.RED);
						if(b.isWonBy(p2)) {
							area.setText("Computer Has Won!");
							boardPanel.setTurn(0);
						}
					}else {
						boardPanel.setTurn(2);
						area.setText("it is Player 2 turn");
					}
				}
			}else if(boardPanel.turn == 2) {
				if(b.isOccupied(button.getXforBoard(),button.getYforBoard())) {
					area.append("That Spot Is Occupied Please choose another");
				}else {
					b.placeStone(button.getXforBoard(),button.getYforBoard(), boardPanel.player2);
					button.setBackground(Color.RED);
					boardPanel.setTurn(1);
					area.setText("it is Player 1 turn");
					if(b.isWonBy(player2)) {
						area.setText("Player 2 Has Won!");
						boardPanel.setTurn(0);
					}
				}
			}else {area.setText("Game Has Already Ended!");}
		}

		@Override
		public void mousePressed(MouseEvent e) {/*isnt used*/}

		@Override
		public void mouseReleased(MouseEvent e) {/*isnt used*/}

		@Override
		public void mouseEntered(MouseEvent e) {/*isnt used*/}

		@Override
		public void mouseExited(MouseEvent e) {/*isnt used*/}
	}
	
	public class boardButton extends JButton {
		private int X;
		private int Y;
		
		public int getXforBoard() {return this.X;}
		public int getYforBoard() {return this.Y;}
		public boardButton() {
			super();
		}
		public boardButton(int x, int y) {
			super();
			this.X = x;
			this.Y = y;
		}
	}
}
