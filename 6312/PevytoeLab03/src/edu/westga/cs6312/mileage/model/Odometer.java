package edu.westga.cs6312.mileage.model;

/**
 * Models an analog odometer with Digits for tracking mileage.
 * Tracks mileage up to 999.9, handling rollovers between Digits.
 * Each Digit ranges from 0 to 9, with the rightmost Digit representing decimal (tenth's).
 * 
 * @author William Pevytoe
 * 
 * @version 1/18/2024
 */
public class Odometer {
	private Digit[] mileageDigits;
	
	/**
	 * 0-parameter constructor that creates an array of 4  
	 */
	public Odometer() {
		this.mileageDigits = new Digit[4];
		for (int position = 0; position < 4; position++) {
			this.mileageDigits[position] = new Digit();
		}
	}
	
	/**
	 * 4-parameter constructor that creates an array of 4 
	 * 
	 *  @param hundreds odometer point
	 *  @param tens odometer point
	 *  @param ones odometer point
	 *  @param decimal odometer point
	 */
	public Odometer(int hundreds, int tens, int ones, int decimal) {
		this();
		
		for (int position = 0; position < hundreds; position++) {
			this.mileageDigits[0].increment();
		}
		for (int position = 0; position < tens; position++) {
			this.mileageDigits[1].increment();
		}
		for (int position = 0; position < ones; position++) {
			this.mileageDigits[2].increment();
		}
		for (int position = 0; position < decimal; position++) {
			this.mileageDigits[3].increment();
		}
	}
	
	/**
     * Returns a formatted string representation of the odometer's mileage.
     *
     * @return String representation of the odometer's mileage
     */
	public String toString() {
		return "Odometer with mileage " 
				+ this.mileageDigits[0].getValue() 
				+ this.mileageDigits[1].getValue() 
				+ this.mileageDigits[2].getValue() 
				+ "." 
				+ this.mileageDigits[3].getValue();
	}
	
	/**
	 * Increasing an Odometer digit at a designated position by a designated mileage
	 * 
	 * @param position on the Odometer to change
	 * @param increaseMileage the amount to add to the digit on the Odometer
	 */
	public void incrementDigit(int position, int increaseMileage) {
	    for (int turns = 0; turns < increaseMileage; turns++) {
	        int previousValue = this.mileageDigits[position].getValue();
	        this.mileageDigits[position].increment();
	        if (this.mileageDigits[position].getValue() >= previousValue) {
	            continue;
	        }
	        for (int digit = position - 1; digit >= 0; digit--) {
	            this.mileageDigits[digit].increment();
	            if (this.mileageDigits[digit].getValue() != 0) {
	                break;
	            }
	        }
	    }
	}
	
	/**
	 * Decreasing an Odometer digit at a designated position by a designated mileage
	 * 
	 * @param position position on the Odometer to change
	 * @param decreaseMileage the amount to subtract to the digit on the Odometer
	 */
	public void decrementDigit(int position, int decreaseMileage) {
	    for (int turns = 0; turns < decreaseMileage; turns++) {
	        int previousValue = this.mileageDigits[position].getValue();
	        this.mileageDigits[position].decrement();
	        if (this.mileageDigits[position].getValue() <= previousValue) {
	            continue;
	        }
	        for (int digit = position - 1; digit >= 0; digit--) {
	            this.mileageDigits[digit].decrement();
	            if (this.mileageDigits[digit].getValue() != 9) {
	                break;
	            }
	        }
	    }

	}
}
