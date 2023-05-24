//Hello
/**
 * This Game Interface inherits all abstract classes that can create any given User UI to eliminate any class dependency
 */
public interface GameInterface {
    /**
     * Abstract method to ask user for game mode that they want to play
     * @param gameMode1 gameMode type
     * @param gameMode2 additional gameMode type
     * @return chosen game mode
     */
    GameMode promptGameMode(GameMode gameMode1, GameMode gameMode2);

    /**
     * Abstract method to prompt message user to place stone placement
     * @param playerName name of player
     * @param playerStone players stone representation
     * @return player move
     */
    int[] promptMove(String playerName, Stone playerStone);

    /**
     * Abstract method to prompt message to user to enter their name for each stone
     * @param stone used to represend player on board
     * @return Scanner to user to enter name
     */
    String promptName(Stone stone);

    /**
     * Abstract method to display message to user
     * @param message displays message to user
     */
    void displayMessage(String message);

    /**
     * Abstract method that displays the game board
     */
    void displayBoard();
}
