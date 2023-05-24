/**
 * board for an Omok game, The board has a size of n x n Players alternate placing 
 * stones on the board, the first player to form a row of five stones wins .
 */
public class BoardJdoc {
    private int n; //size
    private int board[][];
    private boolean playerOne = true; //true for player ones turn false for player twos.
    private boolean adminMode = false;

    /**
     * Constructs a new board with a size of 15 x 15.
     */
    public BoardJdoc() {
        this.n = 15;
        this.board = new int[this.n][this.n];
    }

    /**
     * Constructs a new board with a custom n x n size.
     * @param nIn the size of the board
     */
    public BoardJdoc(int nIn) {
        this.n = nIn;
        this.board = new int[nIn][nIn];
    }

    /**
     * Places a stone at the specified position (x, y).
     * stone placement will depend on the current turn 
     * @param x the x-coordinate of the positio
     * @param y the y-coordinate of the position
     */
    public void placePiece(int x, int y) {
        this.board[x][y] = playerOne ? 1 : 2;
        this.playerOne = !this.playerOne;
        if (adminMode) {
            this.playerOne = !this.playerOne;
        }
    }

    /**
     * Checks if x and y coordinates on the board are free
     * @param x the x-coordinate of the position
     * @param y the y-coordinate of the position
     * @return true if the position is available, false otherwise
     */
    public boolean availableSpot(int x, int y) {
        return x < this.n && y < this.n && x > -1 && y > -1 && this.board[x][y] == 0;
    }

    /**
     * Gets the size of the board.
     * @return the size of the board
     */
    public int getN() {
        return n;
    }

    /**
     * Gets the board.
     * @return the board as a 2D integer array
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * Gets the player whose turn it is.
     * @return 1 if it is player one's turn, 2 if it is player two's turn
     */
    public int getPlayer() {
        return playerOne ? 1 : 2;
    }

    /**
     * Sets the size of the board.
     * @param nIn the new size of the board
     */
    public void setN(int nIn) {
        this.n = nIn;
    }
    /**
     * Checks if the board has a winning row, and if it doesnt it returns null
     * if its a draw it returns a 2d array with just a value of 0, if it is a win it returns 
     * the winning row
     * @return 2d array
     */
    public int[][] checkWin(){
        int counter = 0; //checks if theres any spaces left to play
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.n ; j++){
                //check rows 
                if( board[i][j] != 0  && j < this.n - 4){ //check if there's 5 stones in a row of the same player
                   if(board[i][j] == board[i][j+1] && board[i][j] == board[i][j+2] && board[i][j] == board[i][j+3] && board[i][j] == board[i][j+4]){     
                        int[][] win =  { {i,j},{i,j+1},{i,j+2},{i,j+3},{i,j+4}};
                        return win;
                   }
                }
                //check cols 
                if( board[i][j] != 0  && i < this.n - 4){ //check if there's 5 stones in a column of the same player
                   if(board[i][j] == board[i+1][j] && board[i][j] == board[i+2][j] && board[i][j] == board[i+3][j] && board[i][j] == board[i+4][j]){
                        int[][] win = { {i,j},{i+1,j},{i+2,j},{i+3,j},{i+4,j}};
                        return win;
                   }
                }
                counter ++;
            }
        }
        // check diagonals Right to Left
        for(int i = 0; i < this.n - 3; i++){
            for(int j = 0; j < this.n - 3; j++){
                if(board[i][j] != 0 && board[i][j] == board[i+1][j+1] && board[i][j] == board[i+2][j+2] && board[i][j] == board[i+3][j+3] && board[i][j] == board[i+4][j+4]){
                    int[][] win = { {i,j},{i+1,j+1},{i+2,j+2},{i+3,j+3},{i+4,j+4}};
                    return win;
                }
            }
        } 
        // check diagonals Left to Right
        for(int i = 0; i < this.n - 3; i++){
            for(int j = 3; j < this.n; j++){
                if(board[i][j] != 0 && board[i][j] == board[i+1][j-1] && board[i][j] == board[i+2][j-2] && board[i][j] == board[i+3][j-3] && board[i][j] == board[i+4][j-4]){
                    int[][] win = { {i,j},{i+1,j-1},{i+2,j-2},{i+3,j-3},{i+4,j-4}};
                    return win;
                }
            }
        }
        if(counter == (n*n)-1 ){//check Board isnt full
            int[][] boardFull = {{0}};
            return boardFull;
        }
        return null;
    }
}