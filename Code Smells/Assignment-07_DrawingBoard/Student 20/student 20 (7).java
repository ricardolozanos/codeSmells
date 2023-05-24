import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.*;
public class DrawingBoard extends noapplet.NoApplet {
    //Attributes:
    private Shape[] shapes;
    //Constructor:
    public DrawingBoard(){
        this.shapes = new Shape[]{
                new Shape("Circle", 200, 100, 20, 20, Color.yellow),
                new Shape("Rectangle", 50, 50, 40, 20, Color.cyan),
                new Shape("Triangle", 250, 250, 20, 20, Color.GREEN)
        };
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Shape s: shapes){
            s.paint(g);
        }
    }
    public static void main(String[]args){
        new DrawingBoard().run();
    }
    //Shape class

}