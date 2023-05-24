package OmokConsole.UI;

import OmokConsole.Model.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class BoardPanel extends JPanel {
    private int xMove;
    private int yMove;
    private String currPlayer;
    private boolean moveMade = false;
    private java.util.List<FilledSpace> filledSpaces;


    public BoardPanel() {

        filledSpaces = new ArrayList<>();

        this.setPreferredSize(new Dimension(400, 400));
        this.setLayout(new GridLayout(15, 15));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        for (int i = 0; i < 225; i++) {
            JButton temp = new JButton();
            temp.setBackground(new Color(0, 0, 0, 0));
            temp.setOpaque(false);
            temp.addActionListener(e ->
            {
                //System.out.println(temp.getY() + ", " + temp.getX());
                //System.out.println(((temp.getY() - 1) / 35) + ", " + ((temp.getX() - 3) / 33));
                //System.out.println((((temp.getY() - 1) / 35) * 36 + 1) + ", " + (((temp.getX() - 3) / 33) * 33 + 3));
                //System.out.println();
                paintPiece(((temp.getY() - 1) / 35), ((temp.getX() - 3) / 33) ,temp.getX(), temp.getY());
                repaint();
            });
            this.add(temp);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.ORANGE);
        g.fillRect(0,0, 600,600);

        for (var space: filledSpaces){
            if (space.player.equals("Black")) {
                g.setColor(Color.BLACK);
            }
            else if(space.player.equals("White")) {
                g.setColor(Color.WHITE);
            }
            g.fillOval(space.x, space.y, 20, 20);
        }
    }

    public void paintPiece(int xMove, int yMove, int xButton, int yButton) {
        this.xMove = xMove;
        this.yMove = yMove;
        filledSpaces.add(new FilledSpace(xButton + 7, yButton + 7, currPlayer));
        moveMade = true;
    }

    public boolean checkFilledSpaces(int x, int y){
        for (FilledSpace space: filledSpaces) {
            if (space.x == x && space.y == y && space.player.equals("White")){
                return false;
            }
        }
        return true;
    }

    public void paintPieceCom(Board board){
        for(int i = 0; i < board.getSize(); i++){
            for(int j = 0; j < board.getSize(); j++){
                if (board.getBoard()[i][j] == 2 && checkFilledSpaces(i, j)){
                    filledSpaces.add(new FilledSpace((i * 36 + 1), (j * 33 + 3), "White"));

                }
            }
        }
        repaint();
        moveMade = true;
    }

    public int getXMove() {
        return xMove;
    }

    public int getYMove() {
        return yMove;
    }

    public boolean isMoveMade() {
        return moveMade;
    }

    public void setMoveMade(boolean moveMade) {
        this.moveMade = moveMade;
    }

    public String getCurrPlayer() {
        return currPlayer;
    }

    public void setCurrPlayer(String currPlayer) {
        this.currPlayer = currPlayer;
    }
}

class FilledSpace{
    public int x;
    public int y;
    public String player;

    public FilledSpace(){
    }

    public FilledSpace(int x, int y, String player){
        this.x = x;
        this.y = y;
        this.player = player;
    }
}
//row and column of the board[][] from button getY and getX
//temp.getY() - 6) / 35, (temp.getX() - 2) / 33
