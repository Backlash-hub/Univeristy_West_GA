package edu.westga.cs6312.polymorphism.model;

/**
 * Create a dog as a mammal
 * 
 * @author William Pevytoe
 * 
 * @version 1/31/2024
 */
public class Dog extends Mammal {
	
	/**
	 * 0 - parameter constructor that creates the Dog as a Mammal
	 */
	public Dog() {
		super("dog");
	}
	
	/**
	 * Implements the getSound method to return the sound of the dog
	 * 
	 * @return a string representing the sound a dog makes
	 */
	@Override
	public String getSound() {
		return "Woof";
	}
}
