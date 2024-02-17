package edu.westga.cs6312.fishing.model;

/**
 * This models an fishing Angler that has money left over and has caught fish
 * 
 * @author William Pevytoe
 * 
 * @version 2/13/2024
 */
public class Angler {
	private int moneyUnitsLeft;
	private int fishCaught;
	
	/**
	 * 0 - parameter constructor what will initiate the Angler with 100 money units and 0 fish caught
	 */
	public Angler() {
		this.moneyUnitsLeft = 100;
		this.fishCaught = 0;
	}
	
	/**
	 * Getter for moneyUnitsLeft
	 * 
	 * @return moneyUnitsLeft
	 */
	public int getMoneyUnitsLdeft() {
		return this.moneyUnitsLeft;
	}
	
	/**
	 *Getter for fishCaught 
	 * 
	 * @return fishCaught
	 */
	public int getFishCaught() {
		return this.fishCaught;
	}
	
	/**
	 * Holds the new value of moneyUnitsLeft after subtracting the money required to fish
	 * 
	 * @param moneyRequiredToFish is the money that is required to fish at a location
	 * 
	 * Precondition:	moneyRequiredToFish > 0
	 * 					moneyRequiredToFish > this.moneyUnitsLeft
	 * 
	 * Postcondition:	this.moneyUnitsLeft is updated
	 */
	public void payToFish(int moneyRequiredToFish) {
		if (moneyRequiredToFish < 0) {
			throw new IllegalArgumentException("Invalid: Must be positive");
		} else if (this.moneyUnitsLeft < moneyRequiredToFish) {
			throw new IllegalArgumentException("Invalid: Not enought money");
		}
		this.moneyUnitsLeft -= moneyRequiredToFish;
	}
	
	/**
	 * Holds the new value of the fishCaught after catching a select number of fish
	 * 
	 * @param caughtFish is the number of fish just caught
	 * 
	 * Precondition:	caughtFish > 0
	 * 
	 * Postcondition:	this.fishCaught is updated
	 */
	public void catchFish(int caughtFish) {
		if (caughtFish < 0) {
			throw new IllegalArgumentException("Invalid: Must be positive");
		}
		this.fishCaught += caughtFish;
	}
	
	/**
	 * Gives a string representation of the Angler
	 * 
	 * @return a string representation of the Angler with the money units left and the number of fish caught
	 * 
	 */
	public String toString() {
		return "Number of money units left: [ " + this.moneyUnitsLeft + " ], Number of fish caught: [ " + this.fishCaught + " ]";
	}

}
