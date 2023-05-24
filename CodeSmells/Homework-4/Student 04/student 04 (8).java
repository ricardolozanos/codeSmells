package HW4_GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import HW4_GUI.console.Board;


public class Main extends JFrame {
    
    private static final String IMAGE_DIR = "images/";
    private JComboBox<String> comboBox;
    private BoardPanel boardPanel;
    private BoardController controller;

    public Main(BoardPanel boardPanel){
        super("Omok Game");
        this.boardPanel = boardPanel;
        this.controller = new BoardController(this.boardPanel, this.boardPanel.getBoard(), 1);
        configureUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 500);
        setVisible(true);
    }
    
    /**
     * Configures UI for the Omok game
     */
    private void configureUI(){
        setLayout(new BorderLayout());
        add(createNorthPanel(), BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);
    }

    /**
     * Creates the north panel
     * @return northPanel
     */
    private JPanel createNorthPanel() {
        JPanel northPanel = new JPanel(new BorderLayout());
        createMenu();
        northPanel.add(createToolBar(), BorderLayout.NORTH);
        northPanel.add(createComboBox(), BorderLayout.CENTER);
        northPanel.add(boardPanel.getJLabel(), BorderLayout.SOUTH);
        return northPanel;
    }

    /**
     * Creates the menu with menu items
     */
    private void createMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");

        menu.setMnemonic(KeyEvent.VK_G);
        menu.getAccessibleContext().setAccessibleDescription("MENU");
        menuBar.add(menu);

        JMenuItem playMenuItem = new JMenuItem(new OmokAction("Play", createImageIcon("play.png"),
        "Start a new game", KeyEvent.VK_N, KeyEvent.VK_N, this::startGame));

        JMenuItem infoMenuItem = new JMenuItem("About", KeyEvent.VK_N);
        infoMenuItem.setIcon(createImageIcon("config.png"));

        JMenuItem exitMenuItem = new JMenuItem(new OmokAction("Exit", null,
        "Exit the game", KeyEvent.VK_X, KeyEvent.VK_Q, this::exitGame));

        menu.add(playMenuItem);
        menu.add(infoMenuItem);
        menu.add(exitMenuItem);

        setJMenuBar(menuBar);
        setVisible(true);
        setJMenuBar(menuBar);
    }

    /**
     * Creates the toolbar
     * @return toolbar panel
     */
    private JPanel createToolBar(){
        JPanel panel = new JPanel();
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(true);
        toolBar.addSeparator();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        
        JButton playButton = new JButton(new OmokAction("", createImageIcon("play.png"), 
        "Play a new game", KeyEvent.VK_N, KeyEvent.VK_N, this::startGame));

        JButton infoButton = new JButton(new OmokAction("", createImageIcon("config.png"), 
        "About", KeyEvent.VK_1, KeyEvent.VK_2, null));

        toolBar.add(playButton);
        toolBar.add(infoButton);

        panel.add(toolBar);
        return panel;
    }

    /**
     * Creates the combo box
     * @return combo box panel
     */
    private JPanel createComboBox(){
        JPanel panel = new JPanel();
        JButton playButton = new JButton(new OmokAction("Play", null, 
        "Play a new game", KeyEvent.VK_N, KeyEvent.VK_N, this::startGame));

        panel.add(playButton);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.add(new JLabel(" Opponent:"));

        comboBox = new JComboBox<>(new String[] { "Human", "Computer" });
    
        panel.add(comboBox);
        return panel;
    }

    /**
     * Starts a new game if the user clicks the "Play" button or menu item, also sets the opponent type to human or computer
     */
    private void startGame(){
        int result = JOptionPane.showConfirmDialog(null, "Do you want to start a new game?", "Omok", JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION){
            boardPanel.initializeBoard();
            controller.setCurrentPlayer(controller.getPlayer1());
            String opponentType = (String) comboBox.getSelectedItem();
            if(opponentType.equals("Computer")){
                boardPanel.getNewOpponent(2);
            }else{
                boardPanel.getNewOpponent(1);
            }
            boardPanel.placeStone(true);
            boardPanel.hoveringEffect(true);
        }
       
    }

    /**
     * Exits the game if the user clicks the "Exit" button or menu item
     */
    private void exitGame() {
        int result = JOptionPane.showConfirmDialog(null, "Do you want to exit the game?", "Omok", JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }


    /** Create an image icon from the given image file. */
    private ImageIcon createImageIcon(String filename) {
        URL imageUrl = getClass().getResource(IMAGE_DIR + filename);
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        }
        return null;
    }

    public static void main(String[] args) {
        Board board = new Board(15);
        BoardPanel boardPanel = new BoardPanel(board);
        new Main(boardPanel);
    }


}
