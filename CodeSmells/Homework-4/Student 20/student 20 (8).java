import java.awt.*;

public class Player {
    /**
     * char representing Player's stone
     */
    private char stone;
    /**
     * String representing player's name
     */
    private String playerName;
    /**
     * String representing player's name
     */
    private Color color;
    /**
     * @param stone is the car representing the player
     */
    public Player(char stone, String playerName){
        this.stone = stone;
        this.playerName = playerName;
    }
    /**
     * @param stone is the car representing the player
     * @param playerName is the string representing player's name
     */
    public Player(char stone, String playerName, Color color){
        this.stone = stone;
        this.playerName = playerName;
    }
    /**
     * Returns stone
     */
    public char getStone() {
        return stone;
    }
    /**
     * Returns player's name
     */
    public String getPlayerName() {
        return playerName;
    }
    /**
     * @param stone will be used to set the new stone
     */
    public void setStone(char stone) {
        this.stone = stone;
    }

}
