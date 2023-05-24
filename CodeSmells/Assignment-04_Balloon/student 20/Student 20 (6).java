import javax.swing.*;
public class MyFrame2 extends JFrame{
    Balloon2 panel;
    MyFrame2(){
        panel = new Balloon2();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
}
