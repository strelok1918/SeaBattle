package SeaBattle;

import javafx.beans.value.ObservableObjectValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 02.02.14.
 */
public class Board {

    private ArrayList<Point> shots = new ArrayList<Point>();
    private ShipList ships;

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

    private boolean belong(Point cell, Ship currentShip) {
        Point currentCell = currentShip.startPoint;
        Point add = Point.getIncrement(currentShip.direction);

        for(int i = 0; i < currentShip.shipLength; i++) {
            if(cell.equals(currentCell)) {
                return true;
            }
            currentCell.next(add);
        }
        return false;
    }
}
