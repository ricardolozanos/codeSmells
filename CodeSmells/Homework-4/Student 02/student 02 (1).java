package OmokConsole.Model;
/** Represents a board of n * n size.
 * @author Jordan Aguon
 * @version 1.0 (2/26/23)
 */
public class Board {
    private int size;
    private int[][] board;
    /** Constructor to create board of 15 * 15 size filled with 0's.
     */
    public Board(){
        this.size = 15;
        this.board = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                this.board[i][j] = 0;
            }
        }
    }
    /** Constructor to create board of given size filled with 0's.
     * @param size determines size of the array used for the board object.
     */
    public Board(int size){
        this.size = size;
        this.board = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                this.board[i][j] = 0;
            }
        }
    }

    /** Returns board field
     * @return The 2d array of the board field.
     */
    public int[][] getBoard() {
        return board;
    }

    /** Returns size field
     * @return the value of size field.
     */
    public int getSize() {
        return size;
    }




}
