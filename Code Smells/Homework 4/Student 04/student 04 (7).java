package HW4_GUI.console;

public class HumanPlayer extends Player {
    private ConsoleUI ui;
        
    public HumanPlayer(String name, char piece, ConsoleUI ui) {
        super(name, piece);
        this.ui = ui;
    }

    @Override
    public Coordinate pickPlace(Board board){
        Coordinate move = null;
        int decision = ui.chooseMove();
        if(decision == 1){
            move = ui.playerMove(this);
        }else{
            move = board.getSuggestion(this.symbol);
        }
        return move;
    }
}


