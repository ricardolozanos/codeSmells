package OmokBoard;

public class Board {
    private int size;
    private player[][] board;



    public Board(){
        this.size = 15;
        this.board = new player[15][15];
    }
    public Board(int size) {
        this.size = size;
        board = new player[size][size];
    }
    public int getSize(){
        return size;
    }

    public boolean validPlacement(int row,int col){
        if(board[row][col]==null){
            return true;
        }
        return false;
    }
    public void placeStone(int row, int col, player p) {
            board[row][col] = p;
    }

    public boolean isFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }

        return true;
    }
    public void clear() {
        for(int i =0; i <=size;i++){
            for(int j = 0; j <=size;j++){
                board[i][j] = null;
            }
        }
    }
    public boolean hasWon(player p) {
        // check rows
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length - 4; j++) {
                if (board[i][j] == p && board[i][j + 1] == p && board[i][j + 2] == p && board[i][j + 3] == p && board[i][j + 4] == p) {
                    return true;
                }
            }
        }

        // check columns
        for (int i = 0; i < board.length - 4; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == p && board[i + 1][j] == p && board[i + 2][j] == p && board[i + 3][j] == p && board[i + 4][j] == p) {
                    return true;
                }
            }
        }

        // check diagonal
        for (int i = 0; i < board.length - 4; i++) {
            for (int j = 0; j < board.length - 4; j++) {
                if (board[i][j] == p && board[i + 1][j + 1] == p && board[i + 2][j + 2] == p && board[i + 3][j + 3] == p && board[i + 4][j + 4] == p) {
                    return true;
                }
            }
        }

        for (int i = 4; i < board.length; i++) {
            for (int j = 0; j < board.length - 4; j++) {
                if (board[i][j] == p && board[i - 1][j + 1] == p && board[i - 2][j + 2] == p && board[i - 3][j + 3] == p && board[i - 4][j + 4] == p) {
                    return true;
                }
            }
        }

        return false;
    }
    public void printBoard() {
        player p1 = new player();
        player p2 = new player();
        System.out.printf("%-4s", "");
        for (int i = 0; i < board[0].length; i++){
            System.out.printf("%-4d",i+1);
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.printf("%-4d",i+1);
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == null) {
                    System.out.print("* ");
                }
                else if (board[i][j] == p1 ) {
                    System.out.print("O ");
                }
                else if (board[i][j] == p2){
                    System.out.print("X ");
                }

            }
            System.out.println("");
        }
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

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}


