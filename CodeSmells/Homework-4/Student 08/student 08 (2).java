
import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;



public class Main extends NoApplet {
    public Main() {
        ImageIcon PLAY = new ImageIcon("play.webp");
        ImageIcon INFO = new ImageIcon("info.jpg");
        PLAY.setImage(PLAY.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));
        INFO.setImage(INFO.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));
        var frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(500, 600));

        frame.add(new JPanel(), BorderLayout.SOUTH);
        frame.add(new JPanel(), BorderLayout.EAST);
        frame.add(new JPanel(), BorderLayout.WEST);

        /** creates the board */
        BoardPanel board = new BoardPanel();
        board.addMouseListener(board);
        board.addMouseMotionListener(board);
        frame.add(board, BorderLayout.CENTER);

        /** Adds JMenuBar */
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        menu.setMnemonic(KeyEvent.VK_G);
        menu.getAccessibleContext().setAccessibleDescription("Game menu");
        menuBar.add(menu);
        JMenuItem menuItem = new JMenuItem("Play", KeyEvent.VK_P);
        menuItem.setIcon(PLAY);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Play a new game");
        menu.add(menuItem);
        JMenuItem menuItem2 = new JMenuItem("Info", KeyEvent.VK_I);
        menuItem2.setIcon(INFO);
        menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.ALT_DOWN_MASK));
        menuItem2.getAccessibleContext().setAccessibleDescription("About The Game");
        menu.add(menuItem2);


        /** adds Play and Opponent select */
        var north = new JPanel();
        north.setLayout(new BorderLayout());
        var PlayOpp = new JPanel();
        var play = new JButton("Play");
        var opp = new JLabel(" Opponent: ");
        var butG = new ButtonGroup();
        var human = new JRadioButton("Human");
        var cpu = new JRadioButton("Computer");

        var turn = new JLabel(" ");
        turn.setFont(new Font("Serif", Font.PLAIN, 20));

        butG.add(human);
        butG.add(cpu);

        PlayOpp.add(play);
        PlayOpp.add(opp);
        PlayOpp.add(human);
        PlayOpp.add(cpu);
        north.add(menuBar, BorderLayout.NORTH);
        north.add(PlayOpp, BorderLayout.CENTER);
        north.add(turn, BorderLayout.SOUTH);
        frame.add(north, BorderLayout.NORTH);

        play.addActionListener(e -> {
            if (human.isSelected()) {
                Player p1 = new Player("Player 1", Color.BLACK);
                Player p2 = new Player("Player 2", Color.white);
                board.start();
                turn.setText(p1.name() + " turn");

            }

            if (cpu.isSelected()) {
                board.start();
                turn.setText("VS CPU");

            }
        });

        menuItem.addActionListener(e -> {
           if(board.isStarted()) {
               int out = JOptionPane.showConfirmDialog(this, "Confirm Restart");
               if(out == 0) {
                   board.board.clear();
               }
           }
           else {
               JOptionPane.showMessageDialog(this, "Game not started");
           }

        });

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new Main());
    }

}