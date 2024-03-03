package edu.westga.cs6312.files.controller;

import edu.westga.cs6312.files.model.RealEstateManager;
import edu.westga.cs6312.files.view.RealEstateTUI;

/**
 * Runs the RealEstateTUI program
 * 
 * @author William Pevytoe
 * 
 * @version 2/28/2024
 */
public class RealEstateDriver {

	/**
	 * Runs the program
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		RealEstateManager newManager = new RealEstateManager();
		RealEstateTUI newEstateTui = new RealEstateTUI(newManager);
		newEstateTui.run();
	}

}
