package edu.westga.cs6312.interfaces.controller;

import edu.westga.cs6312.interfaces.view.RealEstateTUI;

/**
 * Runs the RealEstateTUI program
 * 
 * @author William Pevytoe
 * 
 * @version 2/7/2024
 */
public class RealEstateDriver {

	/**
	 * Runs the program
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		RealEstateTUI newEstateTUI = new RealEstateTUI();
		newEstateTUI.run();
	}

}
