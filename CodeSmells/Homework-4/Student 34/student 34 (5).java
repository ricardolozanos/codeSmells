package omokThings;

import java.awt.*;

public class Player extends Board {
    static Color color;
    static String name;

    static Character marker;

    public Player() {

    }

    public Player(Color color, String name, Character marker) {
        this.color = color;
        this.name = name;
        this.marker = marker;
    }

}
