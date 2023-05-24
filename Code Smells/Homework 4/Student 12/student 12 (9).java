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
public class HumanPlayer implements Player {
    /** Name of this player. */
    private final String name;

    /** Name of this player. */
    private final int id;

    /** Create a new player with the given name.
     * @param name  sets the Player's name.
     * @param id  sets the Player's id.
     */
    public HumanPlayer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    /** Return the name of this player.
     * @return name Player's name/id
     */
    public String name() {
        return name;
    }

    @Override
     /** Return the name of this player.
     * @return name Player's name/id
     */
    public int id() {
        return id;
    }


    @Override
    /**
     * Gets computer's move.
     * @return int[]   Containing the coordiantes.
     */
    public int[] getNextMove(Player[][] board) {
        int[] arr = { 7,7};
        return arr;
    }

    @Override
    /**
     * States that the current players is human.
     * @return false
     */
    public boolean isComputer(){
        return false;
    }

}

