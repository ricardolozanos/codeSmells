import java.util.HashSet;
import java.util.Set;

public class Board {
    private int [][] board;
    private int board_size;
    public Board(){
        this.board_size = 15;
        this.board = new int[15][15];
    }

    public Board(int len){
        this.board_size = len;
        this.board = new int[board_size][board_size];
    }
    public void setBoard_size(int len){
        this.board_size = len;
    }
    public void clear(){
        this.board = new int[15][15];
    }
    public boolean placeStone(int x, int y, int player){
        if(this.board[y-1][x-1]!=0) return false;
        this.board[y-1][x-1]=player;
        return true;
    }
    public int[][] getBoard() {
        return board;
    }
    public int getSize(){
        return board_size;
    }
    public Set<int[]> getNeighbors(int x, int y){
        Set<int[]> neighbors = new HashSet<>();
        if(x>=1 && y>=1){
            neighbors.add(new int[]{y-1, x-1});
        }
        if(y>0) {
            neighbors.add(new int[]{y-1, x});
        }
        if(x<board_size-1 && y>0){
            neighbors.add(new int[]{y-1, x+1});
        }
        if(x>=1){
            neighbors.add(new int[]{y, x-1});
        }
        if(y<board_size-1 && x>0) {
            neighbors.add(new int[]{y + 1, x - 1});
        }
        if (x<board_size-1) {
            neighbors.add(new int[]{y, x + 1});
        }
        if (y<board_size-1) {
            neighbors.add(new int[]{y + 1, x});
        }
        if (x<board_size-1 && y<board_size-1) {
            neighbors.add(new int[]{y + 1, x + 1});
        }
        return neighbors;
    }
    public void replaceBoard(int[][] replacement){
        this.board = replacement;
    }
    public boolean isFull(){
        for(int i = 0; i<board_size; i++){
            for(int j = 0; j<board_size; j++){
                if(board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isEmpty(int x, int y) {
        return board[x-1][y-1] == 0;
    }
    public boolean isOccupied(int x, int y) {
        return board[x-1][y-1] != 0;
    }
    public boolean isOccupiedBy(int x, int y, int player) {
        return board[x-1][y-1] == player;
    }
    public int playerAt(int x, int y) {
        return board[x-1][y-1];
    }
    public void manualChange(int x, int y, int player){
        board[x][y] = player;
    }
    public boolean checkTie(){
        for(int i = 0; i<board_size; i++){
            for(int j = 0; j<board_size; j++){
                if(board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean gameStarted(){
        for(int i = 0; i<board_size; i++){
            for(int j = 0; j<board_size; j++){
                if(board[i][j] != 0){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isWonBy(Player player){
        boolean outcome = false;
        for (int i = 0; i < board_size; i++){
            for(int j = 0; j < board_size; j++){
                if (board[i][j] != 0){
                    outcome = winningRow(player);
                    if(outcome){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean winningRow(Player player){
        //horizontal
        for(int i=0; i<board_size; i++){
            int csqstones = 0;
            for(int j=0; j<board_size; j++){
                if(board[i][j] == player.pNum){
                    csqstones++;
                    if (csqstones == 5){
                        board = new int[board_size][board_size];
                        for(int k = 0; k < 5; k++){
                            board[i][j-k] = player.getpNum();
                        }
                        return true;
                    }
                }
                else {
                    csqstones = 0;
                }
            }
        }
        //vertical
        for(int i=0; i<board_size; i++){
            int csqstones = 0;
            for(int j=0; j<board_size; j++){
                if(board[j][i] == player.pNum){
                    csqstones++;
                    if (csqstones == 5){
                        board = new int[board_size][board_size];
                        for(int k = 0; k < 5; k++){
                            board[j-k][i] = player.getpNum();
                        }
                        return true;
                    }
                }
                else {
                    csqstones = 0;
                }
            }
        }
        //diagonal (/ top-down)
        for(int i = 0; i<board_size-4; i++){
            for(int j = 4; j<board_size; j++){
                int csqstones = 0;
                if(board[i][j] == player.pNum) {
                    for (int k = 0; k < 5; k++) {
                        if (board[i + k][j - k] == player.pNum) {
                            csqstones++;
                            if (csqstones == 5) {
                                board = new int[board_size][board_size];
                                for(int w = 0; w < 5; w++){
                                    board[i + k - w][j - k + w] = player.getpNum();
                                }
                                return true;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        //diagonal (\ top-down)
//        System.out.println("pnum = "+player.pNum);
        for(int i = 0; i<board_size-4; i++){
            for(int j = 0; j<board_size-4; j++){
                int csqstones = 0;
                if(board[i][j] == player.pNum){
                    for(int k = 0; k<5; k++) {
                        if (board[i + k][j + k] == player.pNum) {
//                            System.out.println("board coordinate " + (i + k) + " " + (j + k) + " board val " + board[i + k][j + k] + " pnum " + player.pNum);
                            csqstones++;
//                            System.out.println("csqstones = " + csqstones);
                            if (csqstones == 5) {
                                board = new int[board_size][board_size];
                                for(int w = 0; w < 5; w++){
                                    board[i + k - w][j + k - w] = player.getpNum();
                                }
                                return true;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }
    public void printBoard(){
        for(int i = 0; i<board_size; i++){
            for(int j = 0; j<board_size; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public void resetBoard(){
        board = new int[board_size][board_size];
    }
    public static class Place {
        public final int x;

        public final int y;

        /** Create a new place of the given indices.
         *
         * @param x 0-based column (vertical) index
         * @param y 0-based row (horizontal) index
         */
        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
