import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CPUPlayer extends Player{
    public CPUPlayer(int pnum){
        super.pNum = pnum;
    }
    public boolean makeMove(int x, int y, Board board){
        //board.placeStone(x, y, pNum);
        //horizontal check for win moves
        for(int i=0; i<board.getSize(); i++){
            int csqstones = 0;
            for(int j=0; j<board.getSize(); j++){
                if(board.getBoard()[i][j] == pNum){
                    csqstones++;
                    //if there are 4 consecutive stones, check if the next or previous one is available
                    //if so, place stone and return.
                    if (csqstones == 4 && board.getBoard()[i][j+1] == 0 && (j+1) < board.getSize()){
                        //test
//                        System.out.println("this the test" + (j+1) + i);
                        return board.placeStone(j+2, i+1, pNum);
                    }
                    else if (csqstones == 4 && board.getBoard()[i][j-4] == 0 && (j-4) >= 0){
                        return board.placeStone(j-3, i+1, pNum);
                    }
                }
                else {
                    csqstones = 0;
                }
            }
        }
        //vertical check for win moves
        for(int ihor=0; ihor< board.getSize(); ihor++){
            int csqstones = 0;
            for(int jver=0; jver<board.getSize(); jver++){
                if(board.getBoard()[jver][ihor] == pNum){
                    csqstones++;
//                    System.out.println(csqstones);
//                    System.out.println("This is I" + ihor);
                    if (csqstones == 4 && board.getBoard()[jver+1][ihor] == 0 && (jver+1)< board.getSize()){
//                        System.out.println("This is the test" + j + i);
                        return board.placeStone(ihor+1, jver+2, pNum);
                    }
                    else if (csqstones == 4 && board.getBoard()[jver-4][ihor] == 0 && (jver-4) >= 0){
//                        return true;
//                        System.out.println("This is the test" + jver + ihor);
//                        return true;
                        return board.placeStone(ihor+1, jver-3, pNum);
                    }
//                    System.out.println("BETWEEN IFS");
                }
                else {
                    csqstones = 0;
                }
            }
        }
        //diagonal (/) check for win moves
        for(int i = 0; i<board.getSize()-4; i++){
            for(int j = 4; j< board.getSize(); j++){
                int csqstones = 0;
                if(board.getBoard()[i][j] == pNum) {
                    for (int k = 0; k < 4; k++) {
                        if (board.getBoard()[i + k][j - k] == pNum) {
//                            System.out.println("IN THE K LOOP");
                            csqstones++;
//                            System.out.println("Consecutive STONES " + csqstones);
                            if (csqstones == 4 && board.getBoard()[i + k + 1][j - k - 1] == 0 && (i+k+1)< board.getSize() && (j - k - 1) >= 0) {
//                                System.out.println("In the LAST IF");
                                return board.placeStone(j-k, i+k+2 , pNum);
                            }
                            if (csqstones == 4 && board.getBoard()[i - 1][j + 1] == 0 && (i-1) >=0 && (j+1) < board.getSize()) {
                                return board.placeStone(j+2, i, pNum);
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        //diagonal (\) check for win moves
        for(int i = 0; i<board.getSize()-4; i++){
            for(int j = 0; j<board.getSize()-4; j++){
                int csqstones = 0;
                if(board.getBoard()[i][j] == pNum){
                    for(int k = 0; k<5; k++) {
                        if (board.getBoard()[i + k][j + k] == pNum) {
//                            System.out.println("board coordinate " + (i + k) + " " + (j + k) + " board val " + board[i + k][j + k] + " pnum " + player.pNum);
                            csqstones++;
//                            System.out.println("csqstones = " + csqstones);
                            if (csqstones == 4 && board.getBoard()[i + k + 1][j + k + 1] == 0 && (i+k+1)< board.getSize() && (j+k+1)< board.getSize()) {
                                return board.placeStone(j + k + 2, i + k + 2, pNum);
                            }
                            if (csqstones == 4 && board.getBoard()[i - 1][j - 1] == 0 && (i-1) >=0 && (j-1) >=0) {
                                return board.placeStone(j, i, pNum);
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        // Place stone near opponent's
        for(int i = 0; i< board.getSize(); i++){
            for(int j = 0; j< board.getSize(); j++){
                if(board.getBoard()[i][j] == 1){
                    Set<int[]> neighbors = board.getNeighbors(i, j);
                    //select random neighbor of oponent's play
                    int[][] arrayOfArrays = neighbors.toArray(new int[0][]);
                    for(int k = 0; k< arrayOfArrays.length; k++){
                        arrayOfArrays = neighbors.toArray(new int[0][]);
                        int randomIndex = new Random().nextInt(arrayOfArrays.length);
                        int[] randomArray = arrayOfArrays[randomIndex];
                        if(board.placeStone(randomArray[1]+1, randomArray[0]+1, pNum)) return true;
                        neighbors.remove(randomArray);
                    }


//                    System.out.println("x"+j+"y"+i);
//                    for (int[] coordinates : neighbors) {
//                        for (int coo : coordinates){
//                            System.out.print(coo+" ");
//                        }
//                        System.out.println();
//                    }
//                    for (int[] coordinates : neighbors) {
//                        if(board.placeStone(coordinates[1]+1, coordinates[0]+1, pNum)) return true;
//                    }
                }
            }
        }
        return false;
    }
}
