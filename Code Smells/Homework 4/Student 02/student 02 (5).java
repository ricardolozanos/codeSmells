package OmokConsole.UI;

import OmokConsole.Model.COMGame;
import OmokConsole.Model.Game;
import OmokConsole.Model.PVPGame;


public class Controller {
    public ConsoleUI test;
    public Game testGame;
    public GUI testGUI;

    public Controller() {
        this.test = new ConsoleUI();
    }


    public void run() {
        testGUI = new GUI();
        while (!testGUI.isGameModeSelected()) {

            System.out.print("");
            //waiting for selection
        }
        if (testGUI.getGameMode().equals("Computer")) {
            //test.printMessage("Starting Player vs Computer game!");
            testGame = new COMGame();
            while (!testGame.getWinCon() && !testGame.getTieCon()) {
                //test.printBoard(testGame.getBoard());
                //test.printMessage("Player 1 enter your turn! Enter your row then enter your column");
                testGUI.setCurrPlayer("Black");
                while (!testGUI.testBoardPanel.isMoveMade()) {
                    System.out.print("");
                }
                testGame.playerTurn(testGUI.testBoardPanel.getXMove(), testGUI.testBoardPanel.getYMove());
                testGUI.setCurrPlayer("White");
                while (!testGUI.testBoardPanel.isMoveMade()) {
                    System.out.print("");
                }
                testGame.comTurn();
                testGUI.testBoardPanel.paintPieceCom(testGame.getBoard());


            }
            if (testGame.getWinCon()) {
                if (testGame.getCurrPlayer() == testGame.getPlayer1()) {
                    test.printBoard(testGame.getBoard());
                    test.printMessage("Congrats Player 1! You Win!");

                } else {
                    test.printBoard(testGame.getBoard());
                    test.printMessage("Com Wins! Better luck next time!");
                }
            }

        } else if (testGUI.getGameMode().equals("Human")) {
            //test.printMessage("Starting Player vs Player game!");
            testGame = new PVPGame();
            while (!testGame.getWinCon() && !testGame.getTieCon()) {
                //test.printBoard(testGame.getBoard());
                if (testGame.getCurrPlayer() == testGame.getPlayer1()) {
                    testGUI.setCurrPlayer("Black");
                    test.printMessage("Player 1 enter your turn! Enter your row then enter your column.");
                } else {
                    testGUI.setCurrPlayer("White");
                    test.printMessage("Player 2 enter your turn! Enter your row then enter your column.");
                }
                //test.printMessage("Or enter -1 to exit game.");
                //test.setXYFromSystemIn(testGame.getBoard());
                while (!testGUI.testBoardPanel.isMoveMade()) {
                    System.out.print("");
                }
                testGame.playerTurn(testGUI.testBoardPanel.getXMove(), testGUI.testBoardPanel.getYMove());
                testGUI.testBoardPanel.setMoveMade(false);
            }
            if (testGame.getWinCon()) {
                if (testGame.getCurrPlayer() == testGame.getPlayer1()) {
                    //test.printBoard(testGame.getBoard());
                    //test.printMessage("Congrats Player 1! You Win!");
                    testGUI.setWinner("Black");

                } else {
                    //test.printBoard(testGame.getBoard());
                    //test.printMessage("Congrats Player 2! You Win!");
                    testGUI.setWinner("White");
                }
            }
            if (testGame.getTieCon()) {
                test.printBoard(testGame.getBoard());
                test.printMessage("Game Over! It's a tie!");
            }
        }
    }
}
/*
ConsoleUI Controller code
public void run() {
        testBoardPanel = new BoardPanel();
        test.printMessage("Welcome to my Omok game!");
        while(test.getInput() != -1) {
            test.printMessage("Please enter '1' for Player vs Computer or enter '2' for Player vs Player.");
            test.printMessage("Or enter -1 to exit game.");
            test.setInputFromSystemIn();
            if (test.getInput() == 1){
                test.printMessage("Starting Player vs Computer game!");
                testGame = new COMGame();
                while(!testGame.getWinCon()  && test.getInput() != -1 && !testGame.getTieCon()){
                    test.printBoard(testGame.getBoard());
                    test.printMessage("Player 1 enter your turn! Enter your row then enter your column");
                    test.setXYFromSystemIn(testGame.getBoard());
                    testGame.playerTurn(test.getX(), test.getY());
                    testGame.comTurn();

                }
                if (testGame.getWinCon()){
                    if (testGame.getCurrPlayer() == testGame.getPlayer1()){
                        test.printBoard(testGame.getBoard());
                        test.printMessage("Congrats Player 1! You Win!");

                    }
                    else {
                        test.printBoard(testGame.getBoard());
                        test.printMessage("Com Wins! Better luck next time!");
                    }
                }

            }
            else if(test.getInput() == 2){
                test.printMessage("Starting Player vs Player game!");
                testGame = new PVPGame();
                while(!testGame.getWinCon()  && test.getInput() != -1  && !testGame.getTieCon()){
                    test.printBoard(testGame.getBoard());
                    if (testGame.getCurrPlayer() == testGame.getPlayer1()){
                        test.printMessage("Player 1 enter your turn! Enter your row then enter your column.");
                    }
                    else {
                        test.printMessage("Player 2 enter your turn! Enter your row then enter your column.");
                    }
                    test.printMessage("Or enter -1 to exit game.");
                    test.setXYFromSystemIn(testGame.getBoard());
                    testGame.playerTurn(test.getX(), test.getY());
                }
                if (testGame.getWinCon()){
                    if (testGame.getCurrPlayer() == testGame.getPlayer1()){
                        test.printBoard(testGame.getBoard());
                        test.printMessage("Congrats Player 1! You Win!");

                    }
                    else {
                        test.printBoard(testGame.getBoard());
                        test.printMessage("Congrats Player 2! You Win!");
                    }
                }
                if (testGame.getTieCon()) {
                    test.printBoard(testGame.getBoard());
                    test.printMessage("Game Over! It's a tie!");
                }
            }
            else{
                test.printMessage("Input not recognized. Try again.");
            }
            if(test.getInput() == -1){
                test.printMessage("Ending game, Goodbye!");
            }

        }

    }
 */
