package edu.westga.cs6312.books.model;

import java.util.ArrayList;

/**
 * This models a book manager that keeps track of number of pages read a day per month
 * 
 * @author William Pevytoe
 * 
 * @version 2/20/2024
 */
public class BookManager {
	private ArrayList<Integer> pagesPerDay;
	private String month;
	
	/**
	 * 0 - parameter constructor that sets the pages per day and the month
	 */
	public BookManager() {
		this.pagesPerDay = new ArrayList<Integer>();
		this.month = "";		
	}
	
	/**
	 * Sets the month
	 * 
	 * @param month is the month to be recorded in
	 * 
	 * Precondition:	month length >= 2
	 * 					month != null
	 * 
	 * Postcondition:	The month is set
	 */
	public void setMonth(String month) {
		if (month == null) {
			throw new NullPointerException("Invalid month name. It should not null");
		} else if (month.length() < 2) {
			throw new IllegalArgumentException("Invalid month name. It should contain at least 2 characters.");
		} else {
			this.month = month;
		}
	}
	
	/**
	 * Sets the pages read
	 * 
	 * @param pagesRead are the number of pages read
	 * 
	 * Precondition:	pagesRead > 0
	 * 
	 * Postcondition:	Adds pagesRead to the Array
	 */
	public void addPages(int pagesRead) {
		if (pagesRead > 0) {
			this.pagesPerDay.add(pagesRead);
		} else {
			throw new IllegalArgumentException("Invalid input. Must be 0 or greater. ");
		}
	}
	
	/**
	 * A string method that returns with a representation of the BookManager
	 * 
	 * @return string representation of the BookManager
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Month: ").append(this.month).append("\n");
		if (this.pagesPerDay.isEmpty()) {
			result.append("no pages");
		} else {
			result.append("Pages read per day:\n");
			for (int pages : this.pagesPerDay) {
				result.append(pages).append("\n");
			}
		}
		return result.toString();
	}
}
