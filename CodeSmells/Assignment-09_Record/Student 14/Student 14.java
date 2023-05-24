public class place {
    private int x,y;

    public place(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public boolean equals(Object t){
        if (this == t) {
            return true;
        }
        if (t == null) {
            return false;
        }
        if (getClass() != t.getClass()){
            return false;
        }
        place other = (place) t;
        if (other.x() == x && other.y() == y){
            return true;
        }
        return false;
    }
    public int hashCode(){
        int o = 0;
        o = o << 8|(int) x;
        o = o << 8|(int) y;
        return o;
    }
    public String toString(){
        String out = String.format("place [x=%d, y=%d]", x, y);   
        return out; 
    }    public static void main(String[] args) {
        place k = new place(10, 30);
        place g = new place(10, 30);
        place f = new place(10, 10);
        System.out.println(k.toString());
        System.out.println(k.equals(g));
        System.out.println(k.equals(f));
        System.out.println(k.hashCode());
        System.out.println(g.hashCode());
        System.out.println(k);

    }
}
