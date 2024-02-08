package edu.westga.cs6312.polymorphism.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.polymorphism.model.Dog;

/**
 * Testing the Dog Constructor, toString, getSound, and getMovement
 * 
 * @author William Pevytoe
 * 
 * @version 1/31/2024
 */
class DogWhenTestDog {

	/**
	 * Test the Dog 0 Parameter constructor and the toString method
	 */
	@Test
	public void testTheDogConstructorAndToString() {
		Dog theDog = new Dog();
		assertEquals("The animal's kind is a(n) dog. The animal is covered with hair.", theDog.toString());
	}
	
	/**
	 * Test the Dog getSound method
	 */
	@Test
	public void testTheSoundOfTheDog() {
		Dog theDog = new Dog();
		assertEquals("Woof", theDog.getSound());
	}
	
	/**
	 * Test the Dog getMovment method (false)
	 */
	@Test
	public void testTheMovementOfTheDogShouldBeWalk() {
		Dog theDog = new Dog();
		assertEquals("I walk on four legs", theDog.getMovement(false));
	}
	
	/**
	 * Test the Dog getMovment method (True)
	 */
	@Test
	public void testTheMovementOfTheDogShouldBeRun() {
		Dog theDog = new Dog();
		assertEquals("I run on four legs", theDog.getMovement(true));
	}

}
