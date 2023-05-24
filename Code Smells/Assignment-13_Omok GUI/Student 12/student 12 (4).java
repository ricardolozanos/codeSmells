public abstract class Player {
    private final int value;
    private final String label;

    public Player(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return this.label;
    }
}
