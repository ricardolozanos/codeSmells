package HW4_GUI.console;

import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random;

    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
        this.random = new Random();
    }


    @Override
    public Coordinate pickPlace(Board board) {
        int size = board.getSize();
        int x, y;
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (!board.isCellEmpty(x, y));
        return new Coordinate(x, y);
    }

    
    
}
