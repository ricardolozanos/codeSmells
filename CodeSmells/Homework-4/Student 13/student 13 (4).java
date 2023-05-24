import java.awt.event.MouseEvent;

public class GameController {
    boolean secret = false;
    Board board = new Board();
    Playable player1;
    Playable player2;
    UserInterfaceable UI;
    boolean turnTracker = true;
    public GameController(UserInterfaceable ui){
        UI = ui;
    }

    /**
     * Will start the Omok game Lifecycle
     */
    public void start(){
        board = new Board();
        int gameMode = UI.getGameMode();
        switch(gameMode){
            case 1:
                startPvP();
                break;
            case 2:
                startStrategy();
                break;
            case 3:
                break;
            case -9:
                secret = true;
                start();
                break;
            default:
                throw new IllegalArgumentException("GameMode cannot be " + gameMode);
        }
    }
    private void startPvP(){
        player1 = new LocalPlayer(UI, UI.getPlayerName(1), 1);
        player2 = new LocalPlayer(UI, UI.getPlayerName(2), 2);
        pvpLoop();
    }
    private void pvpLoop(){
        if ((int) Math.random() * 2 >= 1){
            turnTracker = true;
        }
        else{
            turnTracker = false;
        }
        int victorNum = 0;
        while(victorNum == 0){
            if(turnTracker){
                placeStone(player1);
                if(board.checkWin(1)){
                    victorNum = 1;
                }
                turnTracker = !turnTracker;
            }
            else{
                placeStone(player2);
                if(board.checkWin(2)){
                    victorNum = 2;
                }
                turnTracker = !turnTracker;
            }
        }
        if (victorNum == 1) {
            UI.drawVictoryScreen(player1.getPlayerName());
            start();
        }
        else{
            UI.drawVictoryScreen(player2.getPlayerName());
            start();
        }
    }
    private void placeStone(Playable player){
        int[] toPlace;
        UI.drawBoard(board.getBoard());
        if (!(player instanceof ComputerPlayer) && secret){
            int[] omokhack = new ComputerPlayer(player.getPlayerNum(), UI).getStonePlacement(board.getBoard());
            UI.displayString("OMOKFISH would play " + (omokhack[0] + 1) + ", " + (omokhack[1] + 1) + " here");
        }
        toPlace = player.getStonePlacement(board.getBoard());
        while(!board.placeStone(toPlace[0], toPlace[1], player.getPlayerNum())){
            UI.drawBoard(board.getBoard());
            UI.displayString("Please enter a valid coordinate for your stone");
            toPlace = player.getStonePlacement(board.getBoard());
        }
    }
    private void startStrategy(){
        player1 = new LocalPlayer(UI, UI.getPlayerName(1), 1);
        player2 = new ComputerPlayer(2, UI);
        strategyLoop();
    }

    private void strategyLoop(){
        if ((int) Math.random() * 2 >= 1){
            turnTracker = true;
        }
        else{
            turnTracker = false;
        }
        int victorNum = 0;
        while(victorNum == 0){
            if(turnTracker){
                placeStone(player1);
                if(board.checkWin(1)){
                    victorNum = 1;
                }
            }
            else{
                placeStone(player2);
                if(board.checkWin(2)){
                    victorNum = 2;
                }
            }
            turnTracker = !turnTracker;
        }
        UI.drawBoard(board.getBoard());
        if (victorNum == 1) {
            UI.drawVictoryScreen(player1.getPlayerName());
        }
        else{
            UI.drawDefeatScreen();
        }
        start();
    }
    public void startGUI(){
        board = new Board(19,19);
        turnTracker = true;
        UI.drawBoard(board.getBoard());
    }
    public void placeStone(MouseEvent e){
        int[] toPlace = new int[2];
        if (turnTracker){
            toPlace[1] = (e.getX()-27)/18 + ((((e.getX()-27)/9)%2 == 1) ? 1 : 0);
            toPlace[0] = e.getY()/18 + (((e.getY()/9)%2 == 1) ? 1 : 0);
            if (!board.placeStone(toPlace[0]+1, toPlace[1]+1, 1)){
                return;
            }
            UI.drawBoard(board.getBoard());
            if (board.checkWin(1)){
                UI.drawVictoryScreen("Player1");
            }
            else{
                if (UI.getGameMode() == 1) {
                    turnTracker = !turnTracker;
                    UI.getStonePlacement("Player2");
                }
                else{
                    var fish = new ComputerPlayer(2, UI);
                    toPlace = fish.getStonePlacement(board.getBoard());
                    board.placeStone(toPlace[0], toPlace[1], 2);
                    if (board.checkWin(2)){
                        UI.drawDefeatScreen();
                    }
                    else{
                        UI.getStonePlacement("Player1");
                    }
                    UI.drawBoard(board.getBoard());
                }
            }
        }
        else{
                toPlace[1] = (e.getX()-27)/18 + ((((e.getX()-27)/9)%2 == 1) ? 1 : 0);
                toPlace[0] = e.getY()/18 + (((e.getY()/9)%2 == 1) ? 1 : 0);
                if (!board.placeStone(toPlace[0]+1, toPlace[1]+1, 2)){
                    return;
                }
                turnTracker = !turnTracker;
                UI.drawBoard(board.getBoard());
                if (board.checkWin(2)) {
                    UI.drawVictoryScreen("Player2");
                }
                else{
                    UI.getStonePlacement("Player1");
                }
        }
    }
}
