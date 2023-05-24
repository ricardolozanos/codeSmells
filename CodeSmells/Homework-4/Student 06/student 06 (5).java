import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Objects;

public class OmokGUI extends JFrame{
    private int mode;
    private Board board;
    public BoardPanel boardPanel;
    private JLabel cp;
    private JPanel s;
    public OmokGUI(Board board) {
        setTitle("Omok");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(520, 590));
        pack();
        this.board = board;
        setLayout(new BorderLayout());
        boardPanel = new BoardPanel(board);
        add(boardPanel, BorderLayout.CENTER);
        JPanel north = new JPanel();
        cp = new JLabel();
        JLabel selOp = new JLabel("Select Opponent:");
        String[] optns = {"Human", "Computer"};
        JComboBox<String> opps = new JComboBox<>(optns);
        JButton play = new JButton("Play");
        north.add(selOp);
        north.add(opps);
        north.add(play);
        add(north, BorderLayout.NORTH);
        play.addActionListener(e -> {
            setMode((String) opps.getSelectedItem());
            s.add(cp);
            if(board.gameStarted()){
                int confirm = JOptionPane.showConfirmDialog(this, "Start new game?", "Confirm", JOptionPane.OK_CANCEL_OPTION);
                if (confirm == JOptionPane.OK_OPTION) {
                    board.resetBoard();
                    boardPanel.play();
                    boardPanel.repaint();
                }
            }
            else{
                boardPanel.play();
                revalidate();
                play.setText("Start a New Game");
            }
        });
        s = new JPanel();
        s.setPreferredSize(new Dimension(getWidth(), 30));
        add(s, BorderLayout.SOUTH);
//
        JMenuBar menu = new JMenuBar();
        setJMenuBar(menu);
        JMenu omokMenu = new JMenu("OMOK Game");
        omokMenu.setMnemonic(KeyEvent.VK_M); // Set the mnemonic to 'M'
        menu.add(omokMenu);
        JMenuItem ng = new JMenuItem("New Game", KeyEvent.VK_N);
        ng.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        ng.addActionListener(e -> {
            setMode((String) opps.getSelectedItem());
            s.add(cp);
            if(board.gameStarted()){
                int confirm = JOptionPane.showConfirmDialog(this, "Start new game?", "Confirm", JOptionPane.OK_CANCEL_OPTION);
                if (confirm == JOptionPane.OK_OPTION) {
                    board.resetBoard();
                    boardPanel.play();
                    boardPanel.repaint();
                }
            }
            else{
                boardPanel.play();
                revalidate();
                play.setText("Start a New Game");
            }
        });
        omokMenu.add(ng);

        URL iconUrl = getClass().getResource("omok.jpg");
        assert iconUrl != null;
        ImageIcon menuIcon = new ImageIcon(iconUrl);
        Image image = menuIcon.getImage();
        Image scale = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledMenuIcon = new ImageIcon(scale);
        omokMenu.setIcon(scaledMenuIcon);
        // Toolbar/Tooltip
        JToolBar westToolbar = new JToolBar();
        JToolBar eastToolbar = new JToolBar();
        JButton newButton = new JButton();
        newButton.setToolTipText("Change board color");
        URL bicon = getClass().getResource("menu.png");
        assert bicon != null;
        ImageIcon buttonIcon = new ImageIcon(bicon);
        Image bimage = buttonIcon.getImage();
        Image bscale = bimage.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        ImageIcon scaledBicon = new ImageIcon(bscale);
        newButton.setIcon(scaledBicon);
        westToolbar.add(newButton);
        add(westToolbar, BorderLayout.WEST);
        add(eastToolbar, BorderLayout.EAST);
        pack();
        setVisible(true);
    }
    public void winner(Player p){
        if(boardPanel.getCond()) {
            cp.setText("Player " + p.getpNum() + " has won!");
            revalidate();
            repaint();
        }

    }
    public void setCurrentPlayerLabel() {
        cp.setText("Player " + boardPanel.getCurrPlayer() + " turn.");
    }
    public void tie(){
        if(boardPanel.getCond()) {
            s.add(new JLabel("Its a TIE!"), BorderLayout.SOUTH);
            s.repaint();
            revalidate();
            repaint();
        }
    }
    public void setMode(String player){
        if(Objects.equals(player, "Human")){
            mode = 2;
        }
        else{
            mode = 1;
        }
    }

    public int getMode(){
        return mode;
    }
//    public static void main(String[] args) {
//        Board board = new Board(15);
//        javax.swing.SwingUtilities.invokeLater(() -> new OmokGUI(board));
//    }
}