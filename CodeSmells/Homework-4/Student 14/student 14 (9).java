package game;

import java.lang.reflect.Array;
import java.util.Random;

/** Point of contact for UI, holds the board and players for the game */
public class omokGame {
    int size; // board size
    int type; // records type of game 1: Vs. Ai, 2: Vs. another\
    int currentplayer;
    Random ran = new Random();
    board gamespace;
    public player[] players = new player[2];

    /** @param type - decides if game is vs ai or vs human 1: Ai, 2: human */
    public omokGame(int type, int size){
        this.type = type;
        this.gamespace = new board(size);
        this.currentplayer = ran.nextInt(2);
        if (type == 1){
            players[0] = new hplayer(gamespace, "O");
            players[1] = new mplayer(gamespace, "X");
        }
        if (type == 2){
            players[0] = new hplayer(gamespace, "O");
            players[1] = new hplayer(gamespace, "X");
        }
    }
    /**no input makes a vs AI game with a size 15 board*/
    public omokGame(){
        this(1, 15);
    }

    /** Flips between 0/1 for alternating turns*/
    public int getplayer(){
        if (currentplayer == 0){
            currentplayer = 1;
        }
        else {
            currentplayer = 0;
        }
        return currentplayer;
    }

    public board gamespace(){
        return gamespace;
    }

}
