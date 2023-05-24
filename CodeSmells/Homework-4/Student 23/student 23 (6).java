/**
 * @param name Name of this player.
 */
public record Player(String name) {

    /**
     * Create a new player with the given name.
     */
    public Player {
    }

    /**
     * Return the name of this player.
     */
    @Override
    public String name() {
        return name;
    }
}
