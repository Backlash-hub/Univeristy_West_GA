package edu.westga.cs6312.recusive.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import edu.westga.cs6312.recusive.model.TestManager;

/**
 * Gathers user data to create the TestManager
 * 
 * @author William Pevytoe
 * 
 * @version 3/7/2024
 */
public class TestTUI {
	private Scanner input;
	private TestManager scoresManager;
	
	/**
	 * 1 - Parameter constructor that initiates the scanner and TestManager
	 * 
	 * @param manager is the TestManager Object
	 */
	public TestTUI(TestManager manager) {
		this.input = new Scanner(System.in);
		this.scoresManager = manager;
	}
	
	/**
	 * Runs the program
	 */
	public void run() {
		System.out.println("Welcome to the test score list reverser");
		int choice;
		do {
			this.displayMenu();
			choice = this.getIntegerFromUser("Enter your choice: ");
			switch (choice) {
				case 1:
					this.addTestScores();
					break;
				case 2:
					this.displayOriginal();
					break;
				case 3:
					this.displayLoop();
					break;
				case 4:
					this.displayRecursion();
					break;
				case 5:
					System.out.println("Thank you for using our system");
					break;
				default:
					System.out.println("Invalid menu option. Please try again.\n");
			}	
		} while (choice != 5);
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
	
	private void displayMenu() {
		System.out.println("\n 1 - Add test scores from file");
		System.out.println(" 2 - Display original test scores on console");
		System.out.println(" 3 - Display loop-reversed test scores on console");
		System.out.println(" 4 - Display recursive-reversed test scores on console");
		System.out.println(" 5 - Quit\n");
	}
	
	private void addTestScores() {
		 System.out.print("\nEnter the file name: ");
		    String fileName = this.input.nextLine();

		    try (Scanner inFile = new Scanner(new File(fileName))) {
		        while (inFile.hasNextLine()) {
		            String line = inFile.nextLine();
		            try {
		                int score = Integer.parseInt(line.trim());
		                this.scoresManager.addTestScore(score);
		            } catch (IllegalArgumentException iae) {
		            	System.out.println("\nInvalid score format: " + line + " was not added");
		            }
		        }
		        System.out.println("\nValid test scores added successfully from file: " + fileName);
		    } catch (FileNotFoundException fnfe) {
		        System.out.println("File not found: " + fileName);
		    }
		}
	
	private void displayOriginal() {
		System.out.println("\nThe original test scores are:\n" + this.scoresManager.toString());
	}
	
	private void displayLoop() {
		System.out.println("\nThe loop-reversed test scores are:\n" + this.scoresManager.reverseListWithALoop());
	}
	
	private void displayRecursion() {
		System.out.println("\nThe recursive-reversed test scores are:\n" + this.scoresManager.reverseListWithRecursion());
	}

}