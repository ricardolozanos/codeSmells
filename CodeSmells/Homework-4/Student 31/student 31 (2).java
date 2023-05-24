package noapplet.example;

import java.awt.*;

import javax.swing.*;

/** A class used to create and design a game board by drawing it.
 *
 *  @author Rodriguez Francisco
 *  @version 1.5 (02/26/2023)
 *  @since version 0.5
 */


@SuppressWarnings("serial")
public class DrawBoard extends JPanel {
    MapSize size;
    Map map;
    final int STONE_SIZE=26;

    int counter;

    String temp;


    /**
     * Method used to draw the board game and, also it is a constructor
     * @param m variable used to base on the number of rows and columns from MapSize class
     * @param map variable used for mapping the place
     */
    public DrawBoard(MapSize m, Map map) {
        setBackground(Color.BLACK );
        size=m;
        setLayout(null);
        System.out.println("board");
        this.map=map;



    }

    /**
     * Method used to design the whole window and call the board and drawstone methods
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(150,20,200));
        g.setFont(new Font("San-serif", Font.BOLD, 30));
        g.drawString("FRANCISCO RODRIGUEZ--Irvin Arredondo", 20, 600);
        g.setColor(new Color(150,20,200));
        g.drawString(turn(), 20, 630);

        board(g);
        drawStone(g);


    }



    /**
     * Method used to draw the line intersections in the board
     * @param g
     */
    public void board(Graphics g) {
        for(int i=1;i<=size.getSize();i++){
            g.drawLine(size.getCell(), i*size.getCell(), size.getCell()*size.getSize(), i*size.getCell());
            g.drawLine(i*size.getCell(), size.getCell(), i*size.getCell() , size.getCell()*size.getSize());
        }
    }

    /**
     * Method used to design the range of the stone
     * @param g
     */
    public void drawStone(Graphics g) {
        for(int y=0;y<size.SIZE;y++){
            for(int x=0;x<size.SIZE;x++){
                if(map.getXY(y, x)==map.getBlack()){
                    //counter ++;
                    //temp="Black turn";
                    drawBlack(g,x,y); }
                else if(map.getXY(y, x)==map.getWhite()){
                    //counter --;
                    //temp="White turn";
                    drawWhite(g, x, y);}
            }
        }
    }

    /**
     * Method used to draw the actual stone with color black
     * @param g refers to the Graphics
     * @param x refers to the position in x coordinate
     * @param y refers to the position in y coordinate
     */
    public void drawBlack(Graphics g,int x,int y){
        g.setColor(Color.GRAY);
        g.fillOval((x+1)*size.getCell()-15, (y)*size.getCell()+15, STONE_SIZE, STONE_SIZE);
    }
    /**
     * Method used to draw the actual stone with color white
     * @param g refers to the Graphics
     * @param x refers to the position in x coordinate
     * @param y refers to the position in y coordinate
     */
    public void drawWhite(Graphics g,int x,int y){
        g.setColor(Color.WHITE);
        g.fillOval(x*size.getCell()+15, y*size.getCell()+15, STONE_SIZE, STONE_SIZE);

    }

    //method use for comparing the possible player turn
    public String turn(){
        if(counter==1){
            return temp="Black turn";
        }
        if(counter==0){
            return temp="White turn";
        }
        return null;
    }


}