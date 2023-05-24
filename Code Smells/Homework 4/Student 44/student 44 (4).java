import javax.swing.*;

public class Dialogs extends JDialog {
    public Dialogs(){
        setLocationRelativeTo(null);
    }
    public void newGame(){
        int choice = JOptionPane.showOptionDialog(this,"Create new game?","New Game?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Confirm", "Cancel"}, null);
        if(choice == JOptionPane.YES_OPTION){
            new MainFrame(1);
        }
    }
    public void aboutMSG(){
        JOptionPane.showMessageDialog(this,"HOW TO PLAY OMOK: \n1. Select Game mode(Human, Computer)\n" +
                " 2. Initiate game by clicking any Play button\n" +
                "3. Connect 5 stones in a row (horizontal, vertical, diagonal)");
    }
    public void exitSys(){
        System.exit(0);
    }
    public void winMessage(Player player){
        int choice = JOptionPane.showOptionDialog(this,player.name() + " you won!\nCreate new game ","VICTORY!!!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Confirm", "Cancel"}, null);
        if(choice == JOptionPane.YES_OPTION){
            new MainFrame(1);
        }
    }
    public void fullBoard(){
        int choice = JOptionPane.showOptionDialog(this,"The Board is full:((\nCreate new game to break the tie!!","TIE!!!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Confirm", "Cancel"}, null);
        if(choice == JOptionPane.YES_OPTION){
            new MainFrame(1);
        }
    }

}
