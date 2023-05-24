package OmokConsole.Model;

public class PVPGame implements Game {
    private final Board board;
    private Player player1;
    private Player player2;
    private Player currPlayer;
    private Place place;
    private boolean winCon = false;
    private boolean tieCon = false;

    public PVPGame(){
        this.board = new Board();
        player1 = new Player(1);
        player2 = new Player(2);
        currPlayer = player1;
        place = new Place(currPlayer, board);
    }

    public PVPGame(int size){
        this.board = new Board(size);
        player1 = new Player(1);
        player2 = new Player(2);
        currPlayer = player1;
        place = new Place(currPlayer, board);
    }



    @Override
    public boolean checkPlace(int x, int y){
        if (x < 0 | x > board.getSize() - 1 | y < 0 | y > board.getSize() - 1) {
            return true;
        }
        return board.getBoard()[x][y] == 1 | board.getBoard()[x][y] == 2;
    }

    @Override
    public void playerTurn(int x, int y){
        if (checkPlace(x,y)){
            return;
        }
        place.placeStone(x, y);
        if (checkWin(x, y)){
            winCon = true;
            return;
        }
        if (checkTie()){
            tieCon = true;
            return;
        }
        if (currPlayer == player1){
            place.setCurrPlayer(player2);
            currPlayer = player2;
        }
        else {
            place.setCurrPlayer(player1);
            currPlayer = player1;
        }
    }
    @Override
    public void comTurn(){
    }

    @Override
    public int countPieces(int player, int x, int y, int dx, int dy){
        int count = 1;
        int row = x + dx;
        int col = y + dy;

        while(row < board.getSize() && row >= 0 && col < board.getSize() && col >= 0 && board.getBoard()[row][col] == player){
            row += dx;
            col += dy;
            count += 1;
        }

        row = x - dx;
        col = y - dy;

        while(row < board.getSize() && row >= 0 && col < board.getSize() && col >= 0 && board.getBoard()[row][col] == player){
            row -= dx;
            col -= dy;
            count += 1;

        }

        return count;
    }
    @Override
    public boolean checkWin(int x, int y){
        return countPieces(board.getBoard()[x][y], x, y, 1, -1) == 5
                || countPieces(board.getBoard()[x][y], x, y, 1, 1) == 5
                || countPieces(board.getBoard()[x][y], x, y, 1, 0) == 5
                || countPieces(board.getBoard()[x][y], x, y, 0, 1) == 5;
    }

    @Override
    public boolean checkTie(){
        for(int i = 0; i < board.getSize(); i++){
            for (int j = 0; j < board.getSize(); j++){
                if (board.getBoard()[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean getWinCon() {
        return winCon;
    }

    @Override
    public boolean getTieCon() {
        return tieCon;
    }

    @Override
    public Player getCurrPlayer(){
        return this.currPlayer;
    }

    @Override
    public Player getPlayer1(){
        return this.player1;
    }

    @Override
    public Player getPlayer2(){
        return this.player2;
    }

    @Override
    public Board getBoard(){
        return this.board;
    }
}
