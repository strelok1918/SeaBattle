package com.SeaBattle;

import java.util.ArrayList;

/**
 * Created by Igor on 02.02.14.
 */
public class Board {
    private ArrayList<Ship> shipsList = new ArrayList<Ship>();

    public void addShip(Ship currentShip) {
        if(canAddShip(currentShip)) {
            shipsList.add(currentShip);
        }
    }

    private boolean canAddShip(Ship currentShip) {
        return !shipLimitRiched(currentShip) && checkShipCells(currentShip);
    }

    private boolean checkShipCells(Ship currentShip){
        Point currentCell = currentShip.startPoint;
        Point add;
        if(currentShip.direction.equals(Orientation.HORIZONTAL)) {
            add = new Point(1, 0);
        } else {
            add = new Point(0, 1);
        }
        for(int length = 0; length < currentShip.shipLength; length++){
            if(!isCellCorrect(currentCell)) {
                return false;
            }
            currentCell.next(add);
        }
        return true;
    }

    private boolean isCellCorrect(Point cell) {
        for(Ship item: shipsList) {
            if(neighbourToShip(item, cell) || outOfBoard(cell)) {
                return false;
            }
        }
        return true;
    }

    private boolean neighbourToShip(Ship currentShip, Point cell) {
        Point currentCell = currentShip.startPoint;
        Point add;
        if(currentShip.direction.equals(Orientation.HORIZONTAL)) {
            add = new Point(1, 0);
        } else {
            add = new Point(0, 1);
        }

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
        for(Ship item : shipsList) {
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
