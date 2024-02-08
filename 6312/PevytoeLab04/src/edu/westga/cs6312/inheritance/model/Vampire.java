package edu.westga.cs6312.inheritance.model;

/**
 * Creating a Vampire that has a name, HP, and needs pints of blood
 * 
 * @author William Pevytoe
 * 
 * @version 1/24/2024
 */
public class Vampire extends Monster {
	private int pintsOfBloodNeeded;
	
	/**
	 * 2 - Parameter Constructor to name and assign health credits to a Vampire 
	 * while setting blood units to 0
	 * 
	 * @param name is the name of the Vampire
	 * @param healthCredits are the health points of the Vampire
	 */
	public Vampire(String name, int healthCredits) {
		super(name, healthCredits);
		this.pintsOfBloodNeeded = 0;
	}
	
	/**
	 * 3 - Parameter Constructor to name, assign health credits, and pints of blood to a Vampire
	 * 
	 * @param name is the name of the Vampire
	 * @param healthCredits are the units of health of the Vampire
	 * @param pintsOfBlood units of blood the Vampire needs
	 */
	public Vampire(String name, int healthCredits, int pintsOfBlood) {
		super(name, healthCredits);
		if (pintsOfBlood >= 0 && pintsOfBlood <= 10) {
			this.pintsOfBloodNeeded = pintsOfBlood;
		} else {
			this.pintsOfBloodNeeded = 0;
		}
	}
	
	/**
	 * Getting pints of blood needed
	 * 
	 * @return the pints of blood needed
	 */
	public int getPintsOfBloodNeeded() {
		return this.pintsOfBloodNeeded;
	}
	
	/**
	 * Sets the pints of blood the Vampire needs
	 * 
	 * @param pintsOfBlood are the units of blood a Vampire needs
	 */
	public void setPintsOfBloodNeeded(int pintsOfBlood) {
		if (pintsOfBlood >= 0 && pintsOfBlood <= 10) {
			this.pintsOfBloodNeeded = pintsOfBlood;
		} else {
			this.pintsOfBloodNeeded = 0;
		}
	}
	
	/**
	 * returns a formatted string representation of the Vampire name, health units, and pints of blood
	 */
	@Override
    public String toString() {
        return super.toString() + ", -Pints of Blood Needed: " + this.pintsOfBloodNeeded;
    }

}
