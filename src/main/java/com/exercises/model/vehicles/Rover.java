package com.exercises.model.vehicles;

import com.exercises.model.enums.DirectionEnum;
import com.exercises.model.navigation.NavigationControls;
import com.exercises.model.plateau.SquarePlateauImpl;
import com.exercises.model.navigation.NavigationServiceForOtherRovers;
import com.exercises.model.navigation.NavigationServiceForFirstRover;

import java.util.ArrayList;
import java.util.List;

/**
 * This class determines the navigation of rovers
 * on the plateau based on user input
 */
public class Rover implements Vehicle {

    private String position;
    private String instruction;
    private int x_coordinate;
    private int y_coordinate;
    private DirectionEnum direction;
    public static List<String> roverPositions = new ArrayList();
    NavigationControls navigationService = new NavigationServiceForFirstRover();
    NavigationControls navigationServiceForOtherRovers = new NavigationServiceForOtherRovers();

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
     * This method is to move the rover based on the instruction and position provided
     * as input and return position
     *
     * @param position
     * @param instruction
     * @return
     * @throws Exception
     */
    @Override
    public String getPositionBasedOnInstruction(String position, String instruction) throws Exception {
        this.position = position;
        this.instruction = instruction;
        splitGivenPositionToCoordinatesAndDirection(position);
        if (checkValidCoordinates()) {
            if (checkValidPosition(position)) {
                for (int i = 0; i <= instruction.length() - 1; i++) {
                    splitGivenPositionToCoordinatesAndDirection(position);
                    if (instruction.charAt(i) == 'L') {
                        position = navigationService.spinLeft(x_coordinate, y_coordinate, direction);
                    } else if (instruction.charAt(i) == 'R') {
                        position = navigationService.spinRight(x_coordinate, y_coordinate, direction);
                    } else if (instruction.charAt(i) == 'M') {
                        if (roverPositions.size() == 0) {
                            position = navigationService.movePosition(x_coordinate, y_coordinate, direction);
                        } else if (roverPositions.size() > 0) {
                            position = navigationServiceForOtherRovers.movePosition(x_coordinate, y_coordinate, direction);
                        }
                    }
                }
            }
        }
        roverPositions.add(position);
        return position;
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
        if (x_coordinate <= SquarePlateauImpl.MAX_X_COORDINATE && y_coordinate <= SquarePlateauImpl.MAX_Y_COORDINATE
                && x_coordinate >= SquarePlateauImpl.MIN_X_COORDINATE && y_coordinate >= SquarePlateauImpl.MIN_Y_COORDINATE) {
            isValid = true;
        } else {
            throw new Exception("Given input is outside the plateau range");
        }
        return isValid;
    }

    /**
     * This method is to check if the given position is valid or
     * if there is already a rover present in the given position
     * and return
     *
     * @param position
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkValidPosition(String position) throws Exception {
        boolean isValidPosition = false;
        if (roverPositions.size() > 0) {
            for (int i = 0; i <= roverPositions.size() - 1; i++) {
                if (position.charAt(0) == roverPositions.get(i).charAt(0) && position.charAt(2) == roverPositions.get(i).charAt(2)) {
                    throw new Exception("Given position is invalid as there is already a rover at this position. Please start at another position..!!");
                } else {
                    isValidPosition = true;
                }
            }
        } else {
            isValidPosition = true;
        }
        return isValidPosition;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

}
