public final class placeRecords {
    private final int x;
    private final int y;

    public placeRecords(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int x() {
        return x;
    }
    public int y() {
        return y;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof placeRecords)) {
            return false;
        }
        placeRecords other = (placeRecords) obj;
        return this.x == other.x && this.y == other.y;
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
