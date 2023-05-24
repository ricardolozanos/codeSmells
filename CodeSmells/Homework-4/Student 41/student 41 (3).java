package noapplet;

public class Player {
    boolean [][] Pieces;
    public Player(int BoardWidth,int BoardHeight){
        this.Pieces = new boolean[BoardWidth][BoardHeight];
    }
    protected boolean pieceAt(int x, int y){
        return Pieces[x][y];
    }
    protected void setPiece(int x, int y, boolean bool){
        Pieces[x][y] = bool;
    }
}
