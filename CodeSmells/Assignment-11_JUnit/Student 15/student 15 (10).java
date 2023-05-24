public class GoPuck implements Puck{
    private Player owner;
    private boolean lockedFinal;
    private int x,y;
    public GoPuck(){}
    public GoPuck(Player owner,int x, int y){
        this.owner = owner;
        this.x = x;
        this.y = y;
        lockedFinal = true;
    }
    public void setX(int x){
        if(lockedFinal) return;
        this.x = x;
    }
    public void setY(int y){
        if(lockedFinal) return;
        this.y = y;
    }
    public void setOwner(Player owner){
        if(lockedFinal) return;
        this.owner = owner;
    }

    public void lockFinal() {
        lockedFinal = true;
    }

    public int getX(){return x;}
    public int getY(){return y;}
    public Player getOwner(){
        return owner;
    }
    public boolean equals(Object other){
        if(other == null) return false;
        if(this == other) return true;
        if(this.getClass() != other.getClass()) return false;
        Puck tmp = (Puck)other;
        return x == tmp.x && y == tmp.y;
    }
}
