package com.exercises.model.navigation;

import com.exercises.model.enums.DirectionEnum;
import com.exercises.model.vehicles.Rover;
import com.exercises.model.plateau.SquarePlateauImpl;

/**
 * This class represents the Navigation service and has methods that
 * help to navigate the vehicles other than first vehicles
 * such as Rover or Robot
 */
public class NavigationServiceForOtherRovers extends NavigationControlsImpl {
    boolean flag = false;

    /**
     * This method is to move the other vehicles one step forward or backward direction
     * and skip the instruction if the coordinates are not valid or if there is already a
     * vehicle present in the position returned
     * and return final position
     *
     * @param x_coordinate
     * @param y_coordinate
     * @param direction
     * @return
     */
    @Override
    public String movePosition(int x_coordinate, int y_coordinate, DirectionEnum direction) {
        flag = true;
        for (int i = 0; i <= Rover.roverPositions.size() - 1; i++) {
            if (direction.equals(DirectionEnum.N)) {
                if ((y_coordinate < SquarePlateauImpl.max_Y_Coordinate)
                        && ((y_coordinate + 1 != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(2))))
                        || (x_coordinate != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(0)))))) {
                    if (i == Rover.roverPositions.size() - 1 && flag == true) {
                        y_coordinate = y_coordinate + 1;
                    }
                } else {
                    flag = false;
                    y_coordinate = y_coordinate;
                }
            } else if (direction.equals(DirectionEnum.S)) {
                if ((y_coordinate > SquarePlateauImpl.MIN_Y_COORDINATE)
                        && ((y_coordinate - 1 != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(2))))
                        || (x_coordinate != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(0)))))) {
                    if (i == Rover.roverPositions.size() - 1 && flag == true) {
                        y_coordinate = y_coordinate - 1;
                    }
                } else {
                    flag = false;
                    y_coordinate = y_coordinate;
                }
            } else if (direction.equals(DirectionEnum.E)) {
                if ((x_coordinate < SquarePlateauImpl.max_X_Coordinate)
                        && ((x_coordinate + 1 != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(0))))
                        || (y_coordinate != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(2)))))) {
                    if (i == Rover.roverPositions.size() - 1 && flag == true) {
                        x_coordinate = x_coordinate + 1;
                    }
                } else {
                    flag = false;
                    x_coordinate = x_coordinate;
                }
            } else if (direction.equals(DirectionEnum.W)) {
                if ((x_coordinate > SquarePlateauImpl.MIN_X_COORDINATE)
                        && ((x_coordinate - 1 != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(0))))
                        || (y_coordinate != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(2)))))) {
                    if (i == Rover.roverPositions.size() - 1 && flag == true) {
                        x_coordinate = x_coordinate - 1;
                    }
                } else {
                    flag = false;
                    x_coordinate = x_coordinate;
                }
            }
            position = getCurrentPositionAsString(x_coordinate, y_coordinate, direction);
        }
        return position;
    }
}
