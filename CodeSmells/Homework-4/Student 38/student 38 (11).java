//Hello
public interface Player {
    //Method to make move on board
    int[] makeMove(Board board);
    //returns players stone representation
    Stone getStone();
    //Return players name
    String getName();
}
