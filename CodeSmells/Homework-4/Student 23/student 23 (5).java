import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Objects;


public class Omok_GUI {

    public Omok_GUI() {
        // Frame
        JFrame frame = new JFrame("Omok");
        frame.setLayout(new BorderLayout());
        frame.setSize(new Dimension(800, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Bottom Panel - Msg Bar
        JPanel bottom_panel = new JPanel();
        JLabel msg = new JLabel("   Msg:  ");
        bottom_panel.add(msg);
        bottom_panel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        bottom_panel.setLayout(new BoxLayout(bottom_panel, BoxLayout.X_AXIS));
        JLabel msg_bar = new JLabel();
        bottom_panel.add(msg_bar);
        frame.add(bottom_panel, BorderLayout.SOUTH);

        // Board
        Board board = new Board();
        Board_Panel board_GUI = new Board_Panel(board, msg_bar);
        frame.add(board_GUI);

        // Top Panel - ComboBox

        JComboBox<Object> opponent_list = new JComboBox<>();
        opponent_list.addItem("Human");
        opponent_list.addItem("Computer");

        // MenuBar -> Menu -> Menu Items
        Icon menu_icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("orange_button.png")));
        JMenuBar menu_bar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menu.setIcon(menu_icon);
        menu.setMnemonic('M');
        JMenuItem item = new JMenuItem("Play");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.SHIFT_DOWN_MASK));
        item.addActionListener( new AbstractAction("Toggle Menu") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                if (JOptionPane.showConfirmDialog(board_GUI,"Would You Like To Start A New Game?", "", JOptionPane.YES_NO_OPTION) == 0) {
                    String opponent = (String) opponent_list.getSelectedItem();
                    if(opponent != null) {
                        msg_bar.setText("You Selected " + opponent + " As Your Opponent!");
                        if(opponent.equals("Computer")) {
                            board_GUI.setIsAiGame(true);
                            board_GUI.clearBoard();
                        }
                        else {
                            board_GUI.setIsAiGame(false);
                            board_GUI.clearBoard();
                        }
                    }
                }
            }
        });

        menu.add(item);
        menu_bar.add(menu);
        frame.setJMenuBar(menu_bar);

        // Top Panel - Tool Bar, Button, and Label
        JPanel top_panel = new JPanel();
        top_panel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        Icon play_icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("play_button.png")));
        JToolBar tb = new JToolBar();
        tb.setToolTipText("Move The Tool Bar Wherever You'd Like");
        JPanel tb_panel = new JPanel();
        JButton b1 = new JButton("Play");
        b1.addActionListener( new AbstractAction("New Game") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                if (JOptionPane.showConfirmDialog(board_GUI,"Would You Like To Start A New Game?", "", JOptionPane.YES_NO_OPTION) == 0) {
                    String opponent = (String) opponent_list.getSelectedItem();
                    if(opponent != null) {
                        msg_bar.setText("You Selected " + opponent + " As Your Opponent!");
                        if(opponent.equals("Computer")) {
                            board_GUI.setIsAiGame(true);
                            board_GUI.clearBoard();
                        }
                        else {
                            board_GUI.setIsAiGame(false);
                            board_GUI.clearBoard();
                        }
                    }
                }
            }
        });
        b1.setIcon(play_icon);
        tb_panel.add(b1);
        tb.add(tb_panel);
        top_panel.add(tb, BorderLayout.SOUTH);

        frame.add(top_panel, BorderLayout.NORTH);
        top_panel.setLayout(new BoxLayout(top_panel, BoxLayout.X_AXIS));

        top_panel.add(new JLabel("  Select Opponent:  "));

        top_panel.add(opponent_list);


        // Frame Settings
        frame.pack();
        frame.setVisible(true);
    }

}
