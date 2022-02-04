package com.exercises.app;

import com.exercises.model.plateau.Plateau;
import com.exercises.model.vehicles.Rover;
import com.exercises.model.plateau.SquarePlateauImpl;

public class Main {

    public static void main(String[] args) throws Exception {
        Plateau plateau = new SquarePlateauImpl("5 5");
        plateau.getMax_X_Coordinate();
        plateau.getMax_Y_Coordinate();

        Rover rover = new Rover();
        System.out.println(rover.getPositionBasedOnInstruction("1 2 N", "LMLMLMLMM"));
        System.out.println(rover.getPositionBasedOnInstruction("3 3 E", "MMRMMRMRRM"));
    }
}
