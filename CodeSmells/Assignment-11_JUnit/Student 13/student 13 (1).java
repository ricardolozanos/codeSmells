import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserInterface implements UserInterfaceable{
    Scanner input;
    OutputStream outputStream;
    InputStream inputStream;
    PrintWriter output;
    public UserInterface(InputStream inputStream, OutputStream outputStream){
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.output = new PrintWriter(outputStream, true);
        this.input = new Scanner(inputStream);
    }
    @Override
    public void drawBoard(int[][] board){
        for (int i = 0; i < board.length; i++){
            output.print("|");
            for (int j = 0; j < board[i].length; j++){
                switch(board[i][j]){
                    case(0):
                        output.print(" |");
                        break;
                    case(1):
                        output.print("O|");
                        break;
                    case(2):
                        output.print("X|");
                        break;
                    case 3:
                        output.print("*|");
                        break;
                }
            }
            output.println();
        }
    }
    @Override
    public int[] getStonePlacement(String playerName){
        int[] stonePlacement = new int[2];
        output.println(playerName + "'s turn, please input the column you would like to place a stone in:");
        stonePlacement[1] = input.nextInt();
        output.println(playerName + "'s turn, please input the row you would like to place a stone in:");
        stonePlacement[0] = input.nextInt();

        return stonePlacement;
    }
    @Override
    public void displayString(String toDisplay){
        output.println(toDisplay);
    }
    @Override
    public int getGameMode(){
        boolean invalidInput = true;

        output.println("Welcome to Super Omok 3000!");
        output.println("Please enter your desired GameMode:");
        output.println("- Player vs Player (1)");
        output.println("- Strategy (2)");
        output.println("- Exit Game (3)");
        while (invalidInput){
            switch(input.nextInt()){
                case(1):
                    output.println("You selected Player vs Player!");
                    return 1;
                case(2):
                    output.println("You selected Strategy mode!");
                    return 2;
                case(3):
                    output.println("Thank you for playing!");
                    input.close();
                    return 3;
                case(-9):
                    output.println("YOU HAVE EARNED OMOKFISH'S FRIENDSHIP");
                    output.println("HE WILL BE YOUR GUIDE");
                    return -9;
                default:
                    output.println("Welcome to Super Omok 3000!");
                    output.println("Please enter your desired GameMode:");
                    output.println("- Player vs Player (1)");
                    output.println("- Strategy (2)");
                    output.println("Please select a valid option");
            }
        }
        return -1;
    }

    @Override
    public String getPlayerName(int playerNum) {
        boolean invalidInput = true;
        String playerName = "";

        output.println("Please enter name of player " + playerNum + ":");
        while (invalidInput) {
            playerName = input.next();
            if(isValidName(playerName)){
                invalidInput = false;
            }
            else{
                output.println("Please enter a valid name (1 to 12 letters/numbers)");
            }
        }
        return playerName;
    }

    @Override
    public void drawVictoryScreen(String playerName){
        output.println(playerName + " has won!");
        output.println("Enter anything to continue");
        input.next();
    }
    @Override
    public void drawDefeatScreen(){
        output.println("You have lost, OMOKFISH reigns supreme!");
        output.println("Enter anything to continue");
        input.next();
    }

    /**
     * Checks if a String is a valid name (1 to 12 letters/numbers)
     * @param name the String to validate
     * @return true if the String is valid, otherwise false
     */
    private boolean isValidName(String name){
        char currChar;
        for (int i = 0; i < name.length(); i++) {
            currChar = name.charAt(i);
            if (!((currChar >= 'a' && currChar <= 'z') || (currChar >= 'A' && currChar <= 'Z') || (currChar >= '0' && currChar <= '9'))){
                return false;
            }
        }
        if (name.length() == 0 || name.length() > 12) {
            return false;
        }
        return true;
    }

    @Override
    public void close() {
        input.close();
    }
}
