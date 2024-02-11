package edu.westga.cs6312.polymorphism.model;

/**
 * Abstract subclass to create a Animal that is a Bird 
 * 
 * @author William Pevytoe
 * 
 * @version 1/30/2024
 */
public abstract class Bird extends Animal {

	/**
	 * 1 - parameter constructor that creates an Animal object that is a Bird
	 * 
	 * @param animalKind 	The kind of animal
	 */
	public Bird(String animalKind) {
		super(animalKind, "feathers");
	}
	
	/**
	 * Overrides the Animal getMovement method to proved the correct movement of the bird subclass
	 * 
	 * @param isFast a boolean value indicating whether the animal is moving fast or not
	 * 
	 * @return a String indicating the movement of the animal
	 */
	@Override
	public String getMovement(boolean isFast) {
		if (isFast) {
			return "I fly";
		} else {
			return "I walk on two legs";
		}
	}	
}