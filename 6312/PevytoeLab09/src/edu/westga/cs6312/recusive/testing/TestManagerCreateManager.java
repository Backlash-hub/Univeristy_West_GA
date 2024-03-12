package edu.westga.cs6312.recusive.testing;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.recusive.model.TestManager;

/**
 * Testing creating the Test Manager, addTestScore & toString
 * 
 * @author William Pevytoe
 * 
 * @version 3/7/2024
 */
class TestManagerCreateManager {

	/**
	 * Testing Creating Test Manager and addTestScore
	 */
	@Test
	void testTestManagerCreateManagerOneValidInput() {
		TestManager manager = new TestManager();
		manager.addTestScore(50);
		assertEquals("50 ", manager.toString());
	}
	
	/**
	 * Testing Creating Test Manager and addTestScore
	 */
	@Test
	void testTestManagerCreateManagerThreeValidInputs() {
		TestManager manager = new TestManager();
		manager.addTestScore(0);
		manager.addTestScore(50);
		manager.addTestScore(100);
		assertEquals("0 50 100 ", manager.toString());
	}
	
	/**
	 * Testing Creating Test Manager and addTestScore with Negative number
	 */
	@Test
	void testTestManagerCreateManagerInValidNegativeInput() {
		TestManager manager = new TestManager();
		assertThrows(IllegalArgumentException.class, () ->
		manager.addTestScore(-50));
	}
	
	/**
	 * Testing Creating Test Manager and addTestScore with positive number
	 */
	@Test
	void testTestManagerCreateManagerInValidPostiveInput() {
		TestManager manager = new TestManager();
		assertThrows(IllegalArgumentException.class, () ->
		manager.addTestScore(150));
	}
}
