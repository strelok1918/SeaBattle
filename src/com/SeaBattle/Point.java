package com.SeaBattle;

/**
 * Created by Igor on 02.02.14.
 */
public class Point {
    public int x;
    public int y;
    public Point(int xt, int yt) {
        x = xt;
        y = yt;
    }

    public boolean neighbour(Point cell) {
        return (Math.abs(cell.x - x) <= 1 && Math.abs(cell.y - y) <= 1);
    }

    public void next(Point add) {
        x += add.x;
        y += add.y;
    }
}
