package noapplet.example;
import java.awt.*;
import noapplet.NoApplet;
public class gridOmok extends NoApplet {
    public gridOmok(){
    }
    public gridOmok(String[] params) {super(params);}
    //Declare variable used to draw lines for grid
    static final int rows = 16;
    static final int cols = 16;
    static final int originX = 0;
    static final int originY = 0;
    static final int cellSize = 50;
    //method to draw
    protected void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, d.width, d.height);
        //Draw name and lines
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(new Color(0, 0,0));
        g.drawString("*Jose San Miguel*", 310, 830);
        //For loops draw the lines used to represent columns and rows
        for(int i = 0; i < rows + 1;i++){
            g.drawLine(originX,originY + i * cellSize, originX + cols * cellSize, originY + i * cellSize);
        }
        for(int i = 0; i < cols + 1; i++) {
            g.drawLine(originX + i * cellSize, originY, originX + i * cellSize, originY + rows * cellSize);
        }
        //Draw colored circles
        g.fillOval(375,376,50,50);
        g.setColor(Color.RED);
        g.fillOval(425,325,50,50);
    }
    public static void main(String[] args) {
        //new HelloWorld().run();
        // or specify optional parameters such as the window size
        new gridOmok(new String[] {"width=800", "height=840"}).run();
    }
}
