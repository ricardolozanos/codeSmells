import javax.swing.*;
public class MyFrame extends JFrame{
   Balloon panel;
   MyFrame(){
     panel = new Balloon();

     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.add(panel);
     this.pack();
     this.setVisible(true);
   }
}
