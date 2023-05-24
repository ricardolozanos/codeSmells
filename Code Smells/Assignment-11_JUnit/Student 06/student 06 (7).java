import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Board {
    private int [][] board;
    private int board_size;

    public Board(int len){
        this.board_size = len;
        this.board = new int[board_size][board_size];
    }
    public void setBoard_size(int len){
        this.board_size = len;
    }
    public boolean placeStone(int x, int y, int player){
//        if (x > board_size-1 || y > board_size-1 || x < 0 || y < 0){
//            return false;
//        }
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
//        int [][] board = this.board;
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
    public void manualChange(int x, int y, int z){
        board[x][y] = z;
    }

    public boolean isGameWon(Player player){
        boolean outcome = false;
        for (int i = 0; i < board_size; i++){
            for(int j = 0; j < board_size; j++){
                if (board[i][j] != 0){
                    outcome = check5(player);
                    if(outcome){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean check5(Player player){
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

}
