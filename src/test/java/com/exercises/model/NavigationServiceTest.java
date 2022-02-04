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
        //Act
        int max_x_coordinate = plateau.getMax_X_Coordinate();
        //Assert
        assertEquals(5, max_x_coordinate);
    }

    @Test
    public void testMaxYCoordinateOfSquarePlateau() {
        //Arrange
        Plateau plateau = new SquarePlateauImpl("5 5");
        //Act
        int max_y_coordinate = plateau.getMax_Y_Coordinate();
        //Assert
        assertEquals(5, max_y_coordinate);
    }

    @Test
    public void testRoverMovementBasedOnInstruction() throws Exception {
        //Arrange
        Vehicle vehicle = new Rover();
        //Act
        String position = vehicle.getPositionBasedOnInstruction("1 2 N", "LMLMLMLMM");
        //Assert
        assertEquals("1 3 N", position);
    }

    @Test
    public void testSecondRoverMovementBasedOnInstruction() throws Exception {
        //Arrange
        Plateau plateau = new SquarePlateauImpl("5 5");
        Vehicle vehicle = new Rover();
        //Act
        plateau.getMax_X_Coordinate();
        plateau.getMax_Y_Coordinate();
        String position = vehicle.getPositionBasedOnInstruction("3 3 E", "MMRMMRMRRM");
        //Assert
        assertEquals("5 1 E", position);
    }
}
