package omokThings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.CountDownLatch;

public class omok extends JPanel {

    private static CountDownLatch latch = new CountDownLatch(1); // NEWWWWW STUFFF
    private int size = 600;
    Dimension forJ = new Dimension(size, size);
    private static int x, y;
    private static int roundedX, roundedY;
    private int boardSize = 15; //change to have a button later
    private int conversionTing = size / boardSize;

    private int addTing = conversionTing / 2;
    private int stoneX, stoneY;
    private static int mouseClickedInt = 0;

    private static int[] AIplaceStones = new int[2];
    Game game = new Game(); //creating this game does not allow the Jframe to create a jframe



    static JTextArea textForTurn = new JTextArea("Please select Opponent, and Board Size");


    public omok() {



        var frame = new JFrame("Omok");
        frame.setPreferredSize(forJ);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        var panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        var panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());

        var panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());

        var panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());

        var panel5 = new JPanel();
        panel5.setLayout(new FlowLayout());

        var panelForBoard = new JPanel();
        panelForBoard.setLayout(new GridLayout(1,1));
        panelForBoard.setSize(size, size);

        var button1 = new JButton("Play");
        var text1 = new JTextArea("Opponent");
        text1.setEditable(false);
        var boardTXT = new JTextArea("BoardSize"); // make into a button
        boardTXT.setEditable(false);
        var userSize = new JTextField("      ");

        String options[] = {"Human", "Computer"};
        var oppChoose = new JComboBox(options);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Omok");
        menu.setMnemonic(KeyEvent.VK_G);
        menu.getAccessibleContext().setAccessibleDescription("Omok Menu");
        menuBar.add(menu);


        JToolBar toolbar = new JToolBar();
        Icon icon1 = new ImageIcon("playButton.png");
        Icon icon2 = new ImageIcon("squareHW4.png");
        Icon icon = new ImageIcon("playButton2");
        JButton button2 = new JButton(icon1);
        JButton button3 = new JButton(icon2);
        JButton button4 = new JButton(icon);
        toolbar.add(button2);
        toolbar.add(button3);
        toolbar.add(button4);
        toolbar.addSeparator();


        JMenuItem menuItem1 = new JMenuItem("Play", KeyEvent.VK_P);
        JMenuItem menuItem2 = new JMenuItem("Help", KeyEvent.VK_H);
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
        menuItem1.getAccessibleContext().setAccessibleDescription("Begins a new game");
        menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.ALT_DOWN_MASK));
        menuItem2.getAccessibleContext().setAccessibleDescription("Explains Rules");
        menu.add(menuItem1);
        menu.add(menuItem2);

        //creating action listeners ------ need this so we can start game with play
        //create a start methods

        button1.addActionListener(e -> {

            // based on human or computer selection that game will start

            if (oppChoose.getSelectedItem() == "Human"){
                game.PVP();


            }
            if (oppChoose.getSelectedItem() == "Computer"){
                game.PVE();

            }
        });


        panel1.add(panel3, BorderLayout.CENTER); // main JPannel is panel1
        panel1.add(menuBar, BorderLayout.NORTH);
        panel1.add(panel4, BorderLayout.SOUTH);

        panel3.add(panel2, BorderLayout.NORTH);
        BoardPanel gameBoard = new BoardPanel();

        panel4.add(textForTurn);

        panelForBoard.add(gameBoard);// ---------------- new part
        panel3.add(panelForBoard, BorderLayout.CENTER);

        MyMouseListener newHandler = new MyMouseListener();
        panelForBoard.addMouseListener(newHandler.getMouseListener()); ///// THIS IS NEW
        panelForBoard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                //NEED TO FIND AWAY TO PRINT AI THINGS /STONES

                // temp code ------------------------------
                x = e.getX();
                y = e.getY();

                // NEW NEW STUFFFFFFF
                latch.countDown();

                System.out.print(x + " " + y + " ");
                System.out.print(userSize.getText()+ " ");
                mouseClickedInt = 1;
                // -----------------------------------------

                if(textForTurn.getText() == "playerOne please re-click correct space: ") {

                    x = e.getX();
                    y = e.getY();

                    System.out.print(x + " " + y + " ");

                    x = x / conversionTing;
                    y = y / conversionTing;

                    roundedX = x + 20;
                    roundedY = y + 20;


                    //make it drawn at roundedX and rounded Y

                    //USE AIPLACESTONES TO DRAW AI STONES


                }

                //FOR PLAYER2
                if (textForTurn.getText() == "playerTwo please re-click correct space: "){

                    x = e.getX();
                    y = e.getY();

                    System.out.print(x + " " + y + " ");

                    x = x / conversionTing;
                    y = y / conversionTing;

                    roundedX = x + 20;
                    roundedY = y + 20;


                    //figure out how to re draw this oval on Jpanel center aka paintcomponent in PLAYER1 COLOR

                    // ------>        getGraphics().drawOval();
                    //make it drawn at roundedX and rounded Y


                }

            }
        });

        panel2.add(toolbar);
        panel2.add(button1);
        panel2.add(text1);
        panel2.add(oppChoose);
        panel2.add(boardTXT);
        panel2.add(userSize);

        frame.setContentPane(panel1);
        frame.pack();
        frame.setVisible(true);

    }

   // public omok(String[] params) {super(params);
    //}

    public class BoardPanel extends JPanel
    {
        protected void paintComponent(Graphics g) {
            Dimension d = getSize();
            g.setColor(Color.orange);
            g.fillRect(0, 0, size, size);
            g.setColor(new Color(0, 0,0));
            int repeat = size / boardSize;
            int i  = repeat;// change so user can pick the size of the board
            while (i <= size){
                g.drawLine(i, 0, i, size);
                i += repeat;
            }
            i = repeat;
            while (i <= size){
                g.drawLine(0, i, size, i);
                i += repeat;

            }

            for (int z = 0; z < boardSize; z++) {
                for (int y = 0; y < boardSize; y++) {
                    if (game.boardArr[z][y] == 'X' || game.boardArr[z][y] == 'Y'){
                        stoneX = z * conversionTing;
                        stoneY = y * conversionTing;
                        if(game.boardArr[z][y] == 'X'){
                            g.setColor(Color.RED);
                            g.fillOval(stoneX, stoneY, 30, 30);
                        }
                        if(game.boardArr[z][y] == 'O'){
                            g.setColor(Color.BLUE);
                            g.fillOval(stoneX, stoneY, 30, 30);
                        }
                    }
                }
            }
        }



    }


    public static void changeBottomTxt(String str){ // change based on players turn
        textForTurn.setText(str);
    }

    public static int[] ClickXandY(){ //sends location for board updates
        int[] locations = new int[2];
        locations[0] = roundedX;
        locations[1] = roundedY;
        return locations;
    }

    public static void aiStones(int[] x){ //gets ai placements for adding to paint
        AIplaceStones[0] = x[0];
        AIplaceStones[1] = x[1];

    }

    public static int mouseClicked(){
        return mouseClickedInt;
    }

    public static void mouseClickedReset(){
        mouseClickedInt = 0;
    }
    public static void mouseWaiter(){ // NEWWWWW STUFf
        System.out.print("IM IN MOUSE WAITER");
        try {
            latch.await(); // Wait for the latch to be released
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args){

        SwingUtilities.invokeLater(() -> new omok());
    }


}
