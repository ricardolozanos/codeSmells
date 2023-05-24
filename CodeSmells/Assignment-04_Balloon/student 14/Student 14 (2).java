package noapplet.BallonAnim;
import java.awt.*;

import noapplet.NoApplet;
import noapplet.BallonAnim.*;

public class BallonAnim2 extends BallonAnim {
    boolean shrink = false;
    public BallonAnim2 (String[] params){
        super(params);
    }
    
    protected void paintComponent(Graphics g){
        Dimension d = getSize();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.GREEN);
        if(shrink) {
            size = size - offset;
            if(size == 7) {
                shrink = false;
            }
        }
        else {
            size = size + offset;
            if(d.width <= size || d.height <= size) {
                shrink = true;
            }
        }
        g.fillOval(d.width/2-size/2, d.height/2-size/2, size, size);
    }

    public static void main(String[] args) {
        new BallonAnim2(new String[] {"height = 500", "width = 500"}).run();
    }
}
