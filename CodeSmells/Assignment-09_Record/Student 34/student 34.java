package noapplet.recordThing;

public class recordEx {
    int x, y;

    recordEx(){

    }

    recordEx(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int hashCode(){
        return 1;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        return false;
    }
}
