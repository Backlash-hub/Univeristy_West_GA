package edu.westga.cs6312.mileage.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.mileage.model.Digit;

class DigitWhenCreateDigit {

	/**
	 * Test to confirm the 0-parameter constructor creates a Digit with a current value 0
	 */
	@Test
	public void testGetValue() {
		Digit theDigit = new Digit();
		int value = theDigit.getValue();
		assertEquals(0, value);
	}
}
