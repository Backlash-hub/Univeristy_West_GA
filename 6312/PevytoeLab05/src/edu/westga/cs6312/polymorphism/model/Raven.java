package edu.westga.cs6312.polymorphism.model;

/**
 * Creating a Raven subclass to a Bird
 * 
 * @author William Pevytoe
 * 
 * @version 1/31/2024
 */
public class Raven extends Bird {
	
	/**
	 * 0 - parameter constructor that creates the Raven as a Bird
	 */
	public Raven() {
		super("raven");
	}
	
	/**
	 * Implements the getSound method to return the sound of the raven
	 * 
	 * @return a string representing the sound a raven makes
	 */
	@Override
	public String getSound() {
		return "Caw";
	}
}
