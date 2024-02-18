package edu.westga.cs6312.fishing.model;

/**
 * LargeFish is a sub class of FishType that creates a small fish type
 * 
 * @author William Pevytoe
 * 
 * @version 2/16/2024
 */
public class LargeFish extends FishType {
	
	/**
	 * 0 - Parameter constructor that sets the number of fish in the school to 50
	 */
	public LargeFish() {
		super(50);
	}

	/**
	 * Sets the number of small fish caught at once to 50
	 */
	@Override
	public int catchFish() {
		int fishCaught = this.getNumberOfFishInSchool();
	    if (fishCaught >= 50) {
	        fishCaught = 50;
	    }
	    removeFish(fishCaught);
	    return fishCaught;
	}

	/**
	 * Determines the cost to fish
	 */
	@Override
	public int costToFish() {
		return 50;
	}
	
	/**
	 * String method that represents the number of Small Fish in the school
	 * 
	 * @return a string that represents the number of Small Fish in the school
	 */
	@Override
	public String toString() {
		return "Large fish with " + this.getNumberOfFishInSchool() + " fish in the school";
	}
}
