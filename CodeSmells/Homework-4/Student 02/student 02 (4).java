package OmokConsole.UI;

import OmokConsole.Model.Board;
import java.util.Scanner;
public class ConsoleUI {
    Scanner sc;
    public int input;
    public int x;
    public int y;
    public ConsoleUI(){
        sc = new Scanner(System.in);
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public int getInput(){
        return this.input;

    }

    public void setInputFromSystemIn() {
        this.input = sc.nextInt();
    }

    public void setInput(int input){
        this.input = input;
    }

    public void setXYFromSystemIn(Board board){
        this.x = sc.nextInt();
        this.y = sc.nextInt();
        if (this.x < -1 | this.x > board.getSize() | this.y < -1 | this.y > board.getSize()) {
            System.out.println("Please enter a move within the board space.");
        }
        this.input = this.x;
        this.input = this.y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void printBoard(Board board){
        System.out.print("\t|");
        for (int i = 0; i < board.getSize(); i++){
            if (i > 9) {
                System.out.print(" " + i + "  |");
            }
            else {
                System.out.print("  " + i + "  |");
            }
        }
        System.out.println();
        for(int i = 0; i < (board.getSize() * 6) + 5; i++){
            System.out.print("-");
        }
        System.out.println();

        for(int i = 0; i < board.getSize(); i++){
            System.out.print(i + "\t|  ");
            for(int j = 0; j < board.getSize(); j++){
                System.out.print(board.getBoard()[i][j] + "  |  ");
            }
            System.out.println();
            for(int k = 0; k < (board.getSize() * 6) + 5; k++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println("\n\n");

    }
}
