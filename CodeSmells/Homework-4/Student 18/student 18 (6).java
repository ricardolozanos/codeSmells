
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument.Content;

public class OmokGUI extends JFrame {
	Game game;
	private int GameMode;
	JComboBox comboBox;
	BoardPanel boardPanel;
	
	
    public OmokGUI() {
        super("Omok");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 200));

        // main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        //North Panel
        JPanel northPanel = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton human = new JRadioButton();
        JRadioButton computer = new JRadioButton();
        human.setText("Human");
        computer.setText("Computer");
        buttonGroup.add(human);
        buttonGroup.add(computer);
        northPanel.add(new JLabel("Choose the Battle: "));
        northPanel.add(human);
        northPanel.add(computer);
        mainPanel.add(northPanel, BorderLayout.NORTH);
        
        
        //playButton
        JButton playButton = playButton(human,computer,this);
        //center
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(5,5));
        centerPanel.add(playButton);
        mainPanel.add(centerPanel);
        
        
        //makes it visible
        setContentPane(mainPanel);
        pack();
        setVisible(true);
    }
    public JFrame gameBoard(Board b) {
    	
    	return new JFrame();
    }
    
    public JButton playButton(JRadioButton a,JRadioButton b, OmokGUI o) {
    	JButton playButton = new JButton("Play");
    	playButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Game game;
				if(a.isSelected()) {
					game = new PVP();
					game.start();
					o.setGameMode(1);
					showBoard(game);
				}else if(b.isSelected()){
					game = new PVC();
					game.start();
					showBoard(game);
					o.setGameMode(2);
				}else {
					JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,"Please Select Type Of Oponent!"); 
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {/*unused method*/}
			@Override
			public void mouseReleased(MouseEvent e) {/*unused method*/}
			@Override
			public void mouseEntered(MouseEvent e) {/*unused method*/}
			@Override
			public void mouseExited(MouseEvent e) {/*unused method*/}});
    	return playButton;
    }
    
    protected void setGameMode(int i) {
    	this.GameMode = i;
    	}
    
	public void showBoard(Game g) {
    	this.game = g;
    	//main panel
    	JPanel mainPanel = new JPanel();
    	mainPanel.setLayout(new BorderLayout());
    	
    	
    	
    	//menuBar
    	JMenuBar menuBar = menuBarMethod(this);
    	menuBar.setAlignmentX(LEFT_ALIGNMENT);
    	this.setJMenuBar(menuBar);
    	
    	
    	
    	
    	//center panel
    	JPanel textAreaPanel = new JPanel();
    	textAreaPanel.setLayout(new BorderLayout());
    	JPanel comboBoxPanel = new JPanel();
    	JComboBox comboBox = new JComboBox();
    	JLabel labelForComboBox = new JLabel("Next Opponent: ");
    	comboBox.addItem("Human");
    	comboBox.addItem("Computer");
    	comboBoxPanel.add(labelForComboBox);
    	comboBoxPanel.add(comboBox);
    	textAreaPanel.add(comboBoxPanel, BorderLayout.NORTH);
    	
    	JTextArea console= startArea(this.GameMode);
    	console.setWrapStyleWord(true);
    	textAreaPanel.add(console, BorderLayout.CENTER);
    	mainPanel.add(textAreaPanel, BorderLayout.CENTER);
    	
    	
    	
    	
    	//board Panel aka south panel
    	JPanel south= new JPanel();
    	BoardPanel boardpanel = new BoardPanel(this.game, console, g.getPlayer1(), g.getPlayer2());
    	south.add(boardpanel);
    	mainPanel.add(south, BorderLayout.SOUTH);
    	
    	//toolbar
    	JToolBar toolbar = new JToolBar("toolbar");
    	toolbar.setOrientation(JToolBar.HORIZONTAL);
    	JButton playToolBar = playOnBoard(comboBox, this, boardPanel, console);
    	toolbar.add(playToolBar);
    	mainPanel.add(toolbar, BorderLayout.PAGE_START);
    	
    	
    	//sets panel as main content 
    	setContentPane(mainPanel);
    	pack();
    	setVisible(true);
    	
    }
    
    private JTextArea startArea(int a) {
		if(a == 1) {
			return new JTextArea("You have chosen PVP! Have Fun!");
		}
		return new JTextArea("You have chosen PVC! Have Fun!");
	}
	public JMenuBar menuBarMethod(OmokGUI gui) {
    	JMenu menuButton = new JMenu("Window");
    	JMenuBar menuBar = new JMenuBar();
    	JButton playButton = playOnBoard(gui.comboBox, gui, null, null);
    	JButton exitButton = exitButton(gui);
    	menuButton.add(playButton);
    	menuButton.add(exitButton);
    	menuBar.add(menuButton);
    	return menuBar;
    }
    
    
    public JButton playOnBoard(JComboBox jcb, OmokGUI gui, BoardPanel bp, JTextArea console) {
    	JButton playButton = new JButton("Play");
    	playButton.addMouseListener(new MouseListener() {
    		
			@Override
			public void mouseClicked(MouseEvent e) {
				if(gui.game.getBoard().hasValues()) {
					int temp = JOptionPane.showConfirmDialog(null, "Game in Progress, Restart?");
					if(temp == JOptionPane.YES_OPTION) {
						gui.game.getBoard().clear();
						if(jcb.getSelectedItem().toString() == "Human") {
							gui.game = new PVP();
							gui.game.start();
							gui.showBoard(gui.game);
							
						}else {
							gui.game = new PVC();
							gui.game.start();
							gui.showBoard(gui.game);
						}
					}
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {/*Unused method*/}
			@Override
			public void mouseReleased(MouseEvent e) {/*Unused method*/}
			@Override
			public void mouseEntered(MouseEvent e) {/*Unused method*/}
			@Override
			public void mouseExited(MouseEvent e) {/*Unused method*/}
    		
    	});
    	
    	
    	
    	return playButton;
    }
    protected void boardPanel(BoardPanel boardPanel) {
		this.boardPanel(boardPanel);
	}
	public JButton exitButton(OmokGUI o){
    	JButton exitButton = new JButton("Exit");
    	exitButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				o.dispose();
			}
			@Override
			public void mousePressed(MouseEvent e) {/*unused method*/}
			@Override
			public void mouseReleased(MouseEvent e) {/*unused method*/}
			@Override
			public void mouseEntered(MouseEvent e) {/*unused method*/}
			@Override
			public void mouseExited(MouseEvent e) {/*unused method*/}});
    	return exitButton;
    }
    public static void main(String[] args) {
        //javax.swing.SwingUtilities.invokeLater(() -> new OmokGUI());
    	new OmokGUI();
    }
}
