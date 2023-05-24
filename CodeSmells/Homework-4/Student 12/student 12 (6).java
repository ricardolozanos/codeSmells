/**
 * A player in an Omok game. that can return recommended moves
 */
public class ComputerPlayer extends HumanPlayer{

    public ComputerPlayer(String name, int id) {
        super(name, id);
    }

    @Override
    /**
     * States that the current player is the computer
     * @return boolean current player is computer
     */
    public boolean isComputer(){
        return true;
    }

    @Override
    /**
     * Gets computer's next move
     * @param board current board to analyze the best move for the computer
     * @return int list [%,%], containing computer'smove
     */
    public int[] getNextMove(Player[][] board) {
        int n = board.length;
        int[] begginerMove = {-1,-1};//begginer moves place 2 pieces in a row 
        int[] okayMove = {-1,-1};//okay moves place 3 pieces in a row
        int[] goodMove = {-1,-1};//good moves place 4 pieces in a row
        int[] bestMove ={-1,-1};//best moves are moves that let you place 5 pieces in a row or stop player from placing 5 pieces RETURNED IMEDIATELY
        // Check if there are any "3 in a row" patterns and add a stone to complete the pattern
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == null) {
                    // ----------------------------------------- Check horizontal ------------------------------------------------
                    //Left
                    if (j < n - 2 && board[i][j + 1] == this ) {
                        begginerMove[0] = i;
                        begginerMove[1] = j;
                    }
                    if (j < n - 2 && board[i][j + 1] == this && board[i][j + 2] == this) {
                        okayMove[0] = i;
                        okayMove[1] = j;
                    }
                    if (j < n - 3 && board[i][j + 1] == this && board[i][j + 2] == this && board[i][j + 3] == this) {
                        goodMove[0] = i;
                        goodMove[1] = j;

                    }
                    if (j < n - 4 && board[i][j + 1] != null && board[i][j + 2] == board[i][j + 1] && board[i][j + 3] ==  board[i][j + 1] && board[i][j + 4] ==  board[i][j + 1]) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        return bestMove;
                    }
                    // ----------------------------------------- Check Vertical ------------------------------------------------
                    // Check vertical
                    if (i < n - 2 && board[i + 1][j] == this) {
                        begginerMove[0] = i;
                        begginerMove[1] = j;
                    }
                    if (i < n - 2 && board[i + 1][j] == this && board[i + 2][j] == this) {
                        okayMove[0] = i;
                        okayMove[1] = j;
                    }
                    if (i < n - 3 && board[i + 1][j] == this && board[i + 2][j] == this && board[i + 3][j] == this) {
                        goodMove[0] = i;
                        goodMove[1] = j;
                    }
                    if (i < n - 4 && board[i + 1][j] != null && board[i + 2][j] == board[i + 1][j] && board[i + 3][j] == board[i + 1][j] && board[i + 4][j] == board[i + 1][j]) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        return bestMove;
                    }
                    // Check diagonal left-right
                    if (i < n - 2 && j < n - 2 && board[i + 1][j + 1] == this) {
                        begginerMove[0] = i;
                        begginerMove[1] = j;
                    }
                    if (i < n - 2 && j < n - 2 && board[i + 1][j + 1] == this && board[i + 2][j + 2] == this) {
                        okayMove[0] = i;
                        okayMove[1] = j;
                    }
                    if (i < n - 3 && j < n - 3 && board[i + 1][j + 1] == this && board[i + 2][j + 2] == this && board[i + 3][j + 3] == this) {
                        goodMove[0] = i;
                        goodMove[1] = j;
                    }
                    if (i < n - 4 && j < n - 4 && board[i + 1][j + 1] != null && board[i + 2][j + 2] == board[i + 1][j + 1] && board[i + 3][j + 3] == board[i + 1][j + 1] && board[i + 4][j + 4] == board[i + 1][j + 1]) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        return bestMove;
                    }
                    // Check diagonal right-left
                    if (i < n - 2 && j > 1 && board[i + 1][j - 1] == this) {
                        begginerMove[0] = i;
                        begginerMove[1] = j;
                    }
                    if (i < n - 2 && j > 1 && board[i + 1][j - 1] == this && board[i + 2][j - 2] == this) {
                        okayMove[0] = i;
                        okayMove[1] = j;
                    }
                    if (i < n - 3 && j > 2 && board[i + 1][j - 1] == this && board[i + 2][j - 2] == this && board[i + 3][j - 3] == this) {
                        goodMove[0] = i;
                        goodMove[1] = j;
                    }
                    if (i < n - 4 && j > 3 && board[i + 1][j - 1] != null && board[i + 2][j - 2] == board[i + 1][j - 1] && board[i + 3][j - 3] == board[i + 1][j - 1] && board[i + 4][j - 4] == board[i + 1][j - 1]) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        return bestMove;
                    }
                }
            }
        }
        //robot will now look at its best move options to its worst and chose the better option
        if(goodMove[0] != -1){
            return goodMove;
        }else if(okayMove[0] != -1){
            return okayMove;
        }else if(begginerMove[0] != -1){
            return begginerMove;
        }
        //robot hasnt placed first piece so place it now towards the middle
        int[] firstMove = {n/2, n/2 };
        if(board[n/2][n/2] == this){
            return firstMove;
        }
        firstMove[0] =  (n/2)+1;
        firstMove[1] =  (n/2)+1;
        return firstMove;
    }

    
}
