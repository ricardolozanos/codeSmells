/**

 The ConsoleUI class represents the console user interface for an Omok game.

 It allows users to choose between playing a human game or a strategy game,

 and provides a way for players to enter their names.
 */
public class ConsoleUI {

    /**

     The input scanner for the console.
     */
    private Scanner input;
    /**

     The size of the game board.
     */
    private int boardSize;
    /**

     Constructs a new ConsoleUI object with the specified board size.
     @param boardSize the size of the game board
     */
    public ConsoleUI(int boardSize) {
        this.boardSize = boardSize;
        input = new Scanner(System.in);
    }
    /**

     Displays the game mode options to the user and allows them to choose
     between playing a human game or a strategy game.
     */
    public void GameMode() {
        System.out.println("Select game mode:");
        System.out.println("1. Human game");
        System.out.println("2. Strategy game");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                playHumanGame();
                break;
            case 2:
                playStrategyGame();
                break;
            default:
                System.out.println("Error. Please choose between the two games.");
                GameMode();
                break;
        }
    }
    /**
     Starts a new human game with two human players.
     */
    private void playHumanGame() {
// TODO: implement
    }
    /**

     Starts a new strategy game with one human player and one computer player.
     */
    private void playStrategyGame() {
// TODO: implement
    }
    /**

     Asks for and returns the name of a player.
     @return the name of the player
     */
    private String getPlayerName() {
        System.out.print("Enter player name: ");
        return input.next();
    }
}