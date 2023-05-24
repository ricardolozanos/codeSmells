package noapplet.SS;
import java.awt.Color;
import java.awt.Graphics;

public class Solar_system extends noapplet.AnimationNoApplet {
    private Sun sun;

    protected Solar_system(String[] args) {
        super(args);
    }

    protected void initAnimation(){
        super.initAnimation();
        sun = new Sun(dim.width/2, dim.height/2,50, Color.ORANGE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        sun.draw(g);
    }

    //protected void Sun()

    public static void main(String[] args) {
        new Solar_system(new String[] {"width=1000", "height=1000"}).run();
    }

}