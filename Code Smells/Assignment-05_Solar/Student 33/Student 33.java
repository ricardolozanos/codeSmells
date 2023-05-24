package noapplet.example.solar;

import noapplet.AnimationNoApplet;

import java.awt.*;
import java.util.Date;

public class Main extends AnimationNoApplet {
    private Sun Sun = new Sun();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0, dim.width, dim.height);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(Color.ORANGE);
        g.drawString("Francisco Roman", 40, 30);
        Sun.Update(g,new Date().getTime(), dim.width/2, dim.height/2);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
class Sun extends Planet {
    public Sun(){
        super(Color.red, 35, 0, true, new Planet[] {

            new Planet(Color.BLUE, 15, 175, false, null),

            new Planet(Color.GREEN, 15, 50,false, new Planet[] {
                // Moon
                new Planet(Color.GRAY, 6, 14, true, null)
            }),

            new Planet(Color.MAGENTA, 10, 75, false,null),
            new Planet(Color.ORANGE, 25, 125,false, new Planet[] {
                new Planet(Color.GRAY, 7, 35, false,null),
                new Planet(Color.GRAY, 8, 30, false,new Planet[]{
                    new Planet(Color.GRAY, 5, 10,true, null)
                })
            })

        });
    }
}
class Planet {
    private Color Color;
    private double Speed = 0;
    public double Distance;
    private int Size;
    private boolean Reverse;
    private Planet[] Children;

    public Planet(Color color, int size, double distance,boolean reverse, Planet[] children) {
        Color = color;
        Size = size;
        Distance = distance;
        Reverse = reverse;
        Children = children;
        if(distance > 0){
            Speed = (double)size / distance; // a little bit physics based
        }
    }
    public void Update(Graphics g, long millisecond, double xOffset, double yOffset) {
        double progress = Speed * ((double)millisecond / 1000d) * 2*Math.PI;

        if(Reverse)
            progress *= -1;

        double x = Math.cos(progress) * Distance + xOffset;
        double y = Math.sin(progress) * Distance + yOffset;

        g.setColor(Color);
        g.fillOval((int)(x - Size / 2), (int)(y - Size / 2), Size, Size);

        if(Children == null){
            return;
        }

        for (Planet child : Children)
            child.Update(g,millisecond, x, y);
    }
}