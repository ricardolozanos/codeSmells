package OmokConsole.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GUI extends JFrame{
    static String human = "Human";
    static String computer = "Computer";
    static String current = "None";
    private String currPlayer;
    private boolean startNewGame = false;
    private boolean gameInProgress = false;
    private boolean gameModeSelected = false;
    public JFrame frame;
    BoardPanel testBoardPanel;
    Timer timer;
    JLabel playerLabel;
    JLabel winnerLabel;
    private static final int DELAY = 1000;

    public GUI() {
        testBoardPanel = new BoardPanel();
        frame = new JFrame("Omok");
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        var panel = new JPanel();
        panel.setLayout(new BorderLayout());
        var display = new JPanel();
        display.setLayout(new GridLayout(0, 1));


        JRadioButton humanButton = new JRadioButton("Human");
        humanButton.setMnemonic(KeyEvent.VK_B);
        humanButton.setActionCommand("Human");

        JRadioButton computerButton = new JRadioButton("Computer");
        computerButton.setMnemonic(KeyEvent.VK_C);
        computerButton.setActionCommand("Computer");

        JButton play = new JButton("Play");

        JLabel text = new JLabel();

        display.add(play);
        display.add(text);

        ButtonGroup group = new ButtonGroup();
        group.add(humanButton);
        group.add(computerButton);

        var statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(6,0));
        JLabel player = new JLabel("Current Player:");
        playerLabel = new JLabel();
        winnerLabel = new JLabel();


        statusPanel.add(player);
        statusPanel.add(playerLabel);
        statusPanel.add(winnerLabel);
        //statusPanel.add(winner);

        humanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current = e.getActionCommand();
            }
        });
        computerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current = e.getActionCommand();
            }
        });

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("           " + current + " Selected");
                if (!current.equals("None")) {
                    gameModeSelected = true;
                    gameInProgress = true;
                    frame.remove(panel);
                    frame.add(testBoardPanel, BorderLayout.CENTER);
                    frame.add(statusPanel, BorderLayout.EAST);
                }
                repaint();
            }
        });

        JPanel radioPanel = new JPanel(new GridLayout(1, 0));
        radioPanel.add(humanButton);
        radioPanel.add(computerButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuOptions = new JMenu("Options");
        JMenuItem menuNewGame = new JMenuItem("New Game");
        menuNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gameInProgress){
                    int a = JOptionPane.showConfirmDialog(frame, "Start new game?");
                    if (a == JOptionPane.YES_OPTION){
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        startNewGame = true;
                        frame.dispose();

                    }
                }
            }
        });
        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        menuOptions.add(menuNewGame);
        menuOptions.add(menuExit);
        menuBar.add(menuOptions);
        frame.setJMenuBar(menuBar);

        panel.add(radioPanel, BorderLayout.CENTER);
        panel.add(display, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        //frame.setContentPane(panel);
        frame.setVisible(true);


    }

    public String getGameMode(){
        return current;
    }

    public boolean isGameModeSelected() {
        return gameModeSelected;
    }

    public void setCurrPlayer(String currPlayer) {
        this.currPlayer = currPlayer;
        playerLabel.setText("      " + this.currPlayer);
        testBoardPanel.setCurrPlayer(currPlayer);
    }

    public void setWinner(String winner){
        winnerLabel.setText("  " + winner + " Wins!");
    }

    public static void main(String[] args) {
        new GUI();
    }

    public boolean isStartNewGame() {
        return startNewGame;
    }

    public void setStartNewGame(boolean startNewGame) {
        this.startNewGame = startNewGame;
    }
}
