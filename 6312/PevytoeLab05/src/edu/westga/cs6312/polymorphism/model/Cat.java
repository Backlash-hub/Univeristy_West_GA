package edu.westga.cs6312.polymorphism.model;

/**
 * Create a cat as a mammal
 * 
 * @author William Pevytoe
 * 
 * @version 1/31/2024
 */
public class Cat extends Mammal {
	
	/**
	 * 0 - parameter constructor that creates the Cat as a Mammal
	 */
	public Cat() {
		super("cat");
	}
	
	/**
	 * Implements the getSound method to return the sound of the cat
	 * 
	 * @return a string representing the sound a cat makes
	 */
	@Override
	public String getSound() {
		return "Meow";
	}
}
