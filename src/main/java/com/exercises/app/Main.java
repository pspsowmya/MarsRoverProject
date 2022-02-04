package com.exercises.app;

import com.exercises.model.plateau.Plateau;
import com.exercises.model.vehicles.Rover;
import com.exercises.model.plateau.SquarePlateauImpl;
import com.exercises.model.vehicles.Vehicle;

public class Main {

    public static void main(String[] args) throws Exception {
        Plateau plateau = new SquarePlateauImpl("5 5");
        plateau.getMax_X_Coordinate();
        plateau.getMax_Y_Coordinate();

        Vehicle vehicle = new Rover();

        System.out.println(vehicle.getPositionBasedOnInstruction("1 2 N", "LMLMLMLMM")); // 1 3 N
        System.out.println(vehicle.getPositionBasedOnInstruction("3 3 E", "MMRMMRMRRM")); // 5 1 E
        System.out.println(vehicle.getPositionBasedOnInstruction("0 0 S", "MRMR")); // 0 0 N
        System.out.println(vehicle.getPositionBasedOnInstruction("0 3 E", "MRMR")); // 0 2 W
        System.out.println(vehicle.getPositionBasedOnInstruction("1 2 W", "MRMR")); // 1 2 E
        System.out.println(vehicle.getPositionBasedOnInstruction("0 3 S", "MRMRRMLMMMRM")); // 1 5 E
        System.out.println(vehicle.getPositionBasedOnInstruction("5 5 S", "MRMLMLMRMRMMMMLMRMLMMMRMM")); // 1 0 W
        //System.out.println(vehicle.getPositionBasedOnInstruction("0 0 W", "MRMR")); // Exception


    }
}
