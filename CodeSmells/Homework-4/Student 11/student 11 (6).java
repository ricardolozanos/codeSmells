import java.util.LinkedList;
import java.util.List;

/**
 * Abstraction of an Omok board, which consists of n x n intersections
 * or places where players can place their stones. The board can be 
 * accessed using a pair of 0-based indices (x, y), where x and y 
 * denote the column and row number, respectively. The top-left 
 * intersection is represented by the indices (0, 0), and the
 * bottom-right intersection is represented by the indices (n-1, n-1).
 */
public class Board {
    private int size = 15;
    private Player [][] board;
    private List<Board.Place> winRow;

    /** Create a new board of the default size. */
    public Board() {
        board = new Player[size][size];
    }

    /** Create a new board of the specified size. */
    public Board(int size) {
        if(size >= this.size)
            this.size = size;
        board = new Player[size][size];
    }

    /** Return the size of this board. */
    public int size() {
        return size;
    }

    /** Removes all the stones placed on the board, effectively 
     * resetting the board to its original state. 
     */
    public void clear() {
        winRow = null;
        board = new Player[size][size];
    }

    /** Return a boolean value indicating whether all the places
     * on the board are occupied or not.
     */
    public boolean isFull() {
        /*
         * // Option one is to iterate and check for null
         * for(Player [] place : board)
         *      for(Player p : place)
         *          if(p == null) return false;
         * return true;
         *
         * // Option two, is dynamically counting the played moves
         * return occupied == (size * size);
         */
        for(Player [] place : board)
            for(Player p : place)
                if(p == null) return false;
        return true;
    }

    /**
     * Place a stone for the specified player at a specified 
     * intersection (x, y) on the board.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     * @param player Player whose stone is to be placed
     */
    public void placeStone(int x, int y, Player player) {
        board[x][y] = player;
    }

    /**
     * Return a boolean value indicating whether the specified 
     * intersection (x, y) on the board is empty or not.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public boolean isEmpty(int x, int y) {
        return board[x][y] == null;
    }

    /**
     * Is the specified place on the board occupied?
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public boolean isOccupied(int x, int y) {
        // or return !isEmpty(x,y)
        return board[x][y] != null;
    }

    /**
     * Return a boolean value indicating whether the specified
     * intersection (x, y) on the board is occupied by the given 
     * player or not.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public boolean isOccupiedBy(int x, int y, Player player) {
        return board[x][y] == player;
    }

    /**
     * Return the player who occupies the specified intersection (x, y) 
     * on the board. If the place is empty, this method returns null.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public Player playerAt(int x, int y) {
        return board[x][y];
    }

    /**
     * Return a boolean value indicating whether the given player 
     * has a winning row on the board. A winning row is a consecutive 
     * sequence of five or more stones placed by the same player in 
     * a horizontal, vertical, or diagonal direction.
     */
    public boolean isWonBy(Player player) {
        List<Place> winningRow = (List<Place>) winningRow();
        if(winningRow == null) return false;
        return player == board[winningRow.get(0).x][winningRow.get(0).y];
    }

    /** Return the winning row. For those who are not familiar with
     * the Iterable interface, you may return an object of
     * List<Place>. */
    public Iterable<Place> winningRow() {
        if(winRow != null) return winRow;
        List<Place> collection = new LinkedList<>();
        int len = 5;
        // check horizontally
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                winningRowHelper(collection,i,j);
                if(collection.size() == len){
                    winRow = collection;
                    return collection;
                }
            }
        }
        // check vertically
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                winningRowHelper(collection,j,i);
                if(collection.size() == len){
                    winRow = collection;
                    return collection;
                }
            }
        }
        // check diagonally, top left to bottom right
        for(int i = 0; i <= (size + size - 1); i++){
            int j = Math.min(i, size-1);
            for(int k = Math.max(0,i - size + 1); k <= j; k++){
                winningRowHelper(collection,k,i-k);
                if(collection.size() == len){
                    winRow = collection;
                    return collection;
                }
            }
        }
        // check diagonally, top right to bottom left
        for(int i = 1 - size; i < size; i++){
            int j = Math.min(size + i - 1,size - 1);
            for(int k = Math.max(0,i); k < j; k++){
                winningRowHelper(collection,k,k-i);
                if(collection.size() == len){
                    winRow = collection;
                    return collection;
                }
            }
        }
        return null;
    }

    /**
     * Helper method to remove duplicate lines on iterable
     * @param collection
     * @param i
     * @param j
     */
    private void winningRowHelper(List<Place> collection, int i, int j){
        if(board[i][j] != null){
            if(collection.isEmpty()) collection.add(new Place(i,j));
            else if(board[collection.get(0).x][collection.get(0).y] == board[i][j]) collection.add(new Place(i,j));
            else{
                collection.clear();
                collection.add(new Place(i,j));
            }
        }
        else collection.clear();
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