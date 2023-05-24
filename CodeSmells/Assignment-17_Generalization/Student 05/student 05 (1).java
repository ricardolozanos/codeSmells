import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sine and Cosine Plot");
        SineCosinePlotter plotter = new SineCosinePlotter(args);
        frame.getContentPane().add(plotter);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
