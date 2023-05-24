
/**
 * This is the class of the omok or gomoku board that creates the actual board
 * that the players will interact with when playing the game. It contains methods that
 * create and show the board.
 * @author Alan Robles
 * @version
 */
public class OmokBoard {

    private String [][] boardGame;
    private String space = "+";
    private int size = 18;

    public String[][] getBoardGame() {
        return boardGame;
    }

    /**
     * set the boardgame as a String 2d array
     * @param boardGame that creates the omok board game
     */
    public void setBoardGame(String [][] boardGame) {
        this.boardGame = boardGame;
    }
    public String getSpace() {
        return space;
    }

    /**
     * Just to set the spaces in the game board
     * @param space which occupies the spaces with a + sign in the board
     */
    public void setSpace(String space) {
        this.space = space;
    }
    public int getSize() {
        return size;
    }

    /**
     * sets the size of the game board
     * @param size which gets the n x n size of the board
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * This method has public access and contains no parameters to create the omok board using a 2d array
     * with a size
     */
    public OmokBoard(){
        //Board game of size 18 by 18
        boardGame = new String[size][size];
        /*
        Creating a 2d array that sets empty spaces for all the positions of the
        omok board
         */
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                boardGame[i][j] = space;
            }
        }
    }

    /**
     * This method just simply shows the board when playing the game with label
     * for the rows and columns
     */
    public void showOmokBoard(){
        //Print 1-18 for the vertical numbers
        System.out.println("  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18");
        for (int i = 0; i < size; i++) {
            // Use printf for the format to print 1-18 horizontally and alignment
            // and the + 1 to start at 1 rather than 0
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < size; j++) {
                System.out.print(boardGame[i][j] + " ");
            }
            //Skip the line
            System.out.println();
        }
    }
}
