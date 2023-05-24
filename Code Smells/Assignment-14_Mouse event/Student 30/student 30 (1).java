package noapplet.Files;

public class CounterModel {

    private int value;

    /**
     * Increments the value by 1 when clicking the increment button
     */
    public void incrementValue(){
        value = value + 1;
    }

    /**
     * Decrements the value by 1 when clicking the decrement value
     * button
     */
    public void decrementValue(){
        value = value - 1;
    }

    /**
     * Resets the value to 0 by clicking the reset button
     */
    public void reset (){
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
