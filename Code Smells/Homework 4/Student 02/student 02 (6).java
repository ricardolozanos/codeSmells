package OmokConsole.Model;
/** Interface of different Omok game modes.
 * @author Jordan Aguon
 * @version 1.0 (2/26/23)
 */
public interface Game {
    /** Returns if coordinate on the board is empty or filled.
     */
    boolean checkPlace(int x, int y);

    /** Fills in coordinate on the board with symbol of current player.
     * @param x row on the board
     * @param y column on the board
     */
    void playerTurn(int x, int y);

    /** Computer player fills in coordinate to block a 3 or 4 in a row piece or places piece randomly
     */
    void comTurn();

    /** returns integer of how many pieces a player has connected at a coordinate in a given direction.
     * @param player which player to check pieces for.
     * @param x row on the board.
     * @param y column on the board.
     * @param dx next row to check for player piece.
     * @param dy next column to check for player piece.
     */
    int countPieces(int player, int x, int y, int dx, int dy);

    /** Returns true if player has 5 pieces in a row or false in any other condition
     * @param x row on the board
     * @param y column on the board
     */
    boolean checkWin(int x, int y);

    /** Returns true if board has no empty spaces available.
     */
    boolean checkTie();

    /** Returns winCon field.
     */
    boolean getWinCon();

    /** Returns getTieCon field.
     */
    boolean getTieCon();

    /** Returns currPlayer field.
     */
    Player getCurrPlayer();

    /** Returns player1 field.
     */
    Player getPlayer1();

    /** Returns player2 field.
     */
    Player getPlayer2();

    /** Returns board field.
     */
    Board getBoard();
}
