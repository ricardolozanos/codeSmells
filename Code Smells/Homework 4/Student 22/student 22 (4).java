import java.awt.*;

/**
 * A player in an Omok game. It holds the name of the player and
 * can be used to identify a specific player throughout the game.
 * The Player class helps to keep track of the moves made by each
 * player during the game.
 */
public class Player{

    private final String name;
    private final Color stoneColor;

    public Player(String name, Color stoneColor) {
        this.name = name;
        this.stoneColor = stoneColor;
    }

    public String getName() {
        return name;
    }

    public Color getStoneColor() {
        return stoneColor;
    }
}

