package com.exercises.model.navigation;

import com.exercises.model.enums.DirectionEnum;
import com.exercises.model.plateau.SquarePlateauImpl;

/**
 * This class represents Navigation service and has methods that
 * help to navigate the first vehicle such as Rover or Robot
 */
public class NavigationServiceForFirstRover extends NavigationControlsImpl {

    /**
     * This method is to move the first vehicle one step forward or backward direction
     * and skip the instruction if the coordinates are not valid
     * and return final position
     *
     * @param x_coordinate
     * @param y_coordinate
     * @param direction
     * @return
     */
    @Override
    public String movePosition(int x_coordinate, int y_coordinate, DirectionEnum direction) {
        if (direction.equals(DirectionEnum.N)) {
            if (y_coordinate < SquarePlateauImpl.max_Y_Coordinate) {
                y_coordinate = y_coordinate + 1;
            } else {
                y_coordinate = y_coordinate;
            }
        } else if (direction.equals(DirectionEnum.S)) {
            if ((y_coordinate > SquarePlateauImpl.MIN_Y_COORDINATE)) {
                y_coordinate = y_coordinate - 1;
            } else {
                y_coordinate = y_coordinate;
            }
        } else if (direction.equals(DirectionEnum.E)) {
            if (x_coordinate < SquarePlateauImpl.max_X_Coordinate) {
                x_coordinate = x_coordinate + 1;
            } else {
                x_coordinate = x_coordinate;
            }
        } else if (direction.equals(DirectionEnum.W)) {
            if (x_coordinate > SquarePlateauImpl.MIN_X_COORDINATE) {
                x_coordinate = x_coordinate - 1;
            } else {
                x_coordinate = x_coordinate;
            }
        }
        position = getCurrentPositionAsString(x_coordinate, y_coordinate, direction);
        return position;
    }


}
