/* Team:
 * Carlos Cisneros &
 * Braulio Bracamontes
*/
/**
 * A player in an Omok game. It holds the name of the player and
 * can be used to identify a specific player throughout the game.
 * The Player class helps to keep track of the moves made by each
 * player during the game.
 */
public interface Player {
    /** Return the name of this player.
     * @return name Player's name/id
     */
    public String name();

     /** Return the name of this player.
     * @return name Player's name/id
     */
    public int id();

     /** Return the name of this player.
     * @return players next recommended move or computer move
     */
    public int[] getNextMove(Player[][] board);

     /** Return the name of this player.
     * @return players next recommended move or computer move
     */
    public boolean isComputer();


}

