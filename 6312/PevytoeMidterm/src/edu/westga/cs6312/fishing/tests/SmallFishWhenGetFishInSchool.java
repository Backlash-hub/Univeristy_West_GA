package edu.westga.cs6312.fishing.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.fishing.model.SmallFish;

/**
 * Test to confirm getNumberOfFishInSchool accessor method functions correctly 
 * 
 * @author William Pevytoe
 * 
 * @version 2/15/2024
 */
class SmallFishWhenGetFishInSchool {

	/**
	 * Test the getNumberOfFishInSchool accessor method
	 */
	@Test
	public void testSmallFishWhenGetFishInSchool() {
		SmallFish theSmallFish = new SmallFish();
		assertEquals(100, theSmallFish.getNumberOfFishInSchool());
	}

}
