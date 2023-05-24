import java.awt.*;
import java.util.Random;

public abstract class Player{
    private final int[] lastMove = {-1,-1};
    public Color color;

    public Player(){}
    public abstract void setLastMove(int x, int y);
    public abstract int[] getLastMove();
    public abstract String name();
}

class Human extends Player{

    /** Name of this player. */
    private final String name;
    private final int[] lastMove = {-1,-1};
    public Color color = Color.WHITE;

    /** Create a new player with the given name. */
    public Human(String name) {
        this.name = name;
    }

    /** Return the name of this player. */
    public String name() {
        return name;
    }

    @Override
    public void setLastMove(int x, int y){
        lastMove[0] = x;
        lastMove[1] = y;
    }
    @Override
    public int[] getLastMove(){
        return lastMove;
    }
}
class Computer extends Player{
    private Board board;
    private Human p1;
    private int[] lastMove = {-1,-1};
    private Strategy strat;
    public Color color = Color.BLACK;
    String name = "Player 2";
    public Computer(Board board, Human p1){
        this.board = board;
        this.p1 = p1;
        strat = new Strategy(board,p1);
    }
    public String name(){
        return this.name;
    }
    @Override
    public void setLastMove(int x, int y){
        int[] move = strat.makeMove();
        lastMove[0] = move[0];
        lastMove[1] = move[1];
    }
    @Override
    public int[] getLastMove(){ return lastMove; }
}
class Strategy{
    private Board board;
    private Human human;
    Random rand = new Random();
    public Strategy(Board board, Human human){
        this.board = board;
        this.human = human;
    }
    public int[] makeMove(){
        // int[] last = human.getLastMove();
        //   int[] ans = {-1,-1};

        int[] ans = {rand.nextInt(15), rand.nextInt(15)};
        while(!(board.isOccupied(ans[0], ans[1]))){
            ans[0] = rand.nextInt(15);
            ans[1] = rand.nextInt(15);
        }
        return ans;
    }

}