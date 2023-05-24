package OmokBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class OmokGui extends JDialog{
    private static final Dimension DEFAULT_DIMENSION = new Dimension(320, 425);
    player p = new player();

    Board b = new Board();
    JPanel game = new BoardPanel(b);


    public OmokGui(){
        this(DEFAULT_DIMENSION);
    }

    public OmokGui(Dimension dim) {
        super((JFrame) null,"Omok");
        configureGui();
        setSize(dim);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    private void configureGui(){
        setJMenuBar(addMenuBar());
        add(addToolBar(),BorderLayout.NORTH);
        add(game,BorderLayout.CENTER);
        add(addBottomBar(),BorderLayout.SOUTH);


    }

    public JMenuBar addMenuBar(){

        var menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        menu.setMnemonic(KeyEvent.VK_G);
        menu.getAccessibleContext().setAccessibleDescription("Game menu");
        menuBar.add(menu);
        JMenuItem menuItem = new JMenuItem("Play", KeyEvent.VK_P);
        menuItem.setText("Play");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Play a new game");
        menuItem.addActionListener(e -> playButtonClicked());
        menu.add(menuItem);
        menuBar.add(menu);
        return menuBar;

    }
    public JToolBar addToolBar() {
        var toolbar = new JToolBar();
        String playerString = ("Player Selected");
        String computerString = ("Computer Selected");
        var text = new JTextField(20);
        text.setEditable(false);

        JRadioButton playerButton = new JRadioButton("Player");
        JRadioButton computerButton = new JRadioButton("Computer");
        JButton play = new JButton("Play!");


        ButtonGroup group = new ButtonGroup();
        group.add(playerButton);
        group.add(computerButton);

        toolbar.add(playerButton);
        toolbar.add(computerButton);
        toolbar.add(play);
        toolbar.add(text);
        play.addActionListener(e -> {
            if (playerButton.isSelected()) {
                text.setText(playerString);
                toolbar.add(text);
            } else {
                text.setText(computerString);
                toolbar.add(text);
            }
        });
        return toolbar;
    }
    public JToolBar addBottomBar(){
        var toolBar = new JToolBar();
        var whoseTurn = new JTextField();
        whoseTurn.setText(p.getPlayerNum());
        toolBar.add(whoseTurn);
        whoseTurn.setText("Player: " + controller.currentPlayer.getPlayerNum());
        whoseTurn.setEditable(false);
        return toolBar;
    }
    private void playButtonClicked() {
        if (isGameOver()) {
            startNewGame();
        } else {
            if (JOptionPane.showConfirmDialog(OmokGui.this, "Play a new game?", "Omok", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                startNewGame();
            }
        }
    }
    public boolean isGameOver(){
        if(b.isFull()){
            return true;
        }
        return b.hasWon(p);
    }

    public void startNewGame(){
        b.clear();
        game.repaint();

    }



}
class BoardPanel extends JPanel {

    /** Board to be painted.*/
    private final Board board;

    public int mouseX;
    public int mouseY;
    List<BoardPanel.BoardChangeListener> listeners = new ArrayList();


    public BoardPanel(Board board) {

        this.board = board;

    }
    public interface BoardChangeListener {

        /** Called when a stone is placed at a place by a player. */
        void stonePlaced(int x, int y, player player);

    }
    public void drawStone(Graphics g,int x,int y,player currentPlayer){
        if(currentPlayer.getPlayerNum() == "1"){
            g.setColor(Color.BLACK);
        }
        else{
            g.setColor(Color.WHITE);
        }
        g.fillOval(x,y,25,25);
    }

    public void placeClicked(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();

            }

        });
    }



    @Override
    protected void paintComponent(Graphics g) {
        Dimension d = this.getSize();
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.BLACK);

        int x = 0;
        for (int i = 1; i <= board.getSize(); i++) {
            x = x + 20;
            g.drawLine(x, 0, x, d.height);
        }
        int y = 0;
        for (int i = 1; i <= board.getSize(); i++) {
            y = y + 20;
            g.drawLine(0, y, d.width, y);
        }
        drawStone(g, x, y, controller.currentPlayer);



    }
}

