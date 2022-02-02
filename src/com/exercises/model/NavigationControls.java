package com.exercises.model;

public interface NavigationControls {

     String spinLeft(int x, int y, DirectionEnum direction);
     String spinRight(int x, int y, DirectionEnum direction);
     String movePosition(int x, int y, DirectionEnum direction);
     String getCurrentPositionAsString(int x, int y, DirectionEnum direction);

}
