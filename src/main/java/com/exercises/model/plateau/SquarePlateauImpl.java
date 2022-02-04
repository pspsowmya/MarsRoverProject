package com.exercises.model.plateau;

/**
 * This class is to determine the max and min
 * coordinates of a square plateau
 */
public class SquarePlateauImpl extends Plateau {
    private String coordinates;
    public static int MAX_X_COORDINATE;
    public static int MAX_Y_COORDINATE;
    public static final int MIN_X_COORDINATE = 0;
    public static final int MIN_Y_COORDINATE = 0;

    public SquarePlateauImpl(String coordinates) {
        super(coordinates);
        this.coordinates = coordinates;
    }

    @Override
    public int getMax_X_Coordinate() {
        MAX_X_COORDINATE = Integer.parseInt(String.valueOf(coordinates.charAt(0)));
        return MAX_X_COORDINATE;
    }

    @Override
    public int getMax_Y_Coordinate() {
        MAX_Y_COORDINATE = Integer.parseInt(String.valueOf(coordinates.charAt(0)));
        return MAX_Y_COORDINATE;
    }

}
