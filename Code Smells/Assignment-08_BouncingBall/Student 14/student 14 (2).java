package BouncingBall;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Font;

import noapplet.example.AnimationNoApplet;

public class BouncingBall extends AnimationNoApplet{
    int w, h, numballs;
    List<bouncable> blist = new ArrayList<bouncable>();
    Colsdet clois;
    Random ran = new Random();
    List<Color> colors = new ArrayList<Color>();

    
    public BouncingBall(String[] args, int numballs) {
    	super(args);
        this.numballs=numballs;
        colors.add(Color.white);
        colors.add(Color.green);
        colors.add(Color.blue);
        colors.add(Color.red);

    }

    @Override
    protected void initAnimation() {
        for (int i = 0; i<numballs; i++){
            int raid = ran.nextInt(100);
            int x = ran.nextInt(raid+10,dim.width-(raid+10) );
            int y = ran.nextInt(raid+10,dim.height-(raid+10) );
            int dx = ran.nextInt(-5, 5);
            if(dx == 0){
                dx = ran.nextInt(-5, 5);
            }
            int dy = ran.nextInt(-5,5);
            if(dy == 0){
                dy = ran.nextInt(-5, 5);
            }
            Color color = colors.get(ran.nextInt(colors.size()));
            blist.add(new roundball(x,y,dx,dy,raid,color, this));

        }
        clois = new Colsdet(blist);
        w=dim.width;
        h=dim.height;
    }

    /** Display the current time. */ 
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	// fill the background
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, dim.width, dim.height);
        clois.colisions();
        for (bouncable i : blist){
            i.paint(g);
        }
    	g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        g.setColor(Color.WHITE);
        g.drawString("William Dunlap", 100, 100);
    }

    public static void main(String[] args) {
        new BouncingBall(new String[] {"width=3500", "height=3500"}, 10).run();
    }

    
}
