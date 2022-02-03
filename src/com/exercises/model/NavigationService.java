package com.exercises.model;

public class NavigationService implements NavigationControls {

    public String position;

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

    @Override
    public String movePosition(int x_coordinate, int y_coordinate, DirectionEnum direction) {
        if (direction.equals(DirectionEnum.N)) {
            if(y_coordinate < SquarePlateau.MAX_Y_COORDINATE) {
                y_coordinate = y_coordinate + 1;
            }
            else {
                y_coordinate = y_coordinate;
            }
        } else if (direction.equals(DirectionEnum.S)) {
            if ((y_coordinate > SquarePlateau.MIN_Y_COORDINATE)) {
                y_coordinate = y_coordinate - 1;
            } else {
                y_coordinate = y_coordinate;
            }
        } else if (direction.equals(DirectionEnum.E)) {
            if(x_coordinate < SquarePlateau.MAX_X_COORDINATE){
                x_coordinate = x_coordinate + 1;
            }
            else{
                x_coordinate = x_coordinate;
            }
        } else if (direction.equals(DirectionEnum.W)) {
            if (x_coordinate > SquarePlateau.MIN_X_COORDINATE) {
                x_coordinate = x_coordinate - 1;
            } else {
                x_coordinate = x_coordinate;
            }
        }
        position = getCurrentPositionAsString(x_coordinate, y_coordinate, direction);
        return position;
    }


    @Override
    public String getCurrentPositionAsString(int x, int y, DirectionEnum direction) {
        position = x + " " + y + " " + direction;
        return position;
    }

}
