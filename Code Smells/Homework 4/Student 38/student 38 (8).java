import javax.swing.*;
//hello
//Our main method where all the major interactions are computed
public class GUIMain{
    static Board board = new Board(15);
    GUIInterface ui = new GUIInterface(board);
    public static void main(String[] args) {
        //Initialize board and interface, in this case terminal UI
        new GUIMain();
    }
}