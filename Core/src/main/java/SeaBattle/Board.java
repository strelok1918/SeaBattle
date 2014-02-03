package SeaBattle;

import javafx.beans.value.ObservableObjectValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 02.02.14.
 */
public class Board {

    private ArrayList<Point> shots = new ArrayList<Point>();
    private ShipList ships = new ShipList();

    public Board() {
    }

    public boolean addShip(Ship currentShip) {
        return ships.addShip(currentShip);
    }

    public ShotResult shot(Point cell) {
       if(shots.contains(cell)) {
           return ShotResult.REPEAT;
       }
       shots.add(cell);
       return ships.shot(cell);
    }

    public boolean isAShip(Point cell) {
        return ships.isShip(cell);
    }
}
