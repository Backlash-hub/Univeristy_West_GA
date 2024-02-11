package edu.westga.cs6312.inheritance.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.inheritance.model.Monster;

/**
 * Testing getting Monster HP and setting a new HP value to a Monster
 * 
 * @author William Pevytoe
 * 
 * @version 1/24/2024
 */
class MonsterWhenUpdatingHealthPoints {
	
	/**
	 * Creating a new Monster and just retrieving the Health Points
	 */
	@Test
	public void testGettingMonstersHealthPoints() {
		Monster newMonster = new Monster("Joe", 88);
		assertEquals(88, newMonster.getHealthPoints());
	}
	
	/**
	 * Creating a new Monster and changing the Health Points
	 */
	@Test
	public void testSettingNewHealthPointsfrom40to99() {
		Monster newMonster = new Monster("Joe", 40);
		newMonster.setHealthPoints(99);
		assertEquals(99, newMonster.getHealthPoints());
	}

}
