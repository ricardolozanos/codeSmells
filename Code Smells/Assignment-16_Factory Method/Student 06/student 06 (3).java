public class GrowingShrinkingBalloon implements Balloon{
    private int size;
    private final int defaultDirection;
    private int direction;
    public GrowingShrinkingBalloon(int initialSize, int initialDirection) {
        size = initialSize;
        direction = initialDirection;
        defaultDirection = initialDirection;
    }
    public void speed(int inflation) {
        size += inflation;
    }
    public int getSize() {
        if(size >= 400){
            direction = -direction;
        }
        else if(size <= 0){
            direction = defaultDirection;
        }
        speed(direction);
        return size;
    }
}
