package noapplet;

import java.awt.*;

public class Balloon2 extends Balloon {
    @Override
    public void checkSize(){
        if (x >= 400 || y >= 400){
            increasing = false;
        }
        else if (x <= 0 || y <= 0){
            increasing = true;
        }
    }
    @Override
    public void changeSize(){
        if (increasing){
            x++;
            y++;
        }
        else{
            x--;
            y--;
        }
    }
    public static void main(String[] args) {
        new Balloon2().run();
    }
}
