public class Controller {
    public enum GameMode{
        HUMAN("Human"),
        RANDOM_BOT("Random Bot"),
        SMART_BOT("Smart Player");
        public String mode;
        GameMode(String mode){this.mode = mode;}

    }
    Board board;
    Player player, opponent,currentPlayer;
    Board.Place recentPlace;
    public Controller(){
        this(new Board());
    }
    public Controller(Board board){
        this.board = board;
    }
    public Player getPlayer(){return player;}
    public Player getOpponent(){return opponent;}
    public void setPlayers(Player player, Player opponent){
        if(player.getId() == opponent.getId()){
            player.setId(Player.ID.BLACK);
            opponent.setId(Player.ID.WHITE);
        }
        this.player = player;
        this.opponent = opponent;
    }
    public void setDefaultHumanPlayers(){
        this.player = new HumanPlayer("Player");
        this.opponent = new HumanPlayer("Opponent");
        player.setId(Player.ID.BLACK);
        opponent.setId(Player.ID.WHITE);
    }
    public void setDefaultSoloPlayers(BotPlayer.BotType type){
        this.player = new HumanPlayer("Player");
        this.opponent = new BotPlayer("Bot");
//        if(type == BotPlayer.BotType.RANDOM)
//
//        if(type == BotPlayer.BotType.SMART)
    }
    public void startGame(){
        board.clear();
    }
    public Board getBoard(){
        return this.board;
    }
    public void placeStone(int x, int y){
        if(board.isOccupied(x,y)) return;
        board.placeStone(x,y,currentPlayer);
        recentPlace = new Board.Place(x,y);
        switchPlayer();
    }
    public Board.Place getRecentPlace(){
        return recentPlace;
    }
    public final void setStartingPlayer(Player player){
        currentPlayer = player;
    }
    public void switchPlayer(){
        currentPlayer = currentPlayer!= player ? player : opponent;
    }
    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public void printBoardToConsole(){

    }
    public Player getWinner(){
        if(board.winningRow() == null) return null;
        return board.isWonBy(player)? player : opponent;
    }
}
