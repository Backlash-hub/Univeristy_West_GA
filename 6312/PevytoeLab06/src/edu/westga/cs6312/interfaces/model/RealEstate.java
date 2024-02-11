package edu.westga.cs6312.interfaces.model;

import java.text.DecimalFormat;

/**
 * This is model a piece of real estate with location, square feet of land and the structure  
 * 
 * @author William Pevytoe
 * 
 * @version 2/6/2024
 */
public class RealEstate implements Appraisal, Comparable<RealEstate> {
	private String location;
	private double landArea;
	private double structureArea;
	
	/**
	 * 3- parameter constructor that will initiate the real estate property
	 * 
	 * @param location is the place the property is 
	 * @param landArea is the area of the total property
	 * @param structureArea is the area of the structure on the property
	 * 
	 * Precondition:		location != null
	 * 						landArea > 0
	 * 						structureArea > 0
	 * 
	 * Postcondition:		Real estate property is created with the 3 parameters
	 */
	public RealEstate(String location, double landArea, double structureArea) {
		if (location == null) {
			throw new IllegalArgumentException("Invalid location");
		} else if (landArea <= 0) {
			throw new IllegalArgumentException("Invalid land area");
		} else if (structureArea < 0) {
			throw new IllegalArgumentException("Invalid structure area");
		}
		
		this.location = location;
		this.landArea = landArea;
		this.structureArea = structureArea;
	}
	
	/**
	 * 2 - parameter constructor that will initiate the real estate property without a structure on it
	 * 
	 * @param location is the place the property is 
	 * @param landArea is the area of the total property
	 */
	public RealEstate(String location, double landArea) {
		this(location, landArea, 0.0);
	}
	
	/**
	 * Allows the ability to build a structure on a property
	 * 
	 * @param structureArea is the area of the structure
	 * @return 
	 * 
	 * Precondition:		structureArea > 0
	 * 
	 * Postcondition:		Adds a structure to the property
	 */
	public double buildStructure(double structureArea) {
	    if (structureArea < 0) {
	        throw new IllegalArgumentException("Invalid structure area");
	    }
	    this.structureArea += structureArea;
	    return this.structureArea;
	}
	
	/**
	 * Represent the object as a string
	 * 
	 * @return a string that represents the object as a string
	 */
	public String toString() {
		return "Location: " + this.location + ", Land Area: " + String.format("%.2f", this.landArea) + " sq ft, Structure Area: " + this.structureArea + " sq ft";
	}

	@Override
	public double getEstimate() {
		 DecimalFormat decimalFormat = new DecimalFormat("##.##");
		 return Double.parseDouble(decimalFormat.format((this.structureArea * 100) + (this.landArea * 10)));
	}
	
    @Override
    public int compareTo(RealEstate other) {
        double thisEstimate = this.getEstimate();
        double otherEstimate = other.getEstimate();
        
        if (thisEstimate < otherEstimate) {
            return -1;
        } else if (thisEstimate > otherEstimate) {
            return 1;
        } else {
            return 0;
        }
    }
}
