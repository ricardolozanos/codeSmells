//Hello
public class GameMode {
    private final String name;
    //Constructor takes name of game mode
    public GameMode(String name) {
        this.name = name;
    }
    /**
     * getName gets name of the gameMode
     * @return name of mode
     */
    public String getName() {
        return name;
    }
    public String toString(){
        return name;
    }
    //These two GameMode objects are used to represent the available game modes
    public static final GameMode Human_VS_Human = new GameMode("Human vs. Human");
    public static final GameMode Human_VS_Computer = new GameMode("Human vs. Computer");
}