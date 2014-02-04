package SeaBattle;

import javafx.beans.value.ObservableObjectValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 02.02.14.
 */
public class Board {

    private ArrayList<Shot> shots = new ArrayList<Shot>();
    private ShipList ships = new ShipList();

    public Board() {
    }

    public boolean addShip(Ship currentShip) {
        return ships.addShip(currentShip);
    }

    public ShotResult shot(Point cell) {
       if(shots.contains(new Shot(cell, ShotResult.MISS))) {
           return ShotResult.REPEAT;
       }
       ShotResult result = ships.shot(cell);
       shots.add(new Shot(cell, result));
       return result;
    }

    public boolean isAShip(Point cell) {
        return ships.isShip(cell);
    }
}
