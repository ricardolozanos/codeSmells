import java.util.Scanner;

/** Interactive user class. This class allows Gomoku implementation to interact during run time with user using methods to print messages or scan input.
 * @author Emilio Andre Rojero
 * @version 1.0 (02/26/2023)
 */
public class ConsoleJavaDoc{

    /**Enables scanning function for methods. Defines scanner's name with "s".
     * @param System.in Standard input
     */
    Scanner s = new Scanner(System.in);

    /**Builds object with no parameters or specifications.*/
    public ConsoleJavaDoc(){ }

    /**Prints welcome message tells the user how to choose game mode.
     */
    public void welcome(){
        System.out.println("Welcome to Omok");
        System.out.print("Type 1 for 2 players. Type 2 to play vs computer. ---->>>>");
    }

    /**Scans game mode and checks if it's valid, if not it scans again.
     * @return Integer type, game mode the user wants to play
     */
    public int scanMode(){
        int mode = s.nextInt();
        while(!(mode >= 1 && mode <= 2)){
            System.out.print("Invalid game mode. Type 1 for 2 players. Type 2 to play vs computer. ---->>>>");
            mode = s.nextInt();
        }
        return mode;
    }

    /**Scans two integers from user input.
     * @return Integer array containing the coordinate the user wants to put his/her stone in.
     */
    public int[] getInput(){
        int[] x = new int[2];
        x[0] = s.nextInt();
        x[1] = s.nextInt();
        return x;
    }

    /**Prints victory message to advice x (player number entered as parameter) player that he/she won.
     * @param playerNumber integer which is the number of the player who won to include it in the message.
     */
    public void victoryMessage(int playerNumber){
        System.out.println("\nCONGRATULATIONS PLAYER " + playerNumber + " YOU WON!!!");
    }

    /**Prompts the user to type the next coordinates he/she wants to play.
     */
    public void askCoordinates(){
        System.out.println("Enter coordinates (x y) No comma, and numbers from 0 to 14. Type 1000 to end game.");
    }

    /**Tells the user if his/her coordinate is not valid. This may be caused by an input out of bounds or position already in used.
     */
    public void invalidInput(){
        System.out.print("Invalid input. Enter x y:");
    }

    /**Prints a message telling the user(s) that the game ended in a draw.
     */
    public void drawMessage(){ System.out.println("It's a draw. :/"); }

    /**Tells the user(s) that the game has ended.
     */
    public void endMessage(){ System.out.println("Game ended."); }

    /**Draws the board using ASCII characters and information kept at 2D array parameter.
     * @param table A 2D array which keeps track of the used and empty espaces in the board.
     */
    public void printBoard(int[][] table){

        System.out.println("x  y| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10| 11| 12| 13| 14|");
        System.out.println("----------------------------------------------------------------");
        for(int i = 0; i < 15; i++){
            if(i < 10)
                System.out.print("  " + i + " |");
            else
                System.out.print(" " + i + " |");
            for(int j = 0; j < 15; j++){
                if (table[i][j] == 1)
                    System.out.print(" X |");
                else if(table[i][j] == 2)
                    System.out.print(" 0 |");
                else
                    System.out.print("   |");
            }
            System.out.println();
        }
    }
}