package noapplet.assignments;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import noapplet.NoApplet;

public class Balloon2 extends Balloon{
    public Balloon2(){
    }

    public Balloon2(String[] params){
        super(params);
    }
    boolean growing = true;

    public void start() {
        while (true) {
        repaint();
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
        }
        if (growing) {
            size += 10;
            if (size >= getSize().width) {
            growing = false;
            }
        } else {
            size -= 10;
            if (size <= 10) {
            growing = true;
            }
        }
        }
    }
    public static void main(String[] args) {
        new Balloon2(new String[] {"width=350", "height=350"}).run();
    }
}
