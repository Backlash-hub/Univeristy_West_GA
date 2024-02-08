package edu.westga.cs6312.mileage.model;

/**
 * The Digit class represents a single digit with methods for incrementing, decrementing,
 * and retrieving its value. The digit value ranges from 0 to 9. If the current value is
 * at the maximum, incrementing resets it to 0; if at 0, decrementing sets it to the maximum. 
 * 
 * @author William Pevytoe
 * 
 *  @version 1/17/2024
 */
public class Digit {
	private static int maxVALUE = 9;
	private int currentValue;
	
	/**
	 * No parameter constructor 
	 */
	public Digit() {
		this.currentValue = 0;
	}
	
	/**
	 * Returns the current digit value
	 * 
	 * @return the currentValue
	 */
	public int getValue() {
		return this.currentValue;
	}
	
	/**
	 * Increases the current value
	 */
	public void increment() {
		if (this.currentValue == maxVALUE) {
			this.currentValue = 0;
		} else {
			this.currentValue++;
		}	
	}
	
	/**
	 * Decreases the current value
	 */
	public void decrement() {
		if (this.currentValue == 0) {
			this.currentValue = maxVALUE;
		} else {
			this.currentValue--;
		}
	}
}
