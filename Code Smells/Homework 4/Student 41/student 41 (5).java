package noapplet;

import java.util.Random;

public class Game {
    Board board = new Board();
    int stones = 0;
    boolean isBlackTurn = true;
    public Game(){

    }
    public Game(int width, int height){
        this.board = new Board(width,height);
    }
    protected boolean placeStone(int x, int y){
        if(isBlackTurn){
            if(!board.Player2().pieceAt(x,y) && !board.Player1().pieceAt(x,y)){
                board.Player1().setPiece(x,y,true);
                stones++;
                isBlackTurn = false;
                return true;
            }
        }
        else{
            if(!board.Player1().Pieces[x][y] && !board.Player2().Pieces[x][y]) {
                board.Player2().setPiece(x,y,true);
                stones++;
                isBlackTurn = true;
                return true;
            }
        }
        return false;
    }
    protected boolean checkWin(){
        // returns true if a win or a draw
        int stones = 0;
        int w = board.getWidth();
        int h = board.getHeight();
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                if (board.Player2.pieceAt(x,y) || board.Player1.pieceAt(x,y)){
                    stones++;
                }
                //horizontal
                if (x < w-4){
                    if (board.Player2.pieceAt(x,y) && board.Player2.pieceAt(x+1,y) && board.Player2.pieceAt(x+2,y) && board.Player2.pieceAt(x+3,y) && board.Player2.pieceAt(x+4,y)){
                        return true;
                    }
                }
                //Vertical
                if (y < h-4){
                    if (board.Player2.pieceAt(x,y) && board.Player2.pieceAt(x,y+1) && board.Player2.pieceAt(x,y+2) && board.Player2.pieceAt(x,y+3) && board.Player2.pieceAt(x,y+4)){
                        return true;
                    }
                }
                //Slant Right
                if(x < w-4 && y < h-4){
                    if (board.Player2.pieceAt(x,y) && board.Player2.pieceAt(x+1,y+1) && board.Player2.pieceAt(x+2,y+2) && board.Player2.pieceAt(x+3,y+3) && board.Player2.pieceAt(x+4,y+4)){
                        return true;
                    }
                }
                //Slant Left
                if(x > 3 && y < h-4){
                    if (board.Player2.pieceAt(x,y) && board.Player2.pieceAt(x-1,y+1) && board.Player2.pieceAt(x-2,y+2) && board.Player2.pieceAt(x-3,y+3) && board.Player2.pieceAt(x-4,y+4)){
                        return true;
                    }
                }
                //horizontal Black
                if (x < w-4){
                    if (board.Player1.pieceAt(x,y) && board.Player1.pieceAt(x+1,y) && board.Player1.pieceAt(x+2,y) && board.Player1.pieceAt(x+3,y) && board.Player1.pieceAt(x+4,y)){
                        return true;
                    }
                }
                //Vertical Black
                if (y < h-4){
                    if (board.Player1.pieceAt(x,y) && board.Player1.pieceAt(x,y+1) && board.Player1.pieceAt(x,y+2) && board.Player1.pieceAt(x,y+3) && board.Player1.pieceAt(x,y+4)){
                        return true;
                    }
                }
                //Slant Right Black
                if(x < w-4 && y < h-4){
                    if (board.Player1.pieceAt(x,y) && board.Player1.pieceAt(x+1,y+1) && board.Player1.pieceAt(x+2,y+2) && board.Player1.pieceAt(x+3,y+3) && board.Player1.pieceAt(x+4,y+4)){
                        return true;
                    }
                }
                //Slant Left Black
                if(x > 3 && y < h-4){
                    if (board.Player1.pieceAt(x,y) && board.Player1.pieceAt(x-1,y+1) && board.Player1.pieceAt(x-2,y+2) && board.Player1.pieceAt(x-3,y+3) && board.Player1.pieceAt(x-4,y+4)){
                        return true;
                    }
                }
            }
        }
        if(stones == 225){
            return true;
        }
        return false;
    }
    // Returns winning stones locations
    protected boolean[][] highlightWinner(){
        int w = board.getWidth();
        int h = board.getHeight();
        boolean[][] winningStones = new boolean[w][h];
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                //horizontal
                if (x < w-4){
                    if (board.Player2.pieceAt(x,y) && board.Player2.pieceAt(x+1,y) && board.Player2.pieceAt(x+2,y) && board.Player2.pieceAt(x+3,y) && board.Player2.pieceAt(x+4,y)){
                        winningStones[x][y] = true;
                        winningStones[x+1][y] = true;
                        winningStones[x+2][y] = true;
                        winningStones[x+3][y] = true;
                        winningStones[x+4][y] = true;
                        return winningStones;
                    }
                }
                //Vertical
                if (y < h-4){
                    if (board.Player2.pieceAt(x,y) && board.Player2.pieceAt(x,y+1) && board.Player2.pieceAt(x,y+2) && board.Player2.pieceAt(x,y+3) && board.Player2.pieceAt(x,y+4)){
                        winningStones[x][y] = true;
                        winningStones[x][y+1] = true;
                        winningStones[x][y+2] = true;
                        winningStones[x][y+3] = true;
                        winningStones[x][y+4] = true;
                        return winningStones;
                    }
                }
                //Slant Right
                if(x < w-4 && y < h-4){
                    if (board.Player2.pieceAt(x,y) && board.Player2.pieceAt(x+1,y+1) && board.Player2.pieceAt(x+2,y+2) && board.Player2.pieceAt(x+3,y+3) && board.Player2.pieceAt(x+4,y+4)){
                        winningStones[x][y] = true;
                        winningStones[x+1][y+1] = true;
                        winningStones[x+2][y+2] = true;
                        winningStones[x+3][y+3] = true;
                        winningStones[x+4][y+4] = true;
                        return winningStones;
                    }
                }
                //Slant Left
                if(x > 3 && y < h-4){
                    if (board.Player2.pieceAt(x,y) && board.Player2.pieceAt(x-1,y+1) && board.Player2.pieceAt(x-2,y+2) && board.Player2.pieceAt(x-3,y+3) && board.Player2.pieceAt(x-4,y+4)){
                        winningStones[x][y] = true;
                        winningStones[x-1][y+1] = true;
                        winningStones[x-2][y+2] = true;
                        winningStones[x-3][y+3] = true;
                        winningStones[x-4][y+4] = true;
                        return winningStones;
                    }
                }
                //horizontal Black
                if (x < w-4){
                    if (board.Player1.pieceAt(x,y) && board.Player1.pieceAt(x+1,y) && board.Player1.pieceAt(x+2,y) && board.Player1.pieceAt(x+3,y) && board.Player1.pieceAt(x+4,y)){
                        winningStones[x][y] = true;
                        winningStones[x+1][y] = true;
                        winningStones[x+2][y] = true;
                        winningStones[x+3][y] = true;
                        winningStones[x+4][y] = true;
                        return winningStones;
                    }
                }
                //Vertical Black
                if (y < h-4){
                    if (board.Player1.pieceAt(x,y) && board.Player1.pieceAt(x,y+1) && board.Player1.pieceAt(x,y+2) && board.Player1.pieceAt(x,y+3) && board.Player1.pieceAt(x,y+4)){
                        winningStones[x][y] = true;
                        winningStones[x][y+1] = true;
                        winningStones[x][y+2] = true;
                        winningStones[x][y+3] = true;
                        winningStones[x][y+4] = true;
                        return winningStones;
                    }
                }
                //Slant Right Black
                if(x < w-4 && y < h-4){
                    if (board.Player1.pieceAt(x,y) && board.Player1.pieceAt(x+1,y+1) && board.Player1.pieceAt(x+2,y+2) && board.Player1.pieceAt(x+3,y+3) && board.Player1.pieceAt(x+4,y+4)){
                        winningStones[x][y] = true;
                        winningStones[x+1][y+1] = true;
                        winningStones[x+2][y+2] = true;
                        winningStones[x+3][y+3] = true;
                        winningStones[x+4][y+4] = true;
                        return winningStones;
                    }
                }
                //Slant Left Black
                if(x > 3 && y < h-4){
                    if (board.Player1.pieceAt(x,y) && board.Player1.pieceAt(x-1,y+1) && board.Player1.pieceAt(x-2,y+2) && board.Player1.pieceAt(x-3,y+3) && board.Player1.pieceAt(x-4,y+4)){
                        winningStones[x][y] = true;
                        winningStones[x-1][y+1] = true;
                        winningStones[x-2][y+2] = true;
                        winningStones[x-3][y+3] = true;
                        winningStones[x-4][y+4] = true;
                        return winningStones;
                    }
                }
            }
        }
        return winningStones;
    }
    protected int[] computerTurn(){
        // for every square on the board check if there is a winning move, returns the move
        int w = board.getWidth();
        int h = board.getHeight();
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++){
                if (!board.Player1.pieceAt(x,y) && !board.Player2.pieceAt(x,y)){
                    board.Player2.setPiece(x,y,true);
                    if (checkWin()){
                        board.Player2.setPiece(x,y,false);
                        placeStone(x,y);
                        int[] a = {x,y};
                        return a;
                    }
                    else{
                        board.Player2.setPiece(x,y,false);
                    }
                    board.Player1.setPiece(x,y,true);
                    if (checkWin()){
                        board.Player1.setPiece(x,y,false);
                        placeStone(x,y);
                        int[] a = {x,y};
                        return a;
                    }
                    else{
                        board.Player1.setPiece(x,y,false);
                    }
                }
            }
        }
        Random rand = new Random();
        int x = rand.nextInt(w);
        int y = rand.nextInt(h);
        while(board.Player1.pieceAt(x,y) || board.Player2.pieceAt(x,y)){
            x = rand.nextInt(w);
            y = rand.nextInt(h);
        }
        placeStone(x,y);
        int[] a = {x,y};
        return a;
    }
    protected boolean isTie(){
        // returns true if game is a draw
        int w = board.getWidth();
        int h = board.getHeight();
        return stones == w*h;
    }
    protected String cheat(){
        int w = board.getWidth();
        int h = board.getHeight();
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                if (!board.Player1.pieceAt(x,y) && !board.Player2.pieceAt(x,y)) {
                    board.Player2.setPiece(x,y,true);
                    if (checkWin()) {
                        board.Player2.setPiece(x,y,false);
                        return (x + " " + y);
                    } else {
                        board.Player2.setPiece(x,y,false);
                    }
                        board.Player1.setPiece(x,y,true);
                    if (checkWin()) {
                        board.Player1.setPiece(x,y,false);
                        //placeStone(x,y);
                        return (x + " " + y);
                    } else {
                        board.Player1.setPiece(x,y,false);
                    }
                }
            }
        }
        return "no wining move";
    }
    protected boolean isBlackTurn(){
        return isBlackTurn;
    }
    protected Board getBoard(){
        return board;
    }
}
