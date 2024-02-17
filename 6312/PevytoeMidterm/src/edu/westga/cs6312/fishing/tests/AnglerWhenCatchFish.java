package edu.westga.cs6312.fishing.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.fishing.model.Angler;

/**
 * Testing that the catchFish method works correctly
 * 
 * @author William Pevytoe
 * 
 * @version 2/13/2024
 */
class AnglerWhenCatchFish {

	/**
	 * Test the catchFish method with a positive 1
	 */
	@Test
	public void testCatchFishWithOneFish() {
		Angler newFisher = new Angler();
		newFisher.catchFish(1);
		assertEquals(1, newFisher.getFishCaught());
	}
	
	/**
	 * Test the catchFish method with a positive 100
	 */
	@Test
	public void testCatchFishWithOneHundredFish() {
		Angler newFisher = new Angler();
		newFisher.catchFish(100);
		assertEquals(100, newFisher.getFishCaught());
	}
	
	/**
	 * Test the catchFish method with a positive 50
	 */
	@Test
	public void testCatchFishWithFiftyFish() {
		Angler newFisher = new Angler();
		newFisher.catchFish(50);
		assertEquals(50, newFisher.getFishCaught());
	}
	
	/**
	 * Test the catchFish throws proper error with with a negative number
	 */
	@Test
	public void testCatchFishWithNegativeFiveFish() {
		assertThrows(IllegalArgumentException.class, () -> {
		Angler newFisher = new Angler();
		newFisher.catchFish(-5);
		});
	}

}
