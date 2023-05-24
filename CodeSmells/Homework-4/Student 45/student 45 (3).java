package guiboard.logic;

import guiboard.modelgui.Boarder;
import guiboard.modelgui.Stone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/** Panel for Human opponent. */
public class BoardPanel extends JPanel {
    /** will be changed*/
    public String turn; //not final
    public StoneSelection s;
    protected Boarder boarder;

    public BoardPanel(){
        boarder = new Boarder();
        turn = "Choose your Opponent!";
        this.s = new StoneSelection();
    }

    public BoardPanel(Boarder board){
        boarder = board;
        turn = "Choose your Opponent!";
        this.s = new StoneSelection();
        setPreferredSize(new Dimension(300,300));

    }
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        boarder.draw(g2d);
        turn = StoneSelection.text;
        addMouseListener(s);
    }

    /** Retrieves a String.
     *
     * @return returns a String to show opponent turn.
     */
    public String getTurn(){
        return turn;
    }
}

/**
 * Special MouseListener class to provide for a stone to be drawn when mouse is clicked.
 * Used for when opponent is a human.
 */
class StoneSelection extends MouseAdapter {
    private Boolean setColor = true;
    protected List<String> list = new ArrayList<>(); //the new Array List is necessary, will cause problems otherwise.
    protected int x;
    protected int y;
    protected Color color;

    public static String text;
    /** Creates a new instance to be used as a MouseListener. */
    public StoneSelection(){
        list = getList();
        //empty
    }

    /** Gets x and y from mouseClicked and determines whether a stone should be
     * drawn.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e){
        x = e.getX();
        y = e.getY();
        if(!(x%20 == 10 || y%20==10)){
            int dX = getNum(x);
            int dY = getNum(y);
            String s = dX + " " + dY;
            if (list.contains(s)) {
                list.remove(s);
                drawCircle(dX, dY, e.getSource());
            }
        }

    }

    /**Draws Circle alternating between black and red. Used to aid mouseClicked.
     *
     * @param x position for stone.
     * @param y position for stone.
     * @param source used to retrieve an instance of Graphics.
     */
    public void drawCircle(int x, int y, Object source){
        if(source instanceof BoardPanel){
            Graphics g = ((JComponent)source).getGraphics();
            if(Boolean.TRUE.equals(setColor)){
                color = Color.BLACK;
                text = "black's turn!";
            }
            else{
                color = Color.RED;
                text = "red's turn!";
            }
            setColor = !setColor;
            new Stone(x-10,y-10,color).draw(g);
        }
    }

    /** Create a new List full of possible space on the Omok board.
     *
     * @return full list of strings.
     */
    public List<String> getList(){
        for(int i = 20; i<300;i=i+20){
            for(int f = 20; f<300; f=f+20){
                String s = i +" "+ f;
                list.add(s);
            }
        }
        return list;
    }

    /** Create a new number from given integer.
     *
     * @param num Number that contains the x or y of the mouse.
     * @return returns numbers that are only even multiples of 20.
     */
    public int getNum(int num){
        int hold = num%20; //holds the remainder.
        if(hold>10)return num + (20-hold);
        return num - hold;
    }

    /** Retrieves a String.
     *
     * @return text parameter.
     */
    public String getText(){
        return text;
    }
}
