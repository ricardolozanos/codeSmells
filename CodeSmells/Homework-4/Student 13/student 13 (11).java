import java.util.Scanner;

public class UserInterface implements UserInterfaceable{
    Input input = Input.getInstance();
    @Override
    public void drawBoard(int[][] board){
        for (int i = 0; i < board.length; i++){
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++){
                switch(board[i][j]){
                    case(0):
                        System.out.print(" |");
                        break;
                    case(1):
                        System.out.print("O|");
                        break;
                    case(2):
                        System.out.print("X|");
                        break;
                    case 3:
                        System.out.print("*|");
                        break;
                }
            }
            System.out.println();
        }
    }
    @Override
    public int[] getStonePlacement(String playerName){
        int[] stonePlacement = new int[2];
        System.out.println(playerName + "'s turn, please input the column you would like to place a stone in:");
        stonePlacement[1] = input.nextInt();
        System.out.println(playerName + "'s turn, please input the row you would like to place a stone in:");
        stonePlacement[0] = input.nextInt();

        return stonePlacement;
    }
    @Override
    public void displayString(String toDisplay){
        System.out.println(toDisplay);
    }
    @Override
    public int getGameMode(){
        boolean invalidInput = true;

        System.out.println("Welcome to Super Omok 3000!");
        System.out.println("Please enter your desired GameMode:");
        System.out.println("- Player vs Player (1)");
        System.out.println("- Strategy (2)");
        System.out.println("- Exit Game (3)");
        while (invalidInput){
            switch(input.nextInt()){
                case(1):
                    System.out.println("You selected Player vs Player!");
                    return 1;
                case(2):
                    System.out.println("You selected Strategy mode!");
                    return 2;
                case(3):
                    System.out.println("Thank you for playing!");
                    input.close();
                    return 3;
                case(-9):
                    System.out.println("YOU HAVE EARNED OMOKFISH'S FRIENDSHIP");
                    System.out.println("HE WILL BE YOUR GUIDE");
                    return -9;
                default:
                    System.out.println("Welcome to Super Omok 3000!");
                    System.out.println("Please enter your desired GameMode:");
                    System.out.println("- Player vs Player (1)");
                    System.out.println("- Strategy (2)");
                    System.out.println("Please select a valid option");
            }
        }
        return -1;
    }

    @Override
    public String getPlayerName(int playerNum) {
        boolean invalidInput = true;
        String playerName = "";

        System.out.println("Please enter name of player " + playerNum + ":");
        while (invalidInput) {
            playerName = input.next();
            if(isValidName(playerName)){
                invalidInput = false;
            }
            else{
                System.out.println("Please enter a valid name (1 to 12 letters/numbers)");
            }
        }
        return playerName;
    }

    @Override
    public void drawVictoryScreen(String playerName){
        System.out.println(playerName + " has won!");
        System.out.println("Enter anything to continue");
        input.next();
    }
    @Override
    public void drawDefeatScreen(){
        System.out.println("You have lost, OMOKFISH reigns supreme!");
        System.out.println("Enter anything to continue");
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
}
