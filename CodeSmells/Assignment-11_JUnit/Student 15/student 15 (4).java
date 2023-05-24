import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

abstract class Player {
    public enum ConsoleLabel {
        X((byte)1),
        O((byte)0);
        final byte VALUE;
        ConsoleLabel(byte i){
            this.VALUE = i;
        }
    }
    protected String name;
    protected UUID UID = UUIDGenerator.generateUUIDFromComputerInfo();
    // FOR TESTING
//    protected  UUID UID = UUID.randomUUID();
    private ConsoleLabel label;
    public String getName(){return name;}
    public void setName(String name) {this.name = name;}
    public void setLabel(ConsoleLabel label){
        this.label = label;
    }
    public ConsoleLabel getLabel() {
        return label;
    }
    public static int[] parseCoordinate(String coordinate){
        if(coordinate.length() <= 1) return new int[]{-1,-1,-1};
        coordinate = coordinate.trim().toUpperCase(Locale.ROOT);
        if(coordinate.length() > 3) return new int[]{-1,-1,-1};
        System.out.println(coordinate);
        String row = coordinate.substring(0,1), col = coordinate.substring(1);
        int x, y;
        try{
            x = row.toUpperCase(Locale.ROOT).charAt(0) - 'A';
            y = Integer.parseInt(col) - 1;
        }
        catch (NumberFormatException e){ return null;}
        return new int[]{x,y,0};
    }
    public int [] playMove(Scanner scan){ return null;}
    public UUID getUID(){return this.UID;}
    @Override
    public int hashCode(){
        return this.UID.hashCode();
    }
    @Override
    public String toString(){
        return this.name;
    }
}
