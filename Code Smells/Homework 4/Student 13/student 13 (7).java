public class LocalPlayer implements Playable {
    private String playerName;
    private int playerNum;
    private UserInterfaceable UI;
    public LocalPlayer(UserInterfaceable ui, String name, int num){
        playerName = name;
        playerNum = num;
        UI = ui;
    }
    @Override
    public int getPlayerNum(){return playerNum;}
    @Override
    public String getPlayerName() {
        return playerName;
    }
    @Override
    public int[] getStonePlacement(int[][] board){
        return UI.getStonePlacement(playerName);
    }

}
