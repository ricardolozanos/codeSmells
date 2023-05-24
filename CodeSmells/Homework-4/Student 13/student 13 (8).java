public class Main {
    public static void main(String[] args) {
        GameController Game = new GameController(new UserInterface());
        Game.start();
    }
}