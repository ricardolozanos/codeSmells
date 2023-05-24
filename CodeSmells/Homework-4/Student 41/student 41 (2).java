package noapplet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.net.URL;

public class OmokGUI extends JFrame{
    private final Dimension DEFAULT_DIMENSION = new Dimension(551,670);
    private JPanel panelGame = new JPanel();
    private JTextArea text = new JTextArea();
    private BoardPanel board = new BoardPanel();
    private Game game = new Game();
    private String mode = "";
    private boolean gameOver;

    public OmokGUI() {
        this.setTitle("Omok");
        configureGui();
        setResizable(false);
    }
    // initializes the GUI
    private void configureGui() {
        this.setPreferredSize(DEFAULT_DIMENSION);
        this.setMinimumSize(new Dimension(400,500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        configureMenu();

        var panelMain = new JPanel();
        var panelTop = new JPanel();
        panelTop.setBorder(new EmptyBorder(5,0,72,0));
        panelMain.setLayout(new BorderLayout());
        panelTop.setLayout(new FlowLayout());

        board.setPreferredSize(new Dimension(DEFAULT_DIMENSION.width-100, DEFAULT_DIMENSION.height-120));
        panelGame.add(board);

        panelTop.add(new JLabel("Select Opponent"));
        var Human = new JRadioButton("Human",false);
        var Computer = new JRadioButton("Computer",false);
        var Play = new JButton("Play");

        Human.addActionListener(e -> {
            Computer.setSelected(false);
            Human.setSelected(true);
        });
        Computer.addActionListener(e -> {
            Human.setSelected(false);
            Computer.setSelected(true);
        });
        Play.addActionListener(e -> {
            if (Human.isSelected()) {
                panelTop.setVisible(false);
                mode = "1";
                configureTextPanel();
                text.setText("Black player choose a spot to place a stone\n");
            }
            if (Computer.isSelected()) {
                panelTop.setVisible(false);
                mode = "2";
                configureTextPanel();
            }
        });

        panelTop.add(Human);
        panelTop.add(Computer);
        panelTop.add(Play);

        panelMain.add(panelTop,BorderLayout.NORTH);
        panelMain.add(panelGame,BorderLayout.CENTER);
        this.setContentPane(panelMain);

        this.pack();
        this.setVisible(true);
    }
    // Adds the message box to the GUI
    private void configureTextPanel(){
        JPanel panelTop = new JPanel();

        text.setEditable(false);
        JScrollPane scroll = new JScrollPane(text);

        text.setPreferredSize(new Dimension(DEFAULT_DIMENSION.width-50,100));
        panelTop.add(scroll);

        this.add(panelTop,BorderLayout.NORTH);
        mouseInputConfiguration();
    }
    // Adds the menu bar
    public void configureMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        JMenuItem saveGame = new JMenuItem("Save");
        JMenuItem newGame = new JMenuItem("New");
        JMenuItem exit = new JMenuItem("Exit");

        menuBar.add(menu);
        menu.add(saveGame);
        menu.add(newGame);
        menu.add(exit);

        saveGame.setMnemonic('s');
        newGame.setMnemonic('n');
        exit.setMnemonic('e');

        saveGame.addActionListener(e -> {
            // save game code here
        });
        newGame.addActionListener(e -> {
            int input = JOptionPane.showConfirmDialog(null, "Start a new game?", "Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
            if(input == 0){
                text.setText("");
                board = new BoardPanel();
                game = new Game();
                mode = "";
                gameOver = false;
                configureGui();
            }
        });
        exit.addActionListener(e -> {
            int input = JOptionPane.showConfirmDialog(null, "Exit the game?", "Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
            if(input == 0){
                this.dispose();
            }
        });

        this.setJMenuBar(menuBar);
        configureToolbar(menuBar);
    }
    // Adds the toolbar
    public void configureToolbar(JMenuBar menu) {
        JToolBar toolBar = new JToolBar("Toolbar");
        try{
            JButton hint = new JButton(new ImageIcon(new ImageIcon(new URL("https://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/512/faq-icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT),"Save"));
            JButton undo = new JButton(new ImageIcon(new ImageIcon(new URL("https://icons.iconarchive.com/icons/icons8/windows-8/256/Computer-Hardware-Restart-icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT),"Restart"));

            hint.setBorder(new EmptyBorder(1,5,1,5));
            hint.setToolTipText("Hint move");
            undo.setBorder(new EmptyBorder(1,5,1,5));
            undo.setToolTipText("Undo Move");

            toolBar.add(hint);
            toolBar.add(undo);
            toolBar.setFloatable(false);
            menu.add(toolBar);

            hint.addActionListener(e -> {
                sendMessage("Suggested move: " + game.cheat());
            });
            undo.addActionListener(e -> {
                // undo action code here
            });
        }
        catch (Exception e){

        }
    }
    // Detects when a user Clicks and adds a token on the board
    private void mouseInputConfiguration() {
        board.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if(mode.equals("1"))
                    gameHuman((e.getX()+15)/30,(e.getY()+15)/30);
                else if (mode.equals("2")){
                    gameComputer((e.getX()+15)/30,(e.getY()+15)/30);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    // Logic for a game vs human opponent
    public void gameHuman(int x, int y){
        Color color;
        if(!gameOver){
            if(game.isBlackTurn()){text.setText("Black player choose a spot to place a stone\n");
                color = Color.BLACK;}
            else{text.setText("White player choose a spot to place a stone\n");
                color = Color.WHITE;
            }
            Boolean success = game.placeStone(x,y);
            if(success){
                board.placeStone(getGraphics(),color,x,y);
                text.setText("Last Placed Stone at " + x + "," + y + "\n");
                if(game.isBlackTurn()){sendMessage("Black player choose a spot to place a stone");}
                else{sendMessage("White player choose a spot to place a stone");
                }
            }
            gameOver = game.checkWin();
            if(gameOver){
                endGame();
            }
        }
    }
    // Logic for a game vs computer opponent
    public void gameComputer(int x, int y){
        if(!gameOver){
            if(game.isBlackTurn()) {
                sendMessage("Choose a spot to place a stone");
                Boolean success = game.placeStone(x,y);
                if(success){
                    board.placeStone(getGraphics(),Color.BLACK,x,y);
                }
            }
            else{
                int[] a = game.computerTurn();
                board.placeStone(getGraphics(),Color.WHITE,a[0],a[1]);
                text.setText("Last Placed Stone at "+a[0]+","+a[1]+"\n");
            }
            gameOver = game.checkWin();
            if(gameOver){
                endGame();
            }
        }
    }
    // End game sequence
    public void endGame(){
        if(game.isTie()){
            sendMessage("Its a Draw");
        }
        else if(game.isBlackTurn()){
            sendMessage("White wins");
        }
        else{
            sendMessage("Black wins");
        }
        sendMessage("GAME OVER");
        boolean[][] arr = game.highlightWinner();
        for(int x = 0; x < arr.length; x++){
            for(int y = 0; y < arr.length; y++){
                if(arr[x][y]){
                    board.placeStone(getGraphics(),Color.RED,x,y);
                }
            }
        }
    }
    // adds a message to the message box
    private void sendMessage(String s){
        text.append(s +"\n");
    }

}
