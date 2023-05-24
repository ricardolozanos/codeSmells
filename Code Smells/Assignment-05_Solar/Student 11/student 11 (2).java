import java.awt.*;

public class Circle {
    private String name;
    private int radius;
    private Color color;
    private Circle parent;
    private int distanceFromParent;
    private int degreeFromParent = 90;
    public Circle(String name,int radius, Color color){
        this.name = name;
        this.radius = radius;
        this.color = color;
    }
    public void setParent(Circle parent){
        this.parent = parent;
    }
    public void setDistanceFromParent(int distance){
        this.distanceFromParent = distance;
    }
    public void setDegreeFromParent(int degree){
        degreeFromParent = degree;
    }
    public void incrementDegreeFromParent(){
        if(degreeFromParent == 360){
            degreeFromParent = 0;
            return;
        }
        this.degreeFromParent += 1;
    }
    public int getRadius(){return this.radius;}
    public Circle getParent(){return parent;}
    public int getDistanceFromParent(){return distanceFromParent;}
    public int getDegreeFromParent(){return degreeFromParent;}
    public void draw(int x, int y, Graphics g){
        g.setColor(color);
        g.fillOval(x-radius/2,y-radius/2,radius,radius);
    }
}
