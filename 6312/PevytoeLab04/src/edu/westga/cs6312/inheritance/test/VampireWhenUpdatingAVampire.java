package edu.westga.cs6312.inheritance.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.inheritance.model.Vampire;

/**
 * Testing the setter and getter in Vampire
 * 
 * @author William Pevytoe
 * 
 * @version 1/24/2024
 */
class VampireWhenUpdatingAVampire {
	/**
	 * Testing the getter of pints of blood the Vampire needs
	 */
	@Test
	public void testVampireGetPintsOfBloodof4() {
		Vampire newVampire = new Vampire("Joe", 50, 4);
		assertEquals(4, newVampire.getPintsOfBloodNeeded());
	}
	
	/**
	 * Testing the setter of the pints of blood the Vampire needs
	 */
	@Test
	public void testVampireUpdatePintsOfBloodFrom0To7() {
		Vampire newVampire = new Vampire("Sally,", 22);
		newVampire.setPintsOfBloodNeeded(7);
		assertEquals(7, newVampire.getPintsOfBloodNeeded());
	}
}
