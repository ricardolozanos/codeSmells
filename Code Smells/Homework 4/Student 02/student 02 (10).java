package OmokConsole.Model;

public class Player {
    private int piece;
    private boolean myTurn;

    public Player(){
        this.piece = 1;
        this.myTurn = true;
    }

    public Player(int piece){
        this.piece = piece;
    }

    public int getPiece() {
        return piece;
    }

    public void setMyTurn(boolean myTurn) {
        this.myTurn = myTurn;
    }

    public boolean getMyTurn() {
        return myTurn;
    }
}
