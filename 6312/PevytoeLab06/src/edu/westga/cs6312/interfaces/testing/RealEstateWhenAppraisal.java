package edu.westga.cs6312.interfaces.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.interfaces.model.RealEstate;

/**
 * Testing RealEstate with the Appraisal interface for getEstimate
 * 
 * @author William Pevytoe
 * 
 * @version 2/7/2024
 */
class RealEstateWhenAppraisal {

	/**
	 * Getting an estimate with normal positive numbers
	 */
	@Test
	public void testGetEstimateWithNormalValues() {
		RealEstate newEstate = new RealEstate("New York", 5264.5, 2350.55);
		assertEquals(287700.0, newEstate.getEstimate());
	}
	
	/**
	 * Getting an estimate with low positive numbers
	 */
	@Test
	public void testGetEstimateWithLowValues() {
		RealEstate newEstate = new RealEstate("Jolly Town", 1.1, 2.2);
		assertEquals(231.00, newEstate.getEstimate());
	}
	
	/**
	 * Getting an estimate with high positive numbers
	 */
	@Test
	public void testGetEstimateWithHighValues() {
		RealEstate newEstate = new RealEstate("Seige City", 99999.99, 9999.9);
		assertEquals(1999989.9, newEstate.getEstimate());
	}
}
