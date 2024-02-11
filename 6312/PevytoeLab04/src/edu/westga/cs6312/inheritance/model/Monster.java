package edu.westga.cs6312.inheritance.model;

/**
 * Creating a Monster with a name and health points
 * 
 * @author William Pevytoe
 * 
 * @version 1/23/2024
 */
public class Monster {
	private String monsterName;
	private int overallHP;
	
	/**
	 * 2 - parameter constructor to create a Monster
	 * 
	 * @param name of the monster
	 * @param health the health points the monster has
	 */
	public Monster(String name, int health) {
		this.monsterName = name;
		this.overallHP = health;
	}
	
	/**
	 * Getter for the monster name
	 * 
	 * @return the name of the Monster
	 */
	public String getName() {
		return this.monsterName;
	}
	
	/**
	 * Set name of Monster
	 * 
	 * @param name is the name of the Monster
	 */
	public void setName(String name) {
		this.monsterName = name;
	}
	
	/**
	 * Getter for the Monster's health points
	 * 
	 * @return the health points for the Monster
	 */
	public int getHealthPoints() {
		return this.overallHP;
	}
	
	/**
	 * Set the health points of the Monster
	 * 
	 * @param health is the overall HP of the Monster
	 */
	public void setHealthPoints(int health) {
		this.overallHP = health;
	}
	
	/**
	 * Returns a formatted string representation of the Monster name and health units
	 */
	@Override
	public String toString() {
		return "Monster -Name: " + this.monsterName + ", -Health Units: " + this.overallHP;
	}
}
