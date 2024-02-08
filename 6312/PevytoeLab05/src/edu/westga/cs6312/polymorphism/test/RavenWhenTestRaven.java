package edu.westga.cs6312.polymorphism.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.polymorphism.model.Raven;

/**
 * Testing the Raven Constructor, toString, getSound, and getMovement
 * 
 * @author William Pevytoe
 * 
 * @version 1/31/2024
 */
class RavenWhenTestRaven {

	/**
	 * Test the raven 0 Parameter constructor and the toString method
	 */
	@Test
	public void testTheDogConstructorAndToString() {
		Raven theRaven = new Raven();
		assertEquals("The animal's kind is a(n) raven. The animal is covered with feathers.", theRaven.toString());
	}
	
	/**
	 * Test the raven getSound method
	 */
	@Test
	public void testTheSoundOfTheRaven() {
		Raven theRaven = new Raven();
		assertEquals("Caw", theRaven.getSound());
	}
	
	/**
	 * Test the raven getMovment method (false)
	 */
	@Test
	public void testTheMovementOfTheRavenShouldBeWalk() {
		Raven theRaven = new Raven();
		assertEquals("I walk on two legs", theRaven.getMovement(false));
	}
	
	/**
	 * Test the raven getMovment method (True)
	 */
	@Test
	public void testTheMovementOfTheRavenShouldBeRun() {
		Raven theRaven = new Raven();
		assertEquals("I fly", theRaven.getMovement(true));
	}
}
