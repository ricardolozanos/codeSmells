package noapplet.assignments.HW2;

import java.util.Random;

/**
    * A class for creating a new Game Board
    * <p>This class represents a Game Board and provides methods for initializing a board, making moves,
    * checking if the board is full, checking if there is a winner, and getting suggestions for moves.</p>
    * <p>The Board is represented as a 2D array of characters, with '-' representing an empty space,
    * 'X' representing Player 1, and 'O' representing Player 2. </p>
    * <p>Author: Diego Jared Avina</p>
    * <p>Version: 19.0.2, 2023-01-17</p>
*/
public class Board {
    /** The Game Board */
    private char[][] board;
    /** The size of the board */
    private int size;
    
    /**
     * Constructs a new Game Board of the given size.
     * @param size the size of the Game Board.
    */
    public Board(int size){
        this.size = size;
        this.board = new char[size][size];
    }

    /**
     * Initializes the board by filling the board with '-' signifying an empty space
     */
    public void initializeBoard(){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                board[i][j] = '-';
            }
        }
    }

    /**
     * Gets the current size of the board
     * @return an integer that signifyies the size of the board
     */
    public int getSize(){
        return size;
    }
    
    /**
     * Checks if the current move is valid, if it is we place the player symbol
     * @param row - row provided by user
     * @param col - column provided by user
     * @param piece - symbol of current user
     * @return boolean response depending if the move is valid or not
     */
    public boolean makeMove(int row, int col, char piece) {
        if (row < 0 || row >= size || col < 0 || col >= size || board[row][col] != '-') {
            return false;
        }
        board[row][col] = piece;
        return true;
    }

    /**
     * Returns the current piece given the row and column
     * @param row - row given by user
     * @param col - column given by user
     * @return returns the current piece located at the coordinates provided
     */
    public char getPieceAt(int row, int col){
        return board[row][col];
    }

    
    /**
     * Checks if current board is full
     * @return returns false if we encounter an empty space '-', otherwise returns true
     */
    public boolean isFull(){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (board[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    
    /**
     * Checks if there is a winner by checking horizantally, vertically, and diagonals
     * @param row
     * @param col
     * @return returns true if we encounter 5 of the same symbols in a row, otherwise returns false
     */
    public boolean hasWinner(int row, int col) {
        char piece = board[row][col];

        // Check for horizontal win
        int count = 0;
        for (int c = 0; c < size; c++) {
            if (board[row][c] == piece) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check for vertical win
        count = 0;
        for (int r = 0; r < size; r++) {
            if (board[r][col] == piece) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check for diagonal win (top-left to bottom-right)
        count = 0;
        int r = row;
        int c = col;
        while (r > 0 && c > 0 && board[r-1][c-1] == piece) {
            r--;
            c--;
        }
        while (r < size && c < size && board[r][c] == piece) {
            count++;
            r++;
            c++;
        }
        if (count >= 5) {
            return true;
        }

        // Check for diagonal win (bottom-left to top-right)
        count = 0;
        r = row;
        c = col;
        while (r < size-1 && c > 0 && board[r+1][c-1] == piece) {
            r++;
            c--;
        }
        while (r >= 0 && c < size && board[r][c] == piece) {
            count++;
            r--;
            c++;
        }
        if (count >= 5) {
            return true;
        }

        return false;
    }

    
    /**
     * Suggests a move to a Human Player if they enable cheatmode
     * @param playerSymbol
     * @return a coordinate containing a random move, a winning move, or a blocking move
     */
    public Coordinate getSuggestion(char playerSymbol) {
        Coordinate suggestion;
    
        // Check for a winning move
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == '-') {
                    board[row][col] = playerSymbol;
                    if (hasWinner(row, col)) {
                        board[row][col] = '-';
                        return new Coordinate(row, col);
                    }
                    board[row][col] = '-';
                }
            }
        }
    
        // Check for a blocking move
        char opponentSymbol = (playerSymbol == 'X') ? 'O' : 'X';
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == '-') {
                    board[row][col] = opponentSymbol;
                    if (hasWinner(row, col)) {
                        board[row][col] = '-';
                        return new Coordinate(row, col);
                    }
                    board[row][col] = '-';
                }
            }
        }
    
        // If there is no winning or blocking move, suggest a random move
        Random rand = new Random();
        do {
            suggestion = new Coordinate(rand.nextInt(size), rand.nextInt(size));
        } while (!isCellEmpty(suggestion.getX(), suggestion.getY()));
    
        return suggestion;
    }
    
    
    

    /**
     * Checks if the board at the coordinates provided contains an empty space: '-'
     * @param row
     * @param col
     * @return returns true if the we encounter an empty space: '-', otherwise false
     */
    public boolean isCellEmpty(int row, int col){
        return board[row][col] == '-';
    }


}
