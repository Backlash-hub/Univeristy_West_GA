package edu.westga.cs6312.inheritance.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.inheritance.model.Zombie;

/**
 * Testing the Zombie getter and setter methods
 * 
 * @author William Pevytoe
 * 
 * @version 1/24/2024
 */
class ZombieWhenUpdatingAZombie {
	
	/**
	 * Confirm that the sound is set properly 
	 */
	@Test
	public void testGettingTheZombieSoundRAWR() {
		Zombie newZombie = new Zombie("Brad", "RAWR");
		assertEquals("RAWR", newZombie.getSound());
	}
	
	/**
	 * Confirm that the sound of the Zombie is updated
	 */
	@Test
	public void testUpdatingZombieSoundFromBOOOToAHAHAHAH() {
		Zombie newZombie = new Zombie("Will", "BOOO");
		newZombie.setSound("AHAHAHAH");
		assertEquals("AHAHAHAH", newZombie.getSound());
	}

}
