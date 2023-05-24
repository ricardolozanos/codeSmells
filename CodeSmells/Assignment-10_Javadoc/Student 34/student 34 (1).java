package HomeWork2;

/**
 * @author Anthony Romero
 */
public class Board extends Game {
    /**
     * Used to fill board with correct chars to make board shape
     */
    public static void fillBoard() {
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                boardArr[x][y] = '-';
            }
        }
    }

    /**
     * prints created board
     */
    public static void printBoard() {
        for (int i = 0; i < 15; i++) {
            for (int x = 0; x < 15; x++) {
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
        /* if (player.color == Color.RED){ // if player 1
             boardArr[x][y] = 'X';
         }

         if (player.color == Color.BLUE){ // if player 2
             boardArr[x][y] = 'O';
         }

         */
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
     * @param dirX
     * @param dirY
     * @return
     */
    public static int winCheck(int x, int y, Character userChar, int dirX, int dirY) {
        //check for win if win return 1 else
        int row = 0;
        int col = 0;
        int count = 1;

        x = row + dirX;
        y = col + dirY;

        while (((x >= 0 && x < 15) && (y >= 0 && y < 15)) && boardArr[x][y] == userChar) {
            count++;
            x += dirX;
            y += dirY;
        }

        while (((x >= 0 && x < 15) && (y >= 0 && y < 15)) && boardArr[x][y] == userChar) {
            count++;
            x -= dirX;
            y -= dirY;
        }

        return count;
    }
}
