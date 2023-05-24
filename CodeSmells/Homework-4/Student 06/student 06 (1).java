import javax.swing.*;

public class Controller {
     private Board board;
     private Player p1 = new HumanPlayer(1);
     private Player p2 = new HumanPlayer(2);
     private Player cpu = new CPUPlayer(2);
     private int curr;
     private OmokGUI gui;
     protected int delay = 10;
     private Timer timer;

     public Controller(){
          board = new Board();
          gui = new OmokGUI(board);
          gui.setVisible(true);
          timer = new Timer(delay, e -> {
               if(gui.boardPanel.getCurrPlayer() != curr){
                    curr = gui.boardPanel.getCurrPlayer();
                    gui.setCurrentPlayerLabel();
               }
               if(gui.getMode() == 1 && gui.boardPanel.getCurrPlayer() == 2){
                    cpu.makeMove(0, 0, board);
                    gui.boardPanel.setCurrPlayer(1);
               }
               checkWin();
          });
          timer.start();
     }
     public void checkWin(){
          if(board.isWonBy(p1)){
               gui.winner(p1);
               gui.boardPanel.condFalse();

          }
          else if(gui.getMode() == 1 && board.isWonBy(cpu)){
               gui.winner(cpu);
               gui.boardPanel.condFalse();
          }
          else if(board.isWonBy(p2)){

               gui.winner(p2);
               gui.boardPanel.condFalse();

          }
          else if(board.checkTie()){
               gui.tie();
               gui.boardPanel.condFalse();
          }
     }
}

