package edu.westga.cs6312.sorting.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.sorting.model.ArrayUtilities;

/**
 * Testing generate array method
 * 
 * @author William Pevytoe
 * 
 * @version 3/22/2024
 */
class TestGenerateArrays {

	/**
	 * Creating an array with valid size
	 */
	@Test
	public void testCreateArraywithValidSize() {
		ArrayUtilities arrayUtils = new ArrayUtilities();
		int size = 5;
		int[] result = arrayUtils.generateArray(size);
		assertNotNull(result);
		assertEquals(size, result.length);
	}

	/**
	 * Creating an array with invalid size
	 */
	@Test
	public void testGenerateArrayWithInvalidSize() {
		ArrayUtilities arrayUtils = new ArrayUtilities();
		assertThrows(IllegalArgumentException.class, () -> {
			arrayUtils.generateArray(-1);
		});
	}
}
