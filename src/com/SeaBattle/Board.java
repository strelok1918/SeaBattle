package com.SeaBattle;

import java.util.ArrayList;

/**
 * Created by Igor on 02.02.14.
 */
public class Board {
    private ArrayList<Ship> shipsList = new ArrayList<Ship>();
    private ArrayList<Point> shots = new ArrayList<Point>();

    public int shot(Point cell) {
       if(shots.contains(cell)) {
           return ShotResult.Repeat;
       }
       if(checkHit(cell)) {
           return ShotResult.Hit;
       } else {
           return ShotResult.Miss;
       }
    }

    private boolean checkHit(Point cell) {
        for(Ship item : shipsList) {
            if(belong(cell, item)) {
                return true;
            }
        }
        return false;
    }

    private boolean belong(Point cell, Ship currentShip) {
        Point currentCell = currentShip.startPoint;
        Point add = getIncrement(currentShip.direction);
        for(int i = 0; i < currentShip.shipLength; i++) {
            if(cell.equals(currentCell)) {
                return true;
            }
            currentCell.next(add);
        }
        return false;
    }

    public void addShip(Ship currentShip) {
        if(canAddShip(currentShip)) {
            shipsList.add(currentShip);
        }
    }

    private boolean canAddShip(Ship currentShip) {
        return !shipLimitRiched(currentShip) && checkShipCells(currentShip);
    }

    private Point getIncrement(Orientation direction) {
        if(direction.equals(Orientation.HORIZONTAL)) {
            return new Point(1, 0);
        } else {
            return new Point(0, 1);
        }
    }

    private boolean checkShipCells(Ship currentShip){
        Point currentCell = currentShip.startPoint;
        Point add = getIncrement(currentShip.direction);

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
        Point add = getIncrement(currentShip.direction);

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
