package noapplet.board;
import noapplet.NoApplet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingBoard extends NoApplet {
    private java.util.List<Shape>shapes;
    public DrawingBoard(String[] args){
        super(args);
    }
    @Override
    public void init(){
        super.init();
        shapes = new ArrayList<>();
        shapes.add(new Rectangle(10,10,Color.RED));
        shapes.add(new Rectangle(100,100,Color.BLUE));
        //shapes.add(new Circle(200,200, Color.GREEN));
        shapes.add(new Circle(260,260, Color.GREEN));
        shapes.add(new Triangle(150,180,Color.YELLOW));
        shapes.add(new Triangle(210,180,Color.YELLOW));
        shapes.add(new Triangle(180,130,Color.YELLOW));
    }
    public static void main(String[] args){
        new DrawingBoard(new String[] {"width = 330", "height = 350"}).run();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("San-serif", Font.BOLD, 20));
        g.setColor(Color.BLACK);
        g.fillRect(0,0,330,350);
        g.setColor(Color.GREEN);
        g.drawString("Jose San Miguel", 30, 340);
        for(Shape s: shapes){
            s.draw(g);
        }
    }
}
