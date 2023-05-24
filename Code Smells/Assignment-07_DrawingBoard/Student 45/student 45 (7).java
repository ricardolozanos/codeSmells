package noapplet.example.drawingboard;

import java.awt.*;

public class Rectangle extends Shape{
    private int height;
    private int width;
    protected Rectangle(int x, int y, Color c, int width, int height){
        super(x,y,c);
    }
    /** protected Rectangle(String[] params){
     *      super(params);
     *  }
     * */
    @Override
    public void paintComponent(Graphics g) {
        g.fillRect();
    }
    @Override
    public void draw(Graphics g) {
        Graphics g2;
    }
    public static void main(String[] args){
        new Rectangle(50,50,Color.ORANGE,100,50).run();
    }
    /** new Rectangle(new String[]{ "",""}).run();*/
}
