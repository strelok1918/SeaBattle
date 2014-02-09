package com.SeaBattle.core;

/**
 * Created by Igor on 02.02.14.
 */

public class Point implements Cloneable {
    public Integer x;
    public Integer y;
    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
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

    public String toString() {
        return x.toString() + " " + y.toString();
    }
    public static Point getIncrement(Orientation direction) {
        if(direction.equals(Orientation.HORIZONTAL)) {
            return new Point(1, 0);
        } else {
            return new Point(0, 1);
        }
    }

    public Point getPointByNum(Integer num) {
        Integer x = num / Constants.boardWidth;
        Integer y = num - x * Constants.boardWidth;
        return new Point(x, y);
    }
    @Override
    public boolean equals(Object obj) {
        Point p = (Point)obj;
        return (p.x == x && p.y == y);
    }
}
