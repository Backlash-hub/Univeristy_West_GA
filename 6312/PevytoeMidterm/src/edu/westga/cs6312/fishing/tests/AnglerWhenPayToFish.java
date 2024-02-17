package edu.westga.cs6312.fishing.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.fishing.model.Angler;

/**
 * Testing that the payToFish method works correctly
 * 
 * @author William Pevytoe
 * 
 * @version 2/13/2024
 */
class AnglerWhenPayToFish {

	/**
	 * Testing the payToFish method works with positive 1
	 */
	@Test
	public void testPayToFishForOneUnit() {
		Angler newFisher = new Angler();
		newFisher.payToFish(1);
		assertEquals(99, newFisher.getMoneyUnitsLdeft());
	}
	
	/**
	 * Testing the payToFish method works with positive 99
	 */
	@Test
	public void testPayToFishForNintyNineUnits() {
		Angler newFisher = new Angler();
		newFisher.payToFish(99);
		assertEquals(1, newFisher.getMoneyUnitsLdeft());
	}
	
	/**
	 * Testing the payToFish method works with positive 50
	 */
	@Test
	public void testPayToFishForFiftyUnits() {
		Angler newFisher = new Angler();
		newFisher.payToFish(50);
		assertEquals(50, newFisher.getMoneyUnitsLdeft());
	}
	
	/**
	 * Testing the payToFish throws proper error with a negative number
	 */
	@Test
	public void testPayToFishForNegtiveUnits() {
		assertThrows(IllegalArgumentException.class, () -> {
		Angler newFisher = new Angler();
		newFisher.payToFish(-5);
		});
	}
	
	/**
	 * Testing the payToFish throws proper error with a number greater than money units left
	 */
	@Test
	public void testPayToFishForMoreThanMoneyUnitsLeft() {
		assertThrows(IllegalArgumentException.class, () -> {
		Angler newFisher = new Angler();
		newFisher.payToFish(500);
		});
	}

}
