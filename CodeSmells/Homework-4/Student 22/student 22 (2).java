import javax.swing.*;
import java.awt.*;
// To-do, progress whose turn it is, About button
public class gameFrame extends JFrame {
    private final static Dimension DEFAULT_DIMENSION = new Dimension(400, 600);

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    // Global Var to access in other methods
    JPanel mainPanel = new JPanel(new GridBagLayout());
    String[] options = {"Human", "Computer"};
    JComboBox optionList = new JComboBox(options);
    boolean isVisible = false;

    /** create Game panel */
    public gameFrame() {
        this(DEFAULT_DIMENSION);
    }

    public gameFrame(Dimension dim) {
        super("Omok");
        setLayout(new BorderLayout());
        configureGui(dim);
        player1 = createPlayer("Player 1", Color.BLACK);
        player2 = createPlayer("Player 2", Color.RED);
        board = new Board(player1, player2); // pass player1 and player2 to the constructor
        if (board.isWonBy(player1)) {
            System.out.println("Player 1 wins!");
        }
        GridBagConstraints gbc = new GridBagConstraints();
        mainPanel.add(board, gbc);
        add(mainPanel, BorderLayout.CENTER); // add the mainPanel to the center of the frame

        // Hide Board until Play is selected
        mainPanel.setVisible(isVisible);

        setSize(dim);
        setLocationRelativeTo(null);
        setVisible(true);
        //resizeable false
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void configureGui(Dimension dim) {
        // Top menu Area
        var menuBar = new JMenuBar(); // Top menu Bar
        var menuPanel = new JPanel(); // Panel within Bar
        menuPanel.setLayout(new BorderLayout());
        menuPanel.add(new JLabel("Game"), BorderLayout.WEST);

        // toolbar ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        JToolBar toolbar = new JToolBar();
        JButton btn = new JButton();
        JButton btn2 = new JButton();
        JButton btn3 = new JButton();

        // Button Icons are incredibly microwaved but couldn't figure out how to resize button so resize image
        ImageIcon playIcon = new ImageIcon("res/PlayButton2Resized.png");
        ImageIcon aboutIcon = new ImageIcon("res/About.png");
        ImageIcon exitIcon = new ImageIcon("res/exit.png");
        btn.setFocusable(false);
        btn2.setFocusable(false);
        btn3.setFocusable(false);

        // Icons
        btn.setIcon(playIcon);
        btn2.setIcon(aboutIcon);
        btn3.setIcon(exitIcon);

        // TooltipText
        btn.setToolTipText("Start New Game"); // MUST START NEW GAME
        btn2.setToolTipText("About info");
        btn3.setToolTipText("Exit");

        // Button Actions (!EDIT THESE FOR FUTURE ACTIONS!)
        btn.addActionListener(e -> {
            // if game already running
            if(isVisible){
                int answer = JOptionPane.showConfirmDialog(null, "Are you sure you'd like to start a new game?", "Confirmation", JOptionPane.YES_NO_OPTION);
                // yes = 0, no = 1, X = -1
                if(answer == 0){
                    board.clear();
                    isVisible = false;
                    mainPanel.setVisible(isVisible);
                    optionList.setEnabled(true);
                }
            }
        });

        btn2.addActionListener(e -> {
            System.out.println("About selected");
            String omokDescription = "<html>Omok is a traditional Korean board game, also known as \"Five in a Row.\"<br>" +
                    "It is played on a grid of intersecting lines, typically 15x15 or 19x19. The game involves<br>" +
                    "two players taking turns placing black and white stones on the board's intersections.<br>" +
                    "The objective is to form an unbroken row of five stones horizontally, vertically, or<br>" +
                    "diagonally. The player who achieves this goal first wins the game. Omok is known for<br>" +
                    "its simplicity and strategic depth, providing an engaging and enjoyable experience<br>" +
                    "for players of all ages.</html>";
            JOptionPane.showMessageDialog(null, omokDescription, "About Omok", JOptionPane.INFORMATION_MESSAGE);
        });



        btn3.addActionListener(e -> { // exit button works
            this.dispose();
        });

        toolbar.add(btn);
        toolbar.add(btn2);
        toolbar.add(btn3);
        menuPanel.add(toolbar, BorderLayout.SOUTH);
        // end Toolbar ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // Add Selection
        var selectPanel = new JPanel();
        var playButton = new JButton("Play");
        playButton.setFocusable(false);
        playButton.setToolTipText("Start Game");

        // JComboBox
        JLabel opponent = new JLabel("Opponent: ");
        selectPanel.add(playButton);
        selectPanel.add(opponent);
        selectPanel.add(optionList);

        playButton.addActionListener(e -> {
            if(!isVisible) {
                // Make board Visible
                isVisible = true;
                mainPanel.setVisible(isVisible);
                optionList.setEnabled(false);
            }
        });

        optionList.addActionListener(e -> { // Possibly add on to this later
            if(optionList.getSelectedItem() == "Computer"){ // Implement Bot?
                System.out.println("Computer was selected (TEST)");
            }
            if(optionList.getSelectedItem() == "Human"){ // just continue?
                System.out.println("Human was selected (TEST)");
            }
        });

        setContentPane(selectPanel);

        // put them together
        menuBar.add(menuPanel);
        setJMenuBar(menuBar);
    }

    /** create Player objects */
    public Player createPlayer(String name, Color color) {
        return new Player(name, color);
    }
}
