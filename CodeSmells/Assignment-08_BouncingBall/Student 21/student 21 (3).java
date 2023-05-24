package noapplet.example;

import java.awt.*;
import java.util.ArrayList;

public class BouncingBall extends AnimationNoApplet {
    int w, h;
	private int dx = -2, dy = -4;
    private static java.util.List<Ball> balls;
    protected java.util.List<Bounceable> bal = new ArrayList<Bounceable>();
    Collision coll;

    public BouncingBall(String[] args) {
    	super(args);
    }
    
    @Override
    public void initAnimation() {
        balls = new ArrayList<>();
        balls.add(new CircleBall(100, 100, dx, dy, 50, Color.GREEN));
        balls.add(new CircleBall(100, 100, dx + 10, dy + 10, 50, Color.BLUE));
        balls.add(new CircleBall(100, 100, dx + 15, dy + 15, 50, Color.GRAY));
        
        coll = new Collision(bal);
        w = dim.width;
        h = dim.height;
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        for (Bounceable b: balls) {
        	b.draw(g);
        }
        g.setColor(Color.WHITE);
    	g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.drawString("Dante Lopez", 60, 40);
    }
    
    public static void main(String[] args) {
		new BouncingBall(args).run();
	}
}
