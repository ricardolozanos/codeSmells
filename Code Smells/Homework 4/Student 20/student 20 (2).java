import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
/**
 * BoardPanel is the representation of the current game board
 * @author Estrella Lara
 * @since 04/06/2023
 */
class BoardPanel extends JPanel implements MouseInputListener {

    /** Board to be painted. */
    Board board;
    /** Board to be painted. */
    Point clickPoint, cursorPoint;
    Point[][] stones;
    Boolean enableMouse = false;
    /**
     *
     * Stores color of thw current player's stone
     */
    Color stoneColor;
    public BoardPanel(Board board) {
        this.board = board;
        setLayout(null);
        setPreferredSize(new Dimension(375,375));
        setBackground(Color.ORANGE);
        stones = new Point[board.getSize()][board.getSize()];
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //background
        g.setColor(Color.BLACK);
        for(int i = 25; i <= 350;i+= 25){
            //Draw vertical lines
            g.drawLine(i,0,i,375);
            //Draw horizontal lines
            g.drawLine(0,i,375,i);
        }



        // other fields and methods if needed
        if (cursorPoint != null) {
            g.setColor(getForeground());
            g.drawOval(cursorPoint.x - 3, cursorPoint.y - 3, 25, 25);
        }
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x= e.getX();
        int y= e.getY();

    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {
        cursorPoint = null;
        clickPoint = null;
    }

    /**
     * Invoked when a mouse button is pressed on a component and then
     * dragged.  {@code MOUSE_DRAGGED} events will continue to be
     * delivered to the component where the drag originated until the
     * mouse button is released (regardless of whether the mouse position
     * is within the bounds of the component).
     * <p>
     * Due to platform-dependent Drag&amp;Drop implementations,
     * {@code MOUSE_DRAGGED} events may not be delivered during a native
     * Drag&amp;Drop operation.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        //update current point
        //repaint();
        //controller.updateCursorLocation(e.getX(), e.getY());
    }
}
