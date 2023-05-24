package noapplet.solar;
import noapplet.AnimationNoApplet;
import java.awt.*;
public class Main extends noapplet.AnimationNoApplet{
    private Sun sun;

    public Main(String[] args) {super(args);}

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        // fill the background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        sun.draw(g);

        g.setFont(new Font("Times New Roman", Font.BOLD, 30));
        g.setColor(new Color(128, 255,255));
        g.drawString("Adrian Urquizo", 200, 30);

    }

    protected void initAnimation(){
        super.initAnimation();
        sun = new Sun(dim.width / 2, dim.height / 2, 30, Color.RED);
    }
}
