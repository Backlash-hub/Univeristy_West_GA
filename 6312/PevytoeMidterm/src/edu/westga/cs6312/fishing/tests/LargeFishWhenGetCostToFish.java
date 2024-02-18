package edu.westga.cs6312.fishing.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.fishing.model.LargeFish;

/**
 * Test to confirm that the costToFish method works correctly
 * 
 * @author William Pevytoe
 * 
 * @version 2/16/2024
 */
class LargeFishWhenGetCostToFish {

	/**
	 * Test to confirm that the costToFish method works correctly
	 */
	@Test
	public void testLargeFishWhenGetCostToFish() {
		LargeFish theLargeFish = new LargeFish();
		assertEquals(50, theLargeFish.costToFish());
	}
}
