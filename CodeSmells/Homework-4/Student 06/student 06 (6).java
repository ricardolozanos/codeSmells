abstract class Player {
    protected int pNum;

    public int getpNum(){
        return pNum;
    }
    abstract boolean makeMove(int x, int y, Board board);

}
