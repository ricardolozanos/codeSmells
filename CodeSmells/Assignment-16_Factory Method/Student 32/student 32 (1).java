package BallonFactory;

import java.awt.*;

public interface BalloonInterface {
    void update();
}

class ShrinkingBalloon implements BalloonInterface{
    private int x;
    private int y;
    private int increment = 10;
    private int diameter = 10;
    private boolean growing = true;
    public ShrinkingBalloon(){
        this.x = 175 - 5;
        this.y = 175 - 5;
    }
    public ShrinkingBalloon(int x, int y){
        this.x = x - 5;
        this.y = y - 5;
    }
    @Override
    public void update(){
        if(this.x < 0 || this.x > 350 || this.y < 0 || this.y > 350)
            growing = false;
        if(x > 175)
            growing = true;
        if(growing) {
            this.x -= 5;
            this.y -= 5;
            this.diameter += this.increment;
        }
        else{
            this.x += 5;
            this.y += 5;
            this.diameter -= this.increment;
        }
    }
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public int getDiameter(){return this.diameter;}
}
class GrowingBalloon implements BalloonInterface{
    private int x;
    private int y;
    private int increment = 10;
    private int diameter = 1;
    public GrowingBalloon(){
        this.x = 175 - 5;
        this.y = 175 - 5;
    }
    public GrowingBalloon(int x, int y){
        this.x = x - 5;
        this.y = y - 5;
    }
    @Override
    public void update(){
        if(this.x < 0 || this.y < 0 || this.x > 300 || this.y > 300) {
            this.x = 170;
            this.y = 170;
            this.diameter = 20;
        }
        else{
            this.x -= 5;
            this.y -= 5;
            this.diameter += this.increment;
        }
    }

    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public int getDiameter(){return this.diameter;}
}
