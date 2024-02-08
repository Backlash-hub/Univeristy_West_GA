package edu.westga.cs6312.polymorphism.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.polymorphism.model.Eagle;

/**
 * Testing the Eagle Constructor, toString, getSound, and getMovement
 * 
 * @author William Pevytoe
 * 
 * @version 1/31/2024
 */
class EagleWhenTestEagle {


	/**
	 * Test the eagle 0 Parameter constructor and the toString method
	 */
	@Test
	public void testTheEagleConstructorAndToString() {
		Eagle theEagle = new Eagle();
		assertEquals("The animal's kind is a(n) eagle. The animal is covered with feathers.", theEagle.toString());
	}
	
	/**
	 * Test the eagle getSound method
	 */
	@Test
	public void testTheSoundOfTheEagle() {
		Eagle theEagle = new Eagle();
		assertEquals("Scree", theEagle.getSound());
	}
	
	/**
	 * Test the eagle getMovment method (false)
	 */
	@Test
	public void testTheMovementOfTheEagleShouldBeWalk() {
		Eagle theEagle = new Eagle();
		assertEquals("I walk on two legs", theEagle.getMovement(false));
	}
	
	/**
	 * Test the eagle getMovment method (True)
	 */
	@Test
	public void testTheMovementOfTheEagleShouldBeRun() {
		Eagle theEagle = new Eagle();
		assertEquals("I fly", theEagle.getMovement(true));
	}

}
