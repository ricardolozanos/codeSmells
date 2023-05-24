//package noapplet.example;

public class place {
    private int x, y;
    public place(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int x(){return x;}
    public int y(){return y;}
    public boolean equals(Object t){
        if(this == t){
            return true;
        }
        if(t == null){
            return false;
        }
        if(getClass() != t.getClass()){
            return false;
        }
        place other= (place)t;
        if(other.x() == x && other.y() == y){
            return true;
        }
        return false;
    }
    public int hashcode(){
        int i = 0;
        i = i << 8|(int) x;
        i = i << 8|(int) y;
        return i;
    }
    public String toString(){
        String out = String.format("Place [x=%d, y=%d]", x, y);
        return out;
    }
    public static void main(String[] args){
        place a = new place(15,15);
        place b = new place(100, 50);
        place c = new place(50,80);
        place d = new place(40,40);
        System.out.println(a.toString());
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.equals(d));
        System.out.println(a.hashcode());
        System.out.println(b.hashcode());
        System.out.println(c.hashcode());
        System.out.println(a);
        System.out.println(b);
        System.out.println(d);
    }
}
