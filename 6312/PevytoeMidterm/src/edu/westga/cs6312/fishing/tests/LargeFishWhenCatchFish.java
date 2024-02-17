package edu.westga.cs6312.fishing.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.fishing.model.LargeFish;

/**
 * Test to confirm the catchFish method works
 * 
 * @author William Pevytoe
 * 
 * @version 2/16/2024
 */
class LargeFishWhenCatchFish {

	/**
	 * Test to confirm the catchFish method works
	 */
	@Test
	public void testLargeFishWhenCatchFish() {
		LargeFish theLargeFish = new LargeFish();
		assertEquals(50, theLargeFish.catchFish());
	}

}
