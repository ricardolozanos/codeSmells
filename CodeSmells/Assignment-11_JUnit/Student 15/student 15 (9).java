import java.util.HashSet;
import java.util.ArrayList;
public class GameBoard<T extends Puck> implements Cloneable {
    public enum BoardSize {
        SMALL(13),
        MEDIUM(15),
        LARGE(19);
        final int VALUE;

        BoardSize(int value) {
            this.VALUE = value;
        }
    }
    private ArrayList<ArrayList<T>>  puckBoard;
    private BoardSize size;

    private GameBoard(ArrayList<ArrayList<T>> puckBoard, BoardSize size) {
        this(size);
        for(int i = 0; i < size.VALUE; i++){
            for(int j = 0; j < size.VALUE; j++){
                this.puckBoard.get(i).set(j,puckBoard.get(i).get(j));
            }
        }
    }

    public GameBoard(BoardSize size) {
        this.size = size;
        this.puckBoard = new ArrayList<>();
        for(int i = 0; i < size.VALUE; i++){
            this.puckBoard.add(new ArrayList<T>());
            for(int j = 0; j < size.VALUE; j++)
                this.puckBoard.get(i).add(null);
        }
    }
    private boolean isCoordinateInBounds(int x, int y){
        if(x < 0 || x >= size.VALUE) return false;
        if(y < 0 || y >= size.VALUE) return false;
        return true;
    }
    public int setPuck(T puck) {
        if(puck == null) return -1;
        int x = puck.getX(), y = puck.getY();
        if(!isCoordinateInBounds(x,y)) return -1;
        if(this.puckBoard.get(x).get(y) != null) return -1;
        this.puckBoard.get(x).set(y,puck);
        return 0;
    }

    public T getPuck(int x, int y) {
        if(!isCoordinateInBounds(x,y)) return null;
        return puckBoard.get(x).get(y);
    }
    public void clearPuck(int x, int y) {
        if(!isCoordinateInBounds(x,y)) return;
        puckBoard.get(x).set(y,null);
    }
    public int getBoardSize() {
        return size.VALUE;
    }

    @Override
    public GameBoard clone() {
        return new GameBoard(this.puckBoard, this.size);
    }

    public ArrayList isGameWon(int posX, int posY) {
        if(!isCoordinateInBounds(posX,posY)) return null;
        Player p = puckBoard.get(posX).get(posY).getOwner();
        int [][] direction = {
                {0,1}, // horizontal
                {1,0}, // vertical
                {1,1}, // diagonal top left -> bottom right
                {-1,1}}; // diagonal top right -> bottom left
        for(int i = 0; i < direction.length; i++){
            ArrayList<T> consecetivePucks = isGameWon(posX,posY,direction[i][0],direction[i][1],p);
            if(consecetivePucks.size() >= 5) return consecetivePucks;
        }
        return null;
    }
    public ArrayList isGameWon(int x, int y, int dx, int dy, Player player){
        if(!isCoordinateInBounds(x,y)) return null;
        ArrayList<T> pucks = new ArrayList();
        pucks.add(puckBoard.get(x).get(y));
        int idx = dx * -1, idy = dy * -1;
        isGameWon(pucks,x+dx,y+dy,dx,dy,4,player);
        isGameWon(pucks,x+idx,y+idy,idx,idy,4,player);
        return pucks;
    }
    private void isGameWon(ArrayList<T> pucks, int x, int y, int dx, int dy, int depth, Player player){
        if(depth == 0) return;
        if(!isCoordinateInBounds(x,y) || puckBoard.get(x).get(y) == null) return;
        T puck = puckBoard.get(x).get(y);
        if(puck.getOwner() != player) return;
        pucks.add(puck);
        isGameWon(pucks,x+dx,y+dy,dx,dy,depth-1,player);
    }
    public int[][] buildBoardMatrix() {
        int[][] matrix = new int[size.VALUE][size.VALUE];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (puckBoard.get(i).get(j) == null) continue;
                matrix[i][j] = puckBoard.get(i).get(j).getOwner() instanceof BotPlayer ? 2 : 1;
            }
        }
        return matrix;
    }
    public String encodeBoard(){
        String rtn = "";
        for(int i = 0; i < size.VALUE; i++){
            for(int j = 0; j < size.VALUE; j++){
                T p = puckBoard.get(i).get(j);
                if(p == null) continue;
                rtn += String.format("%d.%d.%d",i,j,p.getOwner().getLabel()== Player.ConsoleLabel.X?1:2);
                rtn += ",";
            }
        }
        return rtn.charAt(rtn.length()-1)!=','?rtn:rtn.substring(0,rtn.length()-1);
    }
    public ArrayList<ArrayList<T>> decodeBoard(String encoding){
        for(String seg : encoding.split(",")){
            String [] data = seg.split(".");
            int x = Integer.parseInt(data[0]);
            int y = Integer.parseInt(data[1]);
            int p = Integer.parseInt(data[2]);

        }
        return null;
    }
    public ArrayList<ArrayList<T>> getPuckBoard(){
        return new ArrayList(this.puckBoard);
    }
}
