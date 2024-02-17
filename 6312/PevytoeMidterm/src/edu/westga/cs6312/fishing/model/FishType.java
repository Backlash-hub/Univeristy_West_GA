package edu.westga.cs6312.fishing.model;

/**
 * Abstract FishType for the type of school of fish
 * 
 * @author William Pevytoe
 * 
 * @version 2/13/2024
 */
public abstract class FishType {
	private int fishInSchool;

	/**
	 * 1 - parameter constructor to create the number of fish in a school
	 * 
	 * @param initialNumberOfFishInSchool are the number of fish in the school
	 * 
	 *                                    Precondition: initialNumberOfFishInSchool
	 *                                    > 0
	 * 
	 *                                    Postcondition: set the number of fish in
	 *                                    the school
	 */
	public FishType(int initialNumberOfFishInSchool) {
		if (initialNumberOfFishInSchool < 0) {
			throw new IllegalArgumentException("Invalid: Must be positive");
		}
		this.fishInSchool = initialNumberOfFishInSchool;
	}

	/**
	 * Getter for number of fish in the school
	 * 
	 * @return fishInSchool
	 */
	public int getNumberOfFishInSchool() {
		return this.fishInSchool;
	}

	/**
	 * Removes a fish from the school
	 * 
	 * @param numberOfFishToRemove is the number to be removed from the school
	 * 
	 * Precondition: 		numberOfFishToRemove > 0
	 *                      numberOfFishToRemove < this.fishInSchool
	 * 
	 * Postcondition: 		this.fishInSchool is updated
	 */
	public void removeFish(int numberOfFishToRemove) {
		if (numberOfFishToRemove < 0) {
			throw new IllegalArgumentException("Invalid: Must be positive");
		} else if (this.fishInSchool < numberOfFishToRemove) {
			throw new IllegalArgumentException("Invalid: Not enough fish in school");
		}
		this.fishInSchool -= numberOfFishToRemove;
	}

	/**
	 *  Abstract method to catch fish
	 * 
	 * @return the subclasses number of fish caught
	 */
	public abstract int catchFish();

	/**
	 * Abstract method to determine cost to fish
	 * 
	 * @return the subclasses cost to fish at a spot
	 */
	public abstract int costToFish();

	/**
	 *  toString method that gives the number of fish in the school
	 *  
	 *  @return a string that gives the number of fish in the school
	 */
	public String toString() {
		return "Number of fish in the school: [ " + this.fishInSchool + " ]";
	}
}
