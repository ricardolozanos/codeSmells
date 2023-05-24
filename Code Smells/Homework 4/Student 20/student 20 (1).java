/**
 *
 * Board will store the stones of each player and
 * determine if there is a winner.
 * @author Estrella Lara
 * @since 02/23/2023
 */
public class Board {
    /**
     *
     * Stores the number of rows
     */
    private final int rows;
    /**
     *
     * Stores the number of columns
     */
    private final int cols;
    /**
     *
     * Stores the empty spaces and stones in a 2D array
     */
    private final Place[][] board;
    /**
     *
     * Creates a 2D array board with 15 rows and 15 columns.
     */
    public Board(){
        this.rows = 15;
        this.cols = 15;
        this.board = new Place[rows][cols];
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++) {
                board[j][i] = new Place(j,i);
            }
        }
    }
    public int getSize() {
        return  rows;
    }
    /**
     *
     * Places a stone in the board in the corresponding position and from a specific player
     * @param x-coordinate represents the column number
     * @param y-coordinate represents the row number
     * @param player will be used to determine the stone to be placed
     */
    public void addStone(int x, int y, Player player){
        board[y][x].setStone(player.getStone());

    }

    /**
     *
     * Will evaluate if the given move is valid
     * @param x-coordinate represents the column number
     * @param y-coordinate represents the row number
     * @return valid move (true or false)
     */
    public boolean validMove(int x, int y){
        if((y>rows-1)||(x>cols-1)){
            return false;
        }
        return board[y][x].getStone() == '-';
    }

    /***
     *
     * @return 0 if game is not over
     *         1 if there is a winner
     *         2 if board is full
     */
    public int gameOver(int lastX,int lastY, Player lastPlayer, Game game){
        if(this.winner(lastX,lastY,lastPlayer)!= null){
            //if there is a winner()
            game.setWinner(lastPlayer);
            return 1;
        }
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++) {
                System.out.println("stone:" + board[j][i].getStone());
                if(board[j][i].getStone() == '-'){
                    //if game is not over
                    return 0;
                }
            }
        }
        //if board full
        return 2;
    }
    public Player winner(int lastX,int lastY,Player lastPlayer){
        int i = 0;
        int k = 0;
        char[] charArray = new char[board[lastY].length];
        //Find horizontal winner
        for (Place x : board[lastY]) {
            if(k>4){
                return lastPlayer;
            }
            else if(board[lastY][i].getStone() != '-'){
                if(k>0){
                    if (charArray[k-1] == board[lastY][i].getStone()){
                        charArray[k] = board[lastY][i].getStone();
                        k+=1;}
                    else if(charArray[k-1] != board[lastY][i].getStone()){
                        charArray[0] = board[lastY][i].getStone();
                        k=1;
                    }
                }else{
                    charArray[k] = board[lastY][i].getStone();
                    k++;}
            }i++;
        }
        k=0;
        //Find vertical winner
        for(i = 0; i < board.length; i++){
//            System.out.println(k);
//            System.out.println("lastX: " +lastX);
//            System.out.println(board[i][lastX].getStone());
            if(k>4){
                return lastPlayer;
            }
            else if(board[i][lastX].getStone() != '-'){
                if(k>0){
                    if (charArray[k-1] == board[i][lastX].getStone()){
                        charArray[k] = board[i][lastX].getStone();
                        k+=1;}
                    else if(charArray[k-1] != board[i][lastX].getStone()){
                        charArray[0] = board[i][lastX].getStone();
                        k=1;
                    }
                }else{
                    System.out.println(board[i][lastX]);
                    charArray[k] = board[i][lastX].getStone();
                    System.out.println("current charArray: " + charArray[k]);
                    k++;}
            }
        }
//        i = 0;
//        int j = 0;
//        k = 0;
//        int row = board.length;
//        int col = board[0].length;
//        //Diagonal winner
//        while(row > i && col >j){
//            while(row> 0 && col<j-1){
//                charArray[k++]=board[row][col].getStone();
//                col++;
//                row--;
//            }
//            charArray[k++] = board[row][col].getStone();
//        }

        //if no winner
        return null;
    }
}