package edu.westga.cs6312.fishing.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.fishing.model.SmallFish;

/**
 * Test to confirm the catchFish method works
 * 
 * @author William Pevytoe
 * 
 * @version 2/15/2024
 */
class SmallFishWhenCatchFish {

	/**
	 * Test to confirm the catchFish method works
	 */
	@Test
	public void testSmallFishWhenCatchFish() {
		SmallFish theSmallFish = new SmallFish();
		assertEquals(50, theSmallFish.catchFish());
	}

}
