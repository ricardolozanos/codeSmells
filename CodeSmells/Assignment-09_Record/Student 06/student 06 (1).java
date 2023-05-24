import java.util.Objects;

public class equivalent {
    private final int x, y;

    public equivalent(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int x(){
        return x;
    }
    public int y(){
        return y;
    }
    @Override
    public String toString(){
        return "Place [x="+x+", y="+y+"]";
    }
    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (!(object instanceof equivalent)) return false;
        equivalent other = (equivalent) object;
        return x == other.x && y == other.y;
    }
    @Override
    public int hashCode(){
        return Objects.hash(x(), y());
    }

}
