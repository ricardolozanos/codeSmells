import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardPanel extends JPanel implements MouseListener, MouseMotionListener{
    Board board;
    Timer timer;
    Player player;
    boolean bounds, start;
    private int mouseX, mouseY;

    boolean nextTurn;

    public BoardPanel() {
        timer = new Timer(100, e -> repaint());
        timer.start();
        board = new Board();
        bounds = false;
        start = false;
        nextTurn = false;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int box = getWidth() / board.size;
        g.setColor(Color.ORANGE);
        g.fillRect(0,0, box * board.size, box * board.size);
        g.setColor(Color.black);
        for (int i = 0; i < board.size; i++) {
            for (int j = 0; j < board.size; j ++) {
                g.drawRect(i * box, j * box, box, box);
                if(board.isOccupied(i,j)) {
                    g.fillOval((i * box)-(box/2), (j * box)-(box/2), box, box);
                }
            }
        }

        if(bounds) {
            circleCursor(g);
        }

    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setnextTurn() {
        nextTurn = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(start) {
            int box = getWidth()/ board.size;
            int point = box/2;
            int dx = ((mouseX - point)/box) * box;
            int dy = ((mouseY - point)/box) * box;

            int ptX = (dx + box) / box;
            int ptY = (dy + box) / box;
            if(board.isEmpty(ptX, ptY)) {
                board.placeStone(ptX, ptY, new Player("Player 1", Color.BLACK));
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
        bounds = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        bounds = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public boolean isStarted() {
        for(int i = 0; i < board.size; i++) {
            for (int j = 0; j < board.size; j++) {
                if(board.isOccupied(i,j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void start() {
        start = true;
    }


    public void circleCursor(Graphics g) {
        int b = getWidth()/board.size;
        int point = b/2;
        int dx = ((mouseX - point)/b) * b;
        int dy = ((mouseY - point)/b) * b;
        g.drawOval(dx + point, dy + point,b, b);
    }
}
