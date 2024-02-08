package edu.westga.cs6312.mileage.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.mileage.model.Digit;

class DigitWhenDecrementValue {

	/**
	 * Test to confirm decrement of a new Digit will produce a current value of 9
	 */
	@Test
	public void testDecrementNewDigitShouldGiveValue9() {
		Digit theDigit = new Digit();
		theDigit.decrement();
		int value = theDigit.getValue();
		assertEquals(9, value);
	}
	
	/**
	 * Test to confirm decrement of value 6 will produce a current value of 5
	 */
	@Test
	public void testDecrementNewDigitAt6ShouldGiveValue5() {
		Digit theDigit = new Digit();
		for (int count = 0; count < 6; count++) {
			theDigit.increment();
		}
		theDigit.decrement();
		int value = theDigit.getValue();
		assertEquals(5, value);
	}
	
	/**
	 * Test to confirm decrement of value 9 will produce a current value of 8
	 */
	@Test
	public void testDecrementNewDigitAt9ShouldGiveValue8() {
		Digit theDigit = new Digit();
		for (int count = 0; count < 9; count++) {
			theDigit.increment();
		}
		theDigit.decrement();
		int value = theDigit.getValue();
		assertEquals(8, value);
	}
	
	/**
	 * Test to confirm decrement of value 25 will produce a current value of 4
	 */
	@Test
	public void testDecrementNewDigitAt25ShouldGiveValue4() {
		Digit theDigit = new Digit();
		for (int count = 0; count < 25; count++) {
			theDigit.increment();
		}
		theDigit.decrement();
		int value = theDigit.getValue();
		assertEquals(4, value);
	}
}
