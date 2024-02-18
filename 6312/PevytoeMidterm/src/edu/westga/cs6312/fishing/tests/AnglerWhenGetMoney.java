package edu.westga.cs6312.fishing.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.fishing.model.Angler;

/**
 * Testing the accessor for the money left method function correctly
 * 
 * @author William Pevytoe
 * 
 * @version 2/13/2024
 */
class AnglerWhenGetMoney {

	/**
	 * Testing the Accessor for the money left of the Angler
	 */
	@Test
	public void testTheAngelerGetterForTheMoneyLeft() {
		Angler newFisher = new Angler();
		assertEquals(100, newFisher.getMoneyUnitsLdeft());
	}

}
