package noapplet.assignments.HW2;

import java.io.InputStream;
import java.io.PrintStream;

import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;
    private PrintStream output;

    public ConsoleUI(){
        this.scanner = new Scanner(System.in);
    }

    public ConsoleUI(InputStream input, PrintStream output) {
        this.scanner = new Scanner(input);
        this.output = output;
    }

    public int chooseGameMode() {
        System.out.println("Choose game mode: ");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Computer");
        return scanner.nextInt();
    }

    public String getPlayerName(int playerNumber) {
        System.out.print("Enter name for player " + playerNumber + ": ");
        return scanner.next();
    }

    public void showBoard(Board board) {
        int size = board.getSize();
        System.out.print("  ");
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board.getPieceAt(i, j) + " ");
            }
            System.out.println();
        }
    }

    public Coordinate playerMove(Player player){
        int row, col;
        System.out.print(player.getName() + ", enter row and column numbers (e.g. 1 2) or -1 to quit: ");
        row = scanner.nextInt();
        if (row == -1){
            System.exit(0);
        }
        col = scanner.nextInt();
        return new Coordinate(row, col);
    }

    public int chooseMove(){
        System.out.println("Please choose one of the following");
        System.out.println("1. Choose Row and Column");
        System.out.println("2. Enable CheatMode");
        return scanner.nextInt();
    }

    public int chooseBoardSize(){
        System.out.println("Please choose the size of the board: ");
        return scanner.nextInt();
    }
    
    
    public void showInvalidMove() {
        System.out.println("Invalid move. Please try again.");
    }

    public void showWinner(Player player) {
        System.out.println(player.getName() + " wins!");
    }

    public void showTie() {
        System.out.println("It's a tie!");
    }

    public void GameModeError(){
        System.out.println("Please choose a valid option!");
    }

}
