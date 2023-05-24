package noapplet.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener {
    Container c;
    JMenuBar mb;

    JMenu Game;
    JMenuItem play, about, exit;
    //JLabel label;
    JTextField turn;
    JButton button, btnPlay, btnHelp;
    JToolBar tb;

    JComboBox c1;
    MapSize size=new MapSize();
    //Here is where the GUI is actually implemented
    public GUI(String title) {
        setTitle(title);
        c=getContentPane();
        setBounds(200,20,800,800);
        c.setLayout(null);
        //This part is assigned to help the Jmenubar
        mb = new JMenuBar();
        //setJMenuBar(mb);
        play=new JMenuItem("Play");
        about=new JMenuItem("About");
        exit=new JMenuItem("EXIT");
        play.addActionListener(this);
        about.addActionListener(this);
        exit.addActionListener(this);
        Game=new JMenu("GAME");
        Game.add(play);Game.add(about);Game.add(exit);
        Game.setBackground(new Color(90,10,105));
        mb.add(Game);
        //This specific part is reserved for the use of Jboutton
        button = new JButton("PLAY");
        button.setBackground(Color.GREEN);
        button.addActionListener(new ButtonActionListener());
        //Space assigned for the Jtoolbar and the call of the picture that will represent the tool
        tb = new JToolBar("options");
        btnPlay = new JButton(new ImageIcon("src/play.png"));
        btnHelp = new JButton(new ImageIcon("src/help.png"));
        tb.add(btnPlay);
        tb.add(btnHelp);
        //This part is for the Jcombobox and it's possible action options
        String s1[] = { "Game mode", "solo", "vs" };
        c1 = new JComboBox(s1);
        c1.setSelectedIndex(0);
        c1.setEditable(true);
        add(c1);
        //Tools and buttons added to the frame
        add(mb);
        mb.add(button);
        mb.add(tb, BorderLayout.PAGE_START);
        mb.add(c1);
        setJMenuBar(mb);
        /*label = new JLabel("start turn");
        setBackground(Color.WHITE);
        add(label);*/




        Map map=new Map(size);
        DrawBoard d=new DrawBoard(size,map);
        setContentPane(d);
        addMouseListener(new MouseEventHandler(map, size,d,this));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //PopUp to let the player who won
    public void popUp(String message) {
        JOptionPane.showMessageDialog(this, message,"CONGRATS",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    //method not yet used for the moment
    private void jmenuBoton() {

    }
//Action performed depending on the Menu item selected
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==play){
            System.out.println("Play pressed"); new GUI("Next game");}
        if(e.getSource()==about){
            System.out.println("About pressed");}
        if(e.getSource()==exit){
            System.out.println("EXIT pressed");System.exit(0);}
    }
    public void start() {
        //timer.start();
    }

    public void close() {
        System.exit(0);
    }

//Action listener for the PLAY button, it also changes the title name
    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                new GUI("Next game");
                repaint();}
        }
    }
}