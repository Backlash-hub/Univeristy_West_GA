package edu.westga.cs6312.fishing.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.fishing.model.SmallFish;

/**
 * Test to confirm constructor method functions correctly 
 * 
 * @author William Pevytoe
 * 
 * @version 2/15/2024
 */
class SmallFishWhenCreateSmallFish {

	/**
	 * Testing the 0 parameter constructor 
	 */
	@Test
	public void testSmallFishWhenCreateSmallFish() {
		SmallFish theSmallFish = new SmallFish();
		assertEquals("Small fish with 100 fish in the school", theSmallFish.toString());
	}

}
