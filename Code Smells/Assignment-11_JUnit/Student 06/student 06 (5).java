import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UI {
    Scanner scanner;
    public UI(){
        scanner = new Scanner(System.in);
    }
    public UI(InputStream in, OutputStream out){
        System.setOut(new PrintStream(out));
        scanner = new Scanner(in);
    }
    public void printBoard(Board board){
        System.out.print("  X");
        for(int i = 0; i < board.getSize(); i++){
            System.out.print("\t" + (i+1));
        }
        System.out.println();
        System.out.println("Y");

        for (int i = 0; i < board.getSize(); i++){
            System.out.print(i+1 + "\t");
            for (int j = 0; j < board.getSize(); j++){
                System.out.print(board.getBoard()[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public String selectMode(){
        System.out.println("Select Game Mode:");
        System.out.println("Press 1 for Single Player");
        System.out.println("Press 2 for PvP");
        System.out.print("Input number: ");
        return scanner.nextLine();
    }
    public void modeSelected(int mode){
        if (mode == 1) {
            System.out.println("Player vs Computer has been selected \n To exit the game at any time, input a negative value as one of the  coordinate values and press enter.");
        } else if (mode == 2) {
            System.out.println("Player vs Player has been selected");
            System.out.println("To exit the game at any time, input a negative value as one of the  coordinate values and press enter.");

        }
        else {
            System.out.println("Please input a valid game mode");
        }
    }
    public void invalid(){
        System.out.println("Invalid number, try again");
    }
    public void playerNext(int x){
        System.out.println("Player " + x + " make your move.");
    }
    public void xIn(){
        System.out.println("Input X Coordinate:");
    }
    public void yIn(){
        System.out.println("Input Y Coordinate:");
    }
    public void cpuMove(){
        System.out.println("CPU Moves");
    }
    public void winNotification(int winner){
        System.out.println("Player " + winner + " has WON!");
    }
    public int[] takeCoordinates(){
        xIn();
        int x = scanner.nextInt();
        yIn();
        int y = scanner.nextInt();
        return new int[]{x, y};
    }
    public int inputInt(){
        return scanner.nextInt();
    }
    public void leaveGame(){
        System.out.println("Game Ended by player.");
    }
    public int sizePrompt(){
        System.out.println("Please input a board size >= 15: ");
        return inputInt();

    }
    public void indexOOB(){
        System.out.println("The coordinates are not valid, try again.");
    }
}
