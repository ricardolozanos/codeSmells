import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * OmokGUI will interact with the controller, the user and the BoardPanel
 * @author Estrella Lara
 * @since 04/06/2023
 */

public class OmokGUI extends JFrame implements ActionListener {
    /**
     *
     * about - will give information about the game to the user
     * play - will start a new game
     * play2 - will start a new game
     */
    JButton play,play2,about;
    /**
     *
     * mainMsg - will be the Label used to inform the user of what it is expected for them to do
     */
    JLabel mainMsg = new JLabel();
    /**
     *
     * mode groups buttons play, human and computer
     */
    ButtonGroup mode;
    /**
     *
     * north panel will be placed on the top of the frame, it will include the menuTool and gameMode panels
     */
    JPanel north = new JPanel();
    /**
     *
     * south panel will be placed on the bottom of the frame, it will include the boardPanel
     */
    JPanel south = new JPanel();
    /**
     *
     * menuTool stores de JMenuBar and JToolBar
     */
    JPanel menuTool = new JPanel();
    /**
     *
     * gameMode has 3 JButtons, play, human and computer
     */
    JPanel gameMode = new JPanel();
    /**
     *
     * This will be the main board of the game
     */
    Board board = new Board();
    /**
     *
     * This is the panel representing the current board
     */
    BoardPanel boardPanel = new BoardPanel(board);
    /**
     *
     * True is there is an ongoing game, false if not
     */
    Boolean gameGoing = false;
    /**
     *
     * Stores the game mode
     */
    int gameModeInt = 0;

    /**
     * Default constructor of OmokGUI
     */
    public OmokGUI() {
        super("Omok");
        //Here we set the dimensions of the frame and its default close operations
        setPreferredSize(new Dimension(425, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //north JPanel
        add(north, BorderLayout.NORTH);
        north.setLayout(new BorderLayout());
        north.add(gameMode,BorderLayout.SOUTH);
        north.add(menuTool, BorderLayout.WEST);

        //gameMode JPanel
        gameMode.setPreferredSize(new Dimension(400,100));

        //Button to start game, it will display the opponent that was selected if clicked
        play = new JButton("Play");
        play.addActionListener(this);
        gameMode.add(play);

        //Create a JLabel to ask the user to select an opponent
        gameMode.add(new JLabel("Select opponent: "));

        //Group JRadioButtons in mode so that only one is selected
        mode = new ButtonGroup();
        JRadioButton human = new JRadioButton("Human");
        human.setActionCommand("Human opponent");
        JRadioButton computer = new JRadioButton("Computer");
        computer.setActionCommand("Computer opponent");
        mode.add(human);
        mode.add(computer);
        gameMode.add(human);
        gameMode.add(computer);

        //menuTool JPanel
        menuTool.setPreferredSize(new Dimension(100,60));
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Game");
        menu.setMnemonic(KeyEvent.VK_G);
        menu.getAccessibleContext().setAccessibleDescription("Game menu");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("Play", KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Play a new game");
        //menuItem.addActionListener(…);
        menu.add(menuItem);
        menuTool.add(menu);

        JToolBar toolBar = new JToolBar("Omok");
        play2 = new JButton("▶");
        play2.addActionListener(this);
        toolBar.add(play2);
        about = new JButton("?");
        about.addActionListener(this);
        toolBar.add(about);
        menuTool.add(toolBar);



        //south
        add(south,BorderLayout.CENTER);
        south.add(boardPanel);

        //Make the Panel visible
        pack();
        setVisible(true);
    }
    /**
     * Shows welcome message to user
     */
    public void welcome(){
        mainMsg.setText("<html>Welcome to Omok!<br/>Please select an opponent</html>");
        gameMode.add(mainMsg);
        pack();
        setVisible(true);
    }
    /**
     * Asks the user to place next stone
     * @param player in turn
     */
    public void nextMove(Player player){
        mainMsg.setText(player.getPlayerName()+"'s turn, place a stone");
        gameMode.add(mainMsg);
        pack();
        setVisible(true);
    }
    /**
     * Asks the user to enter another move, one that it is valid
     */
    public void invalidMove(){
        mainMsg.setText("Invalid move, please try again");
        gameMode.add(mainMsg);
        pack();
        setVisible(true);
    }
    /**
     * Shows game over message and tell the winner, if any
     * @param player is the winner
     */
    public void gameOver(Player player){
        mainMsg.setText("<html>GAME OVER<br/>" + player.getPlayerName() + "<html>wins!<html>");
        gameMode.add(mainMsg);
        pack();
        setVisible(true);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==play || e.getSource()==play2){
            //If no opponent selected, it will ask the user to choose one
            if(mode.getSelection()==null){
                mainMsg.setText("No opponent selected");
            }
            //If there is an opponent selected, it will display it
            else {
                mainMsg.setText(mode.getSelection().getActionCommand());
                if(mode.getSelection().getActionCommand().equals("Human opponent")){
                    gameModeInt = 1;
                }
                else{gameModeInt = 2;}
                gameGoing = true;
                boardPanel.enableMouse = true;

            }
            //Add label to panel and make it visible
            gameMode.add(mainMsg);
            pack();
            setVisible(true);
            //start game
        }
        if(e.getSource()==about){
            mainMsg.setText("<html>Welcome to Omok! This is an abstract strategy board game<br/> played  in a go board of 15x15. The two players alternate and<br/>place their stones on an empty intersection. The winner is the<br/>first player to create an unbroken row of five stones.</html>");
            gameMode.add(mainMsg);
            pack();
            setVisible(true);
        }
    }
}

