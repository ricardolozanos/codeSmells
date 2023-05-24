package guiboard;
import guiboard.panels.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

/** Main Frame of Omok*/
public class Main extends JFrame {
    public Main(String title){
        //Frame
        super(title);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Omok Action
        OmokAction playAction = new OmokAction("Play",createImageIcon("play.png"),"Play a new game",KeyEvent.VK_P,KeyEvent.VK_P, () -> System.out.println("to be implemented..."));
        OmokAction aboutAction = new OmokAction("About",createImageIcon("question_mark.png"),"Place 5 stones to win", KeyEvent.VK_A,KeyEvent.VK_A,() -> System.out.println("to be implemented..."));

        //Menu Bar
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Game");
        menu.setMnemonic(KeyEvent.VK_G);
        menu.getAccessibleContext().setAccessibleDescription("Game menu");
        menuBar.add(menu);

        // Menu Bar items, Play and About.
        JMenuItem menuPlay = new JMenuItem(playAction);
        menu.add(menuPlay);
        JMenuItem menuAbout = new JMenuItem(aboutAction);
        menu.add(menuAbout);
        menu.addSeparator();
        JMenuItem exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_E);
        exit.addActionListener(e -> {
            if("Exit".equals(e.getActionCommand())){
                System.exit(NORMAL);
            }
        });
        menu.add(exit);

        setJMenuBar(menuBar);

        //Tool Bar
        JToolBar toolBar = new JToolBar("Omok");

        //Tool Bar buttons, Play and About.
        JButton buttonPlay = new JButton(playAction);
        JButton buttonAbout = new JButton(aboutAction);
        buttonPlay.setFocusPainted(false);
        buttonPlay.setText("");
        buttonAbout.setFocusPainted(false);
        buttonAbout.setText("");
        toolBar.add(buttonPlay);
        toolBar.add(buttonAbout);

        //Panels
        var panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(300,400));
        panel.add(new MainPanel(),BorderLayout.CENTER);
        panel.add(toolBar,BorderLayout.NORTH);

        //Frame
        setContentPane(panel);
        pack();
        setVisible(true);
    }

    /**Create a new Image Icon from resource folder.
     *
     * @param filename Image filename to be accessed.
     * @return returns created Image icon.
     */
    private ImageIcon createImageIcon(String filename){
        URL imageURL = getClass().getResource("/" + filename);
        if(imageURL != null){
            return new ImageIcon(imageURL);
        }
        return null;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main("Omok"));

    }
}

/** Handles the creation of a new Action.*/
class OmokAction extends AbstractAction {
    private final Runnable runnable;
    public OmokAction(String name,ImageIcon icon, String descr,int mnemonic, int accelerator, Runnable runnable){
        super(name,icon);
        this.runnable = runnable;
        putValue(SHORT_DESCRIPTION,descr);
        putValue(MNEMONIC_KEY,mnemonic);
        putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(accelerator, InputEvent.ALT_DOWN_MASK));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        runnable.run();
    }
}
