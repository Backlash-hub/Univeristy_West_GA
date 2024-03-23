package edu.westga.cs6312.sorting.model;

import java.util.Arrays;
import java.util.Random;

/**
 * This will generate and manipulate simple arrays of integers
 * 
 * @author William Pevytoe
 * 
 * @version 3/14/2024
 */
public class ArrayUtilities {

	/**
	 * Creates an array of the parameter size and fills it with random numbers
	 * between 0 and double the size of the size
	 * 
	 * @param size is the size of the array
	 * @return the array
	 */
	public int[] generateArray(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Size must be greater than 0");
		}

		int[] array = new int[size];
		Random rand = new Random();

		for (int position = 0; position < size; position++) {
			array[position] = rand.nextInt(2 * size);
		}
		return array;
	}

	/**
	 * Checks if the array that is passed is in descending order
	 * 
	 * @param theArray is an array that is passed
	 * @return a true or false depending if the array is in descending order
	 */
	public boolean isInDecreasingOrder(int[] theArray) {
		if (theArray == null) {
			throw new IllegalArgumentException("Array must not be null");
		}
		for (int position = 1; position < theArray.length; position++) {
			if (theArray[position] > theArray[position - 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Will swap the given indexes within the given array
	 * 
	 * @param firstIndex  is the first index supplied in the given array
	 * @param secondIndex is the second index supplied in the given array
	 * @param theArray    is the simple array
	 */
	public void swapElements(int firstIndex, int secondIndex, int[] theArray) {
		if (theArray == null) {
			throw new IllegalArgumentException("Array must not be null");
		}
		if (firstIndex < 0 || firstIndex >= theArray.length || secondIndex < 0 || secondIndex >= theArray.length) {
			throw new IllegalArgumentException("Invalid index provided.");
		}

		int temp = theArray[firstIndex];
		theArray[firstIndex] = theArray[secondIndex];
		theArray[secondIndex] = temp;
	}

	/**
	 * Copies the given array and returns a new one
	 * 
	 * @param theArray is a simple array
	 * @return a copy of the given array
	 */
	public int[] copyArray(int[] theArray) {
		if (theArray == null) {
			throw new IllegalArgumentException("Array must not be null");
		}
		return Arrays.copyOf(theArray, theArray.length);
	}

	/**
	 * Will sort the array values into decreasing order using Insertion sort
	 * algorithm
	 * 
	 * @param theArray is a simple array
	 */
	public void insertionSort(int[] theArray) {
		if (theArray == null) {
			throw new IllegalArgumentException("Array must not be null");
		}

		for (int currentIndex = 1; currentIndex < theArray.length; currentIndex++) {
			int key = theArray[currentIndex];
			int previousIndex = currentIndex - 1;
			while (previousIndex >= 0 && theArray[previousIndex] < key) {
				theArray[previousIndex + 1] = theArray[previousIndex];
				previousIndex = previousIndex - 1;
			}
			theArray[previousIndex + 1] = key;
		}
	}

	/**
	 * Will sort the array values into decreasing order using Quick sort algorithm
	 * 
	 * @param theArray is a simple array
	 */
	public void quickSort(int[] theArray) {
		if (theArray == null) {
			throw new IllegalArgumentException("Array must not be null");
		}

		this.quickSort(theArray, 0, theArray.length - 1);
	}

	private void quickSort(int[] theArray, int low, int high) {
		if (low < high) {
			int pi = this.partition(theArray, low, high);
			this.quickSort(theArray, low, pi);
			this.quickSort(theArray, pi + 1, high);
		}
	}

	private int partition(int[] theArray, int low, int high) {
		int pivot = theArray[low];
		int lowPartition = low - 1;
		int highPartition = high + 1;

		while (true) {
			do {
				lowPartition++;
			} while (theArray[lowPartition] > pivot);

			do {
				highPartition--;
			} while (theArray[highPartition] < pivot);

			if (lowPartition >= highPartition) {
				return highPartition;
			}

			int temp = theArray[lowPartition];
			theArray[lowPartition] = theArray[highPartition];
			theArray[highPartition] = temp;
		}
	}
}
