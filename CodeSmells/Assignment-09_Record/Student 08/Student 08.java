public class Record {
    public record Test(int x, int y){}

    public static void main(String[] args) {
        Test t = new Test(100, 200      );
        System.out.println(t.x() + "," + t.y());
        System.out.println(t.equals(new Test(100, 200)));
        System.out.println(t.equals(new Test(150, 200)));
        System.out.println(t.hashCode());
        System.out.println(t);
        System.out.println();

        System.out.println("TEST 2");

        Test2 t2 = new Test2(100, 200);
        System.out.println(t2.x() + "," + t2.y());
        System.out.println(t2.equals(new Test2(100, 200)));
        System.out.println(t2.equals(new Test2(150, 200)));
        System.out.println(t2.hashCode2());
        System.out.println(t2);
    }

}

class Test2 {
    private final int x, y;

    public Test2(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public boolean equals(Test2 other) {
        if (this == other) { return true; }

        if (other == null) { return false; }

        if (getClass() != other.getClass()) { return false; }

        Test2 otherObj = (Test2) other;

        return true;

   }

    public int hashCode2() {
        return x * 31 + y;
    }

    public String toString() {
        return String.format("Test2[x=%d, y=%d]", x, y);
    }
}


