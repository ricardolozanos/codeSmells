/**
 * The Game class represents a game of Omok. It includes the board, the mode, and
 * the players. It also includes the logic for checking if a player has won.
 */

package HomeWork2.OmokGame;
public class Game {
    /**
     * The ModeType enum represents the different modes that the game can be played
     * in.
     */
    ModeType Mode;

    /**
     * The PieceType enum represents the different types of pieces that can be
     * placed on the board.
     */

    PieceType[][] Board;
    //create computerAI object

    /**
     * Constructor for the Game class. It asks the user for the mode and size of
     * the board, and then initializes the board. It then calls the appropriate
     * method to initialize the game depending on the mode chosen.
     */

    public Game() { // version reverted
        Mode = ConsoleUI.AskMode();
        int size = ConsoleUI.AskSize();
        ConsoleUI.Scanner.nextLine();
        Board = new PieceType[size][size];
        ConsoleUI.Draw(Board);
        //if the mode is player init player gamemode
        if (Mode == ModeType.Player) {
            initGamePlayer();
        }
        //if the mode is computer init computer gamemode
        if (Mode == ModeType.Computer) {
            initGameComputer();
        }
    }

    

    /**
     * Initializes the game in player mode. It asks the user for a move, and then
     * checks if the player has won. If the player has not won, it switches to the
     * other player and repeats the process.
     */
    private void initGamePlayer() {
        Game.PieceType currentPlayer = Game.PieceType.X;
        while (true) {
            ConsoleUI.AskMove(this, currentPlayer == Game.PieceType.X ? 0 : 1);
            ConsoleUI.Draw(Board);
            if (checkWin(this, currentPlayer)) {
                System.out.println(currentPlayer + " wins!");
                break;
            }
            currentPlayer = currentPlayer == Game.PieceType.X ? Game.PieceType.O : Game.PieceType.X;
        }
    }


    /**
     * Initializes the game in computer mode. It asks the user for a move, and then
     * checks if the player has won. If the player has not won, it makes a move for
     * the computer and checks if the computer has won. If the computer has not
     * won, it switches to the other player and repeats the process.
     */
    private void initGameComputer() {
        ComputerAI computer = new ComputerAI(Game.PieceType.X, Game.PieceType.O);
        while (true) {
            int i = 0;
            ConsoleUI.AskMove(this, i);
            ConsoleUI.Draw(Board);
            //make computer move
            computer.makeMove(this);
            ConsoleUI.Draw(Board);
            //check to see if player or computer wins
            if (checkWin(this, Game.PieceType.X)) {
                System.out.println("Player wins!");
                break;
            }
            if (checkWin(this, Game.PieceType.O)) {
                System.out.println("Computer wins!");
                break;
            }
    }
}

    /**
     * Checks if a player has won the game by connecting 5 PieceTypes in any given direction, but it must be 
     * consecutive.
     * @param game the current game object
     * @param pieceType the piece type of the player to check for win
     * @return true if the player has won, false otherwise
     */
    private static boolean checkWin(Game game, Game.PieceType pieceType) {
        int size = game.Board.length;
        // Check horizontal and vertical
        for (int i = 0; i < size; i++) {
            int countH = 0;
            int countV = 0;
            for (int j = 0; j < size; j++) {
                if (game.Board[i][j] == pieceType) {
                    countH++;
                } else {
                    countH = 0;
                }
                if (game.Board[j][i] == pieceType) {
                    countV++;
                } else {
                    countV = 0;
                }
                if (countH == 5 || countV == 5) {
                    return true;
                }
            }
        }
    
        // Check diagonals
        for (int i = 0; i < size; i++) {
            // Check left diagonal
            int countLD = 0;
            int row = i;
            int col = 0;
            while (row < size && col < size) {
                if (game.Board[row][col] == pieceType) {
                    countLD++;
                } else {
                    countLD = 0;
                }
                if (countLD == 5) {
                    return true;
                }
                row++;
                col++;
            }
    
            // Check right diagonal
            int countRD = 0;
            row = i;
            col = 0;
            while (row >= 0 && col < size) {
                if (game.Board[row][col] == pieceType) {
                    countRD++;
                } else {
                    countRD = 0;
                }
                if (countRD == 5) {
                    return true;
                }
                row--;
                col++;
            }
    
            // Check left diagonal (bottom half)
            countLD = 0;
            row = 0;
            col = i;
            while (row < size && col < size) {
                if (game.Board[row][col] == pieceType) {
                    countLD++;
                } else {
                    countLD = 0;
                }
                if (countLD == 5) {
                    return true;
                }
                row++;
                col++;
            }
    
            // Check right diagonal (bottom half)
            countRD = 0;
            row = size - 1;
            col = i;
            while (row >= 0 && col < size) {
                if (game.Board[row][col] == pieceType) {
                    countRD++;
                } else {
                    countRD = 0;
                }
                if (countRD == 5) {
                    return true;
                }
                row--;
                col++;
            }
        }
    
        return false;
    }
    
    /**
     * The ModeType enum represents the mode of the game. It can be either player
     * mode or computer mode.
     */
    public enum ModeType { Player, Computer }

    /**
     * The PieceType enum represents the type of piece on the board. It can be
     * either X, O, or None.
     */

    public enum PieceType { None, X, O }
}