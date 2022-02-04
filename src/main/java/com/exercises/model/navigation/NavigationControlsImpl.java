package com.exercises.model.navigation;

import com.exercises.model.enums.DirectionEnum;

/**
 * This class provides methods to spin vehicles left and right based on the
 * instruction given by user
 */
public abstract class NavigationControlsImpl implements NavigationControls {
    protected String position;



    /**
     * This method is to spin the vehicle to left based on the instruction
     * given in the input and return position
     *
     * @param x_coordinate
     * @param y_coordinate
     * @param direction
     * @return
     */
    @Override
    public String spinLeft(int x_coordinate, int y_coordinate, DirectionEnum direction) {
        if (direction.equals(DirectionEnum.N)) {
            direction = DirectionEnum.W;
        } else if (direction.equals(DirectionEnum.S)) {
            direction = DirectionEnum.E;
        } else if (direction.equals(DirectionEnum.E)) {
            direction = DirectionEnum.N;
        } else if (direction.equals(DirectionEnum.W)) {
            direction = DirectionEnum.S;
        }
        position = getCurrentPositionAsString(x_coordinate, y_coordinate, direction);
        return position;
    }

    /**
     * This method is to spin the vehicle to right based on the instruction
     * given in the input and return position
     *
     * @param x_coordinate
     * @param y_coordinate
     * @param direction
     * @return
     */
    @Override
    public String spinRight(int x_coordinate, int y_coordinate, DirectionEnum direction) {
        if (direction.equals(DirectionEnum.N)) {
            direction = DirectionEnum.E;
        } else if (direction.equals(DirectionEnum.S)) {
            direction = DirectionEnum.W;
        } else if (direction.equals(DirectionEnum.E)) {
            direction = DirectionEnum.S;
        } else if (direction.equals(DirectionEnum.W)) {
            direction = DirectionEnum.N;
        }
        position = getCurrentPositionAsString(x_coordinate, y_coordinate, direction);
        return position;
    }


    /**
     * This method is to cast the final position to string and return
     *
     * @param x
     * @param y
     * @param direction
     * @return
     */
    @Override
    public String getCurrentPositionAsString(int x, int y, DirectionEnum direction) {
        position = x + " " + y + " " + direction;
        return position;
    }

}
