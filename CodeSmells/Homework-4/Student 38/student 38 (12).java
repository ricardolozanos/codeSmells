//Hello
public class Stone {
    public static final Stone RED = new Stone('R');
    public static final Stone BLUE = new Stone('B');
    public static final Stone GREEN = new Stone('G');
    private final char symbol;
    //constructor
    private Stone(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Method is used to get the representation of stone
     * that will be used on board
     * @return symbol
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Used to return string representation of our stone
     * @return string
     */
    public String toString() {
        if (this == RED) {
            return "R";
        } else if (this == BLUE) {
            return "B";
        } else if(this == GREEN) {
            return "G";
        }else {
            return "+";
        }
    }

    /**
     * method is used to get the stone of the opponent
     * @return oppositeStone
     */
    public Stone opposite() {
        return this == RED ? GREEN : RED;
    }
}
