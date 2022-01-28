package com.exercises.model;

public class SquarePlateau extends Plateau{
    private String coordinates;
    private int MAX_X_COORDINATE;
    private int MAX_Y_COORDINATE;
    public final int MIN_X_COORDINATE = 0;
    public final int MIN_Y_COORDINATE = 0;

    public SquarePlateau(String coordinates){
        this.coordinates = coordinates;
    }

    public int getMAX_X_COORDINATE() {
        MAX_X_COORDINATE = Integer.parseInt(String.valueOf(coordinates.charAt(0)));
        return MAX_X_COORDINATE;
    }

    public int getMAX_Y_COORDINATE() {
        MAX_Y_COORDINATE = Integer.parseInt(String.valueOf(coordinates.charAt(0)));
        return MAX_Y_COORDINATE;
    }

}
