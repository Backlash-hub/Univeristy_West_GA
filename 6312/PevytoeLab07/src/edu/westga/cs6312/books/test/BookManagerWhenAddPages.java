package edu.westga.cs6312.books.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.books.model.BookManager;

/**
 * Test the BookManager AddPages
 * 
 * @author William Pevytoe
 * 
 * @version 2/20/2024
 */
class BookManagerWhenAddPages {

	/**
	 * Test AddPages with a valid input
	 */
	@Test
	public void testBookManagerWhenAddePagesWithValidInputOfFive() {
		BookManager manager = new BookManager();
		manager.addPages(5);
		assertEquals("Month: \n" + "Pages read per day:\n" + "5\n", manager.toString());
	}
	
	/**
	 * Test AddPages with a invalid input
	 */
	@Test
	public void testBookManagerWhenAddePagesWithInValidInputOfNegativeOne() {
		assertThrows(IllegalArgumentException.class, () -> {
		BookManager manager = new BookManager();
		manager.addPages(-1);
		});
	}

}
