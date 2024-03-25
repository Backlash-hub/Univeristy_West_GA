package edu.westga.cs6312.sorting.testing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.sorting.model.ArrayUtilities;

/**
 * Testing the Insertion Sort method
 * 
 * @author William Pevytoe
 * 
 * @version 3/22/2024
 */
class TestingInsertionSortArrayUtils {

	/**
	 * Testing method with valid array
	 */ 
	@Test
	public void testInsertionSort() {
		ArrayUtilities arrayUtils = new ArrayUtilities();
		int[] array = { 5, 3, 1, 4, 2 };
		arrayUtils.insertionSort(array);
		assertArrayEquals(new int[] { 5, 4, 3, 2, 1 }, array);
	}

	/**
	 * Testing method with null array
	 */
	@Test
	public void testInsertionSortWithNullArray() {
		ArrayUtilities arrayUtils = new ArrayUtilities();
		assertThrows(IllegalArgumentException.class, () -> {
			arrayUtils.insertionSort(null);
		});
	}
}
