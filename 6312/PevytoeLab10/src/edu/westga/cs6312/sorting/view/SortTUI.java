package edu.westga.cs6312.sorting.view;

import java.util.Scanner;

import edu.westga.cs6312.sorting.model.ArrayUtilities;
import edu.westga.cs6312.sorting.model.SortTimer;

/**
 * Gathers user data to create the SortTimer
 * 
 * @author William Pevytoe
 * 
 * @version 3/19/2024
 */
public class SortTUI {
	private ArrayUtilities manipulateArray;
	private SortTimer timer;
	private Scanner input;
	
	/**
	 * 0 - Parameter constructor that initializes the scanner, SorTimer, ArrayUtilites
	 */
	public SortTUI() {
		this.input = new Scanner(System.in);
		this.timer = new SortTimer();
		this.manipulateArray = new ArrayUtilities();
	}
	
	/**
	 * Runs the program
	 */
	public void run() {		
		System.out.println("Welcome to the sorting application");
		int size = this.getIntegerFromUser("Enter an array size: ");
		int [] originalArray = this.manipulateArray.generateArray(size);
		int [] copyOfArray = this.manipulateArray.copyArray(originalArray);
		
		System.out.println("Before sorting, Insertion Sort's array is sorted: " + this.manipulateArray.isInDecreasingOrder(copyOfArray));
        this.sortAndDisplayTime("Insertion Sort", copyOfArray);
        System.out.println("After sorting, Insertion Sort's array is sorted: " + this.manipulateArray.isInDecreasingOrder(copyOfArray));

        System.out.println("\nBefore sorting, Quick Sort's array is sorted: " + this.manipulateArray.isInDecreasingOrder(originalArray));
        this.sortAndDisplayTime("Quick Sort", originalArray);
        System.out.println("After sorting, Quick Sort's array is sorted: " + this.manipulateArray.isInDecreasingOrder(originalArray));
	}
		
	private int getIntegerFromUser(String message) {
		boolean isValid = false;
		int number = 0;
		do {
			try {
				System.out.println(message);
		        String userInput = this.input.nextLine();
		        number = Integer.parseInt(userInput);
		        isValid = true;
			} catch (NumberFormatException exception) {
				System.out.println("That wasn't a valid integer. Please try again.");
			}
		} while (!isValid);
		return number;
	}
	
	private void sortAndDisplayTime(String algorithmName, int[] array) {
        System.out.println("\nSorting with " + algorithmName + " algorithm...");
        this.timer.startTimer();
        if (algorithmName.equals("Insertion Sort")) {
            this.manipulateArray.insertionSort(array);
        } else if (algorithmName.equals("Quick Sort")) {
            this.manipulateArray.quickSort(array);
        }
        this.timer.stopTimer();
        System.out.println(algorithmName + " sort took: " + this.timer.getElapsedTime() + " milliseconds");
    }
}
