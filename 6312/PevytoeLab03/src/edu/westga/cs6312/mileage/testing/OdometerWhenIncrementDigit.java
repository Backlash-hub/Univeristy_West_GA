package edu.westga.cs6312.mileage.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.mileage.model.Odometer;

class OdometerWhenIncrementDigit {

	/**
	 * Test to confirm increment of a new Odometer will produce a current value of 000.1
	 */
	@Test
	public void testIncrementNewOdometerShouldGiveValuePoint1() {
		Odometer theOdometer = new Odometer();
		theOdometer.incrementDigit(3, 1);
		assertEquals("Odometer with mileage 000.1", theOdometer.toString());
	}
	
	/**
	 * Test to confirm increment of an odometer starting at 999.9 will
	 *  produce an odometer at 000.0
	 */
	@Test
	public void testIncrementNewOdometerStartingAt999Point9ShouldGiveValue000Point0() {
		Odometer theOdometer = new Odometer(9, 9, 9, 9);
		theOdometer.incrementDigit(3, 1);
		assertEquals("Odometer with mileage 000.0", theOdometer.toString());
	}
	
	/**
	 * Test to confirm increment of odometer starting at 456.7 will 
	 * produce an odometer at 516.7
	 */
	@Test
	public void testIncrementNewOdometerStartingAt456Point7ShouldGiveValue516Point7() {
		Odometer theOdometer = new Odometer(4, 5, 6, 7);
		theOdometer.incrementDigit(1, 6);
		assertEquals("Odometer with mileage 516.7", theOdometer.toString());
	}

}
