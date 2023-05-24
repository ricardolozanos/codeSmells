package noapplet;

import java.awt.*;

public class SineCosinePlotter extends MultiPlotter{

    public static void main(String[] args){
        SineCosinePlotter sin = new SineCosinePlotter();
        sin.addFunction(x -> Math.sin((double)x), Color.RED);
        sin.addFunction(x -> Math.cos((double)x), Color.GREEN);
        sin.run();
    }
}
