import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CounterGUI extends NoApplet{
    JButton incButton,decButton,resButton;
    JLabel countLabel;
    MouseAdapter buttonMouseEvent = new MouseAdapter(){
        Color OC;
        @Override
        public void mouseEntered(MouseEvent e) {
            JComponent tmp = (JComponent)e.getSource();
            OC = tmp.getBackground();
            tmp.setBackground(Color.GREEN);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JComponent tmp = (JComponent)e.getSource();
            tmp.setBackground(OC);
        }
    };
    private Counter counter;
    public CounterGUI(){
        //init obj
        counter = new Counter();
        incButton = new JButton("Increment");
        decButton = new JButton("Decrement");
        resButton = new JButton("Reset");

        // add listener to button
        incButton.addActionListener(this::buttonActions);
        decButton.addActionListener(this::buttonActions);
        resButton.addActionListener(this::buttonActions);
        incButton.addMouseListener(buttonMouseEvent);
        decButton.addMouseListener(buttonMouseEvent);
        resButton.addMouseListener(buttonMouseEvent);

        // set frame layout to grid **  extra rows to decrease the spacing
        setLayout(new GridLayout(5,1));

        // set flow layout into a full jpanel and add text
        JPanel countPanel = new JPanel();

        countLabel = new JLabel("Value : " + counter.getCount());
        countLabel.setHorizontalTextPosition(JLabel.CENTER);
        countLabel.setVerticalAlignment(JLabel.CENTER);
        countLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
        countPanel.add(countLabel);
        add(countPanel);

        // add all buttons in a panel and add it to the grid
        JPanel buttonPanel = new JPanel();

        buttonPanel.add(incButton);
        buttonPanel.add(decButton);
        buttonPanel.add(resButton);
        add(buttonPanel);
    }
    public void buttonActions(ActionEvent e){
        if(e.getSource().equals(incButton)) counter.increment();
        if(e.getSource().equals(decButton)) counter.decrement();
        if(e.getSource().equals(resButton)) counter.reset();
        countLabel.setText("Value : " + counter.getCount());
    }
}
