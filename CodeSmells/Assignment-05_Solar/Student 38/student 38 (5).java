package noapplet.SolSystem;
import java.awt.*;
public class MainTester extends noapplet.AnimationNoApplet{
    private Sol sun;

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        //Draw name
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(Color.YELLOW);
        g.drawString("Jose San Miguel", 310, 740);
        sun.draw(g);
    }
    public static void main(String[] args){ new MainTester().run();}

    protected void initAnimation(){
        super.initAnimation();
        sun = new Sol(dim.width/2, dim.height/2, 80, Color.RED);
    }
}