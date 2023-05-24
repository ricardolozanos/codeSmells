import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsoleUI {
    private GameMain<GoPuck> game;
    private Scanner scan;
    private GameMain.GameMode gameMode;
    private GameBoard.BoardSize boardSize;
    public ConsoleUI(){
        this.scan = new Scanner(System.in);
    }
    public ConsoleUI(InputStream input, OutputStream output){
        System.setIn(input);
        try{
            final PrintStream stream = new PrintStream(output,true, StandardCharsets.UTF_8.name());
            System.setOut(stream);
        }
        catch (IOException e){e.printStackTrace();}
        this.scan = new Scanner(input);

    }
    public ConsoleUI(InputStream input, OutputStream output, GameMain<GoPuck> game){
        this(input,output);
        this.game = game;

    }
    public GameMain.GameMode getGameMode() {
        return gameMode;
    }

    public GameBoard.BoardSize getBoardSize() {
        return boardSize;
    }

    public void run(){
        setUpGameMode(0);
        if(gameMode != GameMain.GameMode.DUO_JOIN) {
            setUpBoardSize(0);
            game = new GameMain(gameMode, boardSize);
        }
        else
            game = new GameMain(gameMode);
        setUpPlayers(gameMode.VALUE);
        playGame(0);
    }
    public void setUpGameMode(int n){
        if(n >= 5) throw new IllegalArgumentException("Too many invalid attempts");
        AtomicInteger c = new AtomicInteger('A');
        String style = "%s. %s\n";
        Arrays.stream(GameMain.GameMode.values()).forEach(e -> System.out.printf(style,(char)(c.getAndIncrement()),e));
        System.out.print("Please Select a the Game Mode : ");
        String response = scan.nextLine();
        switch (response.toUpperCase(Locale.ROOT)){
            case "A" -> gameMode = GameMain.GameMode.SOLO;
            case "B" -> gameMode = GameMain.GameMode.DUO_LOCAL;
            case "C" -> gameMode = GameMain.GameMode.DUO_HOST;
            case "D" -> gameMode = GameMain.GameMode.DUO_JOIN;
            default ->{
                System.out.println("Invalid input \"" + response + "\"");
                setUpGameMode(n+1);
            }
        }
    }
    public void setUpBoardSize(int n){
        if(n >= 5) setUpGameMode(n);
        AtomicInteger c = new AtomicInteger('A');
        String style = "%s. %s\n";
        Arrays.stream(GameBoard.BoardSize.values()).forEach(e -> System.out.printf(style,(char)(c.getAndIncrement()),e));
        System.out.print("Please Select the Board Size : ");
        String response = scan.nextLine();
        switch (response.toUpperCase(Locale.ROOT)){
            case "A" -> boardSize = GameBoard.BoardSize.SMALL;
            case "B" -> boardSize = GameBoard.BoardSize.MEDIUM;
            case "C" -> boardSize = GameBoard.BoardSize.LARGE;
            default ->{
                System.out.println("Invalid input \"" + response + "\"");
                setUpBoardSize(n+1);
            }
        }
    }
    public void setUpPlayers(int playerCount){
        String [] prompt = {"Enter Player's Name : ", "Enter Opponent Name : "};
        int i = 0, k = playerCount;
        for(String p : prompt){
            System.out.print(p); prompt[i++] = scan.nextLine();
            if(--playerCount <= 0) break;
        }
        switch (k){
            case 1 -> game.setPlayersName(prompt[0]);
            case 2 -> game.setPlayersName(prompt[0],prompt[1]);
        }
    }
    public void playGame(int n){
        if(n >= 5) setUpGameMode(n);
        if(gameMode == GameMain.GameMode.SOLO){
            AtomicInteger i = new AtomicInteger('A');
            Arrays.stream(GomoKuBot.BotDifficulty.values()).forEach(
                    e -> System.out.printf("%s. %s\n",(char)i.getAndIncrement(),e)
            );
            BotPlayer tmp = (BotPlayer) game.getOpponent();
            System.out.print("Please Select Bot difficulty (Note * the harder the slower) : ");
            String response = scan.nextLine();
            switch (response.toUpperCase(Locale.ROOT)){
                case "A" -> tmp.setDifficulty(GomoKuBot.BotDifficulty.EASY);
                case "B" -> tmp.setDifficulty(GomoKuBot.BotDifficulty.HARD);
                case "C" -> tmp.setDifficulty(GomoKuBot.BotDifficulty.EXPERT);
                default -> {
                    System.out.println("Invalid input \"" + response + "\" Try again!");
                    playGame(n+1);
                }
            }
            playGameLocal();
        }
        else if(gameMode == GameMain.GameMode.DUO_LOCAL)
            playGameLocal();
        else
            playGameOnline();
    }
    public void playGameLocal(){
        gameLoop : while(true){
            game.printBoardToConsole();
            if(game.isCheatOn()){

            }
            int [] playedMove = game.getCurrentPlayer().playMove(scan);

            if(playedMove == null || game.playMove(new GoPuck(game.getCurrentPlayer(),playedMove[0],playedMove[1])) == -1){
                System.out.printf("Invalid or taken Coordinate %s Try Again!\n",game.getCurrentPlayer());
                continue;
            }
            Player player = game.isMoveAWin(playedMove[0],playedMove[1]);
            if(player != null){
                game.printBoardToConsole();
                System.out.printf("%s has won the game!\n",player);
                break gameLoop;
            }
        }
    }
    public void playGameOnline() {
        if (gameMode == GameMain.GameMode.DUO_JOIN){
            while (true) {
                System.out.print("Please enter host ip : ");
                String ip = scan.nextLine();
                String res = game.initClient(ip);
                if (res == null) break;
                System.out.println(res);
            }
            game.setCurrentPlayer(game.getOpponent());
        }
        else if(gameMode == GameMain.GameMode.DUO_HOST){
            game.initServer();
            System.out.println("Current IP : " + GameServer.getCurrentIp());
            int i = 1;
            while(!game.isLobbyReady()){
                try {
                    Thread.sleep(1000);
                    System.out.print("\rWaiting on opponent to join " + ". ".repeat(i));
                    if(++i == 5){
                        System.out.print("\rWaiting on opponent to join       ");
                        i = 0;
                    }
                }catch (Exception e){}
            }
            System.out.println();
        }
        game.setUpOnlineOpponent();
        int i = 1;
        while(true){
            if(game.getPlayer() == game.getCurrentPlayer()){
                game.printBoardToConsole();
                int [] move = game.getPlayer().playMove(scan);
                game.playMoveOnline(new GoPuck(game.getPlayer(),move[0],move[1]));
                game.printBoardToConsole();
                i = 0;
            }
            else{
                try {
                    Thread.sleep(1000);
                    System.out.printf("\rWaiting on %s to play move " + ". ".repeat(i),game.getOpponent());
                    if(++i == 5){
                        System.out.printf("\rWaiting on %s to play move       ",game.getOpponent());
                        i = 1;
                    }
                }catch (Exception e){}
                game.hasOnlineOpponentPlayed(new GoPuck());
            }
        }
    }
}
