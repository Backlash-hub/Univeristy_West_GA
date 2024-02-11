package edu.westga.cs6312.mileage.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.mileage.model.Digit;

class DigitWhenIncrementValue {

	/**
	 * Test to confirm incrementing a new Digit will produce a current value of 1
	 */
	@Test
	public void testIncrementNewDigitShouldGiveValue1() {
		Digit theDigit = new Digit();
		theDigit.increment();
		int value = theDigit.getValue();
		assertEquals(1, value);
	}
	
	/**
	 * Test to confirm incrementing a new Digit (starting at 5) will produce a current value of 6
	 */
	@Test
	public void testIncrementNewDigitAt5ShouldGiveValue6() {
		Digit theDigit = new Digit();
		for (int count = 0; count < 5; count++) {
			theDigit.increment();
		}
		theDigit.increment();
		int value = theDigit.getValue();
		assertEquals(6, value);
	}
	
	/**
	 * Test to confirm incrementing a new Digit (starting at 9) will produce a current value of 0
	 */
	@Test
	public void testIncrementNewDigitAt9ShouldGiveValue0() {
		Digit theDigit = new Digit();
		for (int count = 0; count < 9; count++) {
			theDigit.increment();
		}
		theDigit.increment();
		int value = theDigit.getValue();
		assertEquals(0, value);
	}
	
	/**
	 * Test to confirm incrementing a new Digit (starting at 15) will produce a current value of 0
	 */
	@Test
	public void testIncrementNewDigitAt15ShouldGiveValue6() {
		Digit theDigit = new Digit();
		for (int count = 0; count < 15; count++) {
			theDigit.increment();
		}
		theDigit.increment();
		int value = theDigit.getValue();
		assertEquals(6, value);
	}
}
