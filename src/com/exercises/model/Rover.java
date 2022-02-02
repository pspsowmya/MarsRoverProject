package com.exercises.model;

import java.util.ArrayList;
import java.util.List;

public class Rover extends NavigationService {

    private String position;
    private String instruction;
    private int x_coordinate;
    private int y_coordinate;
    private DirectionEnum direction;
    List<String> roverPositions = new ArrayList();
    public NavigationService navigationService = new NavigationService();

    public Rover(String position, String instruction) {
        this.position = position;
        this.instruction = instruction;
    }

    public void splitGivenPositionToXYAndDirection() {
        x_coordinate = Integer.parseInt(String.valueOf(position.charAt(0)));
        y_coordinate = Integer.parseInt(String.valueOf(position.charAt(2)));
        direction = DirectionEnum.valueOf(String.valueOf(position.charAt(4)));
    }

    public String getPositionBasedOnInstruction() throws Exception {
        splitGivenPositionToXYAndDirection();
        if (checkValidCoordinates()) {
            for (int i = 0; i <= instruction.length() - 1; i++) {
                splitGivenPositionToXYAndDirection();
                if (instruction.charAt(i) == 'L') {
                    position = navigationService.spinLeft(x_coordinate, y_coordinate, direction);
                } else if (instruction.charAt(i) == 'R') {
                    position = navigationService.spinRight(x_coordinate, y_coordinate, direction);
                } else if (instruction.charAt(i) == 'M') {
                    position = navigationService.movePosition(x_coordinate, y_coordinate, direction);
                }
            }
        } else {
            throw new Exception("Given input is outside the plateau range");
        }
        roverPositions.add(position);
        return position;
    }

    public boolean checkValidCoordinates() {
        boolean isValid = false;
        if (x_coordinate <= SquarePlateau.MAX_X_COORDINATE && y_coordinate <= SquarePlateau.MAX_Y_COORDINATE
                && x_coordinate >= SquarePlateau.MIN_X_COORDINATE && y_coordinate >= SquarePlateau.MIN_Y_COORDINATE) {
            isValid = true;
        }
        return isValid;
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
