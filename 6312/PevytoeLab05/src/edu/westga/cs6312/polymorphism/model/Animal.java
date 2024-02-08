package edu.westga.cs6312.polymorphism.model;

/**
 * Creating an Animal that assigns the kind and the covering of the animal
 * 
 * @author William Pevytoe
 * 
 * @version 1/30/2024
 */
public abstract class Animal {
	private String kindOfAnimal;
	private String coveringOfAnimal;
	
	/**
	 * 2 - parameter constructor to create the Animal object
	 * 
	 * @param kind 			The kind of animal being created 
	 * @param covering		The animal's covering type
	 * 
	 * Precondition:		kind != null
	 * 						covering != null
	 * 
	 * Postcondition:		An animal of whose type is kind and is 
	 * 						covered with covering
	 * 
	 */
	public Animal(String kind, String covering) {
		if (kind == null) {
			throw new IllegalArgumentException("Invalid kind");
		}
		if (covering == null) {
			throw new IllegalArgumentException("Invalid covering");
		}
		this.kindOfAnimal = kind;
		this.coveringOfAnimal = covering;
	}
	
	/**
	 * Determines if the animal walks or runs
	 * 
	 * @param isFast a boolean value indicating whether the animal is moving fast or not
	 * @return a String indicating the movement of the animal
	 */
	public String getMovement(boolean isFast) {
		if (isFast) {
			return "I run on four legs";
		} else {
			return "I walk on four legs"; 
		}
	}
	
	/**
	 * Factory Method to create a new animal object based on given kind
	 * 
	 * @param kind	The kind of animal to create
	 * @return A new Animal object with the specified kind
	 */
	public static Animal getNewAnimal(String kind) {
		switch (kind.toLowerCase()) {
			case "dog":
				return new Dog();
			case "cat":
				return new Cat();
			case "raven":
				return new Raven();
			case "eagle":
				return new Eagle();
			default:
				return null;
		}
	}
	
	/**
	 * Abstract method to get the sound the animal makes
	 * 
	 * @return a string representing the sound the animal makes
	 */
	public abstract String getSound();
	
	/**
	 * Returns a formatted string representation of the Animal's kind and covering
	 * 
	 * @return a string that annotates the kind of animal and its covering
	 */
	@Override
	public String toString() {
		return "The animal's kind is a(n) " + this.kindOfAnimal + ". "
		+ "The animal is covered with " + this.coveringOfAnimal + ".";
	}
}
