package SeaBattle;

/**
 * Created by Igor on 02.02.14.
 */
public class Point implements Cloneable {
    public int x;
    public int y;
    public Point(int xt, int yt) {
        x = xt;
        y = yt;
    }

    public Point clone() {
        return new Point(x, y);
    }

    public boolean neighbour(Point cell) {
        return (Math.abs(cell.x - x) <= 1 && Math.abs(cell.y - y) <= 1);
    }

    public void next(Point add) {
        x += add.x;
        y += add.y;
    }

    public static Point getIncrement(Orientation direction) {
        if(direction.equals(Orientation.HORIZONTAL)) {
            return new Point(1, 0);
        } else {
            return new Point(0, 1);
        }
    }
    @Override
    public boolean equals(Object obj) {
        Point p = (Point)obj;
        return (p.x == x && p.y == y);
    }
}
