package edu.westga.cs6312.inheritance.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.inheritance.model.Vampire;

/**
 * Testing the Vampire Constructor and toSting
 * 
 * @author William Pevytoe
 * 
 * @version 1/24/2024
 */
class VampireWhenCreateVampire {

	/**
	 * Test Vampire 2 Parameter Constructor
	 */
	@Test
	public void testCreatingAVampireWithNameBobWith55HPWith0BloodNeeded() {
		Vampire newVampire = new Vampire("Bob", 55);
		assertEquals("Monster -Name: Bob, -Health Units: 55, -Pints of Blood Needed: 0", newVampire.toString());
	}
	
	/**
	 * Test Vampire 3 Parameter Constructor
	 */
	@Test
	public void testCreatingAVampireWithNameJoeWith99HPWith15PintsOfBloodNeeded() {
		Vampire newVampire = new Vampire("Joe", 99, 15);
		assertEquals("Monster -Name: Joe, -Health Units: 99, -Pints of Blood Needed: 0", newVampire.toString());
	}

}
