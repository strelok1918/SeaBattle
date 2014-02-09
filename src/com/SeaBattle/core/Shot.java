package com.SeaBattle.core;

/**
 * Created by Igor on 04.02.14.
 */
public class Shot {
    ShotResult shotResult;
    Point cell;
    public Shot(Point cell, ShotResult result) {
        this.cell = cell.clone();
        shotResult = result;
    }

    @Override
    public boolean equals(Object obj) {
        Shot shot = (Shot)obj;
        return (shot.cell.equals(this.cell));
    }
}
