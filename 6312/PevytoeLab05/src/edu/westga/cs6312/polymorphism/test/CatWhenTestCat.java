package edu.westga.cs6312.polymorphism.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.polymorphism.model.Cat;

/**
 * Testing the Cat Constructor, toString, getSound, and getMovement
 * 
 * @author William Pevytoe
 * 
 * @version 1/31/2024
 */
class CatWhenTestCat {

	/**
	 * Test the cat 0 Parameter constructor and the toString method
	 */
	@Test
	public void testTheCatConstructorAndToString() {
		Cat theCat = new Cat();
		assertEquals("The animal's kind is a(n) cat. The animal is covered with hair.", theCat.toString());
	}
	
	/**
	 * Test the cat getSound method
	 */
	@Test
	public void testTheSoundOfTheCat() {
		Cat theCat = new Cat();
		assertEquals("Meow", theCat.getSound());
	}
	
	/**
	 * Test the cat getMovment method (false)
	 */
	@Test
	public void testTheMovementOfTheCatShouldBeWalk() {
		Cat theCat = new Cat();
		assertEquals("I walk on four legs", theCat.getMovement(false));
	}
	
	/**
	 * Test the cat getMovment method (True)
	 */
	@Test
	public void testTheMovementOfTheCatShouldBeRun() {
		Cat theCat = new Cat();
		assertEquals("I run on four legs", theCat.getMovement(true));
	}


}
