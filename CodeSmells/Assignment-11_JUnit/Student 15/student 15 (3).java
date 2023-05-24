import java.util.Scanner;
import java.util.UUID;

public class HumanPlayer extends Player{
    HumanPlayer(){}
    HumanPlayer(String name,String uuid){
        this.name = name;
        this.UID = UUID.fromString(uuid);
    }
    @Override
    public int[] playMove(Scanner scan){
        System.out.printf("Enter coordinate %s [ex. \"A13\"] : ",this);
        String coordinate = scan.nextLine();
        return Player.parseCoordinate(coordinate);
    }
}
