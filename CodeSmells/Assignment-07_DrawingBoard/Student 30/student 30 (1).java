package noapplet.Files;
import java.awt.*;
import noapplet.NoApplet;

public class DrawingBoard extends NoApplet {
    public DrawingBoard(){

    }

    public DrawingBoard(String [] params){
        super(params);
    }


    protected void paintComponent(Graphics g){

        Dimension d = getSize();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("San-serif", Font.BOLD, 30));
        g.setColor(Color.RED);
        g.drawString("Alan Robles", 80, 80);

        Circle c = new Circle(50,50,Color.BLUE);
        c.draw(g);

        g.setColor(Color.BLACK);
        Rectangle  r = new Rectangle(100,100,Color.black);
        r.draw(g);
    }

    public static void main(String [] args){

        new DrawingBoard(new String [] {"width=330", "height=320"}).run();

    }

}
