import javax.swing.*;
import java.awt.*;
/**

 The BoardPanel class extends JPanel and is used to draw the game board and stones on it.
 It contains methods for painting the board and stones, calculating padding, and drawing the win line.
 */
public class BoardPanel extends JPanel{
    //Create board from board class
    private final Board board;
    /**
     * Constructs a new BoardPanel object.
     * @param board the Board object to be displayed
     */
    public BoardPanel(Board board) {
        this.board = board;
        setFont(new Font("MonoSpaced", Font.BOLD, 164));
    }
    /**
     * Paints the game board and stones on the panel.
     * @param g the graphics object used for painting
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Draw the board lines
        g2d.setColor(Color.BLACK);
        int width = getWidth();
        int height = getHeight();
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.YELLOW);
        int squareSize = Math.min(width, height) / 15;
        int xOffset = (getWidth() - 15 * squareSize - getPadding()) / 2;
        int yOffset = (getHeight() - 15 * squareSize - getPadding()) / 2 + getPadding();
        for (int i = 0; i < 16; i++) {
            g2d.drawLine(xOffset + squareSize * i, yOffset, xOffset + squareSize * i, yOffset + 15 * squareSize);
            g2d.drawLine(xOffset, yOffset + squareSize * i, xOffset + 15 * squareSize, yOffset + squareSize * i);
        }
        // Draw the stones
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                Stone stone = board.getStone(i, j);
                if (stone != null) {
                    boolean isWinningStone = false;
                    java.util.List<Stone> winningRow = board.winningRow();
                    if (winningRow != null && winningRow.contains(stone)) {
                        int index = winningRow.indexOf(stone);
                        if (index >= 0 && index <= winningRow.size() - 5 &&
                                winningRow.get(index + 1) == stone &&
                                winningRow.get(index + 2) == stone &&
                                winningRow.get(index + 3) == stone &&
                                winningRow.get(index + 4) == stone) {
                            isWinningStone = true;
                        }

                    }
                    if (isWinningStone) {
                        g.setColor(stone == Stone.RED ? Color.ORANGE : Color.CYAN);
                        g2d.fillOval(xOffset + i * squareSize + squareSize / 4, yOffset + j * squareSize + squareSize / 4, squareSize / 2, squareSize / 2);
                        g2d.setColor(Color.BLACK);
                        g2d.drawOval(xOffset + i * squareSize + squareSize / 4, yOffset + j * squareSize + squareSize / 4, squareSize / 2, squareSize / 2);
                    } else {
                        g.setColor(stone == Stone.RED ? Color.RED : Color.BLUE);
                        g2d.fillOval(xOffset + i * squareSize + squareSize / 4, yOffset + j * squareSize + squareSize / 4, squareSize / 2, squareSize / 2);
                    }
                }
            }
        }
    }
    /**
     * Calculates the padding to be used around the edges of our game board.
     * @return the padding value
     */
    public int getPadding() {
        int width = getWidth();
        int height = getHeight();
        int squareSize = Math.min(width, height) / 15;
        int xOffset = (width - 15 * squareSize) / 2;
        int yOffset = (height - 15 * squareSize) / 2;
        return Math.min(xOffset, yOffset);
    }
}