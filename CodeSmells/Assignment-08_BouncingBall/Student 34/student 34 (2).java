package noapplet.bouncingBallEx;

import noapplet.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Scanner;


public class BouncingBall extends AnimationNoApplet {

    private int x, y;
    private int dx = -2, dy = -4;
    private int radius = 20;
    private Color color;

    public void init(){
        super.init();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Random rand = new Random();
        Dimension d = getSize();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, d.width, d.height);
        ball newBallz = new circleBall(rand.nextInt(),rand.nextInt(), dx, dy, radius, Color.RED);
        newBallz.drawBalls(g);
    }

     public static void main(String[] args){
        new BouncingBall().run();
    }
}



