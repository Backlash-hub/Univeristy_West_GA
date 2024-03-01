package edu.westga.cs6312.files.model;

import java.util.ArrayList;

/**
 * The Real Estate Manager holds the RealEstate objects
 * 
 * @author William Pevytoe
 * 
 * @version 2/27/2024
 */
public class RealEstateManager {
	private ArrayList<RealEstate> estateManager;
	
	/**
	 * 0 - Parameter constructor that initializes the estate manager 
	 */
	public RealEstateManager() {
		this.estateManager = new ArrayList<RealEstate>();
	}
	
	/**
	 * Adds an RealEstate object to the estate manager
	 * 
	 * Precondition:	estate != null
	 * 
	 * Postcondition:	RealEstate object is added to the estate manager
	 * 
	 * @param estate is the RealEstate object
	 */
	public void addProperty(RealEstate estate) {
		if (estate == null) {
			throw new NullPointerException("Invalid estate. It should not null");
		}
		this.estateManager.add(estate);
	}
	
	/**
	 * Gets the RealEstate array list
	 * 
	 * @return the RealEstate array list
	 */
	public ArrayList<RealEstate> getProperties() {
		return this.estateManager;
	}
	
	/**
	 * Creates and returns a string that represents the estate manager
	 * 
	 * @return a string that represents the estate manager
	 */
	public String toString() {
		String theEstates = "";
		for (RealEstate estates : this.estateManager) {
			theEstates += estates.toString();
		}
		return theEstates;
	}
}
