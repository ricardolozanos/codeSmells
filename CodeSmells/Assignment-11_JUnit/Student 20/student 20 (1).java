import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 * ConsoleUI will interact with the user.
 * It will ask for input and share it with the corresponding classes
 * @author Estrella Lara
 * @since 02/27/2023
 */
public class ConsoleUI {
    /**
     * Board is a 2D array of places containing empty spaces and player stones.
     */
    private Board board;
    private InputStream in;
    private PrintStream out;

    /**
     * Constructor of ConsoleUI
     */
    public ConsoleUI(Board board, InputStream in, PrintStream out){

        this.board = board;
        this.in = in;
        this.out = out;
    }
    /**
     * Prints welcome message and instructions for user
     */
    public void welcome(){
        out.print("""
                Welcome to Omok.
                This is a two-player strategy game typically played with go pieces --- black and
                white stones --- on a go board with 15x15 intersections (or places)
                [Wikipedia]. The two players alternate and place a stone of their color
                on an empty intersection. The game objective is to put one's stones in
                a row of five consecutive places vertically, horizontally, or
                diagonally. The winner is the first player to create an unbroken row
                of five stones.""");
        System.out.println("""
                Welcome to Omok.
                This is a two-player strategy game typically played with go pieces --- black and
                white stones --- on a go board with 15x15 intersections (or places)
                [Wikipedia]. The two players alternate and place a stone of their color
                on an empty intersection. The game objective is to put one's stones in
                a row of five consecutive places vertically, horizontally, or
                diagonally. The winner is the first player to create an unbroken row
                of five stones.""");
    }

    public InputStream getIn() {
        return in;
    }

    public PrintStream getOut() {
        return out;
    }

    /**
     * @return game mode
     */
    public int getGameMode(){
        out.print("Please enter the number of the game mode you choose: \n1 - Human vs human \n2 - Human vs computer");
        System.out.println("Please enter the number of the game mode you choose: \n1 - Human vs human \n2 - Human vs computer");
        Scanner userIn = new Scanner(in);
        return userIn.nextInt();
    }
    /**
     * @return next move on x from user
     */
    public int getNextMoveX(Player playerInTurn){
        out.print("Please enter next move in x for " + playerInTurn.getPlayerName() + ":");
        System.out.println("Please enter next move in x for " + playerInTurn.getPlayerName() + ":");
        Scanner userIn = new Scanner(in);
        return userIn.nextInt();

    }
    /**
     * @return next move on y from user
     */
    public int getNextMoveY(Player playerInTurn){
        out.print("Please enter next move in y for " + playerInTurn.getPlayerName() + ":");
        System.out.println("Please enter next move in y for player " + playerInTurn.getPlayerName()  + ":");
        Scanner userIn = new Scanner(in);
        return userIn.nextInt();
    }
    /**
     * Prints the current board
     */
    public void printBoard(){
        board.printBoard();
    }
    /**
     * Game over message
     */
    public void gameOver(){
        out.print("GAME OVER");
        System.out.println("GAME OVER");
    }


}
