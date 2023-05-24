package BouncingBall;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;

interface bouncable {


    public void paint(Graphics g);
    public int getx();
    public int gety();
    public int getraid();
    public void flipx();
    public void flipy();
}