package com.SeaBattle;

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
        startPoint = start;
    }
}
