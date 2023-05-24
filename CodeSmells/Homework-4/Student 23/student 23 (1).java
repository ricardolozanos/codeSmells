import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private final int size;
    private Player[][] board;
    private int active_player;
    protected ArrayList<Player> players = new ArrayList<>();
    private List<Place> winning_row;
    private boolean gameWon;

    /** Create a new board of the default size. */
    public Board() {
        gameWon = true;
        size = 15;
        board = new Player[size][size];
        winning_row = new ArrayList<>();
        active_player = 0;
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
    }

    /** Create a new board of the specified size. */
    public Board(int size) {
        this.size = size;
        board = new Player[size][size];
        winning_row = new ArrayList<>();
    }

    /** Return the size of this board. */
    public int size() {
        return size;
    }

    /** Removes all the stones placed on the board, effectively
     * resetting the board to its original state.
     */
    public void clear() {
        board = new Player[size][size];
        winning_row = new ArrayList<>();
        active_player = 0;
        gameWon = false;
    }

    /** Return a boolean value indicating whether all the places
     * on the board are occupied or not.
     */
    public boolean is_full() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (board[i][j] == null)
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
    public void place_stone(int x, int y, Player player) {
        board[x][y] = player;
    }

    /**
     * Return a boolean value indicating whether the specified
     * intersection (x, y) on the board is empty or not.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public boolean is_empty(int x, int y) {
        return board[x][y] == null;
    }

    /**
     * Is the specified place on the board occupied?
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public boolean is_occupied(int x, int y) {
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
    public boolean is_occupied_by(int x, int y, Player player) {
        return board[x][y] == player;
    }

    /**
     * Return the player who occupies the specified intersection (x, y)
     * on the board. If the place is empty, this method returns null.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public Player player_at(int x, int y) {
        return board[x][y];
    }

    /**
     * Return a boolean value indicating whether the given player
     * has a winning row on the board. A winning row is a consecutive
     * sequence of five or more stones placed by the same player in
     * a horizontal, vertical, or diagonal direction.
     */

    public boolean checkWin() {
        if(is_won_by(players.get(active_player))) {
            this.gameWon = true;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean is_empty() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (board[i][j] != null)
                    return false;
            }
        }
        return true;
    }

    public boolean isWon() {
        return this.gameWon;
    }

    public List<Place> getWinningRow(){
        return this.winning_row;
    }

    public boolean is_won_by(Player player) {
        List<Place> winningRow = new ArrayList<>();
        //Check for horizontal win
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - 5; j++) {
                if (board[i][j] == player) {
                    boolean is_win = true;
                    for (int k = 0; k < 5; k++) {
                        if (!(board[i][j + k] != null && board[i][j + k].equals(board[i][j]))) {
                            is_win = false;
                            break;
                        } else {
                            winningRow.add(new Place(i, j + k));
                        }
                    }
                    if (is_win) {
                        this.winning_row = winningRow;
                        return true;
                    }
                    winningRow = new ArrayList<>();
                }
            }
        }

        // Check for vertical win
        for (int i = 0; i <= size - 5; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == player) {
                    boolean is_win = true;
                    for (int k = 0; k < 5; k++) {
                        if (!(board[i + k][j] != null && board[i + k][j].equals(board[i][j]))) {
                            is_win = false;
                            break;
                        } else {
                            winningRow.add(new Place(i + k, j));
                        }

                    }
                    if (is_win) {
                        this.winning_row = winningRow;
                        return true;
                    }
                    winningRow = new ArrayList<>();
                }
            }
        }

        // Check for diagonal win (top-left to bottom-right)
        for (int i = 0; i <= size - 5; i++) {
            for (int j = 0; j <= size - 5; j++) {
                if (board[i][j] == player) {
                    boolean is_win = true;
                    for (int k = 0; k < 5; k++) {
                        if (!(board[i + k][j + k] != null && board[i + k][j + k].equals(board[i][j]))) {
                            is_win = false;
                            break;
                        } else {
                            winningRow.add(new Place(i + k, j + k));
                        }
                    }
                    if (is_win) {
                        this.winning_row = winningRow;
                        return true;
                    }
                    winningRow = new ArrayList<>();
                }
            }
        }


        // Check for diagonal win (bottom-left to top-right)
        for (int i = 4; i < size; i++) {
            for (int j = 0; j <= size - 5; j++) {
                boolean isWin = true;
                for (int k = 0; k < 5; k++) {
                    if (!(board[i - k][j + k] != null && board[i - k][j + k].equals(board[i][j]))) {
                        isWin = false;
                        break;
                    }
                    else {
                        winningRow.add(new Place(i - k, j + k));
                    }
                }
                if (isWin) {
                    this.winning_row = winningRow;
                    return true;
                }
                winningRow = new ArrayList<>();
            }
        }
        return false;
    }

    public void makeSmartMove() {
        int [] move = smart_strategy();
        place_stone(move[0], move[1], players.get(1));
    }

    public int[] random_strategy() {
        int n;
        int m;
        Random random = new Random();
        while(true) {
            n = random.nextInt(size);
            m = random.nextInt(size);
            if (is_empty(n,m)) {
                return new int[] {n,m};
            }
        }
    }

    public int[] smart_strategy() {
        int[] return_arr1 = {-1, -1};
        int[] return_arr2 = {-1, -1};

        //Horizontal
        for (int i = 0; i < this.size ; i++) {
            for (int j = 0; j <= this.size - 4; j++) {
                boolean strategy_found = true;
                for (int k = 0; k < 4; k++) {
                    if (board[i][j + k] != null && board[i][j + k].equals(board[i][j])) {
                        continue;
                    } else {
                        strategy_found = false;
                        break;
                    }
                }

                if(strategy_found){
                    if(j + 4 != size) {
                        return_arr1[0] = i;
                        return_arr1[1] = j + 4;
                    }
                    if(j > 0) {
                        return_arr2[0] = i;
                        return_arr2[1] = j - 1;
                    }
                }

                if(return_arr1[0] != -1 && return_arr1[1] != -1) {
                    if(is_empty(return_arr1[0], return_arr1[1])) {
                        return return_arr1;
                    }
                }
                if(return_arr2[0] != -1 && return_arr2[1] != -1) {
                    if (is_empty(return_arr2[0], return_arr2[1])) {
                        return return_arr2;
                    }
                }

            }
        }



        // Check for vertical win
        for (int i = 0; i <= size - 4; i++) {
            for (int j = 0; j < size; j++) {
                boolean strategy_found = true;
                for (int k = 0; k < 4; k++) {
                    if (board[i + k][j] != null && board[i + k][j].equals(board[i][j])) {

                        continue;
                    } else {
                        strategy_found = false;
                        break;
                    }
                }

                if(strategy_found){
                    if(i + 4 != size) {
                        return_arr1[0] = i + 4;
                        return_arr1[1] = j;
                    }
                    if(i > 0) {
                        return_arr2[0] = i - 1;
                        return_arr2[1] = j;
                    }
                }

                if(return_arr1[0] != -1 && return_arr1[1] != -1) {
                    if(is_empty(return_arr1[0], return_arr1[1])) {
                        return return_arr1;
                    }
                }
                if(return_arr2[0] != -1 && return_arr2[1] != -1) {
                    if(is_empty(return_arr2[0], return_arr2[1])) {
                        return return_arr2;
                    }
                }
            }
        }
        // Check for diagonal win (top-left to bottom-right)
        for (int i = 0; i <= size - 4; i++) {
            for (int j = 0; j <= size - 4; j++) {
                boolean strategy_found = true;
                for (int k = 0; k < 4; k++) {
                    if (board[i + k][j + k] != null && board[i + k][j + k].equals(board[i][j])) {
                        continue;
                    } else {
                        strategy_found = false;
                        break;
                    }
                }
                if(strategy_found){
                    if(i + 4 != size && j + 4 != size) {
                        return_arr1[0] = i + 4;
                        return_arr1[1] = j + 4;
                    }
                    if(return_arr1[0] != -1 && return_arr1[1] != -1) {
                        if(is_empty(return_arr1[0], return_arr1[1])) {
                            return return_arr1;
                        }
                    }
                    if(i - 1 != -1 || j - 1 != 1) {
                        return_arr2[0] = i - 1;
                        return_arr2[1] = j - 1;
                    }
                    if(return_arr2[0] != -1 && return_arr2[1] != -1) {
                        if(is_empty(return_arr2[0], return_arr2[1])) {
                            return return_arr2;
                        }
                    }
                }
            }
        }
        // Check for diagonal win (bottom-left to top-right)
        for (int i = 3; i < size; i++) {
            for (int j = 0; j <= size - 4; j++) {
                boolean strategy_found = true;
                for (int k = 0; k < 4; k++) {
                    if (board[i - k][j + k] != null && board[i - k][j + k].equals(board[i][j])) {
                        continue;
                    } else {
                        strategy_found = false;

                        break;
                    }
                }

                //These if statements handle the edge cases to avoid
                //index out of bounds, the first one kind of works, but
                //it needs some modifications
                if(strategy_found){
                    if(i - 4 != -1 && j + 4 != size) {
                        return_arr1[0] = i - 4;
                        return_arr1[1] = j + 4;

                    }
                    if(return_arr1[0] != -1 && return_arr1[1] != -1) {
                        if(is_empty(return_arr1[0], return_arr1[1])) {
                            return return_arr1;
                        }
                    }

                    //This bottom one we need the conditions to avoid
                    //index out of bounds
                    if(i + 1 != size && j - 1 != -1) {
                        return_arr2[0] = i + 1;
                        return_arr2[1] = j - 1;
                    }
                    if(return_arr2[0] != -1 && return_arr2[1] != -1) {
                        if(is_empty(return_arr2[0], return_arr2[1])) {
                            return return_arr2;
                        }
                    }

                }
            }
        }
        return random_strategy();
    }

    public Player get_active_player() {
        return this.players.get(this.active_player);
    }

    /** Ends active player's turn and starts the other's */
    public void end_turn(){
        active_player = (active_player == 1) ? 0 : 1;
    }

    public String whos_turn() {
        return "It's " + players.get(this.active_player).name() +"'s turn";
    }

    /** Return the winning row. For those who are not familiar with
     * the Iterable interface, you may return an object of
     * List<Place>. */
    public List<Place> winning_row() {
        return winning_row;
    }

    /**
     * An intersection on an Omok board identified by its 0-based column
     * index (x) and row index (y). The indices determine the position
     * of a place on the board, with (0, 0) denoting the top-left
     * corner and (n-1, n-1) denoting the bottom-right corner,
     * where n is the size of the board.
     *
     * @param x 0-based column index of this place.
     * @param y 0-based row index of this place.
     */
    public record Place(int x, int y) {
        /**
         * Create a new place of the given indices.
         *
         * @param x 0-based column (vertical) index
         * @param y 0-based row (horizontal) index
         */
        public Place {
        }

        public int x() {
            return x;
        }

        public int y() {
            return y;
        }
    }
}