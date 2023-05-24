package omok.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int size;
    private Player[][] grid;
    private List<Place> winningRow;

    /**
     * Create a new board of the default size.
     */
    public Board() {
        this(15);
    }

    /**
     * Create a new board of the specified size.
     */
    public Board(int size) {
        this.size = size;
        this.grid = new Player[size][size];
        this.winningRow = new ArrayList<>();
    }

    /**
     * Return the size of this board.
     */
    public int size() {
        return size;
    }

    /**
     * Removes all the stones placed on the board, effectively
     * resetting the board to its original state.
     */
    public void clear() {
        this.grid = new Player[size][size];
        this.winningRow.clear();
    }

    /**
     * Return a boolean value indicating whether all the places
     * on the board are occupied or not.
     */
    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Place a stone for the specified player at a specified
     * intersection (x, y) on the board.
     *
     * @param x      0-based column (vertical) index
     * @param y      0-based row (horizontal) index
     * @param player Player whose stone is to be placed
     */
    public void placeStone(int x, int y, Player player) {
        grid[x][y] = player;
        checkForWin(x, y, player);
    }

    /**
     * Return a boolean value indicating whether the specified
     * intersection (x, y) on the board is empty or not.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public boolean isEmpty(int x, int y) {
        return grid[x][y] == null;
    }

    /**
     * Is the specified place on the board occupied?
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public boolean isOccupied(int x, int y) {
        return grid[x][y] != null;
    }

    /**
     * Rreturn a boolean value indicating whether the specified
     * intersection (x, y) on the board is occupied by the given
     * player or not.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public boolean isOccupiedBy(int x, int y, Player player) {
        return grid[x][y] == player;
    }

    /**
     * Return the player who occupies the specified intersection (x, y)
     * on the board. If the place is empty, this method returns null.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public Player playerAt(int x, int y) {
        return grid[x][y];
    }

    /**
     * Return a boolean value indicating whether the given player
     * has a winning row on the board. A winning row is a consecutive
     * sequence of five or more stones placed by the same player in
     * a horizontal, vertical, or diagonal direction.
     */
    /**
     * Return a boolean value indicating whether the given player
     * has a winning row on the board. A winning row is a consecutive
     * sequence of five or more stones placed by the same player in
     * a horizontal, vertical, or diagonal direction.
     */
    public boolean isWonBy(Player player) {
        // Check horizontal rows
        for (int row = 0; row < size; row++) {
            int count = 0;
            for (int col = 0; col < size; col++) {
                if (grid[row][col] == player) {
                    count++;
                    if (count >= 5) {
                        winningRow = new ArrayList<>();
                        for (int i = col - 4; i <= col; i++) {
                            winningRow.add(new Place(row, i));
                        }
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Check vertical rows
        for (int col = 0; col < size; col++) {
            int count = 0;
            for (int row = 0; row < size; row++) {
                if (grid[row][col] == player) {
                    count++;
                    if (count >= 5) {
                        winningRow = new ArrayList<>();
                        for (int i = row - 4; i <= row; i++) {
                            winningRow.add(new Place(i, col));
                        }
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Check diagonal rows
        for (int row = 0; row <= size - 5; row++) {
            for (int col = 0; col <= size - 5; col++) {
                boolean diagonalWin = true;
                for (int i = 0; i < 5; i++) {
                    if (grid[row + i][col + i] != player) {
                        diagonalWin = false;
                        break;
                    }
                }
                if (diagonalWin) {
                    winningRow = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        winningRow.add(new Place(row + i, col + i));
                    }
                    return true;
                }
            }
        }

        // Check anti-diagonal rows
        for (int row = 0; row <= size - 5; row++) {
            for (int col = size - 1; col >= 4; col--) {
                boolean diagonalWin = true;
                for (int i = 0; i < 5; i++) {
                    if (grid[row + i][col - i] != player) {
                        diagonalWin = false;
                        break;
                    }
                }
                if (diagonalWin) {
                    winningRow = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        winningRow.add(new Place(row + i, col - i));
                    }
                    return true;
                }
            }
        }

        return false;
    }

    public Iterable<Place> winningRow() {
        List<Place> result = new ArrayList<>();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Place p = new Place(x, y);
                Player player = playerAt(x, y);
                if (player != null && isWonBy(player)) {
                    result.add(p);
                }
            }
        }
        return result;
    }


    /**
     * An intersection on an Omok board identified by its 0-based column
     * index (x) and row index (y). The indices determine the position
     * of a place on the board, with (0, 0) denoting the top-left
     * corner and (n-1, n-1) denoting the bottom-right corner,
     * where n is the size of the board.
     */
    public static class Place {
        /** 0-based column index of this place. */
        public final int x;

        /** 0-based row index of this place. */
        public final int y;

        /** Create a new place of the given indices.
         *
         * @param x 0-based column (vertical) index
         * @param y 0-based row (horizontal) index
         */
        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // other methods if needed ...
    }
}


/**
 * A player in an Omok game. It holds the name of the player and
 * can be used to identify a specific player throughout the game.
 * The Player class helps to keep track of the moves made by each
 * player during the game.
 */
public class Player {

    /** Name of this player. */
    private final String name;

    /** Create a new player with the given name. */
    public Player(String name) {
        this.name = name;
    }

    /** Return the name of this player. */
    public String name() {
        return name;
    }
}



