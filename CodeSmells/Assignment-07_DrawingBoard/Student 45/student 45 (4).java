package noapplet.example.drawingboard;

import java.awt.*;

public class Triangle extends Shape{
    private int[] xlist;
    private int[] ylist;

    protected Triangle(int x, int y, Color c, int[] xlist, int[] ylist){
        super(x,y,c);

    }
    /** protected Triangle(String[] params){
     *      super(params);
     *  }
     * */


    /** int x[] =( ,  , )
    *   int y[] =( ,  , )   */
    @Override
    protected void initAnimation() {

    }
    @Override
    public void paintComponent(Graphics g) {
        g.fillPolygon(x,y,3);

    }

    @Override
    public void draw(Graphics g) {
        Graphics g2;
    }
    public static void main(String[] args){

        new Triangle(50,50,Color.BLUE,100,100).run();
        /** new Triangle(new String[]{ "",""}).run();
         *
         * */
    }
}
