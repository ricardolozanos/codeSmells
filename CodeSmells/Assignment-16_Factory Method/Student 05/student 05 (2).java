
import javax.swing.JFrame;

public abstract class BalloonApp {
    public abstract Balloon createBalloon();

    public void run(boolean animate) {
        Balloon balloon = createBalloon();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(balloon);
        frame.setVisible(true);

        if (animate) {
            while (true) {
                balloon.animate();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ModularBalloonApp extends BalloonApp {
    public Balloon createBalloon() {
        return new GrowingBalloon();
    }
}

public class EnhancedModularBalloonApp extends BalloonApp {
    public Balloon createBalloon() {
        return new GrowingAndShrinkingBalloon();
    }

}




