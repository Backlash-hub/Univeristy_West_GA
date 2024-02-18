package edu.westga.cs6312.fishing.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.fishing.model.SmallFish;

/**
 * Test to confirm that the costToFish method works correctly
 * 
 * @author William Pevytoe
 * 
 * @version 2/15/2024
 */
class SmallFishWhenGetCostToFish {

	/**
	 * Test to confirm that the costToFish method works correctly
	 */
	@Test
	public void testSmallFishWhenGetCostToFish() {
		SmallFish theSmallFish = new SmallFish();
		assertEquals(25, theSmallFish.costToFish());
	}
}
