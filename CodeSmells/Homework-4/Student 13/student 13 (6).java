import java.util.Scanner;

/**
 * Singleton input class to avoid Scanner.close() closing System.in
 */
public final class Input {
    private static final Input instance = new Input();
    private Input(){}
    private Scanner inputScanner = new Scanner(System.in);

    /**
     * Provides the Input instance
     * @return the Input instance
     */
    public static Input getInstance(){
        return instance;
    }

    /**
     * Provides the next user input line
     * @return the next input line
     */
    public String next(){
        return inputScanner.next();
    }
    /**
     * Provides the next user input int
     * @return the next input int
     */
    public int nextInt(){
        return inputScanner.nextInt();
    }
    /**
     * Closes the Input scanner
     */
    public void close(){
        inputScanner.close();
    }
}
