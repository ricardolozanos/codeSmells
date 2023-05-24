import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class BoardPanel extends JPanel implements MouseMotionListener, MouseListener {
    private int mouseX = -1;
    private int mouseY = -1;
    private int size;
    private Board board;
    private int currPlayer = 1;
    private boolean cond;
    public BoardPanel(Board board){
        super();
        this.board = board;
        this.size = board.getSize() * 30;
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(size, size));
        addMouseMotionListener(this);
        addMouseListener(this);
    }
    public void condTrue(){
        cond = true;
    }
    public void condFalse(){
        cond = false;
    }
    public void play(){
        condTrue();
        if(!emptyBoard()){
            repaint();
        }
    }
    public boolean emptyBoard(){
        for (int i = 0; i<board.getSize(); i++){
            for (int j = 0; j<board.getSize(); j++){
                if(board.getBoard()[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean getCond(){
        return cond;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension d = getSize();
        g.setColor(new Color(168, 116, 67)); //BASIC THEME
//        g.setColor(new Color(223, 255, 120)); // DELICATE THEME
        g.fillRect(0,0,d.width, d.height);
        g.setColor(Color.black);
        for(int i = 0; i<size; i+=30){
            for(int j = 0; j<size; j+=30){
            g.drawRect(i, j, 30, 30);
            }
        }
        if (mouseX >= 0 && mouseY >= 0 && mouseX<=size-40 && mouseY <= size-40) {
            int x = mouseX+15;
            int y = mouseY+15;
            g.setColor(Color.black);
            g.drawOval(x, y, 30, 30);
        }
        for(int i = 0; i<size; i+=30){
            for(int j = 0; j<size; j+=30){
                if(board.getBoard()[i/30][j/30] == 1){
                    int puckX = j + 15;
                    int puckY = i + 15;
                    g.setColor(Color.black); //BASIC THEME
//                    g.setColor(new Color(200, 162, 200)); // DELICATE THEME
                    g.fillOval(puckX, puckY, 30, 30);
                }
                if(board.getBoard()[i/30][j/30] == 2){
                    int puckX = j + 15;
                    int puckY = i + 15;
                    g.setColor(Color.red); //BASIC COLOR
//                    g.setColor(new Color(250, 128, 114)); // DELICATE THEME
                    g.fillOval(puckX, puckY, 30, 30);
                }
            }
        }
    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(cond) {
            int x = e.getX() - 15;
            int y = e.getY() - 15;
            mouseX = (x / 30) * 30;
            mouseY = (y / 30) * 30;
            repaint();
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(cond) {
            int x = (e.getX() + 15) / 30;
            int y = (e.getY() + 15) / 30;
            if (board.placeStone(x, y, currPlayer)) {
                if (currPlayer == 1) {
                    currPlayer = 2;

                } else {
                    currPlayer = 1;
                }
                repaint();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public int getCurrPlayer(){
        return currPlayer;
    }
    public void setCurrPlayer(int p){
        currPlayer = p;
    }
}