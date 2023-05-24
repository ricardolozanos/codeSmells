package omokThings;

import java.awt.*;
import java.util.Random;

public class Game{

    //NEW
    MyMouseListener newHandler = new MyMouseListener();

    static int boardSize = 15; // change to get actual board size!!!!

    static char[][] boardArr = new char[boardSize][boardSize];

    static int[] aiPlacements = new int[2];
    int mouseClickCheck = 0;
    // new ------

    public void PVP(){
        Board.fillBoard(boardSize);
        Player player1 = new Player(Color.RED, "playerOne", 'X');
        Player player2 = new Player(Color.BLUE, "playerTwo", 'O');

        gameLoop(player1, player2, 0);


    }

    public void PVE(){
        Board.fillBoard(boardSize);
        Player player1 = new Player(Color.RED, "playerOne", 'X');
        Player player2 = new Player(Color.BLUE, "playerTwo", 'O');

        gameLoop(player1, player2, 1);
        // have loop for game and array things here basically whole game
    }

    public void gameLoop(Player playerNum, Player playerNum2, int gameMode){
        //Scanner scan = new Scanner(System.in);
        omok.mouseClickedReset();
        int quit = 0;
        int playerCount = 0;
        Player player = new Player(Color.RED, "playerOne", 'x');
        // have loop for game and array things here basically whole game
        while (quit != 99){

            if (playerCount == 0){
                player = new Player(Color.RED, "playerOne", 'x');
            }
            if(playerCount == 1){
                player = new Player(Color.BLUE, "playerTwo", 'O');

                if (gameMode == 1){   // for AI ------------------------------------------
                    player = new Player(Color.BLUE, "Computer", 'O');
                    Random random = new Random();
                    int randomX = random.nextInt(boardSize);
                    int randomY = random.nextInt(boardSize);


                    if (Board.ValidStone(randomX,randomY) == 0){
                        while( Board.ValidStone(randomX,randomY) != 1) {      // if valid spot then continue
                            randomX = random.nextInt(boardSize);
                            randomY = random.nextInt(boardSize);
                        }
                    }
                    aiPlacements[0] = randomX;
                    aiPlacements[1] = randomY;
                    omok.aiStones(aiPlacements);
                    Board.placeStone(player, randomX, randomY);
                    Board.printBoard(boardSize); //send this to omok -----

                    if (Board.winCheck(randomX, randomY, player.marker, boardSize) >= 5) {
                        String print6 = (player.name + " Has won the game");
                        omok.changeBottomTxt(print6);
                        break;
                    }
                    playerCount -= 1;
                    player = new Player(Color.RED, "playerOne", 'x');
                    System.out.print("HERE IN AI");

                }  // END OF AI PART --------------------------------------------------------
            }

            // ASKING FOR USE TO PLACE STONE!!!!! need to change so click sends both x and y -----------------------
            String print1 = (player.name + " Please Click Location");
            System.out.print("HERE IN ASK FOR CLICK");
            omok.changeBottomTxt(print1);
            // need to make a way to quit !!!!!!!!!!

            //newHandler.waitForClick(); NEW STUFFF
            omok.mouseWaiter();
            int[] clickArry = omok.ClickXandY();
            int stoneLocationX = clickArry[0];
            int stoneLocationY = clickArry[1];
            System.out.print("HERE IN AFTER ASK FOR CLICK");


            // mouse listener
            /*
            mouseClickCheck = omok.mouseClicked();
            System.out.print("HERE IN AFTER ASK FOR CLICK111111");
            while (mouseClickCheck != 1) {
                System.out.print("HERE IN WHILE LOOP1");
                clickArry = omok.ClickXandY();
                stoneLocationX = clickArry[0];
                stoneLocationY = clickArry[1];
            }
            System.out.print("HERE IN AFTER ASK FOR CLICK2222");
            mouseClickCheck = 0;
            omok.mouseClickedReset();
             */
            // --------------------------------------------------------------------------------------------------

            if (Board.ValidStone(stoneLocationX,stoneLocationY) == 0){
                while( Board.ValidStone(stoneLocationX,stoneLocationY) != 1) {      // if valid spot then continue
                    String print4 = (player.name + " please re-click correct space: ");
                    omok.changeBottomTxt(print4);

                    //new
                    //newHandler.waitForClick();
                    omok.mouseWaiter();
                    clickArry = omok.ClickXandY();
                    stoneLocationX = clickArry[0];
                    stoneLocationY = clickArry[1];

                    /*
                    mouseClickCheck = omok.mouseClicked();
                    while (mouseClickCheck != 1) {
                        clickArry = omok.ClickXandY();
                        stoneLocationX = clickArry[0];
                        stoneLocationY = clickArry[1];
                    }
                    mouseClickCheck = 0;
                    omok.mouseClickedReset();

                     */

                }
            }

            Board.placeStone(playerNum, stoneLocationX, stoneLocationY);
            Board.printBoard(boardSize); // send this to omok

            if (Board.winCheck(stoneLocationX, stoneLocationY, player.marker, boardSize) >= 5) {
                String print6 = ("Congrats!! " + player.name + " has won the game!");
                omok.changeBottomTxt(print6);
                break;
            }


            if (playerCount == 0){
                playerCount += 1;

            }
            else{
                playerCount -= 1;
            }
        }

    }

}


