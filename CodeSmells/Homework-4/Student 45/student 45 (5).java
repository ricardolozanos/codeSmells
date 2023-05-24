package guiboard.panels;

/** Messages for a User*/

public class Dialog {
    public Dialog(){
        //empty
    }

    /** String to indicate that a game is in progress.
     *
     * @return message for user.
     */

    public String gameProgress(){
        return "Game in progress.";
    }
    /** String to Declare a winner.
     *
     * @return message for user.
     */
    public String winner(String s){
        return s +"is the winner!";
    }
    /** String when a user doesn't choose an Opponent.
     *
     * @return message for user.
     */
    public String noSelection(){
        return "No opponent has been selected.";
    }
}
