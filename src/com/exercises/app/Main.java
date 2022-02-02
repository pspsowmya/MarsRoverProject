package com.exercises.app;

import com.exercises.model.Plateau;
import com.exercises.model.Rover;
import com.exercises.model.SquarePlateau;

public class Main {

    public static void main(String[] args) throws Exception {
        Plateau plateau = new SquarePlateau("5 5");
        plateau.getMax_X_Coordinate();
        plateau.getMax_Y_Coordinate();

        Rover rover = new Rover("0 0 S", "MRMRMRMR");
        System.out.println(rover.getPositionBasedOnInstruction());
    }
}
