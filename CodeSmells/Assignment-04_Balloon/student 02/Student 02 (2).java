package noapplet.example;

import java.awt.*;

public class Balloon2 extends Balloon{
    protected boolean grow = true;
    protected String test = "" + size;
    @Override
    public void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, d.width, d.height);
        if (grow) {
            size = size + offset;
            x = x - 5;
            y = y - 5;
        }
        if (size > 300) {
            grow = false;
            //test = "false";
        }
        if (!grow){
            size = size - offset;
            x = x + 5;
            y = y + 5;
        }
        if (size < 11) {
            grow = true;
            //test = "true";
        }
        g.setColor(Color.BLUE);
        g.fillOval(x, y, size, size);
        g.setColor(Color.GREEN);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.drawString("Jordan Aguon", 0, 20);
    }
    public static void main(String[] args) {

        new Balloon2().run();
    }
}
