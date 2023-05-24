public class Place {

    private int x;
    private int y;

    public Place (){

    }

    public Place(int x, int y){

        this.x = x;
        this.y = y;
    }

    public void setX(int x){
        this.x = x;

    }

    public void setY(int y){
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }

        Place other = (Place) obj;

        if (x != other.x){
            return false;
        }
        if (y != other.y){
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        int h;
        return result;

    }

    @Override
    public String toString() {
        return "[Place 1: " + x + " Place 2:" +y+ "]";
    }
}
