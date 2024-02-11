package edu.westga.cs6312.polymorphism.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.polymorphism.model.Animal;
import edu.westga.cs6312.polymorphism.model.Cat;
import edu.westga.cs6312.polymorphism.model.Dog;
import edu.westga.cs6312.polymorphism.model.Eagle;
import edu.westga.cs6312.polymorphism.model.Raven;

/**
 * Testing the Animal getNewAnimal with every subclass animal kind
 * 
 * @author William Pevytoe
 * 
 * @version 1/31/2024
 */
class AnimalWhenGetNewAnimal {

	/**
	 * Test Animal getNewAnimal method with subclass Dog
	 */
	@Test
	public void testGetNewDog() {
		Dog expectedDog = new Dog();
		Animal actualDog = Animal.getNewAnimal("dog");
		assertEquals(expectedDog.toString(), actualDog.toString());		
	}
	
	/**
	 * Test Animal getNewAnimal method with subclass Cat
	 */
	@Test
	public void testGetNewCat() {
		Cat expectedCat = new Cat();
		Animal actualCat = Animal.getNewAnimal("cat");
		assertEquals(expectedCat.toString(), actualCat.toString());		
	}
	
	/**
	 * Test Animal getNewAnimal method with subclass Raven
	 */
	@Test
	public void testGetNewRaven() {
		Raven expectedRaven = new Raven();
		Animal actualRaven = Animal.getNewAnimal("raven");
		assertEquals(expectedRaven.toString(), actualRaven.toString());		
	}
	
	/**
	 * Test Animal getNewAnimal method with subclass Eagle
	 */
	@Test
	public void testGetNewEagle() {
		Eagle expectedEagle = new Eagle();
		Animal actualEagle = Animal.getNewAnimal("eagle");
		assertEquals(expectedEagle.toString(), actualEagle.toString());		
	}
	
	
	
	
	
	

}
