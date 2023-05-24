import java.awt.*;
import java.util.Random;

/**
 * Game will determinate the next player in turn depending on the game mode
 * @author Estrella Lara
 * @since 02/27/2023
 */

public class Game {
    /**
     * Board will store the stones of each player and
     * determine if there is a winner.
     */
    private Board board;
    /***
     * Represents the player in turn
     */
    private Player playerInTurn;
    /***
     * Represents the next player in turn
     */
    private Player nextPlayerInTurn;
    private Player winner;
    /***
     * Stores the game mode
     */
    private int gameMode;
    private int lastX;
    private int lastY;
    private char lastStone;
    /***
     * Computer generated next x move
     */
    private int nextX;
    /***
     * Computer generated next y move
     */
    private int nextY;
    //two modes, mode will be a parameter
    //if human game, loop around:
    // ask console UI to get user move
    // addStone(Place,Player) with move the that we just got
    // see if there is a winner
    //      if there is a winner
    /**
     * Default constructor of Game
     */
    public Game(){
//        this.board = board;
        this.playerInTurn = new Player('x',"player1", Color.white);
        this.nextPlayerInTurn = new Player('o',"player2", Color.BLACK);
        this.nextX = 0;
        this.nextY = 0;
        this.winner = new Player('-', "nobody");
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Sets the current game mode
     */
    public void setGameMode(int gameMode){
        this.gameMode = gameMode;
    }
    /**
     * @return board
     */
    public Board getBoard(){
        return board;
    }
    /**
     * @return playerInTurn
     */
    public Player getTurn(){
        return playerInTurn;
    }
    public Player getTurnAndUpdate(){
        Player tempPlayer = playerInTurn;
        this.playerInTurn = nextPlayerInTurn;
        this.nextPlayerInTurn = tempPlayer;
        return tempPlayer;
    }

    public void setLastX(int lastX) {
        this.lastX = lastX;
    }
    public void setLastY(int lastY){
        this.lastY = lastY;
    }
    public void setLastChar(char lastStone){
        this.lastStone = lastStone;
    }
    public void setWinner(Player winner){
        this.winner = winner;
    }
    public int getLastX() {
        return lastX;
    }
    public int getLastY() {
        return lastY;
    }

    public Player getNextPlayerInTurn() {
        return nextPlayerInTurn;
    }
    public Player getWinner(){
        return winner;
    }
    public int getNextX(){
        Random random = new Random();
        return random.nextInt(board.getSize()) + 1;
    }
    public int getNextY(){
        Random random = new Random();
        return random.nextInt(board.getSize()) + 1;
    }

}
