package game;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
/**gets info from and shows info to user*/
public class conoleUI {
    PrintStream out;

    public conoleUI(PrintStream out) {
        this.out = out;
    }
    public conoleUI(){
        this(System.out);
    }
    /**only run on launch*/
    public void intro(){
        out.println("Welcome to my Omok game");
    }
    /** checks if user wants to start a new game */
    public Boolean endgame(Scanner k){
        out.println("Do you want to play another round? \r\n 1 for yes \r\n 0 for no");
        while(true){
            String g = k.nextLine();
            if(g.equals("1")){
                return true;
            }
            if(g.equals("0")){
                return false;
            }
            out.println("invalid choice please input 1 or 0");
        }
    }
    /** input validation for selecting a game mode */
    public int gameselect(Scanner k) {
        out.println("Please chose a game type you would like to play");
        out.println("1: Vs. the Ai");
        out.println("2: Vs. a friend");
        boolean i = true;
        while (i){
        String g = k.nextLine();
        if (g.equals("1")){
            return 1;
        }
        else if (g.equals("2")){
            return 2;
        }
        else{
            out.println("not a valid choice");
            
        }
    }
    return 0;
    }
    
    /**draws current board state */
    public void drawBoard(omokGame game) {
        out.println("the board is");
        String[][] field = game.gamespace.field;
        for( int i = 0; i<field.length; i++){
            out.print("[  ");
            for( int j = 0; j<field.length; j++){
                if(field[i][j].length()==2){
                out.print("\033[0;93m"+ field[i][j].charAt(1)+"\033[0m"+ "  ");
                }
                else{
                out.print(field[i][j]+"  ");
                }
            }
            out.println("]");
        }
    }

    /** Gets desired input location from user incudes input validation*/
    public int[] getpos(int player, Scanner k, omokGame game){
        out.println("it is player "+(player+1)+ "s turn please input where you would like to place your piece in the following format: X, Y (-1, -1 will exit the match)");
        while(true){
            String g = k.nextLine();
            if(g.equals("-1, -1")){
                return new int[]{-1, -1};
            }
            String[] gar = g.split(", ", -1);
            if (gar.length == 2){
                try{
                    int X = Integer.parseInt(gar[0]);
                    int Y = Integer.parseInt(gar[1]);
                    if((X > 0 && Y > 0) && (X<=game.gamespace.size && Y<=game.gamespace.size) && (game.gamespace.getboard()[Y-1][X-1] == "*")){
                        int[] out = {Y-1,X-1};
                        return out;
                    }
                }
                catch(Exception e){
                }
            }
            out.println("Your input was invalid/already taken please try again (X, Y or -1, -1 to exit match) \r\nInputs must also be within the board's bounds");

        }
    }

    /** decides size of game board from user input */
    public int sizeAsk(Scanner k){
        out.println("What size board do you want?");
        String g = k.nextLine();
        int j = 0;
        try{j =Integer.parseInt(g);}
        catch(Exception e){
            out.println("input must be a whole number");
            return sizeAsk(k);
        }
        
        if (j<15){
            out.println("size must be greater than 14");
            return sizeAsk(k);
        }
        else {
            return j;
        }
        
    }

    /** declares winner of game and exits rounds loop in controller*/
    public boolean printwinner(int curplayer, omokGame game) {
        out.println("player "+ (curplayer+1) + " has won");
        drawBoard(game);

        return false;
    }
    
}