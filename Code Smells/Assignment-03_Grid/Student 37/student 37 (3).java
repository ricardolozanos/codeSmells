import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;
public class MyPanel extends JPanel {
	
	 MyPanel(){
		this.setPreferredSize(new Dimension(500,500));
	}
	public void paint(Graphics g) {
		Graphics2D g2D=(Graphics2D)g;
		//g2D.setPaint(Color.BLUE);
		g2D.setStroke(new BasicStroke(2));
		//g2D.drawLine(0, 0, 500, 500);
        for (int i = 24; i<=800; i+=24)
{
  g2D.drawLine(i, 0, i, 800); 
}
for (int i = 24; i<=800; i+=24)
{
  g2D.drawLine(0, i, 800, i); 
}
g2D.setPaint(Color.BLUE);
g2D.fillOval(326, 326, 20, 20);
g2D.setPaint(Color.RED);
g2D.fillOval(300, 300, 20, 20);
g2D.setFont(new Font("Ink Free",Font.BOLD,50));
g2D.drawString("Carlos Sandoval", 100, 210);
	}
}