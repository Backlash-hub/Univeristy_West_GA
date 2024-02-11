package edu.westga.cs6312.inheritance.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.inheritance.model.Monster;

/**
 * Testing getting Monster name and updating a Monster name
 * 
 * @author William Pevytoe
 * 
 * @version 1/24/2024 
 */
class MonsterWhenUpdatingName {
	
	/**
	 * Creating a new Monster and just retrieving the name
	 */
	@Test
	public void testShowTheMonsterName() {
		Monster newMonster = new Monster("Greg", 55);
		assertEquals("Greg", newMonster.getName());
	}
	
	/**
	 * Creating a new Monster and changing the name
	 */
	@Test
	public void testUpdateMonsterNameFromJoetoBrad() {
		Monster newMonster = new Monster("Joe", 99);
		newMonster.setName("Brad");
		assertEquals("Brad", newMonster.getName());
	}

}
