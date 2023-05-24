import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;
/**
 This class implements the GameInterface and provides a graphical user interface (GUI) for the Omok game.
 It contains variables and methods to handle the game state and GUI events.
 */
public class GUIInterface extends NoApplet{
    //Variables used in this class
    private GameMode selectedMode = GameMode.Human_VS_Human;
    boolean GameInProgress = false;
    Stone currentStone = Stone.RED;
    Player player1 =  getPlayer1();
    Player player2 =  getPlayer2();
    Player currentPlayer = player1;
    private final Board board;
    private BoardPanel panel;
    private int clickedRow;
    private int clickedCol;
    private JFrame frame;
    JLabel message;
    private boolean win = false;
    /**
     * Constructor for GUIInterface class.
     * @param board the game board to be used in the Omok game
     */
    public GUIInterface(Board board) {
        this.board = board;
        panel = new BoardPanel(board);
        panel.setPreferredSize(new Dimension(500, 500)); // set the preferred size
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle mouse click event here
                int x = e.getX();
                int y = e.getY();
                // Handle the click event
                if(!win) {
                    handleMouseClick(x, y);
                }
            }
        });
        //Create JLabel to display non-invasive messages to user
        message = new JLabel(" ",JLabel.CENTER);
        message.setForeground(Color.WHITE);
        message.setText("Welcome to Omok, select game-mode and click play");
        JFrame frame = new JFrame("Omok");
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Resize JFrame
        frame.pack();

        // Create a JMenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Menu");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        // Add the JMenuItem objects to the JMenu object
        fileMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(e -> System.exit(0));
        // Add the JMenu object to the JMenuBar object
        menuBar.add(fileMenu);
        // Add the JMenuBar to the JFrame
        frame.setJMenuBar(menuBar);
        //Create a ToolBar
        JToolBar toolBar = new JToolBar();

        //Create play button and play code
        JButton playButton = createButton("Res/playbutton.png", 50, 25, "Play game");
        playButton.addActionListener(e -> {
            int result = JOptionPane.YES_OPTION;
            if (GameInProgress) {
                result = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new game?", "New Game", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.NO_OPTION) {
                    System.out.println("Do later");
                    return;
                }
            }
            board.clearBoard();
            panel.repaint();
            GameInProgress = true;
            win = false;
            currentStone = Stone.RED;
            selectedGame(selectedMode);
            System.out.println(selectedMode.toString());
            if(selectedMode == GameMode.Human_VS_Human){
                message.setText("You selected human vs human and it is Player1's turn");
                player1 = new HumanPlayer(Stone.RED, promptName(Stone.RED),null);
                setPlayer1(player1);
                player2 = new HumanPlayer(Stone.BLUE, promptName(Stone.BLUE),null);
                setPlayer2(player2);
            } else if(selectedMode == GameMode.Human_VS_Computer){
                message.setText("You selected human vs computer and it is Player1's turn");
                player1 = new HumanPlayer(Stone.RED, promptName(Stone.RED), null);
                setPlayer1(player1);
                player2 = new ComputerPlayer(Stone.BLUE);
                setPlayer2(player2);
            }
            if (!GameInProgress) {
                message.setText("Red players turn");
            }
        });

        //Create clear button with code to clear board
        JButton clearButton = createButton("Res/Screenshot (3338).png", 40, 25, "Clear board");
        clearButton.addActionListener((e) -> {
            board.clearBoard();
            panel.repaint();
        });

        //Create exit button with exit code
        JButton exitButton = createButton("Res/Screenshot (3337).png", 20, 25, "Exit game");
        exitButton.addActionListener(e -> System.exit(0));

        //Add buttons to toolBar
        toolBar.add(playButton);
        toolBar.add(clearButton);
        toolBar.add(exitButton);

        //Create JComboBox for gameMode selection
        JComboBox<GameMode> gameModeComboBox = createGameModeComboBox();

        //Create topPanel to hold toolbar
        JPanel topPanel;
        topPanel = new JPanel(new BorderLayout());
        topPanel.add(toolBar, BorderLayout.CENTER);
        topPanel.add(gameModeComboBox,BorderLayout.EAST);
        topPanel.setSize(new Dimension(15,15));
        // add the top panel to the top region of the frame
        frame.add(topPanel, BorderLayout.NORTH);

        //Create bottomPanel for messages
        JPanel bottomPanel;
        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(message, BorderLayout.SOUTH);
        bottomPanel.setBackground(Color.BLACK);
        bottomPanel.setSize(new Dimension(15,15));
        //Add bottom panel to the bottom region of the frame
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    /**
     * Template for button creation
     * @param imagePath the path of the image
     * @param width designated width of image
     * @param height designated height of image
     * @param tooltip Chosen tooltip representation
     * @return designated custom button with icon
     */
    public JButton createButton(String imagePath, int width, int height, String tooltip) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); // set the desired width and height
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        JButton button = new JButton(scaledIcon);
        button.setToolTipText(tooltip);
        return button;
    }
    /**
     Creates and returns a JComboBox of type GameMode,
     @return the created JComboBox of type GameMode
     */
    private JComboBox<GameMode> createGameModeComboBox() {
        JComboBox<GameMode> comboBox = new JComboBox<>();
        comboBox.setPreferredSize(new Dimension(200, 50));
        comboBox.addItem(GameMode.Human_VS_Human);
        comboBox.addItem(GameMode.Human_VS_Computer);
        comboBox.setBorder(BorderFactory.createTitledBorder("Select Game-Mode:"));
        comboBox.addActionListener(e -> selectedMode = (GameMode) comboBox.getSelectedItem());
        return comboBox;
    }
    /**
     * Deals with mouseClick and contains the majority of the game logic
     * @param x x-spot clicked on grid
     * @param y y-spot clicked on grid
     */
    public void handleMouseClick(int x, int y) {
        // Calculate the row and column of the clicked cell
        int squareSize = Math.min(panel.getWidth(), panel.getHeight()) / 15;
        int xOffset = (panel.getWidth() - 15 * squareSize) / 2;
        int yOffset = (panel.getHeight() - 15 * squareSize) / 2;
        clickedCol = (y - yOffset) / squareSize;
        clickedRow = (x - xOffset) / squareSize;
        if (board.isValidMove(clickedRow, clickedCol)) {
            board.placeStone(clickedRow, clickedCol, currentStone);
            if(selectedMode == GameMode.Human_VS_Human) {
                currentStone = (currentStone == Stone.RED) ? Stone.BLUE : Stone.RED;
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
            if(selectedMode == GameMode.Human_VS_Computer) {
                currentStone = Stone.BLUE;
                currentPlayer = player2;
                //displayComputerMove();
                if(!win) {
                    displayComputerMove();
                }
            }
            System.out.println(player1.getName());
            message.setText(currentStone.toString() + "'s turn");
            System.out.println(clickedRow + " " + clickedCol);
            if (board.isWinningMove(clickedRow, clickedCol)) {
                play("woohoo.wav");
                message.setText(currentPlayer.getName() + " wins");
                win = true;
            }
        }
        if(!win) {
            System.out.println(player1.getName());
            message.setText(currentStone.toString() + "'s turn");
            System.out.println(clickedRow + " " + clickedCol);
        }
        panel.repaint();
    }
    /**
     Displays the computer's move by calling the makeMove method of the current player and placing the stone on the board.
     If move is valid and leads to a win, displays message indicating current player as the winner.
     Otherwise, updates current player and displays a message indicating whose turn it is.
     If the move is invalid, prints a message to the console.
     */
    private void displayComputerMove() {
        int[] move;
        move = (currentPlayer).makeMove(board);
        if (board.isValidMove(move[0], move[1])) {
            board.placeStone(move[0], move[1], currentStone);
            if (board.isWinningMove(move[0], move[1])) {
                play("woohoo.wav");
                win = true;
                message.setText(currentPlayer.getName() + " wins");
            } else {
                currentStone = Stone.RED;
                currentPlayer = player1;
                message.setText(currentPlayer.getName() + "'s turn");
            }
        } else {
            System.out.println("Invalid move");
        }
        if (win) {
            message.setText(currentPlayer.getName() + " wins");
        }
    }
    /**
     * Simple method for storing gameMode
     * @param selectedMode chosen gameMode
     */
    public GameMode selectedGame(GameMode selectedMode){
        return selectedMode;
    }
    //Used for the playerPrompts
    public String promptName(Stone stone) {
        String playerName = JOptionPane.showInputDialog(frame, "Enter " + stone + " players' name:");
        return playerName;
    }
    //Getters and setters for updating player values
    public Player setPlayer1(Player player1){
        return player1;
    }
    public Player getPlayer1(){
        return player1;
    }
    public Player setPlayer2(Player player1){
        return player1;
    }
    public Player getPlayer2(){
        return player2;
    }
}