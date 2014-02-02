package com.SeaBattle;

/**
 * Created by Igor on 02.02.14.
 */
public class Ship {
    public int ShipLength;
    public Orientation Direction;
    public int AliveDecks;
    public Point StartPoint;

    public Ship(int Length, Orientation dir, Point start) {
        ShipLength = Length;
        AliveDecks = Length;
        Direction = dir;
        StartPoint = start;
    }
}
