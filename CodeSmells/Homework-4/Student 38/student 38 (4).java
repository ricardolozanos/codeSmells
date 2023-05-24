//Hello
import java.util.Scanner;
//ConsoleInterface class that creates the methods which interact with the user
public class ConsoleInterface implements GameInterface {
    private final Board board;
    private final Scanner scanner;
    //Constructor for UI that takes board
    public ConsoleInterface(Board board) {
        this.board = board;
        this.scanner = new Scanner(System.in);
    }
    /**
     * @param gameMode1,gameMode2
     * method to ask user for game mode that they want to play
     */
    public GameMode promptGameMode(GameMode gameMode1, GameMode gameMode2) {
        System.out.println("Please enter 1 or 2 to choose a game mode: ");
        System.out.println("1. " + gameMode1.getName());
        System.out.println("2. " + gameMode2.getName());
        int choice = scanner.nextInt();
        if (choice == 1) {
            return gameMode1;
        } else {
            return gameMode2;
        }
    }
    /**
     * @param stone
     * Prompts user to create their name
     */
    public String promptName(Stone stone) {
        System.out.println("Please enter the name of the " + stone + " player:");
        return scanner.next();
    }
    /**
     * Displays messages to user
     */
    public void displayMessage(String message) {

        System.out.println(message);
    }
    /**
     * Creates and constantly updates board after player use
     */
    public void displayBoard() {
        int size = board.getSize();
        System.out.print(" x ");
        for (int col = 0; col < size; col++) {
            if(col < 10) {
                System.out.print(col + " ");
            }
            else{
                System.out.print((char)('A' + col - 10) + " ");
            }
        }
        System.out.println();
        System.out.println("y --------------------------------");
        for (int row = 0; row < size; row++) {
            if(row < 10) {
                System.out.print(row + "| ");
            }
            else{
                System.out.print((char)('A' + row - 10) + "| ");
            }
            for (int col = 0; col < size; col++) {
                Stone stone = board.getStone(row, col);
                if (stone == null) {
                    System.out.print("+ ");
                } else {
                    System.out.print(stone.getSymbol() + " ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
    }

    /**
     * Prompts player for stone placement
     * @param playerName currentPlayer making move
     * @param playerStone currentPlayers stone
     * @return move
     */
    public int[] promptMove(String playerName, Stone playerStone) {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];
        System.out.println(playerName + " (" + playerStone + " team), enter your move below:");
        System.out.print("Row:");
        String rowInput = scanner.next();
        System.out.print("Column:");
        String colInput = scanner.next();
        move[0] = Character.isLetter(rowInput.charAt(0)) ? rowInput.toUpperCase().charAt(0) - 'A' + 10 : Integer.parseInt(rowInput);
        move[1] = Character.isLetter(colInput.charAt(0)) ? colInput.toUpperCase().charAt(0) - 'A' + 10: Integer.parseInt(colInput);
        return move;
    }
}
