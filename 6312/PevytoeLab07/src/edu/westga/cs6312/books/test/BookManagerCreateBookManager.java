package edu.westga.cs6312.books.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.books.model.BookManager;

/**
 * Test the BookManager constructor
 * 
 * @author William Pevytoe
 * 
 * @version 2/20/2024
 */
class BookManagerCreateBookManager {

	/**
	 * Test the 0 parameter BookManager constructor
	 */
	@Test
	public void testBookManagerCreateBookManager() {
		BookManager manager = new BookManager();
		assertEquals("Month: \n" + "no pages", manager.toString());
	}

}
