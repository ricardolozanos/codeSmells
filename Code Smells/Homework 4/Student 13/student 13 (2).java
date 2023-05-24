import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel{
    int[][] boardState;
    int squareSize;
    public BoardPanel(int[][] boardState){
        this.boardState = boardState;
        setPreferredSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
    public BoardPanel(int size) {
        this(emptyBoard(size));
    }
    private static int[][] emptyBoard(int size){
        int[][] emptyBoard = new int[size][size];
        for (int i = 0; i < size; i ++){
            for (int j = 0; j < size; j++){
                emptyBoard[i][j] = 0;
            }
        }
        return emptyBoard;
    }
    protected void paintComponent(Graphics g){
        Dimension dim = this.getSize();
        squareSize = Math.min(dim.height/boardState.length-1, dim.width/boardState[0].length-1);
        int border = (dim.width - squareSize*boardState[0].length)/2 + 10;
        //Draw Background
        g.setColor(Color.ORANGE);
        g.fillRect(border,0,squareSize*(boardState[0].length-1), squareSize*(boardState.length-1));

        g.setColor(Color.BLACK);
        //Draw Horizontal lines
        for (int i = 0; i < boardState.length; i ++){
            g.drawLine(border, i*squareSize, squareSize*(boardState[0].length-1) + border, i*squareSize);
        }
        //Draw Vertical Lines
        for (int i = 0; i < boardState[0].length; i ++){
            g.drawLine(i*squareSize + border, 0, i*squareSize + border, squareSize*(boardState.length-1));
        }
        //Draw Stones
        for (int i = 0; i < boardState.length; i ++){
            for (int j = 0; j < boardState[0].length; j ++){
                if (boardState[i][j] == 1) {
                    drawStone(g, border, Color.WHITE, j, i);
                }
                else if (boardState[i][j] == 2){
                    drawStone(g, border, Color.BLACK, j, i);
                }
                else if (boardState[i][j] == 3){
                    drawStone(g, border, Color.RED, j, i);
                }
            }
        }
    }
    public void drawStone(Graphics g, int border, Color color,int x, int y ){
        g.setColor(color);
        g.fillOval((x*squareSize) - (squareSize/4) - 3 + border, (y*squareSize) - (squareSize/4) - 3, (squareSize/2) + 6, (squareSize/2) + 6);
    }
    public void updateBoard(int[][] newState){
        boardState = newState;
    }
}
