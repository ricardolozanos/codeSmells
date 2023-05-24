public class Board {
    private int[][] board;
    private int width;
    private int height;

    public Board(int[][] boardArray){
        this.board = boardArray.clone();
    }
    public Board(int x, int y){
        height = x;
        width = y;
        init(x, y);
    }
    public Board(){
        this(19, 19);
    }
    private void init(int x, int y){
        board = new int[x][y];
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                board[i][j] = 0;
            }
        }
    }
    public int[][] getBoard(){
        return board;
    }
    /**
     *Will place stone in given coordinate if the position is empty
     *@param x x coordinate to place stone in.
     *@param y y coordinate to place stone in.
     *@return false if position is occupied, true otherwise.
     */
    public boolean placeStone(int x, int y, int playerNum){
        if (x-1 >= board.length || y-1 >= board[0].length || x < 1 || y < 1 || board[x-1][y-1] != 0){
            return false;
        }
        board[x-1][y-1] = playerNum;
        return true;
    }

    /**
     * Checks if board position is winning for player
     * @return true if player has won
     * @param playerNum player number to check for
     */
    public boolean checkWin(int playerNum){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (checkWinSpot(i, j, 0, -1, playerNum)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkWinSpot(int x, int y, int stoneNumber, int direction, int playerNum){
        if (stoneNumber >= 5){
            highlightWin(direction, x, y, 6);
            return true;
        }
        if (x >= height || y >= width || x < 0 || y < 0){
            return false;
        }
        if (board[x][y] != playerNum){
            return false;
        }
        switch(direction) {
            case -1:
                return (checkWinSpot(x, y, 0, 0, playerNum) ||
                        checkWinSpot(x, y, 0, 1, playerNum) ||
                        checkWinSpot(x, y, 0, 2, playerNum) ||
                        checkWinSpot(x, y, 0, 3, playerNum));
            case 0:
                return checkWinSpot(x - 1, y, stoneNumber + 1, 0, playerNum);
            case 1:
                return checkWinSpot(x - 1, y + 1, stoneNumber + 1, 1, playerNum);
            case 2:
                return checkWinSpot(x, y + 1, stoneNumber + 1, 2, playerNum);
            case 3:
                return checkWinSpot(x + 1, y + 1, stoneNumber + 1, 3, playerNum);
        }
        return false;
    }
    private void highlightWin(int direction, int x, int y, int stoneNum){
        if (stoneNum == 0){
            return;
        }
        if (stoneNum != 6) {
            board[x][y] = 3;
        }
        switch(direction){
            case 0:
                highlightWin(direction, x + 1, y, stoneNum - 1 );
                break;
            case 1:
                highlightWin(direction, x + 1, y - 1, stoneNum - 1 );
                break;
            case 2:
                highlightWin(direction, x, y - 1, stoneNum - 1 );
                break;
            case 3:
                highlightWin(direction, x - 1, y - 1, stoneNum - 1 );
                break;
        }
    }
}
