package SeaBattle;

import java.util.ArrayList;

/**
 * Created by Igor on 03.02.14.
 */
public class ShipList {
    private ArrayList<Ship> ships = new ArrayList<Ship>();

    public boolean addShip(Ship currentShip) {
        if(canAddShip(currentShip)) {
            ships.add(currentShip);
            return true;
        }
        return false;
    }

    public Ship getShip(int index) {
        return ships.get(index);
    }

    public int shipCount() {
        return ships.size();
    }

    public ShotResult shot(Point cell) {
        for(int i = 0; i < ships.size(); i++) {
            if(ships.get(i).isCellBelongToShip(cell)) {
                return markHit(i);
            }
        }
        return ShotResult.MISS;
    }

    private ShotResult markHit(int shipIndex) {
        ships.get(shipIndex).hit();
        if(ships.get(shipIndex).isAlive()) {
            return ShotResult.HIT;
        } else {
            return ShotResult.SINKED;
        }
    }

    public boolean isShip(Point cell) {
        for(Ship item : ships) {
            if(item.isCellBelongToShip(cell)) {
                return true;
            }
        }
        return false;
    }

    private boolean canAddShip(Ship currentShip) {
        return !shipLimitRiched(currentShip) && checkShipCells(currentShip);
    }



    private boolean checkShipCells(Ship currentShip){
        Point currentCell = currentShip.startPoint;
        Point add = Point.getIncrement(currentShip.direction);

        for(int length = 0; length < currentShip.shipLength; length++){
            if(!isCellCorrect(currentCell)) {
                return false;
            }
            currentCell.next(add);
        }
        return true;
    }

    private boolean isCellCorrect(Point cell) {
        if(outOfBoard(cell)) {
            return false;
        }
        for(Ship item: ships) {
            if(neighbourToShip(item, cell)) {
                return false;
            }
        }
        return true;
    }

    private boolean neighbourToShip(Ship currentShip, Point cell) {
        Point currentCell = currentShip.startPoint;
        Point add = Point.getIncrement(currentShip.direction);

        for(int length = 0; length < currentShip.shipLength; length++) {
            if(currentCell.neighbour(cell)) {
                return false;
            }
            currentCell.next(add);
        }
        return true;
    }

    private boolean outOfBoard(Point cell) {
        return !(cell.x >= 0 && cell.x <= Constants.boardWidth && cell.y >= 0 && cell.y <= Constants.boardHeight);
    }

    private boolean shipLimitRiched(Ship currentShip) {
        int count = 0;
        for(Ship item : ships) {
            if(currentShip.shipLength == item.shipLength) {
                count++;
            }
        }
        if(currentShip.shipLength == 4 && count >= Constants.fourDeckCount) {
            return false;
        }

        if(currentShip.shipLength == 3 && count >= Constants.threeDeckCount) {
            return false;
        }

        if(currentShip.shipLength == 2 && count >= Constants.twoDeckCount) {
            return false;
        }

        if(currentShip.shipLength == 1 && count >= Constants.oneDeckCount) {
            return false;
        }
        return true;
    }
}
