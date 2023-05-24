package OmokBoard;

public class computerPlayer extends player{
    private int playerNum = 2;
    public computerPlayer(){
    }
    public computerPlayer(int playerNum){
        this.playerNum = playerNum;
    }
    public int getComputerNum(){
        return playerNum;
    }
    //returns an array of row, col so placeStone function in omokBoard can place the computer piece onto active board
    public int[] comPlaceStone(Board b){
        int row;
        int col;
        int[] coordinate = new int[2];


        return coordinate;
    }
}
