package edu.westga.cs6312.fishing.model;

import java.util.Random;

/**
 * Keeps track of an individual fishing hole in the game
 * 
 * @author William Pevytoe
 * 
 * @version 2/14/2024
 */
public class FishingHole {
	private FishType typeOfFish;
	private int fishingHoleLocation;

	/**
	 * 1 - Parameter constructor that creates the fishing hole
	 * 
	 * @param location is the position of the fishing hole
	 * 
	 *                 Precondition: location > 0
	 * 
	 *                 Postcondition: this.fishingHoleLocation is updated
	 */
	public FishingHole(int location) {
		if (location < 0) {
			throw new IllegalArgumentException("Invalid: Must be positive");
		}
		this.fishingHoleLocation = location;
		this.setUpFishingHole();
	}

	/**
	 * Gives a string representation of the what fishing hole the Angler is located
	 * at
	 * 
	 * @return string representation of the what fishing hole the Angler is located
	 *         at
	 */
	public String getLocation() {
		return "Fishing hole at [ " + this.fishingHoleLocation + " ]";
	}

	/**
	 * Accessor method to get the type of fish at the hole
	 * 
	 * @return typeOfFish at the hole
	 */
	public FishType getFish() {
		return this.typeOfFish;
	}

	/**
	 * toString method to provide a String representation of the FishingHole object
	 * 
	 * @return string representation of the FishingHole object
	 */
	@Override
	public String toString() {
		String fishInfo;
	    if (this.typeOfFish.getNumberOfFishInSchool() != 0) {
	        fishInfo = "containing " + this.typeOfFish;
	    } else {
	        fishInfo = "containing no fish";
	    }
	    return "Fishing hole at " + this.fishingHoleLocation + " " + fishInfo;
	}

	private void setUpFishingHole() {
		Random random = new Random();
        if (random.nextDouble() < 0.5) {
            this.typeOfFish = new SmallFish();
        } else {
            this.typeOfFish = new LargeFish();
        }
	}
	
	/**
	 * Using the Angler's money to pay for a location and tracking the number of fish in the location/ what the Angler has caught
	 * 
	 * @param theFisher is the Angler object
	 */
	public void toFish(Angler theFisher) {
		if (this.typeOfFish != null) {
			int costToFish = this.typeOfFish.costToFish();
			theFisher.payToFish(costToFish);
			int fishCaught = this.typeOfFish.catchFish();
			theFisher.catchFish(fishCaught);
		}
		
	}
}
