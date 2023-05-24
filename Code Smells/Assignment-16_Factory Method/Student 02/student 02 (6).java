package noapplet.BalloonFactoryHW;

import java.awt.*;

public class ModularBalloonApp {

    public Balloon createBalloon() {
        return new GrowingBalloon();
    }
}
