import java.util.Scanner;

public class Controller {
     private Board board;
     private Player p1;
     private Player p2;
     private int mode;

     public Controller(){
          UI ui = new UI();
          this.board = new Board(ui.sizePrompt());
     }

     public void gameMode(int mode){
         this.mode = mode;
     }
//     public boolean gameMode(String mode){
//          switch (mode) {
//               case "1" -> {
//                    this.mode = 1;
//               }
//               case "2" -> {
//                    this.mode = 2;
//               }
//               default -> {
//                    return false;
//               return true;
//     }
//           if (!gameMode(ui.selectMode()){
//               ui.invalid();
//               play();
//           }
     public void play(){
          UI ui = new UI();
//          Scanner scanner = new Scanner(System.in);
//          board.setBoard_size(ui.sizePrompt());
          switch (ui.selectMode()) {
               case "1" -> {
                    gameMode(1);
               }
               case "2" -> {
                    gameMode(2);
               }
               default -> {
                    ui.invalid();
                    play();
               }
          }
//          board.setBoard_size(ui.sizePrompt());
          ui.modeSelected(mode);
          if (mode == 1){
               p1 = new HumanPlayer(1);
               p2 = new CPUPlayer(2);
               Player current = p1;
//               printBoard();
               ui.printBoard(board);
               while(true){
                    ui.playerNext(current.pNum);
                    if(p1 == current) {
                         int [] coordinates= ui.takeCoordinates();
                         if (coordinates[0] < 0 || coordinates[1] <0){
                              ui.leaveGame();
                              break;
                         }
                         if (coordinates[0] > board.getSize() || coordinates[1] > board.getSize()){
                              ui.indexOOB();
                              continue;
                         }
                         if (!current.makeMove(coordinates[0], coordinates[1], board)) continue;
                         //HORIZONTAL TEST Passed
//                         board.manualChange(0, 1, 2);
//                         board.manualChange(0, 2, 2);
//                         board.manualChange(0, 3, 2);
//                         board.manualChange(0, 4, 2);
//                         board.manualChange(0, 5, 1);
                         //VERTICAL TEST  passed
//                         board.manualChange(1, 0, 2);
//                         board.manualChange(2, 0, 2);
//                         board.manualChange(3, 0, 2);
//                         board.manualChange(4, 0, 2);
//                         board.manualChange(5, 0, 1);
                         //DIAGONAL WIN MOVE (/) TEST passed
//                         board.manualChange(1, 6, 2);
//                         board.manualChange(2, 5, 2);
//                         board.manualChange(3, 4, 2);
//                         board.manualChange(4, 3, 2);
//                         board.manualChange(5, 2, 1);
                         //DIAGONAL WIN MOVE (\) TEST
//                         board.manualChange(1, 2, 2);
//                         board.manualChange(2, 3, 2);
//                         board.manualChange(3, 4, 2);
//                         board.manualChange(4, 5, 2);
//                         board.manualChange(5, 6, 1);
                         ui.printBoard(board);

                    }
                    else {
                         int x = 0;
                         int y = 0;
                         ui.cpuMove();
                         //TEST HEEREEEEEEE FIRST IF IS CORRECT
                         if (!current.makeMove(x, y, board)) continue;
//                         if (!current.makeMove(x, y, board)) {
//                              System.out.println("No Stone Played");
//                         }
                    }
                    //!board.placeStone(x, y, current.getpNum()) THIS WAS INSIDE IF BELOW
                    if(board.isGameWon(current)){
//                         printBoard();
                         ui.printBoard(board);
                         ui.winNotification(current.pNum);
                         break;
                    }
                    current = p1 == current? p2 : p1; //short if statement
//                    printBoard();
                    ui.printBoard(board);
               }
          }
          if (mode == 2){
               p1 = new HumanPlayer(1);
               p2 = new HumanPlayer(2);
               Player current = p1;
//               printBoard();
               ui.printBoard(board);
               while(true){
                    ui.playerNext(current.pNum);
//                    ui.xIn();
//                    int x = scanner.nextInt();
//                    ui.yIn();
//                    int y = scanner.nextInt();
                    int [] coordinates= ui.takeCoordinates();
                    if (coordinates[0] < 0 || coordinates[1] <0){
                         ui.leaveGame();
                         break;
                    }
                    if (coordinates[0] > board.getSize() || coordinates[1] > board.getSize()){
                         ui.indexOOB();
                         continue;
                    }
                    //!board.placeStone(x, y, current.getpNum()) THIS WAS INSIDE IF BELOW
                    if (!current.makeMove(coordinates[0], coordinates[1], board)) continue;
                    if(board.isGameWon(current)){
//                         printBoard();
                         ui.printBoard(board);
                         ui.winNotification(current.pNum);
                         break;
                    }
                    current = p1 == current? p2 : p1; //short if statement
//                    printBoard();
                    ui.printBoard(board);
               }
          }
     }
}

