import java.awt.*;
import java.awt.geom.Path2D;

public class Shape {
        protected int x,y,width,height;
        protected Color color;
        protected String shape;
        //Default constructor:
        public Shape(){
        }
        public Shape(String shape,int x, int y, int width, int height, Color color){
            this.shape = shape;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
        }
        public void paint(Graphics g){
            g.setColor(color);
            if (shape.toLowerCase().equals("circle")){
                Circle circle = new Circle(shape,x,y,width,height, color);
                circle.paint(g);
            }
            else if (shape.toLowerCase().equals("rectangle")){
                Rectangle rectangle = new Rectangle(shape,x,y,width,height, color);
                rectangle.paint(g);
            }
            else if (shape.toLowerCase().equals("triangle")){
                Triangle triangle = new Triangle(shape,x,y,width,height, color);
                triangle.paint(g);

            }
        }
}

