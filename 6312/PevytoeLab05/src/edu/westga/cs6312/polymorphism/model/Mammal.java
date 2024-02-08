package edu.westga.cs6312.polymorphism.model;

/**
 * Abstract subclass to create a Animal that is a Mammal 
 * 
 * @author William Pevytoe
 * 
 * @version 1/30/2024
 */
public abstract class Mammal extends Animal {
	
	/**
	 * 1 - parameter constructor that creates an Animal object that is a Mammal 
	 * 
	 * @param animalKind	The kind of animal
	 */
	public Mammal(String animalKind) {
		super(animalKind, "hair");
	}
}