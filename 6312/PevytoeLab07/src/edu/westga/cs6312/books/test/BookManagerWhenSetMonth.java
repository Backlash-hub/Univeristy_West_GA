package edu.westga.cs6312.books.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.books.model.BookManager;

/**
 * Testing the BookManager setMonth method
 * 
 * @author William Pevytoe
 * 
 * @version 2/20/2024
 */
class BookManagerWhenSetMonth {

	/**
	 * Test the setMonth with valid entry
	 */
	@Test
	public void testBookManagerWhenSetMonthWithValidEntry() {
		BookManager manager = new BookManager();
		manager.setMonth("June");
		assertEquals("Month: June\n" + "no pages", manager.toString());
	}
	
	/**
	 * Test the setMonth with null entry
	 */
	@Test
	public void testBookManagerWhenSetMonthWithNullEntry() {
		assertThrows(NullPointerException.class, () -> {
		BookManager manager = new BookManager();
		manager.setMonth(null);
		});
	}
	
	/**
	 * Test the setMonth with less than 2 characters
	 */
	 @Test
	 public void testBookManagerWhenSetMonthWithEntryLessThanTwoCharacters() {
		assertThrows(IllegalArgumentException.class, () -> {
		BookManager manager = new BookManager();
		manager.setMonth("A");
		});
	 }
	

}
