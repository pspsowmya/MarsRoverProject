package com.exercises.model.plateau;

/**
 * This class is to determine the max and min
 * coordinates of a square plateau
 */
public class SquarePlateauImpl extends Plateau {
    public static int max_X_Coordinate;
    public static int max_Y_Coordinate;
    public static final int MIN_X_COORDINATE = 0;
    public static final int MIN_Y_COORDINATE = 0;

    public SquarePlateauImpl(String coordinates) {
        super(coordinates);
        this.coordinates = coordinates;
    }

    @Override
    public int getMax_X_Coordinate() {
        max_X_Coordinate = Integer.parseInt(String.valueOf(coordinates.charAt(0)));
        return max_X_Coordinate;
    }

    @Override
    public int getMax_Y_Coordinate() {
        max_Y_Coordinate = Integer.parseInt(String.valueOf(coordinates.charAt(0)));
        return max_Y_Coordinate;
    }

}
