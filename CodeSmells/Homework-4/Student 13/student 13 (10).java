public interface Playable {
    /**
     * @return the Player's number
     */
    int getPlayerNum();
    /**
     * @return the Player's name
     */
    String getPlayerName();
    /**
     * Provides the position of the stoned to be placed
     * @param board the current state of the board
     * @return the x, y coordinates of the stone to be placed
     */
    int[] getStonePlacement(int[][] board);
}
