import java.awt.*;

public class Player {
    /**
     * Name of this player.
     */
    private final String name;

    private final Color color;

    /**
     * Create a new player with the given name.
     */
    public Player(String name, Color color) {
        this.color = color;
        this.name = name;
    }

    /**
     * Return the name of this player.
     */
    public String name() {
        return name;
    }

    public Color color() {return color;}
}
