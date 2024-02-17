package edu.westga.cs6312.fishing.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.fishing.model.LargeFish;

/**
 * Test to confirm constructor method functions correctly 
 * 
 * @author William Pevytoe
 * 
 * @version 2/16/2024
 */
class LargeFishWhenCreateLargeFish {

	/**
	 * Testing the 0 parameter constructor 
	 */
	@Test
	public void testLargeFishWhenCreateSmallFish() {
		LargeFish theLargeFish = new LargeFish();
		assertEquals("Large fish with 50 fish in the school", theLargeFish.toString());
	}
}
