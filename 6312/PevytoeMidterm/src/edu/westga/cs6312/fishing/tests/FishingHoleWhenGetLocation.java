package edu.westga.cs6312.fishing.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.fishing.model.FishingHole;

/**
 * Test to confirm that the accessor method works correctly
 * 
 * @author William Pevytoe
 * 
 * @version 2/15/2024
 */
class FishingHoleWhenGetLocation {

	/**
	 *  Test to confirm that the accessor method works correctly with 0 in constructor
	 */
	@Test
	public void testFishingHoleOfOneWhenGetLocation() {
		FishingHole theGame = new FishingHole(0);
		assertEquals("Fishing hole at [ 0 ]", theGame.getLocation());		
	}
	
	/**
	 *  Test to confirm that the accessor method works correctly with nine in constructor
	 */
	@Test
	public void testFishingHoleOf9WhenGetLocation() {
		FishingHole theGame = new FishingHole(9);
		assertEquals("Fishing hole at [ 9 ]", theGame.getLocation());		
	}
	
	/**
	 *  Test to confirm that the accessor method works correctly with five in constructor
	 */
	@Test
	public void testFishingHoleOf5WhenGetLocation() {
		FishingHole theGame = new FishingHole(5);
		assertEquals("Fishing hole at [ 5 ]", theGame.getLocation());		
	}

}
