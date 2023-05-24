package omok;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gamecontroller {
	protected Player player1=new Player("Player 1");
	protected Player player2=new Player("Player 2");
	public boolean change=false;
public JPanel makePanel() {
	JPanel turn=new JPanel();
	JLabel playerTurn=new JLabel();
	Color panelColor=turn.getBackground();
	playerTurn.setBackground(panelColor);
	playerTurn.setForeground(Color.BLACK);
	playerTurn.setFont(new Font("Ink Free",Font.BOLD,14));
	playerTurn.setText("Player turn:"+playerTurn());
	playerTurn.setHorizontalAlignment(JLabel.LEFT);
	playerTurn.setOpaque(true);
	turn.add(playerTurn);
	return turn;
}
public void inform() {
	while(true) {
		change=true;
		break;
	}
}
public String playerTurn() {
	if(change==true) {
		String player=player2.name();
		change=false;
		return player;
	}
	return player1.name();

}
}
