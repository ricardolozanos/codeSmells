import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
/**
* Class that shows an Omok GUI 
*/
class GUIOmok extends JFrame {
    BoardPanel boardPanel;
    JLabel outPutText;
    JComboBox dropDownBox;
    JButton play;
    JMenuBar menuBar;
    JToolBar movingTool;
    JButton playIcon;
    JButton about;
    JMenu menu;
    JMenuItem menuPlay;
    JMenuItem menuAbout;
    JMenuItem menuExit;
    OmokInterface listener;

    Color[] stoneColors = {Color.WHITE,Color.BLACK };
    int[] currPos = {-1, -1};
   
	public GUIOmok(){
        super("Omok");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this is the main panel(superPanel)
        JPanel superPanel = new JPanel();
        superPanel.setLayout(new BorderLayout()); 
        superPanel.setPreferredSize(new Dimension(450, 600));

        //this is the menuPanel with the JmenuBar on the top left located NORTh of selection Panel
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        ImageIcon bluePlay = new ImageIcon("play.png");
        playIcon = new JButton(bluePlay);
        ImageIcon blueQuestion = new ImageIcon("question.png");
        about = new JButton(blueQuestion);


        menuBar = new JMenuBar();
        menu = new JMenu("Game");
        menu.setMnemonic(KeyEvent.VK_M);
        menuBar.add(menu);
        //Creating menu ITEMS
        menuPlay = new JMenuItem("Play", KeyEvent.VK_P); // add image Icon in constructors for image menu items 
        menuPlay.setIcon(bluePlay);
        menuPlay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK)); 
        menuPlay.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");//set action event
        menu.add(menuPlay);

        menuAbout = new JMenuItem("About", KeyEvent.VK_A);
        menuAbout.setIcon(blueQuestion);
        menuAbout.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_A, ActionEvent.ALT_MASK));
        menuAbout.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");//set action event
        menu.add(menuAbout);
        
        menuExit = new JMenuItem("Exit", KeyEvent.VK_G);
        menuExit.setBackground(Color.CYAN);
        menuExit.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_G, ActionEvent.ALT_MASK));
        menuExit.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");//set action event
        menu.add(menuExit);
        
        menuPanel.add( menuBar,BorderLayout.WEST);// sets the menubar in the west of the menuPanel
        
        //selection panel located in the north of the superPanel, contains menuPanel, tool panel, style panel
        JPanel selection = new JPanel();
        selection.setLayout(new BorderLayout());
        JPanel tool = new JPanel();
        tool.setLayout(new BorderLayout());

        movingTool = new JToolBar();
        movingTool.setFloatable(true);
        movingTool.setBorderPainted(true);
        movingTool.add(playIcon);
        movingTool.add(about);
        tool.add(movingTool,BorderLayout.WEST);
        JPanel style = new JPanel();
        style.setLayout(new BorderLayout());
        JPanel select = new JPanel();
        select.setLayout(new BorderLayout());

        String[] gameType = {"Human","Computer"};
        dropDownBox = new JComboBox(gameType);
        outPutText =  new JLabel();//will show comments to the user
        JLabel selectionLabel = new JLabel("Select Opponent: ");
        play = new JButton("Play");

        style.add(play, BorderLayout.WEST);
        select.add(selectionLabel,BorderLayout.WEST);
        select.add(dropDownBox,BorderLayout.CENTER); // selection label dropdown play
        style.add(select, BorderLayout.CENTER);


        selection.add(style,BorderLayout.SOUTH);//selectionLabel,dropdown.CENTER
        selection.add(tool,BorderLayout.CENTER);//(panel)toolbar/menu/play.NORTH
        selection.add( menuPanel,BorderLayout.NORTH);
 
        //boardPanel on Center of OG panel
        JPanel centerBoard = new JPanel();
        centerBoard.setLayout(new FlowLayout());
        boardPanel = new BoardPanel(currPos);
        //boardPanel.setPreferredSize(new Dimension(405, 405));
    
        centerBoard.add(outPutText);
        centerBoard.add(boardPanel);
        
        superPanel.add(selection,BorderLayout.NORTH);
        superPanel.add(centerBoard,BorderLayout.CENTER);
         
        setContentPane(superPanel);
        pack();
        setVisible(true);
     

	}
     
    /**
     * Manages each button's action and mouse motions.
     * @param listener whill handle button action or mouse action.
     */
    public void addIOListener(OmokInterface listener) {
        this.listener = listener;
        //All Play Buttons
        play.addActionListener( e-> {
           listener.play();
        });
        playIcon.addActionListener(e->{
            listener.play();
        });
        menuPlay.addActionListener( e-> {
            listener.play();
        });

        //about button 
        about.addActionListener(e->{
            listener.about();
        });
        menuAbout.addActionListener(e->{
            listener.about();
        });
        //exit button
        menuExit.addActionListener(e->{
            listener.endGame();
        });
        
        // Board controlls
        boardPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if( listener.moveSelected(currPos[0], currPos[1]) ){
                    boardPanel.repaint();
                }

            }
        });

        boardPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) { 
                if(listener.gameStart()){
                    int mouseX = e.getX();
                    int mouseY = e.getY();
                    int size = boardPanel.getWidth();
                    int gridSize = size / 15;
                    // Calculate the row and column of the intersection the mouse is closest to
                    int row = Math.round((float) mouseY / gridSize);
                    int col = Math.round((float) mouseX / gridSize);
                    if (row >= 1 && row < 15 && col >= 1 && col < 15) {
                        currPos[0] = row;
                        currPos[1] = col;
                        boardPanel.repaint();
                    }

                }
            }
        });
    }

    /**
     * Gets game type from the dropDownBox.
     * @return String The selected game type 
     */
    public String getOpponent(){
        return dropDownBox.getSelectedItem().toString();
    }

    /**
     * Resets the board for a new game
     */
    public void resetBoard(){
        boardPanel.placements = new ArrayList<BoardPanel.Placement>();
        repaint();
    }

    /**
     * Places the stone of the current player.
     * @param x,y,player    x-coordinates,y-coordinates, current player.
     */
    public void addStone(int x, int y, int player){
        boardPanel.addPlacement(x, y, player);
        repaint();
    }

    /**
     * Places the stone of the current player.
     * @param places  ArrayList<Board.Place> places.
     */
    public void highLight(ArrayList<Board.Place> places){
        for(Board.Place p : places){
            boardPanel.addPlacement(p.x, p.y, 2);
        }
        repaint();
    }

    /**
     * Displays any given string as text
     * @param text  any given to text to understand the game's order.
     */
    public void show(String text) {
        outPutText.setText(text);
    }

    /**
     * Displays question to star a new game.
     * @param msg double checking if the user wants to start a new game.
     * @return int number indicating yes,no, or cancel.
     */
    public int warn(String msg){
        int choice = JOptionPane.showConfirmDialog(this, msg, "Omok", JOptionPane.YES_NO_CANCEL_OPTION) ; 
        return choice;    
    }

    /**
     * Displays game rules.
     * @param msg game rules
     */
    public void info(String msg){
        JOptionPane.showMessageDialog(this,msg);
    }


}
