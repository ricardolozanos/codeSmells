package OmokConsole.Model;

import java.util.Random;

public class COMGame implements Game {
    private final Board board;
    private Player player1;
    private Player comPlayer;
    private Player currPlayer;
    private Place place;
    private boolean winCon = false;
    private boolean tieCon = false;
    private int p1X;
    private int p1Y;
    private int lastX1;
    private int lastY1;
    private int lastX2;
    private int lastY2;

    public COMGame(){
        this.board = new Board();
        player1 = new Player(1);
        comPlayer = new Player(2);
        currPlayer = player1;
        place = new Place(currPlayer, board);
    }

    public COMGame(int size){
        this.board = new Board(size);
        player1 = new Player(1);
        comPlayer = new Player(2);
        currPlayer = player1;
        place = new Place(currPlayer, board);

    }
    @Override
    public boolean checkPlace(int x, int y) {
        if (x < 0 | x > board.getSize() - 1 | y < 0 | y > board.getSize() - 1) {
            return true;
        }
        return board.getBoard()[x][y] == 1 | board.getBoard()[x][y] == 2;
    }

    @Override
    public void playerTurn(int x, int y) {
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
        }
        p1X = x;
        p1Y = y;
        place.setCurrPlayer(comPlayer);
        currPlayer = comPlayer;
    }
    @Override
    public void comTurn(){
        if (checkNearWinHorizontal(p1X, p1Y)) {
            if (!checkPlace(lastX1, lastY1 + 1)){
                place.placeStone(lastX1, lastY1 + 1);
            }
            else if(!checkPlace(lastX2, lastY2 - 1)){
                place.placeStone(lastX2, lastY2 - 1);
            }
        }
        else if (checkNearWinVertical(p1X, p1Y)) {
            if (!checkPlace(lastX1 + 1, lastY1)){
                place.placeStone(lastX1 + 1, lastY1);
            }
            else if(!checkPlace(lastX2 - 1, lastY2)){
                place.placeStone(lastX2 - 1, lastY2);
            }
        }
        else if (checkNearWinDiagonal1(p1X, p1Y)) {
            if (!checkPlace(lastX1 + 1, lastY1 + 1)){
                place.placeStone(lastX1 + 1, lastY1 + 1);
            }
            else if(!checkPlace(lastX2 - 1, lastY2 - 1)){
                place.placeStone(lastX2 - 1, lastY2 - 1);
            }
        }
        else if (checkNearWinDiagonal2(p1X, p1Y)) {
            if (!checkPlace(lastX1 + 1, lastY1 - 1)){
                place.placeStone(lastX1 + 1, lastY1 - 1);
            }
            else if(!checkPlace(lastX2 - 1, lastY2 + 1)){
                place.placeStone(lastX2 - 1, lastY2 + 1);
            }
        }
            Random ran = new Random();
            int x = ran.nextInt(board.getSize());
            int y = ran.nextInt(board.getSize());

            while (checkPlace(x, y)) {
                x = ran.nextInt(board.getSize());
                y = ran.nextInt(board.getSize());
            }
            place.placeStone(x, y);
            place.setCurrPlayer(player1);
            currPlayer = player1;
    }

    @Override
    public int countPieces(int player, int x, int y, int dx, int dy) {
        int count = 1;
        int row = x + dx;
        int col = y + dy;

        while(row < board.getSize() && row >= 0 && col < board.getSize() && col >= 0 && board.getBoard()[row][col] == player){
            row += dx;
            col += dy;
            count += 1;
        }

        lastX1 = row - dx;
        lastY1 = col - dy;

        row = x - dx;
        col = y - dy;

        while(row < board.getSize() && row >= 0 && col < board.getSize() && col >= 0 && board.getBoard()[row][col] == player){
            row -= dx;
            col -= dy;
            count += 1;

        }
        lastX2 = row + dx;
        lastY2 = col + dy;


        return count;
    }

    @Override
    public boolean checkWin(int x, int y){
        return countPieces(board.getBoard()[x][y], x, y, 1, -1) == 5 || countPieces(board.getBoard()[x][y], x, y, 1, 1) == 5
                || countPieces(board.getBoard()[x][y], x, y, 1, 0) == 5 || countPieces(board.getBoard()[x][y], x, y, 0, 1) == 5;
    }

    public boolean checkNearWinHorizontal(int x, int y){
        return countPieces(board.getBoard()[x][y], x, y, 0, 1) >= 3;
    }

    public boolean checkNearWinVertical(int x, int y){
        return countPieces(board.getBoard()[x][y], x, y, 1, 0) >= 3;
    }

    public boolean checkNearWinDiagonal1(int x, int y){
        return countPieces(board.getBoard()[x][y], x, y, 1, 1) >= 3;
    }

    public boolean checkNearWinDiagonal2(int x, int y){
        return countPieces(board.getBoard()[x][y], x, y, 1, -1) >= 3;
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
        return this.winCon;
    }

    @Override
    public boolean getTieCon() {
        return this.tieCon;
    }

    @Override
    public Player getCurrPlayer() {
        return this.currPlayer;
    }

    @Override
    public Player getPlayer1() {
        return this.player1;
    }

    @Override
    public Player getPlayer2() {
        return this.comPlayer;
    }

    @Override
    public Board getBoard() {
        return this.board;
    }
}
