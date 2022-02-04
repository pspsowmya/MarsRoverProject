package com.exercises.model;

import com.exercises.model.plateau.Plateau;
import com.exercises.model.plateau.SquarePlateauImpl;
import com.exercises.model.vehicles.Rover;
import com.exercises.model.vehicles.Vehicle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NavigationServiceTest {
    @Test
    public void testMaxXCoordinateOfSquarePlateau() {
        //Arrange
        Plateau plateau = new SquarePlateauImpl("5 5");
        plateau.getMax_X_Coordinate();
        //Act
        int max_x_coordinate = plateau.getMax_X_Coordinate();
        //Assert
        assertEquals(5, max_x_coordinate);
    }

    @Test
    public void testMaxYCoordinateOfSquarePlateau() {
        //Arrange
        Plateau plateau = new SquarePlateauImpl("5 5");
        plateau.getMax_Y_Coordinate();
        //Act
        int max_y_coordinate = plateau.getMax_Y_Coordinate();
        //Assert
        assertEquals(5, max_y_coordinate);
    }

    @Test
    public void testRoverMovementBasedOnInstruction() throws Exception {
        //Arrange
        Vehicle vehicle = new Rover();

        //Act and Assert
        assertEquals("1 3 N", vehicle.getPositionBasedOnInstruction("1 2 N", "LMLMLMLMM"));
        assertEquals("5 1 E", vehicle.getPositionBasedOnInstruction("3 3 E", "MMRMMRMRRM"));
        assertEquals("0 0 N", vehicle.getPositionBasedOnInstruction("0 0 S", "MRMR"));
        assertEquals("0 2 W", vehicle.getPositionBasedOnInstruction("0 3 E", "MRMR"));
        assertEquals("1 2 E", vehicle.getPositionBasedOnInstruction("1 2 W", "MRMR"));
        assertEquals("1 5 E", vehicle.getPositionBasedOnInstruction("0 3 S", "MRMRRMLMMMRM"));
        assertEquals("1 0 W", vehicle.getPositionBasedOnInstruction("5 5 S", "MRMLMLMRMRMMMMLMRMLMMMRMM"));
    }
}
