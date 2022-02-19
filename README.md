# Mars Rover Exercise Java

## Overview

This repository contains the implementation of Mars Rover Kata.
The main aim of this project is to move rovers around the Surface of Mars.The surface of Mars is represented by a Square Plateau. The Plateau is divided into a grid. Different vehicles on space like Rovers , Robots move on this grid. 
A rover moves based on the instruction provided by the user and the initial position of the rover also is given by the user as input.
The rover can spin to left / right or move a step forward or backward in different directions North, West, East and South based on the user instruction.
The final output should be the position where the rover has reached after passing through different positions from the instructions provided by the user. 

## Design

The UML class diagram for this project is inside the UML folder

We have the top most interface NavigationControls which takes care of few functionalities such as spin rover to left / right, move rovers on plateau and getting the final rover position.
The Abstract class NavigationControlsImpl implements the logic for spinning the rover left / right and the child classes NavigationServiceForFirstRover , NavigationServiceForOtherRovers implements the logic for moving rover on the plateau.

There is an abstract class plateau which specifies the coordinates of a grid

There is another interface called Vehicle which facilitates the movement of Rovers and other vehicles on the plateau. Vehicle inteface has a class called Rover which implements all the methods inside Vehicle interface to move the rover based on user provided inputs such as position and instruction.


**Instructions to run**

To run this project you need to fork the repository to your git account and clone it to your machine.
Once cloned you can run the tests using

mvn test

All the tests should pass and the application should run successfully for additional inputs.


## Future Thoughts

Different Shaped Plateaus 

Different type of vehicles






