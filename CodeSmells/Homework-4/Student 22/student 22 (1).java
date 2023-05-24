import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Board extends JPanel implements MouseListener, MouseMotionListener{
    private final Player player1;
    private final Player player2;
    private Point hoverPoint;

    private final int size;
    private Player[][] board;
    private int cellSize;
    private int columns;
    private int rows;
    private Player currentPlayer;

    public Board(Player player1, Player player2) {
        this(15, player1, player2);
        hoverPoint = new Point(-1, -1);
        addMouseListener(this);
        addMouseMotionListener(this);
        columns = 15;
        rows = 15;
        cellSize = 20;
        currentPlayer = player1;
    }

    public Board(int size, Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
        this.size = size;
        board = new Player[size][size];
    }

    public void clear() {
        board = new Player[size][size];
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isEmpty(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void placeStone(int x, int y, Player player) {
        if (isEmpty(x, y)) {
            board[x][y] = player;
        }
    }

    public boolean isEmpty(int x, int y) {
        return board[x][y] == null;
    }

    public boolean isOccupied(int x, int y) {
        return !isEmpty(x, y);
    }

    public boolean isOccupiedBy(int x, int y, Player player) {
        return board[x][y] == player;
    }

    public Player playerAt(int x, int y) {
        return board[x][y];
    }

    public boolean isWonBy(Player player) {
        return winningRow() != null;
    }

    public List<Place> winningRow() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Player current = board[i][j];
                if (current == null) {
                    continue;
                }
                List<Place> row = checkWin(i, j);
                if (row != null) {
                    return row;
                }
            }
        }
        return null;
    }

    private List<Place> checkWin(int x, int y) {
        int[][] directions = {{1, 0}, {0, 1}, {1, 1}, {1, -1}};
        Player player = board[x][y];

        for (int[] dir : directions) {
            List<Place> sequence = new ArrayList<>();
            int newX = x;
            int newY = y;

            while (newX >= 0 && newX < size && newY >= 0 && newY < size && board[newX][newY] == player) {
                sequence.add(new Place(newX, newY));
                newX += dir[0];
                newY += dir[1];
            }

            if (sequence.size() >= 5) {
                return sequence;
            }
        }

        return null;
    }


    public void checkWinAndShowMessage() {
        if (isWonBy(currentPlayer)) {
            JOptionPane.showMessageDialog(this, currentPlayer.getName() + " wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            clear();
        } else if (isFull()) {
            JOptionPane.showMessageDialog(this, "It's a draw!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            clear();
        }
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the grid and other elements here
        // For example, you can draw the grid lines as follows:
        g.setColor(Color.BLACK);
        for (int i = 0; i <= rows; i++) {
            g.drawLine(0, i * cellSize, columns * cellSize, i * cellSize);
        }
        for (int i = 0; i <= columns; i++) {
            g.drawLine(i * cellSize, 0, i * cellSize, rows * cellSize);
        }
        // Draw the hover effect
        if (hoverPoint.x >= 0 && hoverPoint.y >= 0) {
            g.setColor(new Color(0, 0, 0, 128));
            int circleRadius = cellSize / 2;
            int circleX = hoverPoint.x * cellSize + cellSize / 2 - circleRadius;
            int circleY = hoverPoint.y * cellSize + cellSize / 2 - circleRadius;
            g.drawOval(circleX - cellSize / 2, circleY - cellSize / 2, circleRadius * 2, circleRadius * 2);
        }
        // Draw the stones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Player player = playerAt(i, j);
                if (player != null) {
                    g.setColor(player.getStoneColor()); // Assuming Player class has a getColor() method returning the stone color
                    int stoneRadius = cellSize / 2;
                    int stoneX = i * cellSize + cellSize / 2 - stoneRadius;
                    int stoneY = j * cellSize + cellSize / 2 - stoneRadius;
                    g.fillOval(stoneX - cellSize / 2, stoneY - cellSize / 2, stoneRadius * 2, stoneRadius * 2);
                }
            }
        }


    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        // Find the closest intersection point
        int closestX = (int) Math.round((double) x / cellSize);
        int closestY = (int) Math.round((double) y / cellSize);

        if (closestX >= 0 && closestX < columns && closestY >= 0 && closestY < rows) {
            if (!isOccupied(closestX, closestY)) {
                placeStone(closestX, closestY, currentPlayer);
                repaint();
                checkWinAndShowMessage();
                switchPlayer();
            } else {
                JOptionPane.showMessageDialog(this, "This space is already occupied. Please choose another one.", "Invalid Move", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }




    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int circleRadius = cellSize / 2;

        int closestX = (e.getX() + cellSize / 2) / cellSize;
        int closestY = (e.getY() + cellSize / 2) / cellSize;

        int circleX = closestX * cellSize;
        int circleY = closestY * cellSize;

        // Calculate the distance between the mouse pointer and the closest intersection
        double distance = Math.sqrt(Math.pow(e.getX() - circleX, 2) + Math.pow(e.getY() - circleY, 2));

        if (distance <= circleRadius && closestX >= 0 && closestX < columns && closestY >= 0 && closestY < rows) {
            hoverPoint.setLocation(closestX, closestY);
        } else {
            hoverPoint.setLocation(-1, -1);
        }
        repaint();
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(columns * cellSize, rows * cellSize);
    }



    public static class Place {
        public final int x;
        public final int y;

        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

