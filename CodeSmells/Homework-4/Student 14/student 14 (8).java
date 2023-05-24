package game;

/** commands for machine player*/
public class mplayer extends player {

    public mplayer (board field, String token){
        super(field, token);
    }
    
    /** basic stratagey places down rows as much as able, blocking player rows, only ignoring if its next play can win*/
    public int[] place(){
        int i = 0;
        int j = 0;
        while(field.getboard()[i][j] != "*"){
            if(i != field.size-1){
                i+=1;
            } else {
                j += 1;
                i = 0;
            }
        }
        if(field.getboard()[field.aiwin[0]][field.aiwin[1]]=="*"){
            return super.place(field.aiwin);
        }
        if(field.getboard()[field.blockneed[0]][field.blockneed[1]]=="*"){
            return super.place(field.blockneed);
        }
        int[] out = new int[]{i, j};
        return super.place(out);
    }
}