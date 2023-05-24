/**
 * a controller that can connect to an interface 
 */
public class Controller implements OmokInterface {
    private GUIOmok ioStream;
    private GameInfo info;
    private Board game;
    private Player[] players;
    private Player playerTurn;
    private String rules; 

    /**
     * Launches the interface
     */
    public void start(){
        game = new Board();
        String[] gameModes = {"Human","Computer"};
        ioStream = new GUIOmok();
        ioStream.addIOListener(this);
        info = new GameInfo(gameModes);
        ioStream.show("Select Opponent");
        rules = "The game is played by two players on a grid."+System.lineSeparator()+ "The players take turns marking the spaces in the grid [O].One of them will be WHITE and the other BLACK."+System.lineSeparator()+"In order to win the game, a player must place five of their marks in a horizontal, vertical or diagonal row, while preventing the opponent from doing so."+System.lineSeparator()+ "The game is won by the player who manages to place five marks in a row."+ System.lineSeparator()+"Game On, Good Luck!";
    }

    /**
     * Starts a new game, human or computer game
     */
    public void newGame(){
        String opp = ioStream.getOpponent();
        //looking for strategy in array
        for(int i = 0; i < info.gameModes.length ;i++){
            if( opp.equalsIgnoreCase(info.gameModes[i]) ){
                info.gameIndx = i;
                break;
            }
        }
        if(info.gameIndx == 1){
            this.players = new Player[]{new HumanPlayer("PlayerOne" ,1), new ComputerPlayer("playerTwo" ,2)};
        }else{
            this.players = new Player[]{new HumanPlayer("PlayerOne" ,1), new HumanPlayer("playerTwo" ,2)};
        }

        playerTurn = players[0]; // Always start with player 1 in new game
        game.clear();
        ioStream.resetBoard();
        ioStream.show(playerTurn.name()+" select stone placement");
    }

    /**
     * Places stone on board and checks for a win
     * @param x,y given coordinates
     */
    public void makeMove(int x, int y){
        game.placeStone(x, y, playerTurn); //adds stone to board
        ioStream.addStone(x, y, playerTurn.id()-1); //adds stone to interface
        boolean won = game.isWonBy(playerTurn);
        if(won){
            if(playerTurn.isComputer()){
                ioStream.show("you lost. better luck next time!");
            }else{
                ioStream.show(playerTurn.name()+" won!!");
            }
            ioStream.highLight(game.winningRow());
            info.gameStart = false;
            return;
        }
        changePlayerTurn();

        //if the next turn isnt a computer turn and the game hasnt been won already ask player 2 for stone placement
        if(!playerTurn.isComputer() && !won){
            ioStream.show(playerTurn.name()+" select stone placement");
        }

    }

    /**
     * Changes the player turn if Player1 -> Player2, if Player2 -> Player1
     */
    public void changePlayerTurn(){
        playerTurn = players[ (playerTurn.id() == 1) ? 1 : 0 ];
    }


    @Override
    /**
     * Allows the game to be played and board to be clicked
     */
    public void play() {
        //if the game hasnt been started yet
        if(!info.gameStart){
            newGame();// set game Index to users choice
            info.gameStart = true;
        //if in the middle of a game
        }else{
            //0 = Yes, 1 = No , 2 = Cancel
            int choice = ioStream.warn("Play a new Game?");
            if(choice == 0){
                newGame();
            } 
        }
    }

    @Override
    /**
     * Checks for the selected coordinates availability
     * @param x,y  cooridinates
     * @return boolean stating if the move is valid or not
     */
    public boolean moveSelected(int x, int y) {
        if(info.gameStart){
            if(game.isEmpty(x, y)){
                makeMove(x, y);
                if(playerTurn.isComputer()){
                    int[] coords = playerTurn.getNextMove(game.getBoard());
                    makeMove(coords[0], coords[1]);
                }
               return true;
            }else{
                ioStream.show("Space taken, try another spot");
                return false;
            }
        }
        ioStream.show("Press Play to Start");
        return false;
    }

    @Override
    /**
     * Sends the rules string to the GUI
     */
    public void about() {//displays rules
        ioStream.info(rules);
    }

    @Override
    /**
     * Prompt to exit the game with buttons
     */
    public void endGame(){//message before exiting the game
        int choice = ioStream.warn("Click yes if you want to exit.");
        if(choice == 0){
            System.exit(0);
        }
    }

    @Override
    /**
     *Current game status
     @return boolean true-game going on , false game not available
     */
    public boolean gameStart(){
        return info.gameStart;
    }
    
    /**
     * Containing game information
     */
    public class GameInfo{
        String[] gameModes;
        int gameIndx;
        boolean gameStart;
        public GameInfo(String[] gameModes){
            this.gameModes = gameModes;
            this.gameIndx = 0;
            this.gameStart = false;
        }
    }


}
