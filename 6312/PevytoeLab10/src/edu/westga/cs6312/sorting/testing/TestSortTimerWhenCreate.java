package edu.westga.cs6312.sorting.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.sorting.model.SortTimer;

/**
 * Testing the Constructor along with Start and Stop get the time elapsed
 * 
 * @author William Pevytoe
 * 
 * @version 3/22/2024
 */
class TestSortTimerWhenCreate {

	/**
	 * Testing getting the ElapsedTime with Zero runtime
	 */
	@Test
	public void testGetElapsedTimeWithZeroRuntime() {
		SortTimer timer = new SortTimer();
        timer.startTimer();
        timer.stopTimer();
        assertEquals(0, timer.getElapsedTime());
	}
	
	/**
	 * Testing getting the ElapsedTime with 10 second runtime
	 */	
	@Test
	public void testGetElapsedTimeWith10SecondRuntime() {
		SortTimer timer = new SortTimer();
        timer.startTimer();
        try {
        	Thread.sleep(10000);
        } catch (InterruptedException ex) {
        	ex.printStackTrace();
        }
        timer.stopTimer();
        long elapsedTime = timer.getElapsedTime();
        assertTrue(elapsedTime >= timer.getElapsedTime());
	}
	
	/**
	 * Testing getting the ElapsedTime with 5 second runtime
	 */
	@Test
	public void testGetElapsedTimeWith5SecondRuntime() {
		SortTimer timer = new SortTimer();
        timer.startTimer();
        try {
        	Thread.sleep(5000);
        } catch (InterruptedException ex) {
        	ex.printStackTrace();
        }
        timer.stopTimer();
        long elapsedTime = timer.getElapsedTime();
        assertTrue(elapsedTime >= timer.getElapsedTime());
	}
}
