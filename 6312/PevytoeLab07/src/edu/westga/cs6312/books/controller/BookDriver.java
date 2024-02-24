package edu.westga.cs6312.books.controller;

import edu.westga.cs6312.books.model.BookManager;
import edu.westga.cs6312.books.view.BookTUI;

/**
 * Runs the BookTUI program
 * 
 * @author William Pevytoe
 * 
 * @version 2/21/2024
 */
public class BookDriver {

	/**
	 * Runs the program
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		BookManager newManager = new BookManager();
		BookTUI newBookTUI = new BookTUI(newManager);
		newBookTUI.run();
	}

}
