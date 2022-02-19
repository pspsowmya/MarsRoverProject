package com.exercises.model;

import com.exercises.model.plateau.Plateau;
import com.exercises.model.plateau.SquarePlateauImpl;
import com.exercises.model.vehicles.Rover;
import com.exercises.model.vehicles.Vehicle;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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
    public void testCheckValidPosition() throws Exception {
        //Arrange
        Vehicle vehicle = new Rover();
        //Act
        boolean isValid = vehicle.checkValidPosition("0 0 N");
        //Assert
        assertEquals(true, isValid);
    }

    @Test
    public void testCheckInvalidPosition() {
        //Arrange
        Vehicle vehicle = new Rover();
        //Act and Assert
        assertThrows(Exception.class, () -> vehicle.checkValidPosition("0 0 N"));
    }


    @Test
    public void testCheckInvalidCoordinates() {
        //Arrange
        Vehicle vehicle = new Rover();
        vehicle.splitGivenPositionToCoordinatesAndDirection("6 6 N");
        //Act and Assert
        assertThrows(Exception.class, () -> vehicle.checkValidCoordinates());
    }


    @Test
    public void testRoverMovementBasedOnInstructionWithoutParameters() throws Exception {
        //Arrange
        Vehicle vehicle = new Rover();

        //Act
        String expectedPosition = vehicle.getPositionBasedOnInstruction("0 0 S", "MRMR");

        //Assert
        assertEquals("0 0 N", expectedPosition);
    }


    @ParameterizedTest
    @CsvSource({"1 2 N, LMLMLMLMM, 1 3 N", "3 3 E, MMRMMRMRRM, 5 1 E", "0 3 E, MRMR, 0 2 W", "1 2 W, MRMR, 1 2 E",
            "0 3 S, MRMRRMLMMMRM, 1 5 E", "5 5 S, MRMLMLMRMRMMMMLMRMLMMMRMM, 1 0 W"})
    public void testRoverMovementBasedOnInstructionWithParameters(ArgumentsAccessor argumentsAccessor) throws Exception {
        //Arrange
        String position = argumentsAccessor.getString(0);
        String instruction = argumentsAccessor.getString(1);
        String expectedPosition = argumentsAccessor.getString(2);
        Vehicle vehicle = new Rover();

        //Act and Assert
        assertEquals(expectedPosition, vehicle.getPositionBasedOnInstruction(position, instruction));
    }

    @Test
    public void testRoverMovementBasedOnInstructionForException() {
        //Arrange
        Vehicle vehicle = new Rover();

        //Act and Assert
        assertThrows(Exception.class, () -> vehicle.getPositionBasedOnInstruction("1 5 E", "LMLM"));
    }

}
