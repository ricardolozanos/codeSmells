package game;

import java.lang.reflect.Array;
/** abstract to reperesant both human and machine players */
public abstract class player {
    protected board field;
    protected String token;

    public player(board field, String token){
        this.field = field;
        this.token = token;
    }

    public int[] place(int[] places){
        field.field[places[0]][places[1]] = token;
        return places;
    }
    /** here so machine player can use its no argument place always does 0, 0 */
    public int[] place(){
        return new int[]{0, 0};
    }

    
}
