package omok;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleUI {

    private final Scanner scanner;
    private final GameController gameController;
    private final PrintStream output;

    public ConsoleUI(InputStream input, PrintStream output) {
        this.scanner = new Scanner(input);
        this.gameController = new GameController();
        this.output = output;
    }

    //Introduction to the game board and will call on GameController to continue the game forward
    public void intro() {
        output.println("Welcome");
        output.println("Choose game mode 1 for computer 2 for PVP, or 3 to quit game");
        int num = scanner.nextInt();
        switch(num) {
            case 1:
                gameController.computerGame();
                break;
            case 2:
                gameController.PVP();
                break;
            case 3:
                break;
            default:
                output.println("Invalid input");
                break;
        }
    }
}