package com.exercises.model.plateau;

/**
 * This class is to represent the coordinates
 * of a plateau that we get from user as
 * input
 */
public abstract class Plateau {

    String coordinates;

    public Plateau(String coordinates) {
        this.coordinates = coordinates;
    }

    public abstract int getMax_X_Coordinate();

    public abstract int getMax_Y_Coordinate();

}
