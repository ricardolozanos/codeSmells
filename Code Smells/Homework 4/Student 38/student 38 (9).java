//Implementation of player used for humans
public class HumanPlayer implements Player{
    private final Stone stone;
    private final String name;
    private final GameInterface ui;
    /**
     * @param stone,name,ui
     * Constructor that initializes variables that define our player
     */
    public HumanPlayer(Stone stone, String name, GameInterface ui) {
        this.stone = stone;
        this.name = name;
        this.ui = ui;
    }
    /**
     * @param board
     * makeMove method from player, user chooses where to place stone
     */
    @Override
    public int[] makeMove(Board board) {
        while (true) {
            int[] move = ui.promptMove(getName(), getStone());
            if (board.isValidMove(move[0], move[1])) {
                return move;
            } else {
                ui.displayMessage("Invalid move, try again.");
            }
        }
    }
    /**
     * @return stone type
     */
    @Override
    public Stone getStone() {
        return stone;
    }

    /**
     * @return player name
     */
    @Override
    public String getName() {
        return name;
    }

}