package console;

import game.Board;

import java.io.*;

public interface ConsoleUI {
    void ConsoleUI(Board bd);
    void ConsoleUI(Board bd, InputStream in, PrintStream out);
    void interactMsg(String msg);
    void drawBoard();
    int gameMode();
    int movePlace();

    void start();

    String stop(String s);


}
