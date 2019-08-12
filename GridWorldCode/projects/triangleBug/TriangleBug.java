/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class TriangleBug extends Bug
{
	private int baseSteps;
    private int steps;
    private int sideLength;

    /**
     * Constructs a triangle bug that traces a triangle of a given side length
     * @param length the side length
     */
    public TriangleBug(int length)
    {
        steps = 0;
        sideLength = length;
        if(length % 2 == 0){
        	baseSteps = length;
        } 
        else {
        	baseSteps = length + 1;
        }
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < baseSteps && canMove())
        {
            move();
            steps++;
        }
        else if(baseSteps == steps)
        {
            turn();
            turn();
            turn();
            if(canMove()){
            	move();
            	steps++;
            }
            else{
            	turn();
            }
        }
        else if(steps > baseSteps && steps < (baseSteps / 2) + baseSteps && canMove()){
        	move();
        	steps++;
        }
        else if(steps == (baseSteps / 2) + baseSteps){
        	turn();
        	turn();
        	if(canMove()){
            	move();
            	steps++;
            }
            else{
            	turn();
            }
        }
        else if(steps < 2 * baseSteps && steps > (baseSteps / 2) + baseSteps && canMove()){
        	move();
        	steps++;
        }
        else if(steps == 2 * baseSteps){
        	turn();
        	turn();
        	turn();
        	steps = 0;
        }
        else {
        	turn();
        }
    }
}
   