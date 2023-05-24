package noapplet.balloon;

import java.awt.*;

public class GrowingShrinkingBalloon extends GrowingBalloon {
    public GrowingShrinkingBalloon(){}
    @Override
    public void setCard(Dimension d){
        if (this.sizeX > d.width || this.sizeY > d.height){
            this.cardinality = -1;
        }
        else if (this.sizeX < 0 || this.sizeY < 0){
            this.cardinality = 1;
        }
    }
}
