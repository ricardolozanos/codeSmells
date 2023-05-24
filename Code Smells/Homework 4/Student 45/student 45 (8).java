package guiboard.panels;

import guiboard.logic.BoardPanel;
import guiboard.logic.BoardStrategyPanel;
import guiboard.modelgui.Boarder;
import guiboard.modelgui.BoardGui;

import javax.swing.*;
import java.awt.*;

/** Contains Panels that are most accessed by the user. */

public class MainPanel extends JPanel {
    protected Boolean gameStarted = false;
    public MainPanel(){
        var panel = new JPanel(new BorderLayout());

        var dialog = new Dialog();
        setLayout(new BorderLayout());
        var game = new JPanel(new BorderLayout());

        var button = new JButton("Play");
        var board = new BoardGui();
        game.add(board,BorderLayout.CENTER);

        //Selection of Opponent
        var opponents = new JPanel();
        String[] players = {"Select opponent","Human","Computer"};
        var opp = new JLabel("Opponent:");
        opponents.add(opp);
        var opponent = new JComboBox<>(players);
        opponents.add(opponent);

        //Turn of Player
        var turn = new JLabel("Choose an Opponent.");

        //Play, Action Listener chooses the type of board that will be used.
        button.addActionListener(e -> {
            String decider = (String)opponent.getSelectedItem();
            //JOptionPane.showConfirmDialog()
            if(Boolean.TRUE.equals(gameStarted)) {
                warn(dialog.gameProgress());
                gameStarted = false;
            }
            else {
                System.out.println(decider);
                game.removeAll(); //removes all Components from this panel.
                assert decider != null;
                if (decider.equals("Human")) {
                    var boardHuman = new BoardPanel(new Boarder());
                    game.add(boardHuman, BorderLayout.CENTER);
                    turn.setText(boardHuman.getTurn());
                    game.add(turn,BorderLayout.NORTH);
                    game.revalidate(); // makes it so there can be a new panel
                    gameStarted = true;
                }
                if (decider.equals("Computer")) {
                    var boardComputer = new BoardStrategyPanel(new Boarder());
                    game.add(boardComputer, BorderLayout.CENTER);
                    turn.setText(boardComputer.getTurn());
                    game.add(turn,BorderLayout.NORTH);
                    game.revalidate();// makes it so there can be a new panel
                    gameStarted = true;
                }
                warn("New Game Started!");
                if(decider.equals("Select opponent")){
                    game.add(board);
                    game.add(turn,BorderLayout.NORTH);
                    game.revalidate(); // makes it so there can be a new panel
                    warn(dialog.noSelection());
                }
            }
        });
        //Panel
        panel.add(button,BorderLayout.WEST);
        panel.add(opponents,BorderLayout.EAST);

        //Main Panel
        add(panel,BorderLayout.NORTH);
        add(game,BorderLayout.CENTER);
    }

    /** Create a window to display a message to the user.
     *
     * @param msg message to be displayed.
     */
    private void warn(String msg) {
        JOptionPane.showConfirmDialog(this, msg, "Omok",
                JOptionPane.DEFAULT_OPTION);
    }
}