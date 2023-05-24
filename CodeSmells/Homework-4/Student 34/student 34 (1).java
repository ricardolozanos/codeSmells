package omokThings;

/**
 * @author Anthony Romero
 */
public class Board extends Game {
    /**
     * Used to fill board with correct chars to make board shape
     */
    public static void fillBoard(int boardSize) {
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                boardArr[x][y] = '-';
            }
        }
    }

    /**
     * prints created board
     */
    public static void printBoard(int boardSize) { /// change this so it changes in jpanel
        for (int i = 0; i < boardSize; i++) {
            for (int x = 0; x < boardSize; x++) {
                System.out.print(boardArr[i][x] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("\n\n\n");
    }

    /**
     * places stones on created board
     *
     * @param player
     * @param x
     * @param y
     */
    public static void placeStone(Player player, int x, int y) {

        boardArr[x][y] = player.marker;
    }

    /**
     * checks to make sure stone in valid location
     *
     * @param x
     * @param y
     * @return
     */
    public static int ValidStone(int x, int y) {
        if (boardArr[x][y] != '-') {
            return 0;
        } else
            return 1;
    }

    /**
     * checks for 5 stones in a row
     *
     * @param x
     * @param y
     * @param userChar
     * @return
     */
    public static int winCheck(int x, int y, Character userChar, int boardSize) {
        //check for win if win return 1 else
        int row = x;
        int col = y;
        int count = 1;


        for (int j = -1; j <= 1; j = j + 1) {
            for (int k = -1; k <= 1; k = k + 1) {
                row = x;
                col = y;
                count = 1;
                if(j == 0 && k == 0){
                    k+=1;
                }
                while (((row >= 0 && row < boardSize) && (col >= 0 && col < boardSize)) && boardArr[row][col] == userChar) {
                    if(row != x || col != y ){
                        count++;
                    }
                    row += j;
                    col += k;
                }
                row = x - j;
                col = y - k;
                while (((row >= 0 && row < boardSize) && (col >= 0 && col < boardSize)) && boardArr[row][col] == userChar) {
                    if(row != x || col != y ){
                        count++;
                    }
                    row -= j;
                    col -= k;
                }
                if (count >= 5){
                    return count;
                }
            }
        }

        return count;
    }

}
