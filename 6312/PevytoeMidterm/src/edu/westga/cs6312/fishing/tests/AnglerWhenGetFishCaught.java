package edu.westga.cs6312.fishing.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.fishing.model.Angler;

/**
 * Testing the accessor for the number of fish caught method function correctly
 * 
 * @author William Pevytoe
 * 
 * @version 2/13/2024
 */
class AnglerWhenGetFishCaught {

	/**
	 * Testing the Accessor for the number of fish caught of the Angler 
	 */
	@Test
	public void testTheAngelerGetterForGetFishCaught() {
		Angler newFisher = new Angler();
		assertEquals(0, newFisher.getFishCaught());
	}
}
