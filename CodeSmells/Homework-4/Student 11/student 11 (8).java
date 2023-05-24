public class BotPlayer extends Player{
    public enum BotType{
        RANDOM,
        SMART;
    }
    BotPlayer(String name){
        super(name);
    }
    @Override
    public Board.Place playMove() {
        return null;
    }
}
