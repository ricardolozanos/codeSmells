public class Counter {
    private int count;

    /**
     * Returns the current count value
     * @return : int the current count value
     */
    int getCount(){return count;}

    /**
     * Increments the current count value by one
     */
    void increment(){count++;}

    /**
     * Decrements the current count value by one, if and only if greater than zero
     */
    void decrement(){if(count > 0)count--;}

    /**
     * Resets the current count value to zero
     */
    void reset(){count = 0;}
}
