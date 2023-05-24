package HomeWork2.OmokGame;
import java.util.Scanner;

/**
 * The ConsoleUI class represents the inner workings within the terminal, it consists
 * of methods that take in the User's input to further proceed with the rest of the game.
 * Alongside it also includes the logic that draws the board into the terminal screen
 * with updated visuals.
 *
 * */
public class ConsoleUI {

    /**
     * Scanner that is used to read the User's input for future references
     * */
    static java.util.Scanner Scanner = new Scanner(System.in);

    //ask move
    /**
     * Asks the user for the coordinates of their next move separated by a space,
     * then checks to see if the coordinates have not yet been taken by any player
     * before placing respectable piece in coordinate.
     * @param game the current game object
     * @param turn the number that states whether player is O or X
     * */
    public static void AskMove(Game game, int turn) {
        while (true) {
            //input row and column separated by space
            //if turn is 0, it is X's turn
            //if turn is 1, it is O's turn
            
            System.out.println("Please enter a row and column separated by space:");
            if(turn == 0){
                System.out.println("X's turn");
            } 
            if(turn == 1) {
                System.out.println("O's turn");
            }
            
            String input = Scanner.nextLine();
            String[] parts = input.split(" ");
            if (parts.length == 2) {
                int row = Integer.parseInt(parts[0]);
                int column = Integer.parseInt(parts[1]);
                if (game.Board[row - 1][column - 1] != Game.PieceType.X && game.Board[row - 1][column - 1] != Game.PieceType.O) {
                    if(turn == 0){
                        game.Board[row - 1][column - 1] = Game.PieceType.X;
                    } else {
                        game.Board[row - 1][column - 1] = Game.PieceType.O;
                    }
                    return;
                } else {
                    System.out.println("Invalid move.\n");
                }
            }

        }
    }

    /**
     * constructor that asks the user to choose the
     * game mode they would like to play
     * @return ModeType of game specified through scanner
     * */
    public static Game.ModeType AskMode() {
        while (true) {
            System.out.println("Please choose a game mode:");
            System.out.println("1. Player vs Player");
            System.out.println("2. Player vs Computer");
            int mode = Scanner.nextInt();
            if (mode == 1)
                return Game.ModeType.Player;
            else if (mode == 2)
                return Game.ModeType.Computer;
            else
                System.out.println("Invalid input.\n");
        }
    }

    /**
     * Asks the user for the int that will be the length and height
     * of the board
     * @return int of size specified by user
     * */
    public static int AskSize() {
        while (true) {
            System.out.println("Please enter the board size: ");

            int size = Scanner.nextInt();
            if (size >= 15)
                return size;
            else System.out.println("Must be 15 or greater.\n");
            //if input is not an integer, it will throw an exception
            if (Scanner.hasNextInt() == false) {
                System.out.println("Invalid input.\n");
                Scanner.next();
            }

        }
    }


    /**
     * Draws the board in n*n size specified by user
     * and updates board accordingly with pieces being
     * respectably shown.
     * @param board the current board 2d array
     * */
    public static void Draw(Game.PieceType[][] board) {
        int rowWidth = (int) Math.log(board.length) + 1;
        String out = "";

        // Draws top row of nums first
        out += PadRight("", rowWidth + 1);
        for (int column = 0; column < board.length; column++)
            out += PadRight(column + 1, rowWidth);

        // Draws rest of Board
        for (int row = 0; row < board.length; row++) {
            out += "\n" + PadRight(row + 1, rowWidth + 1);

            for (Game.PieceType piece : board[row]) {
                char character;

                if (piece == Game.PieceType.X)
                    character = 'X';
                else if (piece == Game.PieceType.O)
                    character = 'O';
                else
                    character = '.';

                out += PadRight(character, rowWidth);
            }
        }
        System.out.println(out);
    }
     
    /**
     * Method that adds spaces to the right of any character
     * @param text takes any object to pad
     * @param padding takes in width of row
     * @return String of row to be shown in terminal
     * */
    static String PadRight(Object text, int padding) { // adds spaces to the right of any character
        return String.format("%-" + padding + "s", String.valueOf(text));
    }
}
