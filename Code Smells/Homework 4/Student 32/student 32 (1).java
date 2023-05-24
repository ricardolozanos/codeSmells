import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    Player[][] table;
    List<Place> winningRow = new ArrayList<>(5);
    /** Create a new board of the default size. */
    public Board(){
        this.table = new Player[15][15];
        this.size = 15;
    }

    /** Create a new board of the specified size. */
    public Board(int size) {
        this.table = new Player[size][size];
        this.size = size;
    }

    /** Return the size of this board. */
    public int size() {
        return this.size;
    }

    /** Removes all the stones placed on the board, effectively
     * resetting the board to its original state.
     */
    public void clear() {
        table = new Player[this.size][this.size];
    }

    /** Return a boolean value indicating whether all the places
     * on the board are occupied or not.
     */
    public boolean isFull() {
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                if(table[i][j] == null)
                    return false;
            }
        }
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
        if(x < 0 || y < 0 || x > 14 || y > 14)
            return;
        this.table[x][y] = player;
        player.setLastMove(x,y);
    }

    /**
     * Return a boolean value indicating whether the specified
     * intersection (x, y) on the board is empty or not.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public boolean isEmpty(int x, int y) {
        if(this.table[x][y] == null)
            return true;
        return false;
    }

    /**
     * Is the specified place on the board occupied?
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public boolean isOccupied(int x, int y) {
        if(this.table[x][y] != null)
            return true;
        return false;
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
        if(player.equals(table[x][y])) //if ans is 0, both words are the same lexicographically
            return true;
        return false;
    }

    /**
     * Return the player who occupies the specified intersection (x, y)
     * on the board. If the place is empty, this method returns null.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public Player playerAt(int x, int y) {
        return this.table[x][y];
    }

    /**
     * Return a boolean value indicating whether the given player
     * has a winning row on the board. A winning row is a consecutive
     * sequence of five or more stones placed by the same player in
     * a horizontal, vertical, or diagonal direction.
     */
    public boolean isWonBy(Player player) {
        int[] last = player.getLastMove();
        if(helper(last[0],last[1],1,0,player) >= 5) { return true; }
        winningRow.clear();
        if(helper(last[0],last[1],0,1,player) >= 5) { return true; }
        winningRow.clear();
        if(helper(last[0],last[1],1,1,player) >= 5) { return true; }
        winningRow.clear();
        if(helper(last[0],last[1],1,-1,player) >= 5) { return true; }
        winningRow.clear();
        return false;
    }
    private int helper(int x, int y, int dx, int dy, Player player){
        int count = 0;
        int initX = x;
        int initY = y;
        if(x < 0 || y < 0 || x > 14 || y > 14)
            return count;
        while(player.equals(table[x][y])) {
            this.winningRow.add(new Place(x,y));
            count++;
            x += dx;
            y += dy;
            if(x < 0 || y < 0 || x > 14 || y > 14)
                break;
        }
        x = initX - dx;
        y = initY - dy;
        if(x < 0 || y < 0 || x > 14 || y > 14)
            return count;
        while(player.equals(table[x][y])){
            this.winningRow.add(new Place(x,y));
            count++;
            x -= dx;
            y -= dy;
            if(x < 0 || y < 0 || x > 14 || y > 14)
                break;
        }
        return count;
    }

    /** Return the winning row. For those who are not familiar with
     * the Iterable interface, you may return an object of
     * List<Place>. */
    public Iterable<Place> winningRow() {
        return this.winningRow;
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