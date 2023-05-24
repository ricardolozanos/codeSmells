import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;


public class Board_Panel extends JPanel {
    Board board;
    private Point location;
    private boolean isAiGame;

    public Board_Panel(Board board, JLabel msg_bar) {
        this.isAiGame = false;
        setPreferredSize(new Dimension(600, 600));
        this.board = board;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                location = e.getPoint(); // get the location of the mouse click

                if(!board.is_full()) {
                    if(board.is_empty(location.x / 40, location.y / 40) && !board.isWon()) {
                        board.place_stone(location.x / 40, location.y / 40, board.get_active_player());
                        if(isAiGame) {
                            if(!board.checkWin()) {
                                board.end_turn();
                                msg_bar.setText(board.whos_turn());
                                board.makeSmartMove();

                                if(!board.checkWin()) {
                                    board.end_turn();
                                }
                                else {
                                    msg_bar.setText("GAME WON! " + board.get_active_player().name() + " wins!");
                                }
                            }
                            else {
                                msg_bar.setText("GAME WON! " + board.get_active_player().name() + " wins!");
                            }
                            repaint();
                        }
                        else {
                            if(!board.checkWin()) {
                                board.end_turn();
                                msg_bar.setText(board.whos_turn());
                            }
                            else {
                                msg_bar.setText("GAME WON! " + board.get_active_player().name() + " wins!");
                            }
                            repaint();
                        }
                    }
                }
                // repaint the panel to draw the circle at the new location
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
    }

    private void drawBoard(Graphics g) {
        int cellSize = 40;
        int boardSize = cellSize * (board.size() - 1);
        int marginX = (getWidth() - boardSize) / 2;
        int marginY = (getHeight() - boardSize) / 2;

        // Draw lines
        g.setColor(Color.BLACK);
        for (int i = 0; i < board.size(); i++) {
            g.drawLine(marginX, marginY + i * cellSize, marginX + boardSize, marginY + i * cellSize);
        }
        for (int i = 0; i < board.size(); i++) {
            g.drawLine(marginX + i * cellSize, marginY, marginX + i * cellSize, marginY + boardSize);
        }

        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board.size(); j++) {
                if(board.is_occupied(i, j)) {
                    int x = marginX + i * cellSize - cellSize / 2;
                    int y = marginY + j * cellSize - cellSize / 2;
                    if(Objects.equals(board.player_at(i, j).name(), "Player 1")) {
                        g.setColor(Color.BLACK);
                        g.fillOval(x, y, cellSize, cellSize);
                    }
                    else {
                        g.setColor(Color.RED);
                        g.fillOval(x, y, cellSize, cellSize);
                    }

                }
            }
        }

        if(board.isWon()) {
            List<Board.Place> winning_row = board.getWinningRow();
            for(Board.Place p : winning_row) {
                int x = marginX + p.x() * cellSize - cellSize / 2;
                int y = marginY + p.y() * cellSize - cellSize / 2;
                g.setColor(Color.YELLOW);
                g.fillOval(x, y, cellSize, cellSize);
            }
        }
    }

    public void clearBoard() {
        this.board.clear();
        repaint();
    }

    public void setIsAiGame(boolean isAiGame) {
        this.isAiGame = isAiGame;
    }

}