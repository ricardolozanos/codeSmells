//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.PrintStream;
//import java.nio.charset.StandardCharsets;
//import java.util.Arrays;
//import java.util.Locale;
//import java.util.Scanner;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class ConsoleUIPlay {
//    private Controller controller;
//    private Scanner scan;
//    private Controller.GameMode gameMode;
//    public ConsoleUIPlay(){
//        this.scan = new Scanner(System.in);
//    }
//    public ConsoleUIPlay(InputStream input, OutputStream output){
//        System.setIn(input);
//        try{
//            final PrintStream stream = new PrintStream(output,true, StandardCharsets.UTF_8.name());
//            System.setOut(stream);
//        }
//        catch (IOException e){e.printStackTrace();}
//        this.scan = new Scanner(input);
//
//    }
//    }
//    public GameMain.GameMode getGameMode() {
//        return gameMode;
//    }
//
//    public GameBoard.BoardSize getBoardSize() {
//        return boardSize;
//    }
//
//    public void run(){
//        setUpGameMode(0);
//        if(gameMode != GameMain.GameMode.DUO_JOIN) {
//            setUpBoardSize(0);
//            game = new GameMain(gameMode, boardSize);
//        }
//        else
//            game = new GameMain(gameMode);
//        setUpPlayers(gameMode.VALUE);
//        playGame(0);
//    }
//    public void setUpGameMode(int n){
//        if(n >= 5) throw new IllegalArgumentException("Too many invalid attempts");
//        AtomicInteger c = new AtomicInteger('A');
//        String style = "%s. %s\n";
//        Arrays.stream(Controller.GameMode.values()).forEach(e -> System.out.printf(style,(char)(c.getAndIncrement()),e));
//        System.out.print("Please Select a the Game Mode : ");
//        String response = scan.nextLine();
////        switch (response.toUpperCase(Locale.ROOT)){
////            case "A" -> gameMode = Controller.GameMode.SOLO;
////            case "B" -> gameMode = Controller.GameMode.DUO_LOCAL;
////            case "C" -> gameMode = Controller.GameMode.DUO_HOST;
////            case "D" -> gameMode = Controller.GameMode.DUO_JOIN;
////            default ->{
////                System.out.println("Invalid input \"" + response + "\"");
////                setUpGameMode(n+1);
////            }
////        }
//    }
//    public void setUpBoardSize(int n){
//        if(n >= 5) setUpGameMode(n);
//        AtomicInteger c = new AtomicInteger('A');
//        String style = "%s. %s\n";
//        Arrays.stream(GameBoard.BoardSize.values()).forEach(e -> System.out.printf(style,(char)(c.getAndIncrement()),e));
//        System.out.print("Please Select the Board Size : ");
//        String response = scan.nextLine();
//        switch (response.toUpperCase(Locale.ROOT)){
//            case "A" -> boardSize = GameBoard.BoardSize.SMALL;
//            case "B" -> boardSize = GameBoard.BoardSize.MEDIUM;
//            case "C" -> boardSize = GameBoard.BoardSize.LARGE;
//            default ->{
//                System.out.println("Invalid input \"" + response + "\"");
//                setUpBoardSize(n+1);
//            }
//        }
//    }
//    public void setUpPlayers(int playerCount){
//        String [] prompt = {"Enter Player's Name : ", "Enter Opponent Name : "};
//        int i = 0, k = playerCount;
//        for(String p : prompt){
//            System.out.print(p); prompt[i++] = scan.nextLine();
//            if(--playerCount <= 0) break;
//        }
////        switch (k){
////            case 1 -> game.setPlayersName(prompt[0]);
////            case 2 -> game.setPlayersName(prompt[0],prompt[1]);
////        }
//    }
//    public void playGame(int n){
//        if(n >= 5) setUpGameMode(n);
//        if(gameMode == GameMain.GameMode.SOLO){
//            AtomicInteger i = new AtomicInteger('A');
//            Arrays.stream(GomoKuBot.BotDifficulty.values()).forEach(
//                    e -> System.out.printf("%s. %s\n",(char)i.getAndIncrement(),e)
//            );
//            BotPlayer tmp = (BotPlayer) game.getOpponent();
//            System.out.print("Please Select Bot difficulty (Note * the harder the slower) : ");
//            String response = scan.nextLine();
//            switch (response.toUpperCase(Locale.ROOT)){
//                case "A" -> tmp.setDifficulty(GomoKuBot.BotDifficulty.EASY);
//                case "B" -> tmp.setDifficulty(GomoKuBot.BotDifficulty.HARD);
//                case "C" -> tmp.setDifficulty(GomoKuBot.BotDifficulty.EXPERT);
//                default -> {
//                    System.out.println("Invalid input \"" + response + "\" Try again!");
//                    playGame(n+1);
//                }
//            }
//            playGameLocal();
//        }
//        else if(gameMode == GameMain.GameMode.DUO_LOCAL)
//            playGameLocal();
//        else
//            playGameOnline();
//    }
//    public void playGameLocal(){
//        gameLoop : while(true){
//            controller.printBoardToConsole();
//            if(game.isCheatOn()){
//
//            }
//            int [] playedMove = game.getCurrentPlayer().playMove(scan);
//
//            if(playedMove == null || game.playMove(new GoPuck(game.getCurrentPlayer(),playedMove[0],playedMove[1])) == -1){
//                System.out.printf("Invalid or taken Coordinate %s Try Again!\n",game.getCurrentPlayer());
//                continue;
//            }
//            Player player = game.isMoveAWin(playedMove[0],playedMove[1]);
//            if(player != null){
//                game.printBoardToConsole();
//                System.out.printf("%s has won the game!\n",player);
//                break gameLoop;
//            }
//        }
//    }
//}
