package noapplet.example;

import java.awt.*;

public class RectBall extends Ball{
    private int x, y;

    public RectBall(int[] position) {
        super(position);
        this.x = 20;
        this.y = 20;
    }
    public RectBall(Color color, int[] position, int dx, int dy, int x, int y){
        super(color, position, dx, dy);
        this.x = x;
        this.y = y;
    }
    public RectBall(int[] position, int x, int y){
        super(position);
        this.x = x;
        this.y = y;
    }

    public void bounce(Dimension dim, int[] nextPosition){
        if (nextPosition[0] + x > dim.getWidth() || nextPosition[0] < 0){
            setDx(-getDx());
        }
        if (nextPosition[1] + y > dim.getHeight() || nextPosition[1] < 0){
            setDy(-getDy());
        }
    }
    private void updatePosition(Dimension dim){
        this.bounce(dim, getNextPosition());
        this.setPosition(getNextPosition());
    }
    @Override
    public void draw(Graphics g, Dimension dim){
        updatePosition(dim);
        int[] currPosition = getPosition();
        g.setColor(getColor());
        g.fillRect(currPosition[0], currPosition[1], x, y);
    }
    @Override
    public int getLeftEdge(){
        return getPosition()[0];
    }
    @Override
    public int getRightEdge(){
        return getPosition()[0] + x;
    }
    @Override
    public int getUpEdge(){
        return getPosition()[1];
    }
    @Override
    public int getDownEdge(){
        return getPosition()[1] + y;
    }
}

