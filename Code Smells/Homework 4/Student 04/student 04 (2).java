
package HW4_GUI;

import HW4_GUI.console.Board;
import HW4_GUI.console.ComputerPlayer;
import HW4_GUI.console.Coordinate;
import HW4_GUI.console.HumanPlayer;
import HW4_GUI.console.Player;

public class BoardController {
    
    private Board board;
    private Player player1;
    private Player opponent;
    private Player currentPlayer;
    private BoardPanel boardPanel;

    public BoardController(BoardPanel boardPanel, Board board, int mode) {
        this.board = board;
        this.player1 = new HumanPlayer("Player1", 'X',null);
        if(mode == 1){
            this.opponent = new HumanPlayer("Player2", 'O',null);
        }else if (mode == 2){
            this.opponent = new ComputerPlayer("Computer", 'O');
        }
        this.currentPlayer = player1;
        this.boardPanel = boardPanel;
    }

    /**
     * Switches the current player
     */
    public void switchPlayer() {
        currentPlayer = currentPlayer == player1 ? opponent : player1;
    }

    /**
     * Checks if there is a winner
     * @param i  x coordinate
     * @param j  y coordinate
     * @param currentPlayer  current player
     */
    public void checkWinner(int i, int j, Player currentPlayer){
        if(board.hasWinner(i, j)){
            boardPanel.displayMessage(currentPlayer.getName() + " wins!", false);
        }
    }

    /**
     * Checks if there is a draw
     */
    public void checkDraw(){
        if(board.isFull()){
            boardPanel.displayMessage("Draw!", true);
        }
    }

    /**
     * Computer makes a move
     */
    public void computerMove(){
        Coordinate computerMove = getOpponent().pickPlace(board);
        board.makeMove(computerMove.getX(), computerMove.getY(), getOpponent().getSymbol());
        // boardPanel.repaint();
        checkDraw();
        switchPlayer();
    }

    /**
     * Human player Makes a move
     * @param i  x coordinate
     * @param j  y coordinate
     */
    public void makeMove(int i, int j) {
        board.makeMove(i, j, currentPlayer.getSymbol());
        // boardPanel.repaint();
        checkDraw();
        switchPlayer();
    }

    /**
     * Gets the current player
     * @return currentPlayer
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Sets the current player
     * @param currentPlayer
     */
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    
    /**
     * Gets the player1
     * @return player1
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Sets the player1
     * @param player1
     */
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    /**
     * Gets the opponent
     * @return opponent
     */
    public Player getOpponent() {
        return opponent;
    }

    /**
     * Sets the opponent
     * @param opponent
     */
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

}
