package noapplet.example;

import java.io.PrintStream;
import java.util.Scanner;
/**
 * Class to manage user input and Game prompts
 * @ author Jesus Oropeza & Dante Lopez
 * @ version 1 (2/26/2023)
 */
public class ConsoleUI {
    static Scanner scn = new Scanner(System.in);
    static PrintStream out;
    
    public ConsoleUI(PrintStream out){this.out = out;}
    public ConsoleUI(){this(System.out);}

    public static int Greeting() {
        out.println("*****" + "OMOK" + "*****");
        out.println("Designate the desired size of the board");
        out.println("Must be at least size 15");
        int boardSize = scn.nextInt();
        if (boardSize < 15) {
            out.println("Size must be at least 15! Try again");
            Greeting();
        }
        return boardSize;
    }

    public static int GameMode(){
        out.println("Please select a game mode:");
        out.println("1. Human  |  2. Strategy");
        int usr = scn.nextInt();
        if(usr != 1 && usr != 2){out.println("That is not a valid input!"); GameMode();}
        return usr;
    }

    public static void DisplayRules(){
        out.println("Make selection by first entering the number for the desired ROW");
        out.println("Then enter the number for the desired COLUMN");
        out.println("The first person to go will have the designation 'X' and the other will have the designation 'O'");
        out.println("The first player to have an unbroken line of 5 wins!");
    }

    public static void play(boolean p1turn){
        boolean goodPlace;
        if(p1turn) {out.println(">>> Turn: Player one <<<");}
        else{out.println(">>> Turn: Player two <<<");}
        out.println("To quit game enter a negative value");
        Board.drawBoard();
        out.println("Enter row number");
        int row = scn.nextInt();
        out.println("Enter column number");
        int col = scn.nextInt();
        // Quit game
        if(row < 0 || col < 0){System.exit(0);}
        // Error checking
        goodPlace = Board.placeStone(row, col, p1turn);
        if(!goodPlace){out.println("Invalid selection, try again."); play(p1turn);}
    }

    public static void DisplayWin(boolean p1turn){
        Board.drawBoard();
        if(p1turn){out.println("Congratulations Player 1");}
        else{out.println("Congratulations Player 2");}
        rematch();
    }

    public static void Draw(){
        out.println("No moves left, it's a draw!");
        rematch();
    }

    public static void rematch(){
        out.println("Play again?");
        out.println("1: Yes | 2: No");
        int ans = scn.nextInt();
        if(ans == 1){
            Controller.Intro();
        }
        else{
            System.exit(0);
        }
    }


}
