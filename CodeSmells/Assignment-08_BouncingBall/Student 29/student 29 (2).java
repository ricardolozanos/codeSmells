package BouncingBall;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;


@SuppressWarnings("serial")
public class BouncingBallRunner extends noapplet.AnimationNoApplet{

	Ball[] b = new Ball[1];
	protected Dimension dim;
	protected Font font =  new java.awt.Font("Sans-serif", Font.BOLD, 24);

    public void init() {
        super.init();
        dim = getSize();
        int x = (dim.width  * 2) / 3;
        int y = (dim.height * 2) / 3;

        b = new Ball[4];
        b[0] = new CircleBall(x-40,y,-2,-4,10,Color.GREEN);
        b[1] = new CircleBall(x+50,y,-1,4,10,Color.RED);
        b[2] = new CircleBall(x,y+30,2,2,25,Color.ORANGE);
        b[3] = new CircleBall(x,y-30,2,2,20,Color.BLUE);
    }
   
   protected void paintComponent(Graphics g) {
	   
	   g.setColor(Color.BLACK);
       g.fillRect(0, 0, dim.width, dim.height);
       g.setFont(font);
       g.setColor(Color.YELLOW);
       g.drawString("Christian Revilla" , dim.height / 2 - 100 , dim.width/2 );
       

       b[0].drawBall(g,b);

    }

    public static void main(String[] args) {
    	new BouncingBallRunner().run();
	}

}
