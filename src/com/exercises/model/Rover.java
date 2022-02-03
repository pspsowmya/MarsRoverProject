package com.exercises.model;

import java.util.ArrayList;
import java.util.List;

public class Rover extends NavigationService {

    private String position;
    private String instruction;
    private int x_coordinate;
    private int y_coordinate;
    private DirectionEnum direction;
    public static List<String> roverPositions = new ArrayList();
    public NavigationService navigationService = new NavigationService();
    public NavigationServiceForOtherRovers navigationServiceForOtherRovers = new NavigationServiceForOtherRovers();

    /*public Rover(String position, String instruction) {
        this.position = position;
        this.instruction = instruction;
    }*/

    public void splitGivenPositionToXYAndDirection(String position) {
        x_coordinate = Integer.parseInt(String.valueOf(position.charAt(0)));
        y_coordinate = Integer.parseInt(String.valueOf(position.charAt(2)));
        direction = DirectionEnum.valueOf(String.valueOf(position.charAt(4)));
    }

    public String getPositionBasedOnInstruction(String position, String instruction) throws Exception {
        this.position = position;
        this.instruction = instruction;
        splitGivenPositionToXYAndDirection(position);
        if (checkValidCoordinates()) {
            if (checkValidPosition(position)) {
                for (int i = 0; i <= instruction.length() - 1; i++) {
                    splitGivenPositionToXYAndDirection(position);
                    if (instruction.charAt(i) == 'L') {
                        position = navigationService.spinLeft(x_coordinate, y_coordinate, direction);
                    } else if (instruction.charAt(i) == 'R') {
                        position = navigationService.spinRight(x_coordinate, y_coordinate, direction);
                    } else if (instruction.charAt(i) == 'M') {
                        if(roverPositions.size()==0) {
                            position = navigationService.movePosition(x_coordinate, y_coordinate, direction);
                        }
                        else if(roverPositions.size()>0){
                            position = navigationServiceForOtherRovers.movePosition(x_coordinate,y_coordinate,direction);
                        }
                    }
                }
            }
        }
        roverPositions.add(position);
        return position;
    }

    public boolean checkValidCoordinates() throws Exception {
        boolean isValid = false;
        if (x_coordinate <= SquarePlateau.MAX_X_COORDINATE && y_coordinate <= SquarePlateau.MAX_Y_COORDINATE
                && x_coordinate >= SquarePlateau.MIN_X_COORDINATE && y_coordinate >= SquarePlateau.MIN_Y_COORDINATE) {
            isValid = true;
        }
        else {
            throw new Exception("Given input is outside the plateau range");
        }
        return isValid;
    }


    public boolean checkValidPosition(String position) throws Exception {
        boolean isValidPosition = false;
        if(roverPositions.size()>0) {
            for (int i = 0; i <= roverPositions.size() - 1; i++) {
                if (position.charAt(0) == roverPositions.get(i).charAt(0) && position.charAt(2) == roverPositions.get(i).charAt(2)) {
                    throw new Exception("Given position is invalid as there is already a rover at this position. Please start at another position..!!");
                }
                else{
                    isValidPosition = true;
                }
            }
        }
        else {
            isValidPosition = true;
        }
        return  isValidPosition;
    }


        public String getPosition () {
            return position;
        }

        public void setPosition (String position){
            this.position = position;
        }

        public String getInstruction () {
            return instruction;
        }

        public void setInstruction (String instruction){
            this.instruction = instruction;
        }

    }
