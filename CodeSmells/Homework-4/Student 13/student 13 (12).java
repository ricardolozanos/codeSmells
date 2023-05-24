public interface UserInterfaceable {
    /**
     * Displays the board
     * @param board the board state
     */
    void drawBoard(int[][] board);

    /**
     * Provides the position of the stoned to be placed
     * @param playerName the name of the player to place a stone
     * @return the x, y coordinates of the stone to be placed
     */
    int[] getStonePlacement(String playerName);

    /**
     * Displays a String
     * @param toDisplay String to display
     */
    void displayString(String toDisplay);

    /**
     * Provides the game mode to be played
     * @return an integer representing the preferred game mode (1-2)
     */
    int getGameMode();

    /**
     * Provides the player's name
     * @return the player's name
     */
    String getPlayerName(int playerNum);

    /**
     * Displays victory screen
     * @param playerName the name of the player who has won
     */
    void drawVictoryScreen(String playerName);

    /**
     * Displays defeat screen
     */
    void drawDefeatScreen();
}
