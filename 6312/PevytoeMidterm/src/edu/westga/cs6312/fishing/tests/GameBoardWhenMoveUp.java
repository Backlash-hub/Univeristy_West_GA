package edu.westga.cs6312.fishing.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.fishing.model.GameBoard;

/**
 * Test the GameBoard Move Up to make sure it tracks the Angler's position correctly
 * 
 * @author William Pevytoe
 * 
 * @version 2/16/2024
 */
class GameBoardWhenMoveUp {

	/**
	 * Test the MoveUp method to test the roll over function
	 */
	@Test
	public void testGameBoardWhenMoveUpOne() {
		GameBoard theBoard = new GameBoard();
		theBoard.moveUp();
		assertEquals("Fishing hole at [ 9 ]", theBoard.getFishingHoleLocation().getLocation());
	}
	
	/**
	 * Test the MoveUp method 2 times
	 */
	@Test
	public void testGameBoardWhenMoveUpTwo() {
		GameBoard theBoard = new GameBoard();
		theBoard.moveUp();
		theBoard.moveUp();
		assertEquals("Fishing hole at [ 8 ]", theBoard.getFishingHoleLocation().getLocation());
	}

}
