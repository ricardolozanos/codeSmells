package guiboard.logic;

import guiboard.modelgui.Boarder;

import java.awt.*;
import java.awt.event.MouseEvent;

/** Panel for Computer opponent. */

public class BoardStrategyPanel extends BoardPanel{
    public BoardStrategyPanel(Boarder board){
        boarder = board;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        removeMouseListener(getMouseListeners()[0]);//removes the previous MouseListener
        addMouseListener(new StoneComp()); //adds the newly created MouseListener
    }
}

/**
 * Special MouseListener class to provide for a stone to be drawn when mouse is clicked.
 * Used for when opponent is a computer.
 */
class StoneComp extends StoneSelection{
    public StoneComp(){
        super();
        list = getList();
    }

    /** Implements different instructions that will be used by the Computer.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e){
        //for now
    }
}
