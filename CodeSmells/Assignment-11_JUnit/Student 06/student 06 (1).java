public class HumanPlayer extends Player{
    public HumanPlayer(int pnum){
        super.pNum = pnum;
    }
    public boolean makeMove(int x, int y, Board board){
        return board.placeStone(x, y, pNum);
    }
}
