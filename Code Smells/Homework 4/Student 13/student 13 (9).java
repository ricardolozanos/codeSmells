public class MainGUI {
    public static void main(String[] args){
        GUserInterface gui = new GUserInterface();
        GameController control = new GameController(gui);
        gui.setController(control);
    }
}
