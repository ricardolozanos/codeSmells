import java.awt.*;
import javax.swing.*;
public class BouncingBall extends AnimationNoApplet {
    public BouncingBall(String[] args) {
        super(args);
        this.balls[0] = new CircleBall(Color.yellow, 25, 20, 100, -5, -4);
        this.balls[1] = new CircleBall(Color.blue, 25, 150, 50, -2, -4);
        this.balls[2] = new CircleBall(Color.red, 25, 200, 100, -8, -4);
    }
    public static void main(String[] args) {
        new BouncingBall(new String[] {"width=300", "height=300"}).run();
    }
    private final Ball[] balls = new Ball[3];

    @Override
    protected void initAnimation(){
    }
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,300,300);
        super.paintComponent(g);
        if (distanceBtwPoints(this.balls[0].getYball(),this.balls[1].getYball(),this.balls[0].getXball(),this.balls[1].getXball()) == (this.balls[0].getRadius() + this.balls[1].getRadius())){
            this.balls[0].setDy(-(this.balls[0].getDy()));
            this.balls[0].setDx(-(this.balls[0].getDx()));
            this.balls[1].setDy(-(this.balls[1].getDy()));
            this.balls[1].setDx(-(this.balls[1].getDx()));
        }
        else if (distanceBtwPoints(this.balls[1].getYball(),this.balls[2].getYball(),this.balls[1].getXball(),this.balls[2].getXball()) == (this.balls[1].getRadius()+ this.balls[2].getRadius())){
            this.balls[1].setDy(-(this.balls[1].getDy()));
            this.balls[1].setDx(-(this.balls[1].getDx()));
            this.balls[2].setDy(-(this.balls[2].getDy()));
            this.balls[2].setDx(-(this.balls[2].getDx()));
        }
        else if (distanceBtwPoints(this.balls[0].getYball(),this.balls[2].getYball(),this.balls[0].getXball(),this.balls[2].getXball()) == (this.balls[0].getRadius()+ this.balls[2].getRadius())){
            this.balls[0].setDy(-(this.balls[0].getDy()));
            this.balls[0].setDx(-(this.balls[0].getDx()));
            this.balls[2].setDy(-(this.balls[2].getDy()));
            this.balls[2].setDx(-(this.balls[2].getDx()));
        }

        for(Ball b: balls){
            b.draw(g);
        }
        g.setColor(Color.black);
        g.drawString("Estrella Lara",0,0);
    }
    public int distanceBtwPoints(int y2,int y1, int x2, int x1){
        return (int) Math.ceil(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)));
    }

}