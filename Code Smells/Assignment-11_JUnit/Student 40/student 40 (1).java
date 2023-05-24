package src.noapplet.example;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * A console user interface for displaying game input and output.
 */
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scan;
    private final PrintStream out;

    public ConsoleUI(InputStream in, OutputStream out){
        this.scan = new Scanner(in);
        this.out = new PrintStream(out);
    }

    public Index promptPlace(Player player, Board board){
        out.println("It's " + player.toStrings() + "'s Turn.");
        out.println("Row: ");
        int row = scan.nextInt();
        out.println("Col: ");
        int col = scan.nextInt();
        while(!board.inBounds(row, col) || !board.isEmpty(row,col)){
            out.println("Invalid Position. Please Try Again.");
            out.println("Row: ");
            row = scan.nextInt();
            out.println("Col: ");
            col = scan.nextInt();
            if (!board.inBounds(row,col)){
                board.inBounds(row,col);
            }
            if (!board.isEmpty(row,col)){
                board.isEmpty(row,col);
            }
        }
        return new Index(row, col);
    }

    public void displayMessage(String msg){
        out.println(msg);
    }

    public void displayMessageComp(String msg){
        out.println(msg);
    }

    public int displayMenu(){
        out.println("Welcome to Omok!");
        out.println();
        out.println("MAIN MENU");
        out.println("Choose Game Mode:");
        out.println("1.\tHuman Vs Human");
        out.println("2.\tHuman Vs Computer");
        int res = scan.nextInt();
        return res;
    }

    public int displayBoardSize(){
        out.println("Pick Board Size");
        int ans = scan.nextInt();
        return ans;
    }
}
