package edu.westga.cs6312.sorting.testing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.sorting.model.ArrayUtilities;

/**
 * Testing the Quick sort method
 * 
 * @author William Pevytoe
 * 
 * @version 3/22/2024
 */
class TestQuickSortArrayUtils {

	/**
	 * Testing method with a normal array
	 */
	@Test
	public void testQuickSort() {
		ArrayUtilities arrayUtils = new ArrayUtilities();
		int[] array = { 5, 3, 1, 4, 2 };
		arrayUtils.quickSort(array);
		assertArrayEquals(new int[] { 5, 4, 3, 2, 1 }, array);
	}

	/**
	 * Testing with a null array
	 */
	@Test
	public void testQuickSortWithNullArray() {
		ArrayUtilities arrayUtils = new ArrayUtilities();
		assertThrows(IllegalArgumentException.class, () -> {
			arrayUtils.quickSort(null);
		});
	}

}
