/**
 * A player in an Omok game. It holds the name of the player and
 * can be used to identify a specific player throughout the game. 
 * The Player class helps to keep track of the moves made by each 
 * player during the game.
 */
public abstract class Player {
    public enum ID{
        WHITE(1),
        BLACK(2);
        public final int VALUE;
        ID(int value){
            VALUE = value;
        }
    }

    /** Name of this player. */
    private final String name;
    private ID id;
    public Player(){this("PLAYER");}

    /** Create a new player with the given name. */
    public Player(String name) {
        this.name = name;
    }
    public void setId(ID id){this.id = id;}
    public ID getId(){return id;}
    /** Return the name of this player. */
    public String name() {
        return name;
    }
    public abstract Board.Place playMove();
    public String toString(){return name;}
}