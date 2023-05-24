public class GrowingBalloon implements Balloon{
    private int size;
    private int direction;
    public GrowingBalloon(int initialSize, int initDir) {
        size = initialSize;
        direction = initDir;
    }
    public void speed(int inflation) {
        size += inflation;
    }
    public int getSize() {
        if(size >= 400){
            speed(0);
        }
        else {
            speed(2);
        }
        return size;
    }
}
