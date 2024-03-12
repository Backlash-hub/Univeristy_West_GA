package edu.westga.cs6312.recusive.controller;

import edu.westga.cs6312.recusive.model.TestManager;
import edu.westga.cs6312.recusive.view.TestTUI;

/**
 * Runs the TestTUI program
 * 
 * @author William Pevytoe
 * 
 * @version 3/7/2024
 */
public class TestDriver {

	/**
	 * Runs the program
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		TestManager newManager = new TestManager();
		TestTUI newTestTui = new TestTUI(newManager);
		newTestTui.run();
	}

}
