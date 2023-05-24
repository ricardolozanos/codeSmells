package Omok;

import java.util.Arrays;

/**
 * Board will store the stones of each player and
 * determine if there is a winner.
 * @author Estrella Lara
 * @since 02/23/2023
 */
public class Board {
    /**
     * Stores the number of rows
     */
    private final int rows;
    /**
     * Stores the number of columns
     */
    private final int cols;
    /**
     * Stores the empty spaces and stones in a 2D array
     */
    private final char[][] board;
    /**
     * Creates a 2D array board with 15 rows and 15 columns.
     */
    public Board(){
        this.rows = 15;
        this.cols = 15;
        this.board = new char[rows][cols];
        for (char[] chars : board) {
            Arrays.fill(chars, '-');
        }
    }
    /**
     * Creates a 2D array board with the given number of rows and columns.
     * @param rows stores the number of rows
     * @param cols stores the number of columns
     */
    public Board(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.board = new char[rows][cols];
        for (char[] chars : board) {
            Arrays.fill(chars, '-');
        }
    }

    /**
     *
     * @return rows
     */
    public int getRows(){
        return rows;
    }

    /**
     *
     * @return cols
     */
    public int getCols(){
        return cols;
    }
    /**
     *
     * @return board
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Prints the current board.
     */
    public void printBoard(){
        int i = 1;
        System.out.print("  ");
        do{
            if(i>8){
                System.out.print(i+ " ");
            }
            else{System.out.print(i+"  ");}
            i++;
        }while(i<cols+1);
        System.out.println();
        for(i = 0; i < board.length; i++){
            System.out.print(i+ 1 + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * Places a stone in the board in the corresponding position and from a specific player
     * @param x-coordinate represents the column number
     * @param y-coordinate represents the row number
     * @param player will be used to determine the stone to be placed
     * @param consoleUI will be used to return an error if there is an invalid move
     */
    public void addStone(int x, int y, Player player, ConsoleUI consoleUI){
        if(validMove(x,y)){board[y][x] = player.getStone();}
        else{consoleUI.invalidMove();}
    }

    /**
     * Will evaluate if the given move is valid
     * @param x-coordinate represents the column number
     * @param y-coordinate represents the row number
     * @return valid move (true or false)
     */
    public boolean validMove(int x, int y){
        if((y>rows)||(x>cols)){
            return false;
        }
        return board[y][x] == '-';
    }
}
