package edu.westga.cs6312.inheritance.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.inheritance.model.Zombie;

/**
 * Testing Creating a Zombie with different parameter constructors
 * 
 * @author William Pevytoe
 * 
 * @version 1/24/2024
 */
class ZombieWhenCreatingAZombie {
	
	/**
	 * Testing a 2 - parameter constructor to create a new Zombie named Joe with default HP and 
	 * makes the sound RAWR 
	 */
	@Test
	public void testCreatingA2ParameterZombie() {
		Zombie newZombie = new Zombie("Joe", "RAWR");
		assertEquals("Monster -Name: Joe, -Health Units: 100, -Sound: RAWR", newZombie.toString());
	}
	
	/**
	 * Testing a 3 - parameter constructor to create a new Zombie named Greg with 88 HP and 
	 * makes the sound BOO 
	 */
	@Test
	public void testCreatingA3ParameterZombie() {
		Zombie newZombie = new Zombie("Greg", 88, "BOO");
		assertEquals("Monster -Name: Greg, -Health Units: 88, -Sound: BOO", newZombie.toString());
	}

}
