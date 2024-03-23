package edu.westga.cs6312.sorting.testing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.sorting.model.ArrayUtilities;

/**
 * Testing if the given array is in decreasing order
 * 
 * @author William Pevytoe
 * 
 * @version 3/22/2024
 */
class TestArrayIsInDecreasingOrder {

	/**
	 * Testing decreasing array with a decreasing array
	 */
	@Test
	public void testIsInDecreasingOrderWithSortedArray() {
		ArrayUtilities arrayUtils = new ArrayUtilities();
		int[] array = { 5, 4, 3, 2, 1 };
		assertTrue(arrayUtils.isInDecreasingOrder(array));
	}

	/**
	 * Testing decreasing array with an increasing array
	 */
	@Test
	public void testIsInDecreasingOrderWithUnsortedArray() {
		ArrayUtilities arrayUtils = new ArrayUtilities();
		int[] array = { 1, 2, 3, 5, 4 };
		assertFalse(arrayUtils.isInDecreasingOrder(array));
	}

	/**
	 * Testing decreasing array with a null array
	 */
	@Test
	public void testIsInDecreasingOrderWithNullArray() {
		ArrayUtilities arrayUtils = new ArrayUtilities();
		assertThrows(IllegalArgumentException.class, () -> {
			arrayUtils.isInDecreasingOrder(null);
		});
	}
}
