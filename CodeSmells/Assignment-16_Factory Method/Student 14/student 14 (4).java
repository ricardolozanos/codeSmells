package noapplet.BallonAnim;
import java.awt.*;

import noapplet.NoApplet;
import noapplet.BallonAnim.*;

public class EnhancedModularBalloonApp extends ModularBalloonApp {

    

    public static void main(String[] args) {
        new EnhancedModularBalloonApp(new String[] {"height = 500", "width = 500"}).run();
    }

    public EnhancedModularBalloonApp(String[] params) {
        super(params);
    }

    @Override
    public drawable getballon() {
        // TODO Auto-generated method stub
        return new bballonadv(size, offset);
    }
}

