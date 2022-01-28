package com.exercises.app;

import com.exercises.model.Rover;
import com.exercises.model.SquarePlateau;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SquarePlateau sp = new SquarePlateau("5 5");
        sp.getMAX_X_COORDINATE();
        sp.getMAX_Y_COORDINATE();

        Rover r = new Rover("3 3 E", "MMRMMRMRRM");
        System.out.println(r.getPositionBasedOnInstruction());
    }
}
