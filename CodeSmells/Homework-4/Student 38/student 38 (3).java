//Hello
//Computer player class is where the code for our AI strategy is contained
public class ComputerPlayer implements Player {
    private final Stone stone;
    public ComputerPlayer(Stone stone) {
        this.stone = stone;
    }
    /**
     * @return stone
     */
    @Override
    public Stone getStone() {
        return stone;
    }
    /**
     * @return computer name
     */
    @Override
    public String getName(){
        return "Computer";
    }
    /**
     * Selects spots on board for AI to place their stone based on strategy
     * takes score from evaluatePositon method to determine where would be
     * the best spot to place the computer stone
     * @param board used to determine where to place stone
     * @return bestMove which is where the computer AI will place their
     * stone depending on the score it receives from evaluatePosition
     */
    @Override
    public int[] makeMove(Board board) {
        int size = board.getSize();
        int[] bestMove = null;
        int bestScore = Integer.MIN_VALUE;
        // Check if any move will block the human player from winning
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.isValidMove(i, j)) {
                    board.placeStone(i, j, stone);
                    if (board.isWinningMove(i, j)) {
                        board.removeStone(i, j);
                        return new int[] {i, j};
                    }
                    board.removeStone(i, j);
                }
            }
        }
        // Otherwise,we will use this algorithm to find the best move instead of
        //random placement around the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.isValidMove(i, j)) {
                    int score = evaluatePosition(board, i, j, stone);
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = new int[] {i, j};
                    }
                }
            }
        }
        return bestMove;
    }

    /**
     * evaluatePosition is used by makeMove to determine where it would be best to
     * place a stone on the board
     * @param board used to determine where on board is best
     * @param row since we are going through the rows of board
     * @param col since we are going through the cols of board
     * @param currentStone the currentStone that is being used
     * @return score which is the int that is used to determine best place to place stone
     */
    private int evaluatePosition(Board board, int row, int col, Stone currentStone) {
        int score = 0;
        //opponentStone is used to hold the stone representation of opponent
        Stone opponentStone = currentStone.opposite();
        boolean blockOpponent = false;
        // Checks number of adjacent stones
        for (int i = Math.max(0, row - 1); i <= Math.min(row + 1, board.getSize() - 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(col + 1, board.getSize() - 1); j++) {
                if (board.getStone(i, j) != null) {
                    score += 1;
                }
            }
        }
        // Adds score for each position based on importance using score
        if (board.getStone(row, col) == currentStone) {
            score += 100;
        } else if (board.getStone(row, col) == opponentStone) {
            score -= 100;
        }
        // Check if move blocks the opponent from winning
        if (board.countStonesInARow(row, col, opponentStone) == 3) {
            // Check if opponent has stone adjacent to the row
            int[] adjacentRow = board.getAdjacentRow(row);
            int[] adjacentCol = board.getAdjacentCol(col);
            for (int i = 0; i < adjacentRow.length; i++) {
                if (board.getStone(adjacentRow[i], adjacentCol[i]) == null) {
                    score += 1000;
                    blockOpponent = true;
                    break;
                }
            }
            if (!blockOpponent) {
                // Check if the human has 3 stones in a row in any row or column in
                //order to stop human from getting an open 4 which would mean winning
                int[] adjacentRows = board.getAdjacentRow(row);
                int[] adjacentCols = board.getAdjacentCol(col);
                for (int i = 0; i < adjacentRows.length; i++) {
                    if (board.countStonesInARow(adjacentRows[i], adjacentCols[i], opponentStone) == 3) {
                        // Check move blocks opponent from completing line in that row or column
                        if ((row == adjacentRows[i] && board.countStonesInARow(row, col, opponentStone) < 3) ||
                                (col == adjacentCols[i] && board.countStonesInARow(row, col, opponentStone) < 3)) {
                            score += 1000;
                            break;
                        }
                    }
                }
            }
        }
        return score;
    }
}