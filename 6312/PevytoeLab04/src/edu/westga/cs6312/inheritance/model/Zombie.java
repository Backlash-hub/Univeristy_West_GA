package edu.westga.cs6312.inheritance.model;

/**
 * Creating a Zombie with a name, HP and a sound
 * 
 * @author William Pevytoe
 * 
 * @version 1/24/2024
 */
public class Zombie extends Monster {
	private String soundMade;
	
	/**
	 * 2 - Parameter constructor to create a Zombie with default health units
	 * 
	 * @param name of the Zombie
	 * @param sound the Zombie makes
	 */
	public Zombie(String name, String sound) {
		super(name, 100);
		this.soundMade = sound;
	}
	
	/**
	 * 3 - Parameter constructor to create a Zombie
	 * 
	 * @param name of the Zombie
	 * @param healthPoints is the total health of the Zombie
	 * @param sound is the sound the Zombie makes
	 */
	public Zombie(String name, int healthPoints, String sound) {
		super(name, healthPoints);
		this.soundMade = sound;
	}
	
	/**
	 * Getter for the sound the Zombie makes
	 * 
	 * @return the sound the Zombie makes
	 */
	public String getSound() {
		return this.soundMade;
	}
	
	/**
	 * Setter for the sound of the Zombie
	 * 
	 * @param sound the Zombie makes
	 */
	public void setSound(String sound) {
		this.soundMade = sound;
	}
	
	/**
	 * returns a formatted string representation of the Zombie name, health units, and sound made
	 */
	@Override
	public String toString() {
		return super.toString() + ", -Sound: " + this.soundMade;
	}
}
