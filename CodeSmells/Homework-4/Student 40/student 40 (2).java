package src.noapplet.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;


public class MainPanel extends JFrame implements BoardPanel.clickListener{
    private final int BOARD_SIZE = 20;
    private BoardPanel boardPanel;
    private Board board;
    private Game game;

    private ComputerStrategy strategy;
    private boolean computerSelected = false;
    public boolean gameInProgress = true;
    private ImageIcon play;
    private ImageIcon about;
    private JLabel messageLabel;

    public MainPanel(){
        this.board = new Board(BOARD_SIZE);
        this.game = new Game(board);
        this.strategy = new ComputerStrategy(board);
        this.play = createImageIcon("playbutton.png");
        this.about = createImageIcon("about.png");
        configureUI();
        setLayout(new BorderLayout());
    }
    private ImageIcon createImageIcon(String filename) {
        URL imageUrl = getClass().getResource("/" + filename);
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        }
        return null;
    }

    private void configureUI(){
        setLayout(new BorderLayout());
        boardPanel = new BoardPanel(board, this);
        messageLabel = new JLabel("Welcome to Omok game!");
        //buttons
        var humanButton = new JRadioButton("Human");
        var compButton = new JRadioButton("Computer");
        var display = new JLabel("");
        //Menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);
        JMenuItem playMenuItem = new JMenuItem("Play");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        playMenuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
        playMenuItem.getAccessibleContext().setAccessibleDescription(
                "Play a new game");
        playMenuItem.setIcon(play);
        aboutMenuItem.setIcon(about);
        gameMenu.add(playMenuItem);
        gameMenu.add(aboutMenuItem);
        gameMenu.add(exitMenuItem);
        OmokAction playAction = new OmokAction("", play, "Play the game", KeyEvent.VK_P, KeyEvent.VK_P,
                () -> {
                    if(humanButton.isSelected()){
                        display.setText("Human was selected!");
                        computerSelected = false;
                    }
                    else if (compButton.isSelected()) {
                        display.setText("Computer was selected!");
                        computerSelected = true;

                    }

                });
        OmokAction aboutAction = new OmokAction("", about, "About game ", KeyEvent.VK_P, KeyEvent.VK_P,
                () -> {
                    showMessage("\tVersion 4.5\n @SamanthaGames");
                });
        OmokAction exitAction = new OmokAction("Exit", play, "Exit game ", KeyEvent.VK_P, KeyEvent.VK_P,
                () -> {
                    System.exit(0);
                });
        playMenuItem.addActionListener(playAction);
        aboutMenuItem.addActionListener(aboutAction);
        exitMenuItem.addActionListener(exitAction);
        //Tool bar
        JToolBar toolBar = new JToolBar();
        JPanel topPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(topPanel, BoxLayout.X_AXIS);
        topPanel.setLayout(boxLayout);
        topPanel.add(toolBar);
        topPanel.add(Box.createHorizontalStrut(10));
        topPanel.add(messageLabel);
        add(topPanel, BorderLayout.PAGE_START);
        JButton playToolBarButton = new JButton(playAction);
        JButton aboutToolBarButton = new JButton(aboutAction);
        toolBar.add(playToolBarButton);
        toolBar.add(aboutToolBarButton);

        //Play button
        var playPanel = new JPanel();
        playPanel.setPreferredSize(new Dimension(300, 90));
        var playButton = new JButton("Play");
        ButtonGroup group = new ButtonGroup();
        group.add(humanButton);
        group.add(compButton);
        playPanel.add(new JLabel("Select opponent:"));
        playPanel.add(humanButton);
        playPanel.add(compButton);
        playPanel.add(playButton);
        playPanel.add(display);
        playButton.addActionListener(playAction);
        playPanel.setLayout(new FlowLayout());

        getContentPane().add(boardPanel, BorderLayout.CENTER);
        getContentPane().add(playPanel, BorderLayout.SOUTH);

        //New Game button
        var newGameButton = new JButton("New Game");
        newGameButton.addActionListener(e -> {
            if (gameInProgress) {
                int confirm = JOptionPane.showConfirmDialog(MainPanel.this, "Are you sure you want to start a new game?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    board.clear();
                    game.setActivePlayer(game.getHumanPlayer());
                    //currPlayer = game.getHumanPlayer();
                    repaint();
                }
            }
            else {
                board.clear();
                game.setActivePlayer(game.getHumanPlayer());
                //currPlayer = game.getHumanPlayer();
                repaint();

            }
        });
        playPanel.add(newGameButton);

        setSize(new Dimension(400, 600));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void placeClicked(int x, int y){
        if (board.isEmpty(x, y)){
            board.placePiece(game.getactivePlayer(),x,y);
            if (board.isAWin(x,y)){
                showMessage("Game over, " + game.getactivePlayer().toStrings() + " has won the game!");
                gameInProgress = false;
            }
            if (board.completedBoard()){
                showMessage("Game has ended in a draw");
                gameInProgress = false;
            }
            if (!gameInProgress){
                repaint();
            }
            game.changeTurn();
            messageLabel.setText("It is " + game.getactivePlayer().toStrings() + " Turn");
            if (computerSelected){
                if (game.getactivePlayer() == game.getNextPlayer()) {
                    Index winFourCoordinates = strategy.foundFourToWin(game.getNextPlayer());
                    Index blockFourCoordinates = strategy.foundFourToWin(game.getHumanPlayer());
                    Index blockThreeCoordinates = strategy.foundThreeStones(game.getHumanPlayer());
                    Index placeFourCoordinates = strategy.foundThreeStones(game.getNextPlayer());
                    Index placeThreeCoordinates = strategy.foundTwoStones(game.getNextPlayer());
                    Index blockTwoCoordinates = strategy.foundTwoStones(game.getHumanPlayer());
                    if (winFourCoordinates != null) {
                        board.placePiece(game.getNextPlayer(), winFourCoordinates.x, winFourCoordinates.y);
                        showMessage("Game over, " + game.getNextPlayer().toStrings() + " has won the game!");
                        messageLabel.setText("Game over");
                        gameInProgress = false;
                    } else if (blockFourCoordinates != null) {
                        board.placePiece(game.getNextPlayer(), blockFourCoordinates.x, blockFourCoordinates.y);
                    } else if (blockThreeCoordinates != null) {
                        board.placePiece(game.getNextPlayer(), blockThreeCoordinates.x, blockThreeCoordinates.y);
                    } else if (placeFourCoordinates != null) {
                        board.placePiece(game.getNextPlayer(), placeFourCoordinates.x, placeFourCoordinates.y);
                    } else if (placeThreeCoordinates != null) {
                        board.placePiece(game.getNextPlayer(), placeThreeCoordinates.x, placeThreeCoordinates.y);
                    } else if (blockTwoCoordinates != null) {
                        board.placePiece(game.getNextPlayer(), blockTwoCoordinates.x, blockTwoCoordinates.y);
                    } else {
                        Index index = strategy.startingPlace();
                        board.placePiece(game.getNextPlayer(), index.x, index.y);
                    }
                    game.changeTurn();
                    messageLabel.setText("It is " + game.getactivePlayer().toStrings() + " Turn");
                }
            }


        }
    }


    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    public static void main(String[] args) {
        MainPanel main = new MainPanel();

    }

}
