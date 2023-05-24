package OmokBoard;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class controller {
    Board b = new Board();
    BoardPanel panel = new BoardPanel(b);
    int x,y;
    player p1 = new player("1");
    player p2 = new player("2");
    static player currentPlayer = new player("1");



    public void controller() {
        panel.placeClicked();
        x = panel.mouseX;
        y = panel.mouseY;
        if (b.validPlacement(x,y)){
            b.placeStone(x,y,currentPlayer);
            Graphics g = panel.getGraphics();
            panel.listeners.add(((x1, y1, player) -> panel.drawStone(g,x,y,currentPlayer)));

        }
    }

    public static void start(){}
}
