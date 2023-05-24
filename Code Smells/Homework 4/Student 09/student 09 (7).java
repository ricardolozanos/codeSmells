package OmokBoard;

import java.awt.*;

public class player{
    private String playerNum;

    public player(){
    }
    public player(String playerNum){
        this.playerNum = playerNum;
    }

    public String getPlayerNum(){

        return playerNum;
    }
    public Color playerColor(){
        if(getPlayerNum() == "1"){
            return Color.BLACK;
        }
        else{return Color.WHITE;}
    }

}
