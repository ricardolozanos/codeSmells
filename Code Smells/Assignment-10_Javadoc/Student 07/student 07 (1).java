import java.util.Scanner;

/**
 * ConsoleUI displays data in console.
 *
 * @author braul
 * @version 1.0
 * @see Controller
 */
public class ConsoleUI {
    private Scanner in;
    public Board board;
    public static final int ComputerGame = 1;
    public static final int HumanGame = 2;
    public static int x=0;
    public static int y=0;

    /**
     * Constructor for ConsoleUI
     * @param board
     */
    public ConsoleUI(Board board){
        in = new Scanner(System.in);
        this.board =board;
    }

    /**
     * Prints the String received onto the console
     * @param msg
     */
    public void showMessage(String msg){
        System.out.println(msg);
    }//this is used to show messages throughout code

    /**
     * Gets game type selection
     * @return
     */
    public int promptGameType() {
        for(;;) {//while true
            System.out.println("What game would you like to play? Computer Game : 1 / Human Game :2 ");
            var selectionGame = in.nextInt();
            switch (selectionGame) {
                case ComputerGame:
                    return ComputerGame;
                case HumanGame:
                    return HumanGame;
                default:
                    showMessage("invalid selection");
            }
        }
    }

    /**
     * Shows board for player
     * @param board
     */
    public void showBoard(Board board){
        board.makeBoard();
    }

    /**
     * requests for coordinates
     * @param activePlayer
     * @return
     */
    public String[] promptPlayer(Players activePlayer) {//get the possible coordinates for active player
        System.out.printf("%s select your y coordinate then your x coordinate on board.(Follow syntax, 2,3)  ", activePlayer.name());
        var locationPiece = in.next().split(",");//gets the answer and splits it with the coma and puts it into a list [0,0]
        in.nextLine();
        return locationPiece;//return the possible coordinates


    }

    /**
     * Checks the win type if existent
     * @param num
     * @param activePlayer
     */
    public void winMode(int num, Players activePlayer){//return the exact way you won
        if(num==1){
            System.out.printf("You won with a HORIZONTAL LINE! Congrats %s ",activePlayer.name());
        }else if(num==2){
            System.out.printf("You won with a VERTICAL LINE! Congrats %s ",activePlayer.name());
        }else if(num==3){
            System.out.printf("You won with a DIAGONAL LINE! Congrats %s ",activePlayer.name());
        }
    }

    /**
     * Shows board after every move
     * @param board
     * @param x
     * @param y
     * @param activePlayer
     */
    public void showMove(Board board,String x, String y, Players activePlayer) {//shows move by active player
        board.placeStone(x, y, activePlayer);
    }
}
