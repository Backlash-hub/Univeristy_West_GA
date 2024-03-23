package edu.westga.cs6312.sorting.testing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.sorting.model.ArrayUtilities;

/**
 * Testing the Swap elements method
 * 
 * @author William Pevytoe
 * 
 * @version 3/22/2024
 */
class TestingSwapElementsArrayUtils {

	/**
	 * Testing Swapping Elements with valid indexes
	 */
	@Test
	public void testSwapElementsWithValidIndexes() {
		ArrayUtilities arrayUtils = new ArrayUtilities();
		int[] array = { 1, 2, 3, 4, 5 };
		arrayUtils.swapElements(0, 4, array);
		assertArrayEquals(new int[] { 5, 2, 3, 4, 1 }, array);
	}

	/**
	 * Testing Swapping Elements with invalid index
	 */
	@Test
	public void testSwapElementsWithInvalidIndexes() {
		ArrayUtilities arrayUtils = new ArrayUtilities();
		int[] array = { 1, 2, 3, 4, 5 };
		assertThrows(IllegalArgumentException.class, () -> {
			arrayUtils.swapElements(-1, 4, array);
		});
	}

	/**
	 * Testing Swapping Elements with null array
	 */
	@Test
	public void testSwapElementsWithNullArray() {
		ArrayUtilities arrayUtils = new ArrayUtilities();
		assertThrows(IllegalArgumentException.class, () -> {
			arrayUtils.swapElements(0, 1, null);
		});
	}
}
