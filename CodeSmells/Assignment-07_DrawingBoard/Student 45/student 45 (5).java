package noapplet.example.drawingboard;
import java.awt.*;
import noapplet.NoApplet;

public class Circle extends Shape {
    private int width;
    private int height;
    protected Circle(int x, int y, Color c, int width, int height){
        super(x,y,c);

    }
    /** protected Circle(String[] params){
     *      super(params);
     *  }
     * */

    @Override
    protected void initAnimation() {

    }
    @Override
    public void paintComponent(Graphics g) {

    }

    @Override
    public void draw(Graphics g) {
        Graphics g2;
    }
    public static void main(String[] args){
        new Circle(50,50,Color.RED,100,100).run();
    }

    /** new Circle(new String[]{ "",""}).run();  */
}
