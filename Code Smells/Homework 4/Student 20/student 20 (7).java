public class Place {
    /**
     * x-coordinate in the board
     */
    private int x;
    /**
     * y-coordinate in the board
     */
    private int y;
    /**
     * player that owns that place
     */
    private char stone;
    public Place(int x, int y){
        this.x = x;
        this.y = y;
        this.stone = '-';
    }

    public char getStone() {
        return stone;
    }

    public void setStone(char stone) {
        this.stone = stone;
    }

}
