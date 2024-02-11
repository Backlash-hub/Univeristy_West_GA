package edu.westga.cs6312.polymorphism.model;

/**
 * Creating a Eagle subclass to a Bird
 * 
 * @author William Pevytoe
 * 
 * @version 1/31/2024
 */
public class Eagle extends Bird {
	
	/**
	 * 0 - parameter constructor that creates the Eagle as a Bird
	 */
	public Eagle() {
		super("eagle");
	}
	
	/**
	 * Implements the getSound method to return the sound of the eagle
	 * 
	 * @return a string representing the sound a eagle makes
	 */
	@Override
	public String getSound() {
		return "Scree";
	}

}
