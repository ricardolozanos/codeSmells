package HW4_GUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import HW4_GUI.console.Board;
import HW4_GUI.console.ComputerPlayer;
import HW4_GUI.console.Coordinate;
import HW4_GUI.console.HumanPlayer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class BoardPanel extends JPanel {
    
    private static final Color boardColor = new Color(253, 218, 13);
    private  JLabel turnLabel;
    private Coordinate hoverIntersection;
    private Board board;
    private BoardController controller;


    public BoardPanel(Board board){
        this.board = board;
        getNewOpponent(1);
        turnLabel = new JLabel();
        setBackground(boardColor);
        // Place stones on the board
        placeStone(false);
        // Hovering effect
        hoveringEffect(false);
        
    }

    public void getNewOpponent(int mode){
        this.controller = new BoardController(this, this.board, mode);
    }

    public Board getBoard(){
        return board;
    }

    /**
     * Gets the label
     * @return turnLabel
     */
    public JLabel getJLabel(){
        return turnLabel;
    }

    /**
     * Sets the label
     * @param label
     */
    public void setLabel(String text){
        turnLabel.setText(text);
    }

    public void displayMessage(String message, boolean isDraw){
        if (isDraw){
            JOptionPane.showMessageDialog(this, message);
        }
        JOptionPane.showMessageDialog(this, message);
        System.exit(0);
    }

    /**
     * Initializes the board
     */
    public void initializeBoard(){
        board.initializeBoard();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int size = board.getSize();
        int squareSize = getWidth() / size;
        // Draw board
        drawBoard(size, squareSize, g);
        // Draw stones
        drawStones(size, squareSize, g);
        // Hovering effect
        drawHoverEffect(size, squareSize, g);
        if(controller.getCurrentPlayer() == controller.getPlayer1()){
            turnLabel.setText("Black's turn");
        }else{
            turnLabel.setText("White's turn");
        }
    }

    /**
     * Draws the board
     * @param size
     * @param squareSize
     * @param g
     */
    private void drawBoard(int size, int squareSize, Graphics g){
         // Draw horizontal lines
         for (int i = 0; i < size; i++) {
            g.drawLine(0, i * squareSize, getWidth(), i * squareSize );
        }
        // Draw vertical lines
        for (int i = 0; i < size; i++) {
            g.drawLine(i * squareSize, 0, i * squareSize, getHeight());
        }
    }

    /**
     * Draws the stones
     * @param size
     * @param squareSize
     * @param g
     */
    private void drawStones(int size, int squareSize, Graphics g){
        //  Draw Stones
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int x = i * squareSize + squareSize / 2;
                int y = j * squareSize + squareSize / 2;
                if (board.getPieceAt(i, j) == controller.getPlayer1().getSymbol()) {
                    g.setColor(Color.BLACK);
                    g.fillOval(x+8, y+8, squareSize / 2, squareSize / 2);
                    if (board.hasWinner(i, j)) {
                        g.setColor(Color.RED);
                        g.fillOval(x+10, y+10, squareSize / 2 - 4, squareSize / 2 - 4);
                    }
                } else if (board.getPieceAt(i, j) == controller.getOpponent().getSymbol()) {
                    g.setColor(Color.WHITE);
                    g.fillOval(x+8, y+8, squareSize / 2, squareSize / 2);
                    g.setColor(Color.BLACK);
                    if (board.hasWinner(i, j)) {
                        g.setColor(Color.RED);
                        g.fillOval(x+10, y+10, squareSize / 2 - 4, squareSize / 2 - 4);
                    }
                }
            }
        }
    }

    /**
     * Draws the hovering effect
     * @param size
     * @param squareSize
     * @param g
     */
    private void drawHoverEffect(int size, int squareSize, Graphics g){
        if (hoverIntersection != null) {
            int x = hoverIntersection.getX() * squareSize + squareSize-7;
            int y = hoverIntersection.getY() * squareSize + squareSize-7;
            int ovalSize = squareSize / 2;
            g.drawOval(x, y, ovalSize, ovalSize);
        }
    }

    /**
     * Places a stone on the board by using MouseListener
     * @param startGame
     */
    public void placeStone(boolean startGame) {
        if(startGame){
            // Place stones on the board
        addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int i = e.getX() / (getWidth() / board.getSize());
                    int j = e.getY() / (getWidth() / board.getSize());
                    if (i >= 0 && i < board.getSize() && j >= 0 && j < board.getSize()) {
                        if (board.getPieceAt(i, j) == '-') {
                            // place stone and switch player
                            if(controller.getCurrentPlayer() instanceof HumanPlayer){
                                controller.makeMove(i, j);
                                if (controller.getCurrentPlayer() instanceof ComputerPlayer){
                                    controller.computerMove();  
                                }
                            }
                            repaint();
                            controller.checkWinner(i, j, controller.getCurrentPlayer());
                        }
                    }
                }
            });
        }
    }

    /**
     * Adds a hovering effect to the board
     * @param startGame
     */
    public void hoveringEffect(boolean startGame){
        if(startGame){
            // Hovering effect
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    int size = board.getSize();
                    int squareSize = getWidth() / size;
                    int i = e.getX() / squareSize;
                    int j = e.getY() / squareSize;
                    if (i >= 0 && i < size && j >= 0 && j < size) {
                        hoverIntersection = new Coordinate(i, j);
                    } else {
                        hoverIntersection = null;
                    }
                    repaint();
                }
            });
        }
    }

    
}
