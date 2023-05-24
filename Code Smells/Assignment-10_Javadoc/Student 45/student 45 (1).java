package game;

/**
 * Handles anything to do with the board.
 */

public class Board{
    /**Rows of the board*/
    private int r = 0;
    /**Columns of the board*/
    private int c = 0;
    /**Size of the board*/
    protected int size;
    //private int x;
    /**New Board*/
    protected String[][] str;

    /**Current Board*/
    protected String[][] br;
    //private int y;
    /**Player piece of place*/
    private Place playerPiece;


    /**Used to Create the initial String[][] of a board
     *
     *@param str str is an empty Board.
     * @param br br is the Current Board.
     */
    public Board(String[][] str, String[][] br){
        this.str = str;
        this.br = br;
    }

    /**Used to Create the initial String[][] of a board
     *
     *@return str the new Board
     */
    public String[][] createintStr(){
        str = new String[size][size];
        for(int x =0;x<size;x++){
            for(int y = 0;y<size;y++){
                str[x][y]= ".  ";
            }
        }
        return str;


    }

    /**Prints a new board from the String[][] that is given*/

    public void drawBoard(){
        String rc_ = "";
        for(int x =0;x<br.length;x++){
            StringBuilder h = new StringBuilder();
            for(int y = 0;y<br[0].length;y++){
                h.append(br[x][y]);
                if(x==0){
                    if(c<10){
                        rc_ += Integer.toString(c)+"  ";
                        c++;
                        if(c == 10){
                            c = 0;
                        }
                    }

                }

            }
            if(x==0){
                System.out.println("   "+rc_);
            }
            if(r < 10){
                System.out.println(r+": "+h);
                r++;
                if(r == 10){
                    r = 0;
                }
            }
        }

    }
}
