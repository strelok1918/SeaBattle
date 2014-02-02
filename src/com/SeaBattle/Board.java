package com.SeaBattle;

import android.graphics.Path;

import java.util.ArrayList;

/**
 * Created by Igor on 02.02.14.
 */
public class Board {
    private ArrayList<Ship> ShipsList = new ArrayList<Ship>();

    public void AddShip(Ship currentShip) {

        ShipsList.add(currentShip);
    }

    private boolean CanAddShip(Ship currentShip) {
        return !ShipLimitRiched(currentShip);
    }
    private boolean IsCellCorrect(Point cell, Ship currentShip) {
        for(Ship item: ShipsList) {
            if(NeighbourToShip(item, cell) || OutOfBoard(cell)) {
                return false;
            }
        }
        return true;
    }

    private boolean NeighbourToShip(Ship currentShip, Point cell) {
        Point currentCell = currentShip.StartPoint;
        Point add;
        if(currentShip.Direction.equals(Orientation.HORIZONTAL)) {
            add = new Point(1, 0);
        } else {
            add = new Point(0, 1);
        }

        for(int length = 0; length < currentShip.ShipLength; length++) {
            if(currentCell.Neighbour(cell)) {
                return false;
            }
            currentCell.Next(add);
        }
        return true;
    }

    private boolean OutOfBoard(Point cell) {
        return !(cell.x >= 0 && cell.x <= Constants.BoardWidth && cell.y >= 0 && cell.y <= Constants.BoardHeight);
    }

    private boolean ShipLimitRiched(Ship currentShip) {
        int count = 0;
        for(Ship item : ShipsList) {
            if(currentShip.ShipLength == item.ShipLength) {
                count++;
            }
        }
        if(currentShip.ShipLength == 4 && count >= Constants.FourDeckCount) {
            return false;
        }

        if(currentShip.ShipLength == 3 && count >= Constants.ThreeDeckCount) {
            return false;
        }

        if(currentShip.ShipLength == 2 && count >= Constants.TwoDeckCount) {
            return false;
        }

        if(currentShip.ShipLength == 1 && count >= Constants.OneDeckCount) {
            return false;
        }
        return true;
    }
}
