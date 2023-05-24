import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.stream.Collectors;

public class GUIPlay extends JFrame {
    // global statics
    // global statics
    public static final int WIDTH = 300, HEIGHT = 425;

    // instance variables
    public final LayoutManager layout = new BorderLayout();
    JMenuBar menuBar;
    JToolBar toolBar;
    JButton play;
    JLabel status;
    BoardPanel boardPanel;
    Controller controller;
    JComboBox<Controller.GameMode> strategy = new JComboBox<>(Controller.GameMode.values());

    /**
     * Creates a new instance of GUIPlay using the default board.
     */
    public GUIPlay(){
        this(new Board());
    }

    /**
     * Creates a new instance of GUIPlay using the provided board.
     * @param board the board to use for the game.
     */
    public GUIPlay(Board board){
        controller = new Controller(board);
        setTitle("Omok");
        setLayout(layout);
        setSize(new Dimension(WIDTH,HEIGHT));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        init();
    }

    /**
     * Initializes the GUI elements and sets up the game.
     */
    protected void init(){
        setToolBar();
        setMenu();
        setCenterPanel();
        setBottomPanel();
        add(new JPanel(),BorderLayout.WEST);
        add(new JPanel(),BorderLayout.EAST);
        setupPlayAction();
        boardPanel.lockBoard();
    }

    /**
     * Sets up the action listeners for when a player places a stone on the board.
     */
    private void setupPlayAction(){
        boardPanel.addClickListener(controller::placeStone);
        boardPanel.addClickListener((x,y) -> updateStatus());
        boardPanel.addClickListener((x,y) -> announceWinner());
    }

    /**
     * Updates the status bar with the current player's turn and the most recent move.
     */
    private void updateStatus(){
        Player tmp = controller.getCurrentPlayer();
        status.setText(String.format("Turn : %s (%s)",tmp,tmp.getId()));
        boardPanel.setRecentPlace(controller.getRecentPlace());
    }

    /**
     * Sets up the toolbar.
     */
    private void setToolBar(){
        toolBar = new JToolBar();
        add(toolBar,BorderLayout.PAGE_START);
        JButton lan = createCustomButton(null,"Not Implemented yet","./res/wifi_icon.gif");
        toolBar.add(lan);
        JButton play = createCustomButton(null,"Start Game, restart's game if pressed mid game","./res/play_button.gif");
        toolBar.add(play);
        play.addActionListener(this::startGame);

    }

    /**
     * Creates a custom JButton with an image icon.
     * @param buttonText the text displayed on the button (can be null).
     * @param tooltip the text displayed when the mouse hovers over the button.
     * @param filepath the path to the image icon.
     * @return the new JButton.
     */
    protected JButton createCustomButton(String buttonText, String tooltip, String filepath){
        float square = 24;
        JButton button = new JButton(buttonText);
        Image image = new ImageIcon(filepath).getImage();
        button.setToolTipText(tooltip);
        button.setBorder(BorderFactory.createEtchedBorder());
        float scale = square / Math.max(image.getHeight(null),image.getWidth(null));
        image = scaleImage(image,scale);
        button.setIcon(new ImageIcon(image));
        return button;
    }
    /**
     * Starts the game and initializes the board panel.
     * @param e The ActionEvent associated with the start button.
     */
    private void startGame(ActionEvent e){
        if(boardPanel.isUnlocked()){
            int out = JOptionPane.showConfirmDialog(this,"Confirm Restart");
            if(out != 0) return;
        }
        else {
            JOptionPane.showMessageDialog(this,"Game started");
        }
        controller.setDefaultHumanPlayers();
        switch ((Controller.GameMode)strategy.getSelectedItem()){
            case HUMAN -> controller.setDefaultHumanPlayers();
            case RANDOM_BOT -> controller.setDefaultSoloPlayers(BotPlayer.BotType.RANDOM);
            case SMART_BOT -> controller.setDefaultSoloPlayers(BotPlayer.BotType.SMART);
        }
        controller.setStartingPlayer(controller.getPlayer());
        controller.startGame();
        boardPanel.unlockBoard();
        boardPanel.reset();
        updateStatus();
    }
    /**
     Announces the winner of the game by retrieving the winner from the controller,
     locking the board panel to prevent further moves, and displaying a message dialog
     with the name of the winner.
     If there is no winner (i.e. the game is still ongoing), the method simply returns.
     */
    private void announceWinner(){
        Player player = controller.getWinner();
        if(player == null) return;
        boardPanel.lockBoard();
        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(this,String.format("%s has won.",player)));
    }
    /** Scale the given image. */
    protected Image scaleImage(Image image, float scale) {
        return image.getScaledInstance(
                (int) (image.getWidth(null) * scale),
                (int) (image.getHeight(null) * scale), 0);
    }
    /**
     Sets the menu bar for the Omok game window with options to start a new game or restart the current game.
     The "Play" option starts the game, and the "Restart" option restarts the game if it is currently in progress.
     */
    private void setMenu(){
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        // game options
        JMenu gameMenu = new JMenu("Game");
        JMenuItem play = new JMenuItem("Play"),
                restart = new JMenuItem("Restart");
        play.addActionListener(this::startGame);
        play.setToolTipText("Start Game, restart's game if pressed mid game");
        restart.addActionListener(this::startGame);
        gameMenu.add(play);
        gameMenu.add(restart);
        menuBar.add(gameMenu);
    }
    /**
     This method sets up the center panel of the Omok game GUI. It creates a panel to hold the game board and
     the "Play" button, as well as a combo box for selecting the game mode. The game board is displayed using the
     BoardPanel class, and its size is determined based on the size of the board obtained from the game controller.
     */
    private void setCenterPanel(){
        JPanel centerPanel = new JPanel();
        JPanel topPanel = new JPanel();
        play = new JButton("Play");
        play.addActionListener(this::startGame);
        JLabel startLabel = new JLabel("Strategies : ");
        topPanel.add(play);
        topPanel.add(startLabel);
        topPanel.add(strategy);
        centerPanel.add(topPanel);
        boardPanel = new BoardPanel(controller.getBoard());
        Dimension boardDim = new Dimension(controller.getBoard().size() * 17,controller.getBoard().size() * 17);
        boardPanel.setPreferredSize(boardDim);
        centerPanel.add(boardPanel);
        add(centerPanel,BorderLayout.CENTER);
    }

    /**
     This method sets up the bottom panel of the Omok game GUI. It creates a panel to hold the game board and
     the "Play" button, as well as a combo box for selecting the game mode. The game board is displayed using the
     BoardPanel class, and its size is determined based on the size of the board obtained from the game controller.
     */
    private void setBottomPanel(){
        JPanel bottomPanel = new JPanel();
        status = new JLabel("Idle");
        status.setPreferredSize(new Dimension(WIDTH-50,10));
        bottomPanel.add(status);
        add(bottomPanel,BorderLayout.SOUTH);
    }
    public void run(){
        SwingUtilities.invokeLater(() -> setVisible(true));
    }

    public static void main(String ... args){
        GUIPlay ui = new GUIPlay();
        ui.run();
    }
}
