package edu.westga.cs6312.fishing.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.fishing.model.Angler;

/**
 * Testing the creation of the Angler
 * 
 * @author William Pevytoe
 * 
 * @version 2/13/2024
 */
class AnglerWhenCreateAngler {

	/**
	 * Testing the 0 parameter Angler constructor
	 */
	@Test
	public void testAnglerWhenCreatAngler() {
		Angler newFisher = new Angler();
		assertEquals("Number of money units left: [ 100 ], Number of fish caught: [ 0 ]", newFisher.toString());
	}

}
