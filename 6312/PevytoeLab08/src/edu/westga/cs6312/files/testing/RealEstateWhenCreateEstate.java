package edu.westga.cs6312.files.testing;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.RealEstate;

/**
 * Testing the creation of the RealEstate objects
 * 
 * @author William Pevytoe
 * 
 * @version 2/27/204
 */
class RealEstateWhenCreateEstate {

	/**
	 * Test the 3 parameter constructor with all valid inputs
	 */
	@Test
	public void testRealEstateWhenCreateEstateWithValidInputs() {
		RealEstate newEstate = new RealEstate("Wisconsin", 10000, 2000);
		assertEquals("Estate location: [ Wisconsin ] Estate land area: [ 10000 ] Estate structure"
				+ " area: [ 2000 ]\n", newEstate.toString());
	}
	
	/**
	 * Test the 3 parameter constructor with null location
	 */
	@Test
	public void testRealEstateWhenCreateEstateWithNullLocation() {
		assertThrows(NullPointerException.class, () -> {
		new RealEstate(null, 10000, 2000);
		});	
	}
	
	/**
	 * Test the 3 parameter constructor with negative lot size
	 */
	@Test
	public void testRealEstateWhenCreateEstateWithNegativeLotSize() {
		assertThrows(IllegalArgumentException.class, () -> {
		new RealEstate("Wisconsin", -1, 2000);
		});	
	}
	
	/**
	 * Test the 3 parameter constructor with negative building size
	 */
	@Test
	public void testRealEstateWhenCreateEstateWithNegativeStructureSize() {
		assertThrows(IllegalArgumentException.class, () -> {
		new RealEstate("Wisconsin", 10000, -2000);
		});	
	}

}
