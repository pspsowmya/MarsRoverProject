package com.exercises.model.vehicles;

import com.exercises.model.enums.DirectionEnum;
import com.exercises.model.plateau.SquarePlateauImpl;


/**
 * This class determines and validates of rover coordinates
 * based on user input
 */
public class Rover extends MissionControls {

    /**
     * This method spilts given position into X,Y coordinates and direction
     *
     * @param position
     */
    @Override
    public void splitGivenPositionToCoordinatesAndDirection(String position) {
        x_coordinate = Integer.parseInt(String.valueOf(position.charAt(0)));
        y_coordinate = Integer.parseInt(String.valueOf(position.charAt(2)));
        direction = DirectionEnum.valueOf(String.valueOf(position.charAt(4)));
    }

    /**
     * This method checks if the given input coordinates are valid or not
     * and return
     *
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkValidCoordinates() throws Exception {
        boolean isValid = false;
        if (x_coordinate <= SquarePlateauImpl.max_X_Coordinate && y_coordinate <= SquarePlateauImpl.max_Y_Coordinate
                && x_coordinate >= SquarePlateauImpl.MIN_X_COORDINATE && y_coordinate >= SquarePlateauImpl.MIN_Y_COORDINATE) {
            isValid = true;
        } else {
            throw new Exception("Given input is outside the plateau range");
        }
        return isValid;
    }


}
