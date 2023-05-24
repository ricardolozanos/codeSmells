/**
 The Board class represents a game board for the game of Gomoku. It stores information about the size of the board,
 the stones placed on the board, and provides methods for checking the validity of a move, placing a stone, checking
 if the board is full, and figuring out if a move is a winning move.
 */
public class Board {
    private int size;
    private Stone[][] board;
    /**
     * Constructor to create new board with specified size
     * @param size of board
     */
    public Board(int size) {
        this.size = size;
        this.board = new Stone[size][size];
    }
    /**
     * Gets the size of the board
     * @return size of board
     */
    public int getSize() {
        return size;
    }
    /**
     * Gets the position of stone on the board
     * @param x axis
     * @param y axis
     * @return stone placement
     */
    public Stone getStone(int x, int y) {
        return board[x][y];
    }
    /**
     * Places stone at specified position
     * @param x axis
     * @param y axis
     * @param stone object
     */
    public void placeStone(int x, int y, Stone stone) {
        board[x][y] = stone;
    }
    /**
     * Checks if board is full
     * @return false/true
     */
    public boolean isFull() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == null) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Determines if move is a win
     * @param row x-axis
     * @param col y-axis
     * @return false/true
     */
    public boolean isWinningMove(int row, int col) {
        Stone stone = board[row][col];
        //Check if there is stone in specified position
        if (stone == null) {
            return false;
        }
        int count = 0;
        // Check horizontal
        for (int c = col - 4; c <= col + 4; c++) {
            if (c >= 0 && c < size && board[row][c] == stone) {
                count++;
                if (count == 4) {
                    if (board[row][c+1] == stone){
                        return true;
                    }
                }
            } else {
                count = 0;
            }
        }
        // Check vertical
        count = 0;
        for (int r = row - 4; r <= row + 4; r++) {
            if (r >= 0 && r < size && board[r][col] == stone) {
                count++;
                if (count == 4) {
                    if (board[r+1][col] == stone){
                        return true;
                    }
                }
            } else {
                count = 0;
            }
        }
        // Check diagonal
        count = 0;
        for (int i = -4; i <= 4; i++) {
            int r = row + i;
            int c = col + i;
            if (r >= 0 && r < size && c >= 0 && c < size && board[r][c] == stone) {
                count++;
                if (count == 4) {
                    if (board[r + 1][c+1] == stone){
                        return true;
                    }
                }
            } else {
                count = 0;
            }
        }
        // Check anti-diagonal
        count = 0;
        for (int i = -4; i <= 4; i++) {
            int r = row + i;
            int c = col - i;
            if (r >= 0 && r < size && c >= 0 && c < size && board[r][c] == stone) {
                count++;
                if (count == 4) {
                    if (board[r+1][c-1] == stone){
                        return true;
                    }
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
    /**
     * checks if specified position is a valid move
     * @param x axis
     * @param y axis
     * @return false
     */
    public boolean isValidMove(int x, int y) {
        // Check if the specified position is within the board bounds
        if (x < 0 || x >= size || y < 0 || y >= size) {
            return false;
        }
        // Check if the specified position is already occupied by a stone
        if (board[x][y] != null) {
            return false;
        }
        return true;
    }
    /**
     *
     * @param row
     * @param col
     * @param color
     * @return count
     */
    public int countStonesInARow(int row, int col, Stone color) {
        int count = 0;
        // Check horizontal
        for (int c = col - 3; c <= col + 3; c++) {
            if (c >= 0 && c < size && board[row][c] == color) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * Gets adjacent row to Human stone placement
     * @param row
     * @return adjacentRow
     */
    public int[] getAdjacentRow(int row) {
        int[] adjacentRow = new int[3];
        adjacentRow[0] = row - 1;
        adjacentRow[1] = row;
        adjacentRow[2] = row + 1;
        return adjacentRow;
    }
    /**
     * Gets adjacent column to Human stone placement
     * @param col
     * @return adjacentCow
     */
    public int[] getAdjacentCol(int col) {
        int[] adjacentCol = new int[3];
        adjacentCol[0] = col - 1;
        adjacentCol[1] = col;
        adjacentCol[2] = col + 1;
        return adjacentCol;
    }

    /**
     * Removes stone from board
     * @param x
     * @param y
     */
    public void removeStone(int x, int y) {
        board[x][y] = null;
    }
}
