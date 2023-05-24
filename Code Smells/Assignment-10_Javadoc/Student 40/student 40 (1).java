package src.noapplet.example;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * A console user interface for displaying game input and output.
 */
public class ConsoleUI {
    private InputStream in;
    Scanner scan = new Scanner(System.in);
    private Board board;
    private Player player;
    private PrintStream out;
    /**
     * Constructs a ConsoleUI object with default input stream and output stream.
     */
    public ConsoleUI(){}
    /**
     * Constructs a ConsoleUI object with the specified input stream.
     * @param in the input stream to be used
     */
    public ConsoleUI(InputStream in){
        super();
    }
    /**
     * Constructs a ConsoleUI object with the specified output stream.
     * @param in the output stream to be used
     */
    public ConsoleUI(OutputStream in){

    }
    /**
     * Constructs a ConsoleUI object with the specified input stream, output stream, and board.
     * @param in the input stream to be used
     * @param out the output stream to be used
     * @param board the board to be used
     */
    public ConsoleUI(InputStream in, OutputStream out, Board board){
        this.board = board;
    }

    /** Returns a boolean to check if it is in bounds
     * @param r row
     * @param c column
     * @return a boolean to check if it is in bounds
     */
    public boolean inBounds(int r, int c){
        if (r < 0 || r >= board.boardLength() || c < 0 || c >= board.boardWidth()){
            return false;
        }
        return true;
    }
    /** Returns a boolean to check if the current position is taken or not
     * @param r row
     * @param c col
     * @return a boolean to check if the current position is taken or not
     */
    public boolean isEmpty(int r, int c){
        if (board.getCurrPlace(r,c) != null){
            return false;
        }
        return true;
    }

    /** Returns Index object with the user's rows and columns
     * @param player stone
     * @return Index object with the user's rows and columns
     */
    public Index promptPlace(Player player){
        System.out.println("It's " + player.toStrings() + "'s Turn.");
        System.out.println("Row: ");
        int row = scan.nextInt();
        System.out.println("Col: ");
        int col = scan.nextInt();
        while(!inBounds(row, col) || !isEmpty(row,col)){
            System.out.println("Invalid Position. Please Try Again.");
            System.out.println("Row: ");
            row = scan.nextInt();
            System.out.println("Col: ");
            col = scan.nextInt();
            if (!inBounds(row,col)){
                inBounds(row,col);
            }
            if (!isEmpty(row,col)){
                isEmpty(row,col);
            }
        }

        return new Index(row, col);
    }

    /** Displays a message
     * @param msg
     */
    public void displayMessage(String msg){
        System.out.println(msg);
    }
    /** Displays a message for the computer
     * @param msg
     */
    public void displayMessageComp(String msg){
        System.out.println(msg);
    }

    /** Returns the game mode user chose
     * @return the game mode user chose
     */
    public int displayMenu(){
        System.out.println("Welcome to Omok!");
        System.out.println();
        System.out.println("MAIN MENU");
        System.out.println("Choose Game Mode:");
        System.out.println("1.\tHuman Vs Human");
        System.out.println("2.\tHuman Vs Computer");
        int res = scan.nextInt();
        return res;
    }

    /** Returns the size of the board user chose
     * @return the size of the board user chose
     */
    public int displayBoardSize(){
        System.out.println("Pick Board Size");
        int ans = scan.nextInt();
        return ans;
    }

}

