import javax.swing.*;
import java.awt.*;

public class EnhancedModularBalloonApp extends ModularBalloonApp{
    protected boolean b = true;

    public EnhancedModularBalloonApp(String[] params) {
        super(params);
    }
    @Override
    protected ModularBalloonApp createBalloon() {
        return this;
    }

    protected void paintComponent(Graphics g) {
        Dimension dim = getSize();
        if(b || balloon == 1) {
            balloon += 1;
            b = true;
        }

        if(!b || balloon == dim.height) {
            b = false;
            balloon -= 1;
        }

        x = dim.width/2 - balloon/2;
        y = dim.height/2 - balloon/2;
        g.setColor(Color.white);
        g.fillRect(0,0, dim.width, dim.height);
        g.setColor(Color.GREEN);
        g.fillOval(x, y, balloon, balloon);

    }

    public static void main(String[] args) {
        new EnhancedModularBalloonApp(new String[] {"width=350", "height=350"}).run();
    }

}
