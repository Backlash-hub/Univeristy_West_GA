package edu.westga.cs6312.fishing.controller;

import edu.westga.cs6312.fishing.model.GameBoard;
import edu.westga.cs6312.fishing.view.FishingTUI;

/**
 * Runs the FishingTUI program
 * 
 * @author William Pevytoe
 * 
 * @version 2/13/2024
 */
public class FishingDriver {

	/**
	 * Runs the program
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		GameBoard newGame = new GameBoard();
		FishingTUI fishingTUI = new FishingTUI(newGame);
		fishingTUI.run();
	}

}
