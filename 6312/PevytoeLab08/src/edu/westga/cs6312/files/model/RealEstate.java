package edu.westga.cs6312.files.model;

/**
 * Keeps track of the location, land area and structure area of an estate
 * 
 * @author William Pevytoe
 * 
 * @version 2/27/2024
 */
public class RealEstate {
	private String location;
	private int landArea;
	private int structureArea;
	
	/**
	 * 3 - Parameter constructor that assign the location, land area, and structure area of the estate
	 * 
	 * Precondition:	estateLocation != null
	 * 					lotArea <= 0
	 * 					buildingSize > 0
	 * 
	 * Postcondition:	RealEstate object is created
	 * 
	 * @param estateLocation is the physical location of the estate
	 * @param lotArea is the size of the land the building is located on
	 * @param buildingSize is the size of the building on the estate
	 */
	public RealEstate(String estateLocation, int lotArea, int buildingSize) {
		if (estateLocation == null) {
			throw new NullPointerException("Invalid location. It should not null");
		} else if (lotArea <= 0) {
			throw new IllegalArgumentException("Invalid lot area. It can't be zero or negative");
		} else if (buildingSize < 0) {
			throw new IllegalArgumentException("Invalid lot . It can't be less the zero");
		} else {
			this.location = estateLocation;
			this.landArea = lotArea;
			this.structureArea = buildingSize;
		}
	}
	
	/**
	 * Creates and returns a string that represents the RealEstate object
	 * 
	 * @return a string that represents the RealEstate object
	 */
	public String toString() {
		return "Estate location: [ " + this.location + " ] "
				+ "Estate land area: [ " + this.landArea + " ] "
				+ "Estate structure area: [ " + this.structureArea + " ]\n";
	}
}
