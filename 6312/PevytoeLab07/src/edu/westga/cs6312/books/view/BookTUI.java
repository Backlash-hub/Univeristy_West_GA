package edu.westga.cs6312.books.view;

import java.util.Scanner;

import edu.westga.cs6312.books.model.BookManager;

/**
 * Gathers user data to create a Book manger data set
 * 
 * @author William Pevytoe
 * 
 * @version 2/21/2024
 */
public class BookTUI {
	private Scanner input;
	private BookManager managingBooks;
	 
	/**
	 * 1 - Parameter constructor that initiates the scanner and BookManager
	 * 
	 * @param manager is the BookManager Object
	 */
	public BookTUI(BookManager manager) {
		this.input = new Scanner(System.in);
		this.managingBooks = manager;
	}
	
	/**
	 * Runs the program
	 */
	public void run() {
		System.out.println("Welcome to the book manager");
		boolean validMonthEntered = false;
		
		while (!validMonthEntered) {
			System.out.println("\nPlease enter the month name: ");
			String userInputMonth = this.input.nextLine();
			try {
				this.managingBooks.setMonth(userInputMonth);
				validMonthEntered = true;
			} catch (IllegalArgumentException exception) {
				System.out.println("Name must be at least 2 characters long\nPlease try again");
			} catch (NullPointerException npe) {
				System.out.println("Name should not be null\n Please try again");
			}
		}
		int choice;
        do {
            this.displayMenu();
            choice = this.getIntegerFromUser("Enter your choice: ");
            switch (choice) {
                case 1:
                    this.addPages();
                    break;
                case 2:
                    this.printPages();
                    break;
                case 3:
                    System.out.println("Thank you for using our system");
                    break;
                default:
                    System.out.println("Invalid menu option. Please try again.\n");
            }
        } while (choice != 3);
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
		System.out.println("\n1 - Add a page total to the collection");
		System.out.println("2 - Print the list of page totals");
		System.out.println("3 - Quit\n");
	}
	
	private void addPages() {
		int pages = this.getIntegerFromUser("Please enter a daily page total: ");
		this.managingBooks.addPages(pages);
		System.out.println("Your page total was successfully added");
	}
	
	private void printPages() {
		System.out.println("\n" + this.managingBooks.toString());
	}
}
