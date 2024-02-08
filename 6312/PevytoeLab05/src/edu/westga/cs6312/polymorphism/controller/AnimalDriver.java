package edu.westga.cs6312.polymorphism.controller;

import edu.westga.cs6312.polymorphism.view.AnimalTUI;

/**
 * Runs the AnimalTUI program
 * 
 * @author William Pevytoe
 * 
 * @version 2/1/2024
 */

public class AnimalDriver {

	/**
	 * Creates the AnimalTUI instance 
	 *  
	 * @param args not used
	 */
	public static void main(String[] args) {
		AnimalTUI theTUI = new AnimalTUI();
		theTUI.run();

	}

}
