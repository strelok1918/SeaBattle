package com.SeaBattle.core;

/**
 * Created by Igor on 02.02.14.
 */
public class Ship {
    public int shipLength;
    public Orientation direction;
    public int aliveDecks;
    public Point startPoint;

    public Ship(int length, Orientation dir, Point start) {
        shipLength = length;
        aliveDecks = length;
        direction = dir;
        startPoint = start.clone();
    }

    public void hit() {
        aliveDecks--;
    }

    public boolean isAlive() {
        return (aliveDecks > 0);
    }

    public boolean isCellBelongToShip(Point cell) {
        boolean result = false;

        switch(direction) {
            case HORIZONTAL:
                result = (startPoint.y == cell.y && Math.abs(startPoint.x - cell.x) < shipLength);
                break;
            case VERTICAL:
                result = (startPoint.x == cell.x && Math.abs(startPoint.y - cell.y) < shipLength);
                break;
        }
        return result;
    }
}
