package com.SeaBattle.core;

import java.util.ArrayList;

/**
 * Created by Igor on 02.02.14.
 */
public class Board {
    protected ArrayList<Shot> shots = new ArrayList<Shot>();
    protected ShipList ships = new ShipList();
    protected int aliveShips;

    public Board() {
        aliveShips = 0;
    }

    public boolean addShip(Ship currentShip) {
        if(ships.addShip(currentShip)){
            aliveShips++;
            return true;
        } else {
            return false;
        }
    }

    public boolean isDefeated(){
        return (aliveShips == 0);
    }

    public ShotResult shot(Point cell) {
       if(shots.contains(new Shot(cell, ShotResult.MISS))) {
           return ShotResult.REPEAT;
       }
       ShotResult result = ships.shot(cell);
       shots.add(new Shot(cell, result));
       if(result == ShotResult.SINKED) {
           aliveShips--;
       }
       return result;
    }

    public boolean isAShip(Point cell) {
        return ships.isShip(cell);
    }
}
