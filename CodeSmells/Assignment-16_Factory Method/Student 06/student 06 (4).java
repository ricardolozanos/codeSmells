import java.awt.*;

/** A simple 2D animation game where players can score points by feeding. */
public class ModularBalloonApp extends AnimationNoApplet{
    Balloon expands;
    Balloon shrinks;
    int mode;

    // WRITE YOUR FIELD HERE

    public ModularBalloonApp(String[] args, int mode) {
        super(args);
        this.mode = mode;
        expands = new GrowingBalloon(50, 2);
        shrinks = new GrowingShrinkingBalloon(50,4);
    }

    /** Called when the mouse is clicked to drop a candy. */

    // WRITE YOUR METHOD HERE
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (mode == 1){
        g.fillOval(0, 0, expands.getSize(), expands.getSize());
        }
        else if(mode ==2){
        g.setColor(Color.cyan);
        g.fillOval(0, 0, shrinks.getSize(), shrinks.getSize());}
    }
    public static void main(String[] args) {
        new ModularBalloonApp(new String[]{"width=400", "height=400", "delay=100"},1).run();
        new ModularBalloonApp(new String[]{"width=400", "height=400", "delay=100"},2).run();
    }
}
