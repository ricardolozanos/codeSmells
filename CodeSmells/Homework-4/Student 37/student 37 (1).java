 package omok;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

/** Displays and receives user input and outputs stones in board
 * 	@author Carlos Sandoval	*/
public class Board extends JPanel {
	private final int cell_size=30;
	private final int board_size=15;
	private final int board_width=board_size;
	private final int board_height=board_size;
	Gamecontroller gc=new Gamecontroller();
	public Board() {
		setPreferredSize(new Dimension(board_width,board_height));
		addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            Point mousePos = e.getLocationOnScreen();
	        	final int mouseX = mousePos.x;
	        	final int mouseY = mousePos.y;
	            // Do something with the clicked intersection at (row, col)
	            String player=gc.playerTurn();
	            JLabel pos=placeStone(mouseX,mouseY,player);
	            add(pos);
	            revalidate();
	            repaint();
	            gc.inform();
	            
	        }
	    });
	}
	@Override
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	for(int row=0;row<board_size;row++) {
		for(int col=0;col<board_size;col++) {
			int x=col*cell_size;
			int y=row*cell_size;
			g.drawRect(x, y, cell_size, cell_size);
		}
	}
	}

/**Will place the stone on the Board*/
public JLabel placeStone(int row,int col,String user) {
	// TODO Auto-generated method stub
	/** Declares which players turn*/
	//char symbol=' ';
	JLabel pos=new JLabel();
	Color color=pos.getBackground();
	if(user.equals("Player 1")) {
		//symbol='X';
		   pos.setBackground(color);
	   	   pos.setForeground(Color.RED);
	   	   pos.setFont(new Font("Ink Free",Font.BOLD,32));
	   	   pos.setText("X");
	   	   pos.setBounds(row, col, 100, 30);
	   	   //pos.setHorizontalAlignment(JLabel.CENTER);
	   	   pos.setOpaque(true);
	   	   return pos;
	}else if(user.equals("Player 2")){
		//symbol='O';
		   pos.setBackground(color);
	   	   pos.setForeground(Color.GREEN);
	   	   pos.setFont(new Font("Ink Free",Font.BOLD,32));
	   	   pos.setText("X");
	   	   pos.setBounds(row, col, 50, 50);
	   	   pos.setHorizontalAlignment(JLabel.CENTER);
	   	   pos.setOpaque(true);
	   	   return pos;
	}	
	return pos;
}
/**Checks if the stone landed in the coordinates listed on the board
if not they will be given one more opportunity as explained on GameController method*/
	public boolean isValidPosition(int row,int col) {
		 if(row<1||row>15) {
			return false;
		} if(col<1||col>15) {
			return false;
		}
		return true;
	}
}
