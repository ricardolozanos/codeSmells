package noapplet.Record;
import java.util.Objects;

public record Place(int x, int y) {
    public Place {
        Objects.requireNonNull(x);
        Objects.requireNonNull(y);
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Place newX(int x) {
        return new Place(x, this.y);
    }

    public Place newY(int y) {
        return new Place(this.x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return x == place.x && y == place.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Place{" + "x=" + x + ", y=" + y + '}';
    }
}

