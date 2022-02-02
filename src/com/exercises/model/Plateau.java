package com.exercises.model;

public abstract class Plateau {

    String coordinates;

    public Plateau(String coordinates){
        this.coordinates = coordinates;
    }

    public abstract int getMax_X_Coordinate();
    public abstract int getMax_Y_Coordinate();

}
