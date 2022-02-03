package com.exercises.model;

public class NavigationServiceForOtherRovers implements  NavigationControls{

    public String position;

    @Override
    public String spinLeft(int x, int y, DirectionEnum direction) {
        return null;
    }

    @Override
    public String spinRight(int x, int y, DirectionEnum direction) {
        return null;
    }

    @Override
    public String movePosition(int x_coordinate, int y_coordinate, DirectionEnum direction) {
        for(int i =0; i<=Rover.roverPositions.size()-1; i++){
        if (direction.equals(DirectionEnum.N)) {
            if ((y_coordinate < SquarePlateau.MAX_Y_COORDINATE)
                    && (y_coordinate + 1 != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(2))))
                    || (x_coordinate != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(0))))) {
                y_coordinate = y_coordinate + 1;
            } else {
                y_coordinate = y_coordinate;
            }
        } else if (direction.equals(DirectionEnum.S)) {
            if ((y_coordinate > SquarePlateau.MIN_Y_COORDINATE)
                    && (y_coordinate - 1 != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(2))))
                    || (x_coordinate != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(0))))) {
                y_coordinate = y_coordinate - 1;
            } else {
                y_coordinate = y_coordinate;
            }
        } else if (direction.equals(DirectionEnum.E)) {
            if ((x_coordinate < SquarePlateau.MAX_X_COORDINATE)
            && (x_coordinate + 1 != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(0))))
            || (y_coordinate != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(2))))) {
                x_coordinate = x_coordinate + 1;
            } else {
                x_coordinate = x_coordinate;
            }
        } else if (direction.equals(DirectionEnum.W)) {
            if ((x_coordinate > SquarePlateau.MIN_X_COORDINATE)
            && (x_coordinate - 1 != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(0))))
            || (y_coordinate != Integer.parseInt(String.valueOf(Rover.roverPositions.get(i).charAt(2))))) {
                x_coordinate = x_coordinate - 1;
            } else {
                x_coordinate = x_coordinate;
            }
        }
            position = getCurrentPositionAsString(x_coordinate, y_coordinate, direction);
        }
        return position;
    }


        @Override
        public String getCurrentPositionAsString(int x, int y, DirectionEnum direction) {
            position = x + " " + y + " " + direction;
            return position;
        }
    }
