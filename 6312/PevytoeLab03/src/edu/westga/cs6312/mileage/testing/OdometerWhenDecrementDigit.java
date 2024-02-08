package edu.westga.cs6312.mileage.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.mileage.model.Odometer;

class OdometerWhenDecrementDigit {

	/**
	 * Test to confirm decrement of a new Odometer will 
	 * produce a current value of 999.9
	 */
	@Test
	public void testDecrementNewOdometerShouldGiveValue999Point9() {
		Odometer theOdometer = new Odometer();
		theOdometer.decrementDigit(3, 1);
		assertEquals("Odometer with mileage 999.9", theOdometer.toString());
	}
	
	/**
	 * Test to confirm decrement of an Odometer at 000.1 will
	 *  produce a current value of 000.0
	 * 
	 */
	@Test
	public void testDecrementNewOdometerStartingAt000Point1ShouldGiveValue000Point0() {
		Odometer theOdometer = new Odometer(0, 0, 0, 1);
		theOdometer.decrementDigit(3, 1);
		assertEquals("Odometer with mileage 000.0", theOdometer.toString());
	}
	
	/**
	 * Test to confirm decrement of an Odometer at 456.7 
	 * will produce a current value of 455.9
	 */
	@Test
	public void testDecrementNewOdometerStartingAt456Point7ShouldGiveValue455Point9() {
		Odometer theOdometer = new Odometer(4, 5, 6, 7);
		theOdometer.decrementDigit(3, 8);
		assertEquals("Odometer with mileage 455.9", theOdometer.toString());
	}

}
