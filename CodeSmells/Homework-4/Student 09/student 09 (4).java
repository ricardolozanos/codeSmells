package OmokBoard;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        OmokGui omokGame = new OmokGui();
        omokGame.setVisible(true);
        omokGame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        controller.start();
    }
}
