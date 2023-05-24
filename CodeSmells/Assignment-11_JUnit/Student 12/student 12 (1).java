import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
public class ConsoleUI {
    public Board board;
    public InputStream in;
    public PrintStream out;

    public ConsoleUI(Board board,InputStream in, PrintStream out ){
        this.board = board;
        this.in = in;
        this.out = out;
    }
    //-------------------------------------Output------------------------------------------
    //Shows board when prompted too on Console
    public void printMessage(String curr ){ //called for output to show any string when prompted
        System.out.print(curr);
    }
    public void printBoard( int[][] board){ 
        int n = board.length;
        System.out.println();
        System.out.print("    ");
        for(int i = 0; i < n ; i++ )
            System.out.printf("%2d ", i);
    
        for(int i = 0; i < n; i++ ){
            System.out.println();
            System.out.printf(" %2s%s", i,"  ");
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    System.out.print("X  ");
                }else if(board[i][j] == 2){
                    System.out.print("O  ");
                }else if(board[i][j] == 7){ // win Highlight
                    System.out.print("7  ");
                }else{
                    System.out.print(".  ");
                }
            }
        }
    }
    //-------------------------------------Input------------------------------------------
    //returns user inputs for coordinates
    public int[] promptMove(){
        Scanner input = new Scanner(System.in);
        int[] coordinates = {0,0};
        int[] exit = {-1,0}; //special entry to exit game
        int[] cheats = {-5,0};// special entry to activate cheats
        boolean valid = false;
        while(!valid){
            try{
                coordinates[0] = input.nextInt() ;
                if(coordinates[0] == -1){
                    return exit;
                }else if(coordinates[0] == -5){
                    return cheats;
                }
                coordinates[1] = input.nextInt() ;
                valid = true;
            }catch(InputMismatchException e){
                System.out.print("Not an integer try again\n>");
                input.nextLine();
            }
        }
        return coordinates;
    }
    //takes in a range of integer values and prompts user to enter a value in range
    public int promptMode(int min, int max){
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int val = 0;
        while(!valid){
            try{
                val = input.nextInt() ;
                if(val >= min && val <= max){
                    valid = true;
                }else{
                    System.out.print("Pick value in range from "+min+" to "+max+"\n>");
                }
            }catch(InputMismatchException e){
                System.out.print("Not an integer try again\n>");
                input.nextLine();
            }
        }
        return val;
    }
}