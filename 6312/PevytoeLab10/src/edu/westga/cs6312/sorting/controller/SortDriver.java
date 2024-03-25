package edu.westga.cs6312.sorting.controller;

import edu.westga.cs6312.sorting.view.SortTUI;

/**
 * Runs the SortTUI program
 * 
 * @author William Pevytoe
 * 
 * @version 3/19/2024
 */
public class SortDriver {

	/**
	 * Runs the SortTUI program
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		SortTUI newTui = new SortTUI();
		newTui.run();
	}
}
