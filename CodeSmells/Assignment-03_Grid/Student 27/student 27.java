package Homework;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import noapplet.NoApplet;

@SuppressWarnings("serial")
public class exercise_Omok_board extends NoApplet {
	
	public exercise_Omok_board() {
	}

	public exercise_Omok_board(String[] params) {
		super(params);
	}
	
    protected void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.setColor(new Color(255, 215,0));
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(Color.BLACK);
        int x1 = d.width/16;
        int y1 = d.height/16;
        for(int i = 1; i <= 16; i++) {     	
        	g.drawLine(0,y1,d.width,y1);
        	g.drawLine(x1, 0, x1, d.height);
        	y1 += d.height/16;
        	x1 += d.width/16;
        }
        
        g.setColor(Color.RED);
        g.fillOval(570, 346, 50, 50);
        g.setColor(Color.BLACK);
        g.fillOval(655, 346, 50, 50);
        g.drawString("Nathanael Perez", 60, 40);
    }  
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// generates new window size to fit my computer
		new exercise_Omok_board(new String[] {"width=2736", "height=1824"}).run();
	}

}
