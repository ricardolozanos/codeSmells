import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class BoardPanel extends JPanel implements MouseListener {

    Board board;
    Human p1 = new Human("Player 1");
    Player p2;
    int gameMode;
    private int currTurn = 1;
    Random rand = new Random();
    Dialogs dialogs = new Dialogs();
    public BoardPanel(int gameMode){
        this.addMouseListener(this);
        this.board = new Board();
        this.gameMode = gameMode;
        if(gameMode == 1){
            p2 = new Human("Player 2");
        }
        else{
            p2 = new Computer(this.board, this.p1);
        }
    }
    protected void paintComponent(Graphics g) {
        Dimension d = getSize();
        System.out.println(d.width + " " + d.height);
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.BLACK);
        int x = 0, y = 0;
        double widthIncrement = d.width / 15;
        double heightIncrement = d.height / 15;
        int currX = 0;
        for (x = 0; x <= 14; x++) {
            g.drawLine(currX, y, currX, d.height);
            currX += widthIncrement;
        }
        x = 0;
        int currY = 0;
        for (y = 0; y <= 14; y++) {
            g.drawLine(x, currY, d.width, currY);
            currY += heightIncrement;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Graphics g = getGraphics();
        int mouseX = e.getX();
        int mouseY = e.getY();
        Dimension d = getSize();

        int x = (int) Math.floor(mouseX / (d.width/15));
        int y = (int) Math.floor(mouseY / (d.height/15));
        int temp = x;
        x = y;
        y = temp;

        System.out.println("x y: " + x + " " + y);
        if(board.isOccupied(x,y)){
            return;
        }
        else {
            if (gameMode == 1) {
                if (currTurn == 1) {
                    board.placeStone(x, y, p1);
                    g.setColor(Color.BLACK);
                    draw(x,y,g,d);
                    if (board.isWonBy(p1)){ /*add chat dialog that says that somebody has won*/
                        repaintWinRow(g,d,board);
                        dialogs.winMessage(p1);
                    }
                    currTurn = 2;
                }
                else if (currTurn == 2){
                    g.setColor(Color.WHITE);
                    board.placeStone(x, y, p2);
                    draw(x,y,g,d);
                    if (board.isWonBy(p2)) { /*add chat dialog that says that somebody has won*/
                        repaintWinRow(g,d,board);
                        dialogs.winMessage(p2);
                    }
                    currTurn = 1;
                }
            }
            if (board.isFull()) { /*add chat dialog that says that the board is full*/
                dialogs.fullBoard();
            }

            if (gameMode == 2) {
                board.placeStone(x, y, p1);
                g.setColor(Color.BLACK);
                draw(x,y,g,d);
                if (board.isWonBy(p1)){ /*add chat dialog that says that somebody has won*/
                    repaintWinRow(g,d,board);
                    dialogs.winMessage(p1);
                }

                int[] ans = {rand.nextInt(15), rand.nextInt(15)};
                while (board.isOccupied(ans[0], ans[1])) {
                    ans[0] = rand.nextInt(15);
                    ans[1] = rand.nextInt(15);
                }
                board.placeStone(ans[0], ans[1], p2);
                g.setColor(Color.WHITE);
                draw(ans[0],ans[1], g, d);
                if (board.isWonBy(p2)) { /*add chat dialog that says that somebody has won*/
                    repaintWinRow(g, d, board);
                    dialogs.winMessage(p2);
                }
                currTurn = 1;
            }
        }

    }
    private void draw(int x, int y, Graphics g, Dimension d){
        if (x >= 0 && x <= 14 && y >= 0 && y <= 14) {
            g.fillOval(  5+ y * (d.width / 15),  10 + x * (d.height / 15), 15, 15);
        }
    }
    private void repaintWinRow(Graphics g, Dimension d, Board board){
        g.setColor(Color.RED);
        Board.Place curr;
        for(int i = 0; i < 5; i++){
            curr = board.winningRow.get(i);
            draw(curr.x, curr.y, g, d);
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
}
