public interface Puck {
    Player owner = null;
    boolean lockedFinal = false;
    int x = 0, y = 0;
    Player getOwner();
    int getX();
    int getY();
    void lockFinal();
    void setX(int x);
    void setY(int y);
    void setOwner(Player owner);
    boolean equals(Object other);
    int hashCode();
}
