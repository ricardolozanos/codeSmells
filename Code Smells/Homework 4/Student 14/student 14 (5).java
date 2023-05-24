package game;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
/** Manages control flow for Omok game */
public class Controll {
    omokGame game;
    InputStream in;
    PrintStream out;
    conoleUI console;
    Scanner k;


    public Controll(InputStream in, PrintStream out){
        this.in = in;
        this.out = out;
        console = new conoleUI(out);
    }
    /** if no input or output given uses System in and out */
    public Controll(){
        this(System.in, System.out);
    }

    /** Top level controll folow method for omok game*/
    public void run() {
        k = new Scanner(in);
        console.intro();
        boolean playing = true;
        boolean nowin = true;
        while(playing){
            int type = console.gameselect(k);
            int size = console.sizeAsk(k);
            game = new omokGame(type, size);
            while(nowin){
                nowin=round();
            }
            playing = console.endgame(k);
            nowin = true;
        }
        
    }
    /** Decides the steps for a single plaers turn */
    private boolean round() {
        int[] cords;
        int curplayer = game.getplayer();
        if (game.players[curplayer] instanceof mplayer ){
            cords = game.players[curplayer].place();
        }
        else {
            console.drawBoard(game);
            cords = console.getpos(curplayer, k, game);
            if(cords[0] == -1){
                return false;
            }
            game.players[curplayer].place(cords);

        }
        if(game.gamespace.windetect(cords)){
            return console.printwinner(curplayer, game);

        }
        return true;
    }
    
}
