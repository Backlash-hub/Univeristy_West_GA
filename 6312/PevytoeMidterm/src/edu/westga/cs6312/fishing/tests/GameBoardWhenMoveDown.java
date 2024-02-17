package edu.westga.cs6312.fishing.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.fishing.model.GameBoard;

/**
 * Test the GameBoard Move Down to make sure it tracks the Angler's position correctly
 * 
 * @author William Pevytoe
 * 
 * @version 2/16/2024
 */
class GameBoardWhenMoveDown {

	/**
	 * Test the MoveDown method to test tracking Angler's position (1 move)
	 */
	@Test
	public void testGameBoardWhenMoveDownOne() {
		GameBoard theBoard = new GameBoard();
		theBoard.moveDown();
		assertEquals("Fishing hole at [ 1 ]", theBoard.getFishingHoleLocation().getLocation());
	}
	
	/**
	 * Test the MoveDown method to test tracking Angler's position (5 moves)
	 */
	@Test
	public void testGameBoardWhenMoveDownFive() {
		GameBoard theBoard = new GameBoard();
		for (int position = 0; position < 5; position++) {
			theBoard.moveDown();
		}
		assertEquals("Fishing hole at [ 5 ]", theBoard.getFishingHoleLocation().getLocation());
	}
	
	/**
	 * Test the MoveDown method to test tracking Angler's position with rollover (12 moves)
	 */
	@Test
	public void testGameBoardWhenMoveDownTwelve() {
		GameBoard theBoard = new GameBoard();
		for (int position = 0; position < 12; position++) {
			theBoard.moveDown();
		}
		assertEquals("Fishing hole at [ 2 ]", theBoard.getFishingHoleLocation().getLocation());
	}

}
