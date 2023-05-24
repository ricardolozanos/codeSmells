package HomeWork2.OmokGame;

/**
 * The ComputerAI class that shows off the thinking of the computer,
 * it primarily detects for any kind of winning or losing consecutive move
 * in order to try to prevent the player from winning
 * */
public class ComputerAI {
    /**
     * aiPiece represent the PieceType of the computer
     * */
    private Game.PieceType aiPiece;
    /**
     * playerPiece represents the PieceType of the player
     * */
    private Game.PieceType playerPiece;

    //we can add different modes to the AI later
    /**
     * Constructor for the ComputerAI class, takes in PieceTypes and
     * separates them by the player and the computer
     * @param playerPiece sets PieceType to playerPiece
     * @param aiPiece sets PieceType to aiPiece
     * */
    public ComputerAI(Game.PieceType playerPiece, Game.PieceType aiPiece) {
        this.aiPiece = aiPiece;
        this.playerPiece = playerPiece;
    }

    /**
     * Method that causes the AI to search for consecutive possible wins
     * @param game takes in current game
     * */
    public void makeMove(Game game){
        //detect a winning/losing row by any consecutive move of the player and make move at end of row
        detectRow(game);
        //detect a winning/losing column by any consecutive move of the player and make move at end of column
        detectColumn(game);
        //detect a winning/losing diagonal by any consecutive move of the player and make move at end or beginning of diagonal
        detectDiagonal(game);

    }

    //detect a winning/losing row by any consecutive move of the player and make move at end of row
    /**
     * Method that searches throughout the board to detect any winning or losing
     * row set by the player, and proceeds to make a move at the end of said row
     * @param game takes in current game
     * */
    public void detectRow(Game game){
        int size = game.Board.length;
        //traverse the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //if the current piece is the player's piece
                if (game.Board[i][j] == playerPiece) {
                    //check if there are 2 consecutive player's piece in the row
                    if (j + 1 < size && game.Board[i][j + 1] == playerPiece) {
                        //if there are 2 consecutive player's piece in the row, check if there is an empty space at the end of the row
                        if (j + 2 < size && game.Board[i][j + 2] == null) {
                            //if there is an empty space at the end of the row, make the move
                            game.Board[i][j + 2] = aiPiece;
                            return;
                        }
                        //if there is no empty space at the end of the row, check if there is an empty space at the beginning of the row
                        else if (j - 1 >= 0 && game.Board[i][j - 1] == null) {
                            //if there is an empty space at the beginning of the row, make the move
                            game.Board[i][j - 1] = aiPiece;
                            return;
                        }
                }
            }

        }
    }
}

    //detect a winning/losing column by any consecutive move of the player and make move at end of column
    /**
     * Method that searches throughout the board for any kind of consecutive columns set by the player, then
     * proceeds to make a move at the end of the column
     * @param game takes in current game
     * */
    public void detectColumn(Game game){
        int size = game.Board.length;
        //traverse the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //if the current piece is the player's piece
                if (game.Board[i][j] == playerPiece) {
                    //check if there are 2 consecutive player's piece in the column
                    if (i + 1 < size && game.Board[i + 1][j] == playerPiece) {
                        //if there are 2 consecutive player's piece in the column, check if there is an empty space at the end of the column
                        if (i + 2 < size && game.Board[i + 2][j] == null) {
                            //if there is an empty space at the end of the column, make the move
                            game.Board[i + 2][j] = aiPiece;
                            return;
                        }
                        //if there is no empty space at the end of the column, check if there is an empty space at the beginning of the column
                        else if (i - 1 >= 0 && game.Board[i - 1][j] == null) {
                            //if there is an empty space at the beginning of the column, make the move
                            game.Board[i - 1][j] = aiPiece;
                            return;
                        }
                    }
                }
            }
        }
    }


    //detect a winning/losing diagonal by any consecutive move of the player and make move at end or beginning of diagonal
    /**
     * Method that continues to check the board for any kind of consecutive diagonal set by the player, and commences to make
     * a move at the end of the diagonal
     * @param game take in current game state
     * */
    public void detectDiagonal(Game game){
        int size = game.Board.length;
        //traverse the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //if the current piece is the player's piece
                if (game.Board[i][j] == playerPiece) {
                    //check if there are 2 consecutive player's piece in the diagonal
                    if (i + 1 < size && j + 1 < size && game.Board[i + 1][j + 1] == playerPiece) {
                        //if there are 2 consecutive player's piece in the diagonal, check if there is an empty space at the end of the diagonal
                        if (i + 2 < size && j + 2 < size && game.Board[i + 2][j + 2] == null) {
                            //if there is an empty space at the end of the diagonal, make the move
                            game.Board[i + 2][j + 2] = aiPiece;
                            return;
                        }
                        //if there is no empty space at the end of the diagonal, check if there is an empty space at the beginning of the diagonal
                        else if (i - 1 >= 0 && j - 1 >= 0 && game.Board[i - 1][j - 1] == null) {
                            //if there is an empty space at the beginning of the diagonal, make the move
                            game.Board[i - 1][j - 1] = aiPiece;
                            return;
                        }
                    }
                }
            }
        }
    }
}
