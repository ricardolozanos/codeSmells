import java.awt.*;

/**
 * Controller will call consoleUI and game methods when necessary.
 * @author Estrella Lara
 * @since 02/23/2023
 */
public class Controller {
    /**
     * Will take inputs from the standard input
     * (System.in) and display all output to the standard output (System.out)
     */
    private OmokGUI omokGUI;
    /**
     * Will tell which player goes next on the game. It will have 2 different game modes, computer and human.
     */
    private final Game game;
    private int gameOver;
    private int gameMode;
    private Point currentMove;

    // create a new game
    // if game over
    // ask consoleUI to announce the winner
    //      if computer wins ""
    public Controller(){
        omokGUI = new OmokGUI();
        game = new Game();
        game.setBoard(omokGUI.board);
        gameOver = 0;
        gameMode = 0;
    }
    public void start(){
        omokGUI.welcome();//welcome and instructions
        int i = 0;
        while(gameMode == 0){
            this.setGameMode(omokGUI.gameModeInt);
            game.setGameMode(gameMode);
        }

        int x = 0;
        int y = 0;
        while(gameOver == 0) {
            i = 0;
            if(gameMode == 1) {//For game mode human vs human
                omokGUI.boardPanel.enableMouse = true;
                do{
                    if (i != 0) { //if the move is invalid
                        omokGUI.invalidMove();
                    }
                    //Ask for next move, draw it in the panel and add it to the board
                    while(omokGUI.boardPanel.clickPoint == null) {
                        omokGUI.nextMove(game.getTurn());
                    }
                    x = (int)omokGUI.boardPanel.clickPoint.getX();
                    y = (int)omokGUI.boardPanel.clickPoint.getY();
                    game.setLastChar(game.getTurn().getStone());
                    i++;
                }while(!omokGUI.board.validMove(x,y));
            }
            else{//For game mode human vs computer
                //Human turn
                if(game.getTurn().getPlayerName().equals("player1")){
                    omokGUI.boardPanel.enableMouse = true;
                    while(omokGUI.boardPanel.clickPoint == null) {
                        omokGUI.nextMove(game.getTurn());
                    }
                    do{
                        if (i != 0) {
                            omokGUI.invalidMove();
                        }
                        x = (int)omokGUI.boardPanel.clickPoint.getX();
                        y = (int)omokGUI.boardPanel.clickPoint.getY();
                        game.setLastChar(game.getTurn().getStone());
                        i++;
                    }while(!omokGUI.board.validMove(x,y));
                }
                else {
                //Computer turn
                    omokGUI.boardPanel.enableMouse = false;
                    do {
                        x = game.getNextX();
                        y = game.getNextY();
                        game.setLastChar(game.getTurn().getStone());
                    } while (!omokGUI.board.validMove(x,y));
                }
            }
            //omokGUI. draw stone
            game.getBoard().addStone(x,y,game.getTurnAndUpdate());
            game.setLastX(x);
            game.setLastY(y);
            gameOver = game.getBoard().gameOver(game.getLastX(),game.getLastY(),game.getNextPlayerInTurn(),game);
            omokGUI.repaint();
            System.out.println("gameOver: " + gameOver);
            //game over?
        }
        omokGUI.gameOver(game.getWinner());
    }
    public void setGameMode(int gameM){
        gameMode = gameM;
    }
}
