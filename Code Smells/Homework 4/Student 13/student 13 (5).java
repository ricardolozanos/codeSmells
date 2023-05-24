import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;

public class GUserInterface extends JFrame implements UserInterfaceable{
    GameController controller;
    boolean gameOver = true;
    JLabel textBox = new JLabel("Welcome to OMOK 3000");
    BoardPanel boardPanel = new BoardPanel(19);
    JRadioButton human = new JRadioButton("Human");
    JRadioButton computer = new JRadioButton("Computer");
    int mode = 1;
    public GUserInterface() {
        super("Omok 3000");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(390, 520));
        setResizable(false);
        initBars();
        initPanels();

        boardPanel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if (!gameOver) {
                    controller.placeStone(e);
                }
            }
        });
    }
    private void initBars(){
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);

        JMenuItem playItem = new JMenuItem("Play");
        playItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
        playItem.getAccessibleContext().setAccessibleDescription("Play a new game");
        playItem.addActionListener(event -> playButtonClicked(event));
        gameMenu.add(playItem);
        setJMenuBar(menuBar);


    }
    private void initPanels(){
        var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        var barPanel = new JPanel(new BorderLayout());
        var midPanel = new JPanel(new BorderLayout());
        var botPanel = new JPanel(new BorderLayout());
        var modePanel = new JPanel();
        var displayPanel = new JPanel();
        var gamePanel = new JPanel(new BorderLayout());

        JToolBar toolBar = new JToolBar("Omok");
        JButton button = new JButton("Play");
        button.addActionListener(event -> playButtonClicked(event));
        button.setToolTipText("Play a new game");
        button.setFocusPainted(false);
        toolBar.add(button);


        panel.add(barPanel);
        barPanel.add(toolBar, BorderLayout.NORTH);
        panel.add(midPanel);
        midPanel.add(modePanel, BorderLayout.NORTH);
        panel.add(botPanel);
        botPanel.add(displayPanel, BorderLayout.NORTH);
        panel.add(gamePanel);

        JButton playButton = new JButton("Play");
        ButtonGroup modeGroup = new ButtonGroup();
        playButton.addActionListener(event -> playButtonClicked(event));
        modeGroup.add(human);
        modeGroup.add(computer);

        modePanel.add(playButton);
        modePanel.add(human);
        modePanel.add(computer);

        var bPanel = new JPanel(new BorderLayout());
        gamePanel.add(bPanel, BorderLayout.NORTH);
        bPanel.add(this.boardPanel, BorderLayout.CENTER);

        displayPanel.add(textBox);

        setContentPane(panel);
        pack();
        setVisible(true);
    }

    public void playButtonClicked(ActionEvent event) {
        if (gameOver) {
            startGame();
        }
        else{
            if (JOptionPane.showConfirmDialog(null, "Play a new game?", "Omok", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                startGame();
            }
        }
    }
    public void startGame(){
        if (computer.isSelected()){
            mode = 2;
        }
        else{
            mode = 1;
        }
        gameOver = false;
        getStonePlacement("Player1");
        controller.startGUI();
    }
    @Override
    public void drawBoard(int[][] board){
        this.boardPanel.updateBoard(board);
        this.repaint();
    }

    @Override
    public int[] getStonePlacement(String playerName) {
        textBox.setText(playerName + "'s Turn to place a stone");
        return new int[] {};
    }

    @Override
    public void displayString(String toDisplay) {
        textBox.setText(toDisplay);
    }

    @Override
    public int getGameMode() {
        return mode;
    }

    @Override
    public String getPlayerName(int playerNum) {
        return "Player" + playerNum;
    }

    @Override
    public void drawVictoryScreen(String playerName) {
        gameOver = true;
        displayString(playerName + " Wins!");
    }

    @Override
    public void drawDefeatScreen() {
        gameOver = true;
        displayString("OMOKFISH REIGNS SUPREME!");
    }
    public void setController(GameController c){
        this.controller = c;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new GUserInterface());
    }
}

