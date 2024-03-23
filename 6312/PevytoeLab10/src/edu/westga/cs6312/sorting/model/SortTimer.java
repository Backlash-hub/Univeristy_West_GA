package edu.westga.cs6312.sorting.model;

/**
 * This will be used to start and stop a timer to see how long the code takes to
 * complete
 * 
 * @author William Pevytoe
 * 
 * @version 3/14/2024
 */
public class SortTimer {
	private long startTime;
	private long endTime;
	private boolean programIsRunning;

	/**
	 * 0 - Parameter constructor that initializes the times and that the program is
	 * not running
	 */
	public SortTimer() {
		this.startTime = 0;
		this.endTime = 0;
		this.programIsRunning = false;
	}

	/**
	 * Sets the start time to the current system time
	 * 
	 * Precondition If program is not running
	 * 
	 * Postcondition sets start time sets the program to running
	 */
	public void startTimer() {
		if (this.programIsRunning) {
			throw new IllegalStateException("Timer is already running");
		}
		this.startTime = System.currentTimeMillis();
		this.programIsRunning = true;
	}

	/**
	 * Sets the stop time the the current system time
	 * 
	 * Precondition If the program is running
	 * 
	 * Postcondition Sets the stop time Sets program to not running
	 */
	public void stopTimer() {
		if (!this.programIsRunning) {
			throw new IllegalStateException("Timer is not running");
		}
		this.endTime = System.currentTimeMillis();
		this.programIsRunning = false;
	}

	/**
	 * Returns the time difference between the start time and end time
	 * 
	 * Precondition If the program is running
	 * 
	 * Postcondition Returns the current time - the start time ELSE Returns the end
	 * time - the start time
	 * 
	 * @return the time that has elapsed
	 */
	public long getElapsedTime() {
		if (this.programIsRunning) {
			return System.currentTimeMillis() - this.startTime;
		} else {
			return this.endTime - this.startTime;
		}
	}
}
