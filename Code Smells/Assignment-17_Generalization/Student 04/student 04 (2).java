package exercises.Generalization.Plotter;

import java.awt.Color;

public class Function {
    private Color color;
    
    public Function() {
        color = Color.black;
    }
    
    public double func(double x) {
        return 0;
    }
    
    public void setColor(int c) {
        color = new Color(c);
    }
    
    public Color getColor() {
        return color;
    }
}
