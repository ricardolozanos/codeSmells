import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    JMenuBar menu;
    JMenu GameLabel;
    JMenuItem play, about, exit;
    JComboBox comboBox = new JComboBox(new String[]{"human", "computer"});
    Dialogs dialogs = new Dialogs();
    int gameMode;

    public MainFrame(int gameMode){
        super("Omok");
        this.gameMode = gameMode;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(350,525));
        this.setLayout(new BorderLayout());

        createMenuBar();

        var toolBar = createJToolBar();
        this.add(toolBar,BorderLayout.NORTH);

        var boardPanel = createCenterLayout();
        this.add(boardPanel,BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }
    private void createMenuBar(){
        this.menu = new JMenuBar();
        this.GameLabel = new JMenu("Game");
        this.menu.add(this.GameLabel);
        this.play = new JMenuItem("play", new ImageIcon(getClass().getResource("playImage.png")));
        this.about = new JMenuItem("about", new ImageIcon(getClass().getResource("questionMark.png")));
        this.exit = new JMenuItem("exit", new ImageIcon(getClass().getResource("exit.png")));
        this.GameLabel.add(play);
        this.GameLabel.add(about);
        this.GameLabel.add(exit);
        this.setJMenuBar(menu);

        play.addActionListener(e->{
            dialogs.newGame();
        });
        about.addActionListener(e->{
            dialogs.aboutMSG();
        });
        exit.addActionListener(e->{
            dialogs.exitSys();
        });
    }
    private JToolBar createJToolBar(){
        JToolBar toolBar = new JToolBar(/*"Omok"*/);
        JButton playInToolBar = new JButton(new ImageIcon(getClass().getResource("playImage.png")));
//        playInToolBar.setPreferredSize(new Dimension(50,50));
        playInToolBar.setToolTipText("Create a new Game");
        toolBar.add(playInToolBar);

        JButton aboutInToolBar = new JButton(new ImageIcon(getClass().getResource("questionMark.png")));
//        aboutInToolBar.setPreferredSize(new Dimension(50,50));
        toolBar.add(aboutInToolBar);

        playInToolBar.addActionListener(e->{
            dialogs.newGame();
        });
        aboutInToolBar.addActionListener(e->{
            dialogs.aboutMSG();
        });

        return toolBar;
    }
    private JPanel createCenterLayout() {
        var panel = new JPanel();
        panel.setLayout(new BorderLayout());
        var centerTopWithButtons = new JPanel();
        panel.add(centerTopWithButtons, BorderLayout.NORTH);
        var playButton = new JButton("Play");
        centerTopWithButtons.add(playButton);
        centerTopWithButtons.add(new JLabel("Opponent: "));
        String[] options = {"human", "computer"};
        comboBox = new JComboBox(options);
        comboBox.addActionListener(this);

        centerTopWithButtons.add(comboBox);
        var boardPanel = new BoardPanel(gameMode);
        panel.add(boardPanel, BorderLayout.CENTER);

        playButton.addActionListener(e->{
            if(comboBox.getSelectedItem() == "human"){
                new MainFrame(1);
            }
            else{
                new MainFrame(2);
            }
        });

        return panel;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
