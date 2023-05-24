package omok;

public class Player {

    /** Name of this player. */
    private final String name;

    /** Create a new player with the given name. */
    public Player(String name) {
        this.name = name;
    }

    /** Return the name of this player. */
    public String name() {
        return name;
    }
}