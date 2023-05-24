package noapplet.example;

import java.awt.*;

public class CircleBall extends Ball{
    private int radius;

    public CircleBall(int[] position) {
        super(position);
        this.radius = 20;
    }
    public CircleBall(Color color, int[] position, int dx, int dy, int radius){
        super(color, position, dx, dy);
        this.radius = radius;
    }

    public void bounce(Dimension dim, int[] nextPosition){
        if (nextPosition[0] + radius*2 > dim.getWidth() || nextPosition[0] < 0){
            setDx(-getDx());
        }
        if (nextPosition[1] + radius*2 > dim.getHeight() || nextPosition[1] < 0){
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
        g.fillOval(currPosition[0], currPosition[1], radius*2, radius*2);
    }
    @Override
    public int getLeftEdge(){
        return getPosition()[0];
    }
    @Override
    public int getRightEdge(){
        return getPosition()[0] + radius*2;
    }
    @Override
    public int getUpEdge(){
        return getPosition()[1];
    }
    @Override
    public int getDownEdge(){
        return getPosition()[1] + radius*2;
    }
}
