/**
 * @author David duru
 * @version 1
 * @since 2023
 * A class which creates a 2d character array that acts as a board for an omok match*/
public class Board {
    private final int size;
    private char[][] board;

    //Constructor
    /**Creates an instance of the board
     * @param size a integer that defines the dimension of the omok board */
    public Board(int size){
        this.size = size;
        this.board = new char[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                board[i][j] = '.';
            }
        }
    }

    //getter
    /** gives access to the board for other classes to use.
     * @return a 2d character array
     * */
    public char[][] getBoard(){
        return this.board;
    }
}
