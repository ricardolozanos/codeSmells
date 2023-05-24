import javax.swing.*;

public class ModularBalloonApp extends JFrame {
    private Balloon growingBalloon;
    ModularBalloonApp(){
        growingBalloon = createBalloon();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(growingBalloon);
        this.pack();
        this.setVisible(true);
    }
    public Balloon createBalloon(){
        return new GrowingBalloon();
    }
}
