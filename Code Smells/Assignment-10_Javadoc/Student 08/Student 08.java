/**
 * @author Marc Buster
 * @version 1.0
 *
  Bunch of Print statements that respond to the User's Input */
public class ConsoleUI {
    /** Board that'll be updated each placce */
    public Board b;

    /** Default Constructor for ConsoleUI */
    public ConsoleUI() {}

    /** Print statements of the Intro to the game where player selects what gamemode */
    public void welcome() {
        System.out.println("~~~~ Welcome To Omok ~~~~");
        System.out.println();
        System.out.println("Please select Gamemode (Input number):");
        System.out.println("1. Play versus Computer");
        System.out.println("2. Play versus Player");
    }

    /** Prints the updated board after every placement and select location print statement  */
    public void printBoard(Board board) {
        board.printB();
        System.out.println(" ~~ Please select a location x,y ~~");
    }

    /** gets the board size and creates a board */
    public void boardSize(int x) {
        b = new Board(x);
    }

    /** print statement for ending the game */
    public void end() {
        System.out.println("Thanks For playing!!");

    }

    /** Print statement for selecting the board size */
    public void printBoardSize() {
        System.out.println("Please Select Board size (minimum 15x15)");
    }

}
