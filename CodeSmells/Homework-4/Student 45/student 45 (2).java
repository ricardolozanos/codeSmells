package guiboard.modelgui;

import javax.swing.*;
import java.awt.*;

/** Default Board Panel */

public class BoardGui extends JPanel {
    protected Boarder boarder;
    public BoardGui(){
        boarder = new Boarder();
        setPreferredSize(new Dimension(300,300));
    }

    /** Paints default Omok Board that is non-usable.
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        boarder.draw(g);
    }
}
