import javax.swing.*;
import java.awt.*;

public class EnhancedModularBalloonApp extends ModularBalloonApp{
    @Override
    public Balloon createBalloon(){
        return super.growingShrinkingBalloon();
    }
    public static void main(String ... args){
        JFrame frame = new JFrame("EnhancedBalloon");
        ModularBalloonApp balloons = new EnhancedModularBalloonApp();
        frame.setSize(new Dimension(ModularBalloonApp.WIDTH,ModularBalloonApp.HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add((ModularBalloonApp)balloons.createBalloon());
        frame.setVisible(true);
    }
}
