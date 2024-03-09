package edu.westga.cs6312.recusive.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.recusive.model.TestManager;

/**
 * Testing the Reverse List with Loop
 * 
 * @author William Pevytoe
 * 
 * @version 3/7/2024
 */
class TestManagerReverseListWithLoop {

	/**
	 * Test the Reverse List with Loop
	 */
	@Test
	void testReverseListWithALowValueLoop() {
		TestManager manager = new TestManager();
		manager.addTestScore(10);
		manager.addTestScore(20);
		manager.addTestScore(30);
		assertEquals("30 20 10", manager.reverseListWithALoop());
	}
	
	/**
	 * Test the Reverse List with Loop
	 */
	@Test
	void testReverseListWithAHighValueLoop() {
		TestManager manager = new TestManager();
		manager.addTestScore(80);
		manager.addTestScore(90);
		manager.addTestScore(100);
		assertEquals("100 90 80", manager.reverseListWithALoop());
	}
}