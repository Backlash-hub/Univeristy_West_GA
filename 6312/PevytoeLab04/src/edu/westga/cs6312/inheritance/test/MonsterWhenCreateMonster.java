package edu.westga.cs6312.inheritance.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.inheritance.model.Monster;

/**
 * Testing creating a Monster at with different parameters
 * 
 * @author William Pevytoe
 * 
 * @version 1/23/2024
 */
class MonsterWhenCreateMonster {
	
	/**
	 * Confirm that Creating a new Monster with values Bob and 55 will reflect as such
	 */
	@Test
	public void testCreatingAMonsterWithNameBobWith55HP() {
		Monster theMonster = new Monster("Bob", 55);
		assertEquals("Monster -Name: Bob, -Health Units: 55", theMonster.toString());
	}
	
	/**
	 * Confirm that Creating a new Monster with values Raven and 99 will reflect as such
	 */
	@Test
	public void testCreatingAMonsterWithNameRavenWith99HP() {
		Monster theMonster = new Monster("Raven", 99);
		assertEquals("Monster -Name: Raven, -Health Units: 99", theMonster.toString());
	}

}
