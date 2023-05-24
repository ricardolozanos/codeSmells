import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ComputerPlayer implements Playable{
    private int playerNum;
    private UserInterfaceable UI;
    public ComputerPlayer(int playerNum, UserInterfaceable ui){
        UI = ui;
        this.playerNum = playerNum;
    }
    @Override
    public int getPlayerNum(){return playerNum;}
    @Override
    public String getPlayerName() {
        return "OMOKFISH";
    }

    @Override
    public int[] getStonePlacement(int[][] board) {
        UI.displayString("OMOKFISK is thinking...");
        LinkedList<int[]> spots;
        for (int i = 4; i > 0; i--) {
            spots = findSpotsOfQuality(board, i);
            if (spots.size() != 0) {
                int randomSpot = (int) ((Math.random() * (spots.size() - 1)));
                return spots.get(randomSpot);
            }
        }
        boolean invalid = true;
        int randomX = 1;
        int randomY = 1;
        while(invalid){
            randomX = (int) ((Math.random() * (board.length - 1)));
            randomY = (int) ((Math.random() * (board[0].length - 1)));
            if (board[randomX][randomY] == 0){
                invalid = false;
            }
        }
        return new int[] {randomX, randomY};
    }

    private LinkedList<int[]> findSpotsOfQuality(int[][] board, int quality){
        LinkedList<int[]> coordinates = new LinkedList<int[]>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                coordinates.addAll(checkforSpots(i, j, board, 0, -1, quality));
            }
        }
        return coordinates;
    }
    private List<int[]> checkforSpots(int x, int y, int[][] board, int stoneNum, int direction, int quality){
        LinkedList<int[]> coordinates = new LinkedList<int[]>();

        if (x >= board.length || y >= board[0].length || x < 0 || y < 0) {
            return coordinates;
        }
        if (stoneNum >= quality && board[x][y] == 0){
            coordinates.add(new int[] {x + 1, y + 1});
            return coordinates;
        }
        if (board[x][y] != playerNum) {
            return coordinates;
        }

        switch(direction) {
            case -1:
                coordinates.addAll(checkforSpots(x, y, board, 0, 0, quality));
                coordinates.addAll(checkforSpots(x, y, board, 0, 1, quality));
                coordinates.addAll(checkforSpots(x, y, board, 0, 2, quality));
                coordinates.addAll(checkforSpots(x, y, board, 0, 3, quality));
                coordinates.addAll(checkforSpots(x, y, board, 0, 4, quality));
                coordinates.addAll(checkforSpots(x, y, board, 0, 5, quality));
                coordinates.addAll(checkforSpots(x, y, board, 0, 6, quality));
                coordinates.addAll(checkforSpots(x, y, board, 0, 7, quality));
                coordinates.addAll(checkforSpots(x, y, board, 0, 8, quality));
                break;
            case 0:
                coordinates.addAll(checkforSpots(x - 1 , y, board, stoneNum + 1, 0, quality));
                break;
            case 1:
                coordinates.addAll(checkforSpots(x - 1, y + 1, board, stoneNum + 1, 1, quality));
                break;
            case 2:
                coordinates.addAll(checkforSpots(x, y + 1, board, stoneNum + 1, 2, quality));
                break;
            case 3:
                coordinates.addAll(checkforSpots(x + 1, y + 1, board, stoneNum + 1, 3, quality));
                break;
            case 4:
                coordinates.addAll(checkforSpots(x + 1, y, board, stoneNum + 1, 4, quality));
                break;
            case 5:
                coordinates.addAll(checkforSpots(x + 1, y - 1, board, stoneNum + 1, 5, quality));
                break;
            case 6:
                coordinates.addAll(checkforSpots(x, y - 1, board, stoneNum + 1, 6, quality));
                break;
            case 7:
                coordinates.addAll(checkforSpots(x - 1, y - 1, board, stoneNum + 1, 7, quality));
                break;
        }
        return coordinates;
    }
}
