public record  Place (int x, int y) {
    private static final String p = null;


    public Place(){
        this(0,0);
    }
    
    
    @Override
    public String toString() {
        return "Place [x=" + x + ", y=" + y + ", p=" + p + "]";
    }
    public int x() {
        return x;
    }
    public int y() {
        return y;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + ((p == null) ? 0 : p.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Place other = (Place) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        if (p == null) {
            if (Place.p != null)
                return false;
        } else if (!p.equals(Place.p))
            return false;
        return true;
    }
    

public static void main(String[] args) {
    Place p = new Place(10, 20);
    
    System.out.println(p.x() + ", " + p.y());
    System.out.println(p.equals(new Place(10,20)));
    System.out.println(p.hashCode());
    System.out.println(p); // toString() is called    
} 
    
}
    

 

