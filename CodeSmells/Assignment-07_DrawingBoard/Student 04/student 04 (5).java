package noapplet.assignments.Shapes;

import noapplet.NoApplet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingBoard extends NoApplet {
    private List<Shape> shapes;
      
      

    public void init(){
        shapes = new ArrayList<>();
        // Adds new Circle
        shapes.add(new Circle(10, 10, Color.RED));
        
        // Add new Rectangle
        shapes.add(new Rectangle(100, 150, Color.BLUE));

        // Add new triangle
        shapes.add(new Triangle(250, 250, Color.GREEN));
     
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Shape s: shapes){
            s.draw(g);
        }

    }

    public static void main(String[] args){
        new DrawingBoard().run();
    }
}
