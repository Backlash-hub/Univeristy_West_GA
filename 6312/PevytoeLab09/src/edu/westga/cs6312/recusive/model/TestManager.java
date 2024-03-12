package edu.westga.cs6312.recusive.model;

import java.util.ArrayList;

/**
 * Test Score manager that holds the values of scores
 * 
 * @author William Pevytoe
 * 
 * @version 03/06/2024
 */
public class TestManager {
	private ArrayList<Integer> scoreManager;

	/**
	 * 0 - Parameter constructor that initializes the manager
	 */
	public TestManager() {
		this.scoreManager = new ArrayList<Integer>();
	}

	/**
	 * Adds test score to the test manager
	 * 
	 * Precondition: testScore >= 0 testScore <= 100
	 * 
	 * Postcondition: add testScore to the test manager
	 * 
	 * @param testScore is score to be added to the test manager
	 */
	public void addTestScore(int testScore) {
		if (testScore >= 0 && testScore <= 100) {
			this.scoreManager.add(testScore);
		} else {
			throw new IllegalArgumentException("Invalid Score. Must be between 0 - 100.");
		}
	}

	/**
	 * A string method that returns with a representation of the TestManager
	 * 
	 * @return string representation of the TestManager
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		if (this.scoreManager.isEmpty()) {
			result.append("No Scores");
		} else {
			for (int scores : this.scoreManager) {
				result.append(scores).append(" ");
			}
		}
		return result.toString();
	}

	/**
	 * Returns a string representation of the test scores in reverse order using a
	 * loop.
	 *
	 * @return A string containing the test scores in reverse order.
	 */
	public String reverseListWithALoop() {
		StringBuilder reversed = new StringBuilder();
		if (this.scoreManager.isEmpty()) {
			reversed.append("No Scores");
		} else { 
		for (int position = this.scoreManager.size() - 1; position >= 0; position--) {
			reversed.append(this.scoreManager.get(position)).append(" ");
			}
		}
		return reversed.toString().trim();
	}

	/**
	 * Returns a string representation of the test scores in reverse order using
	 * recursion.
	 *
	 * @return A string containing the test scores in reverse order.
	 */
	public String reverseListWithRecursion() {
		StringBuilder recursion = new StringBuilder();
		if (this.scoreManager.isEmpty()) {
			recursion.append("No Scores");
		} else {
			recursion.append(this.reverseListHelper(this.scoreManager.size() - 1));
		}
		return recursion.toString().trim();
	}

	private String reverseListHelper(int currentIndex) {
		if (currentIndex == 0) {
			return String.valueOf(this.scoreManager.get(currentIndex));
		} else {
			return this.scoreManager.get(currentIndex) + " " + this.reverseListHelper(currentIndex - 1);
		}
	}

}
