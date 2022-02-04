package com.exercises.model.vehicles;

/**
 * This interface represents all the vehicles
 * like rovers, robots moving on the plateau
 */
public interface Vehicle {

    void splitGivenPositionToCoordinatesAndDirection(String position);

    String getPositionBasedOnInstruction(String position, String instruction) throws Exception;

    boolean checkValidCoordinates() throws Exception;

    boolean checkValidPosition(String position) throws Exception;


}
