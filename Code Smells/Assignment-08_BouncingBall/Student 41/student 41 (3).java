package noapplet;

import java.awt.*;
import java.util.Random;

public class CircleBall extends Ball{
    public CircleBall(int radius, Color color, int width, int height){
        this.width = width;
        this.height = height;
        this.radius = radius;
        this.color = color;
        Random rand = new Random();
        this.x = rand.nextInt(radius, width-radius);
        this.y = rand.nextInt(radius,height-radius);

    }

    public void draw(Graphics g,CircleBall[] b) {
        checkWall(b);
        x += dx;
        y += dy;
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
    public void checkWall(CircleBall[] b){
        if (x < radius || x > width - radius) {
            dx = -dx;
        }
        if (y < radius || y > height - radius) {
            dy = -dy;
        }
        else{
            for (CircleBall ball : b) {
                if(this != ball){
                    double i = Math.sqrt((x - ball.x) * (x - ball.x) + (y - ball.y) * (y - ball.y));
                    if (i <= radius + ball.radius){
                        dx = -dx;
                        dy = -dy;
                    }
                }
            }
        }
    }
}
