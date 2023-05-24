import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrowingShrinkingBalloon extends GrowingBallon{
    public boolean reachedEdge = false;
    public GrowingShrinkingBalloon(){
        super();
    }
    @Override
    public void resize(){
        if(!reachedEdge){
            ballonSize+=1;
        }else{
            ballonSize-=1;
        }

        if (ballonSize == width) {
            reachedEdge = true;
        } else if (ballonSize == -1) {
            reachedEdge = false;
        }
    }
}