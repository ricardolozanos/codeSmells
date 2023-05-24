import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardPanel extends JPanel{
    @FunctionalInterface
    public interface ClickListener{
        void placeClicked(int x, int y);
    }
    private final java.util.List<ClickListener> clickListeners = new java.util.ArrayList<>();
    private final Board board;
    private boolean boardLock;
    private Board.Place recentPlace;
    private int mouseX,mouseY,tileSize,halfTileSize;
    private boolean mouseBound;
    private java.util.List<Board.Place> winningRow;
    private final Stroke outline = new BasicStroke(5f);
    public static final Color BOARD_COLOR = new Color(245,184,0,255);
    protected final MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            mouseBound = true;
        }
        @Override
        public void mouseExited(MouseEvent e) {
            mouseBound = false;
        }
        @Override
        public void mouseMoved(MouseEvent e) { mouseX = e.getX(); mouseY = e.getY();}
        @Override
        public void mouseClicked(MouseEvent e) {
            if(boardLock) return;
            // get x and y location
            int tmpX = ((mouseX - halfTileSize)/ tileSize);
            int tmpY = ((mouseY - halfTileSize)/ tileSize);
            tmpX = Math.min(tmpX,board.size()-1);
            tmpY = Math.min(tmpY,board.size()-1);
            int finalTmpY = tmpY;
            int finalTmpX = tmpX;
            clickListeners.forEach(i -> i.placeClicked(finalTmpX, finalTmpY));
            if(winningRow == null)
                winningRow = (java.util.List<Board.Place>) board.winningRow();
        }
    };
    BoardPanel(){
        this(new Board());
    }
    BoardPanel(Board board){
        this.board = board;
        Timer timer = new Timer(16/** aprox 60pfs**/, (e -> repaint()));
        timer.start();
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }
    /**
     * Refreshes the size of the tile depending on the panel size
     */
    protected void refreshSize(){
        int minSize = Math.min(this.getWidth(),this.getHeight()) + 1;
        tileSize = minSize/(board.size()+1);
        halfTileSize = tileSize / 2;
    }
    public void addClickListener(ClickListener listener){
        clickListeners.add(listener);
    }
    /**
     * Draws a grid layout for the board
     * @param g the <code>Graphics</code> object to protect
     */
    protected void drawGrids(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        int minSize = Math.min((board.size() + 1) * tileSize,Math.min(this.getWidth(),this.getHeight()));
        for(int i = 0; i <= board.size()+1; i++){
            // draw flat y-axis
            g2d.drawLine(i * tileSize,0, i * tileSize, minSize);
            // draw flat x-axis
            g2d.drawLine(0,i * tileSize,minSize,i * tileSize);
        }
        Stroke tmp = g2d.getStroke();
        g2d.setStroke(outline);
        g2d.drawRect(0,0,getWidth(),getHeight());
        g2d.setStroke(tmp);
    }
    public void reset(){
        winningRow = null;
    }
    public boolean isUnlocked(){
        return !boardLock;
    }
    public void lockBoard(){
        boardLock = true;
    }
    public void unlockBoard(){
        boardLock = false;
    }
    public void setRecentPlace(Board.Place place){
        recentPlace = place;
    }
    /**
     * Draws all pucks where the board is occupied
     * @param g the <code>Graphics</code> object to protect
     */
    protected final void drawCircles(Graphics g){
        for(int i = 0; i < board.size(); i++)
            for(int j = 0; j < board.size(); j++)
                drawCircle(g,i,j);
    }

    /**
     * Draws a puck where a board is occupied
     * @param g the <code>Graphics</code> object to protect
     * @param i the int value for the row on the board
     * @param j the int value for the col on the board
     */
    protected void drawCircle(Graphics g, int i , int j){
        int offsetX = i * tileSize;
        int offsetY = j * tileSize;
        if(board.isOccupied(i,j)){
            g.setColor(board.playerAt(i,j).getId()== Player.ID.BLACK?Color.BLACK:Color.WHITE);
            g.fillOval(offsetX + halfTileSize,offsetY + halfTileSize, tileSize, tileSize);
            if(recentPlace != null && recentPlace.x == i && recentPlace.y == j){
                g.setColor(Color.RED);
                g.fillOval(offsetX + halfTileSize + (halfTileSize/3),
                        offsetY + halfTileSize + (halfTileSize/3),
                        halfTileSize + (halfTileSize / 2), halfTileSize + (halfTileSize / 2));
                g.setColor(Color.BLACK);
            }
        }
    }
    protected void drawWinningRow(Graphics g){
        if(winningRow == null) return;
        Graphics2D g2d = (Graphics2D) g;
        Stroke tmpStroke = g2d.getStroke();
        Color tmpColor = g2d.getColor();
        g2d.setStroke(new BasicStroke(2f));
        g2d.setColor(Color.RED);
        for(Board.Place place : winningRow){
            g2d.drawOval(place.x * tileSize + halfTileSize,place.y * tileSize + halfTileSize,tileSize,tileSize);
        }
        g2d.setStroke(tmpStroke);
        g2d.setColor(tmpColor);
    }
    /**
     *
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        refreshSize();
        g.setColor(BOARD_COLOR);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(Color.BLACK);
        drawGrids(g);
        drawCircles(g);
        drawWinningRow(g);
        int squareSize = tileSize * board.size() + halfTileSize;
        if(!boardLock &&
                mouseBound &&
                mouseX < squareSize &&
                mouseY < squareSize){
            int tmpX = ((mouseX - halfTileSize)/tileSize) * tileSize;
            int tmpY = ((mouseY - halfTileSize)/tileSize) * tileSize;
            g.drawOval(tmpX + halfTileSize,tmpY + halfTileSize,tileSize,tileSize);
        }
    }
}
