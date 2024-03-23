package edu.westga.cs6312.sorting.testing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.sorting.model.ArrayUtilities;

/**
 * Testing the Copy Array method
 * 
 * @author William Pevytoe
 * 
 * @version 3/22/2024
 */
class TestCopyArrayArrayUtils {

	/**
	 * Testing Copy array with a normal array
	 */
	@Test
	public void testCopyArray() {
		ArrayUtilities arrayUtils = new ArrayUtilities();
		int[] array = { 1, 2, 3, 4, 5 };
		int[] copiedArray = arrayUtils.copyArray(array);
		assertArrayEquals(array, copiedArray);
		assertNotSame(array, copiedArray);
	}

	/**
	 * Testing copy array with null array
	 */
	@Test
	public void testCopyNullArray() {
		ArrayUtilities arrayUtils = new ArrayUtilities();
		assertThrows(IllegalArgumentException.class, () -> {
			arrayUtils.copyArray(null);
		});
	}
}
