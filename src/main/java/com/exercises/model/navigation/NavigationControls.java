package com.exercises.model.navigation;

import com.exercises.model.enums.DirectionEnum;

/**
 * This interface is to manage navigation controls for all the
 * vehicles on the plateau
 */
public interface NavigationControls {

    String spinLeft(int x, int y, DirectionEnum direction);

    String spinRight(int x, int y, DirectionEnum direction);

    String movePosition(int x, int y, DirectionEnum direction);

    String getCurrentPositionAsString(int x, int y, DirectionEnum direction);


}
