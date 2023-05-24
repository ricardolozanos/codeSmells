package noapplet.balloon;

import java.awt.*;

public class Balloon2 extends Balloon{
    public Balloon2(){}
    public Balloon2(String[] params) {super(params);}
    @Override
    public void setCard(Dimension d){
        if (this.sizeX > d.width || this.sizeY > d.height){
            this.cardinality = -1;
        }
        else if (this.sizeX < 0 || this.sizeY < 0){
            this.cardinality = 1;
        }
    }
    public static void main(String[] args){
        new Balloon2().run();
    }
}
