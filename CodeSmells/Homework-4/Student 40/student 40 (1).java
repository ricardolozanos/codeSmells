package src.noapplet.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class BoardPanel extends JPanel {
    int size = 20;
    int cellSize = 20;
    private Board board;

    public BoardPanel(Board board, clickListener listener){
        this.board = board;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = ((e.getY() - cellSize/2) / cellSize);
                int y = ((e.getX() - cellSize/2) / cellSize);
                listener.placeClicked(x, y);
                repaint();
            }
        });


    }


    interface clickListener{
        public void placeClicked(int x, int y);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //drawing board
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        for (int x = 0; x <= size; x++) {
            g.drawLine(x * cellSize, 0, x * cellSize, getHeight());
        }
        for (int y = 0; y <= size; y++) {
            g.drawLine(0, y * cellSize, getWidth(), y * cellSize);
        }
        //drawing pieces
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Player piece = board.playerAt(x, y);
                if (piece != null) {
                    int cx = (y + 1) * cellSize;
                    int cy = (x + 1) * cellSize;

                    if (piece.toStrings().equals("O")) {
                        g.setColor(Color.BLACK);
                        g.fillOval(cx - cellSize / 2, cy - cellSize / 2, cellSize, cellSize);

                    }
                    else {
                        g.setColor(Color.WHITE);
                        g.fillOval(cx - cellSize / 2, cy - cellSize / 2, cellSize, cellSize);
                    }

                }

            }
        }
        //highlighting win
        Iterable<Place> winningStones = board.winningRow();
        if (winningStones != null){
            for (Place p: winningStones){
                int cx = (p.y()+1) * cellSize;
                int cy = (p.x()+1) * cellSize;
                g.setColor(Color.RED);
                g.fillOval(cx - cellSize / 2, cy - cellSize / 2, cellSize, cellSize);
            }
        }

    }
    
}
