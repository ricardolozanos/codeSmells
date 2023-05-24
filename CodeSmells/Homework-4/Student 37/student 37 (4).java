package omok;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Omok implements ActionListener {
	JFrame frame =new JFrame();
	Board board=new Board();
	Gamecontroller gc=new Gamecontroller();
    public Omok() {
       JMenuBar menuBar=menubar();
       JToolBar toolBar=toolBar();
       JPanel toolBarPanel=new JPanel();
   	   JPanel panel=new JPanel();
   	   JLabel textField= new JLabel();
   	   Color panelColor=panel.getBackground();
   	   String modes[]={"Computer","Player"};        
       JComboBox cb=new JComboBox(modes);
       cb.setPreferredSize(new Dimension(300,20));
   	   panel.setLayout(new FlowLayout(FlowLayout.LEFT));
   	   textField.setBackground(panelColor);
   	   textField.setForeground(Color.BLACK);
   	   textField.setFont(new Font("Ink Free",Font.BOLD,14));
   	   textField.setText("Game mode:");
   	   textField.setHorizontalAlignment(JLabel.LEFT);
   	   textField.setOpaque(true);
   	   panel.add(textField,BorderLayout.LINE_START);
       panel.add(cb,BorderLayout.CENTER);
   	   panel.setPreferredSize(new Dimension(40,40));
       toolBarPanel.setLayout(new BorderLayout());
       toolBarPanel.setBounds(0, 0, 100, 100);
       toolBarPanel.add(toolBar,BorderLayout.NORTH);
       toolBarPanel.add(panel,BorderLayout.CENTER);  
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(475,640);
       frame.getContentPane().setBackground(Color.ORANGE);
       frame.setLayout(new BorderLayout());
       frame.setJMenuBar(menuBar);
       frame.add(toolBarPanel,BorderLayout.NORTH);
       frame.add(board,BorderLayout.CENTER);
       //frame.add(gc.makePanel(),BorderLayout.SOUTH);
       frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
private JMenuBar menubar() {
	JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Game");
    menu.setMnemonic(KeyEvent.VK_G);
    menu.getAccessibleContext().setAccessibleDescription("Game menu");
    menuBar.add(menu);
    JMenuItem menuItem = new JMenuItem("Play", KeyEvent.VK_P);
    menuItem.setAccelerator(KeyStroke.getKeyStroke(
       KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
    menuItem.getAccessibleContext().setAccessibleDescription(
       "Play a new game");
    menuItem.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
			  frame.add(gc.makePanel(),BorderLayout.SOUTH);
			  frame.revalidate();
			  frame.repaint();
		  }
		  });
    menu.add(menuItem);
    return menuBar;
}
private JToolBar toolBar() {
	ImageIcon icon=new ImageIcon("C:\\Users\\carlo\\git\\OmokGUI\\OmokGUI\\res\\play.png");
	Image image=icon.getImage();
	Image newImg=image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	icon=new ImageIcon(newImg);
	JToolBar toolBar = new JToolBar("Omok");
	JButton button = new JButton(icon);
	button.setPreferredSize(new Dimension(20,20));
	button.setToolTipText("Play a new game");
	button.setFocusPainted(false);
	button.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
			  frame.add(gc.makePanel(),BorderLayout.SOUTH);
			  frame.revalidate();
			  frame.repaint();
		  } 
			});
	toolBar.add(button);
	toolBar.setPreferredSize(new Dimension(30,30));
	return toolBar;

}


}