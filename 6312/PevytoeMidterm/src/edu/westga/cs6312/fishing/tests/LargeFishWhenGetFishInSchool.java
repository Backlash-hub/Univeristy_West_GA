package edu.westga.cs6312.fishing.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.fishing.model.LargeFish;

/**
 *Test to confirm getNumberOfFishInSchool accessor method functions correctly 
 * 
 * @author William Pevytoe
 * 
 * @version 2/16/2024
 */
class LargeFishWhenGetFishInSchool {

	/**
	 * Test the getNumberOfFishInSchool accessor method
	 */
	@Test
	public void testSmallFishWhenGetFishInSchool() {
		LargeFish theLargeFish = new LargeFish();
		assertEquals(50, theLargeFish.getNumberOfFishInSchool());
	}
}
