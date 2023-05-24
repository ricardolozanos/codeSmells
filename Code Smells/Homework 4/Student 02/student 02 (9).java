package OmokConsole.Model;

public class Place {
    private Board board;
    private Player currPlayer;


    public Place(){

    }

    public Place(Player currPlayer, Board board){
        this.currPlayer = currPlayer;
        this.board = board;
    }

    public void placeStone(int x, int y){
        board.getBoard()[x][y] = currPlayer.getPiece();
        currPlayer.setMyTurn(false);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setCurrPlayer(Player currPlayer) {
        this.currPlayer = currPlayer;
    }

    public Player getCurrPlayer(){
        return this.currPlayer;
    }

    public Board getBoard(){
        return this.board;
    }
}
