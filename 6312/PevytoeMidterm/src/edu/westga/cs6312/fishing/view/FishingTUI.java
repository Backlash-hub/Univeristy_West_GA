package edu.westga.cs6312.fishing.view;

import java.util.Scanner;

import edu.westga.cs6312.fishing.model.Angler;
import edu.westga.cs6312.fishing.model.FishingHole;
import edu.westga.cs6312.fishing.model.GameBoard;

/**
 * Gathers user data to create the game
 * 
 * @author William Pevytoe
 * 
 * @version 2/15/2024
 */
public class FishingTUI {
	private GameBoard gameBoard;
	private Scanner input;
	
	/**
	 * 1 - Parameter Constructor that initializes the game and the scanner
	 * 
	 * @param gamingSurface is the GameBoard Object
	 */
	public FishingTUI(GameBoard gamingSurface) {
		this.gameBoard = gamingSurface;
		this.input = new Scanner(System.in);
	}
	
	/**
	 * Runs the Program
	 */
	public void run() {
		 System.out.println("Welcome to Down by the Fishin' Hole\n"); 
		int choice;
	        do {
	            this.displayMenu();
	            choice = this.getIntegerFromUser("Enter your choice: ");
	            switch (choice) {
	                case 1:
	                    this.describeCurrentFishingHole();
	                    break;
	                case 2:
	                    this.describeAngler();
	                    break;
	                case 3:
	                    this.describeGameBoard();
	                    break;
	                case 4:
	                	this.move();
	                	break;
	                case 5:
	                	this.fishAtCurrentLocation();
	                	break;
	                case 9:
	                    System.out.println("Thank you for using the fishing application!");
	                    break;
	                default:
	                    System.out.println("Invalid menu option. Please try again.\n");
	            }
	        } while (choice != 9);
	}
		
    private void displayMenu() {
        System.out.println("1 - Describe current fishing hole");
        System.out.println("2 - Describe angler");
        System.out.println("3 - Describe game board");
        System.out.println("4 - Move angler position");
        System.out.println("5 - Fish in the current hole");
        System.out.println("9 - Quit the application\n");
    }
    
    private void describeCurrentFishingHole() {
    	System.out.println("\n" + this.gameBoard.getFishingHoleLocation() + "\n");
    }

    private void describeAngler() {
        System.out.println("\nThe Angler has: " + this.gameBoard.getAngler() + "\n");
    }

    private void describeGameBoard() {
        System.out.println("\n" + this.gameBoard.toString() +  "\n");
    }
	
	private int getIntegerFromUser(String message) {
        System.out.println(message);
        String userInput = this.input.nextLine();
        return Integer.parseInt(userInput.trim());
	}
	
	private void move() {
		System.out.println("\n1 - Up");
        System.out.println("2 - Down\n");
		int choice = this.getIntegerFromUser("Select Direction: ");
		if (choice == 1) {
			this.gameBoard.moveUp();
			System.out.println("\n" + this.gameBoard.getFishingHoleLocation() + "\n");
		} else if (choice == 2) {
			this.gameBoard.moveDown();
			System.out.println("\n" + this.gameBoard.getFishingHoleLocation() + "\n");
		} else {
			System.out.println("\nInvalid entry");
		}
	}
	
	private void fishAtCurrentLocation() {
		FishingHole currentHole = this.gameBoard.getFishingHoleLocation();
        Angler theFisher = this.gameBoard.getAngler();
        int initialMoneyUnits = theFisher.getMoneyUnitsLdeft();
        int initialFishCount = currentHole.getFish().getNumberOfFishInSchool();
        this.gameBoard.fishInCurrentLocation();
        int moneyPaid = initialMoneyUnits - theFisher.getMoneyUnitsLdeft();
        int fishCaught = initialFishCount - currentHole.getFish().getNumberOfFishInSchool();
        System.out.println("\nFishing done in the current hole. Money paid: " + moneyPaid + ", Fish caught: " + fishCaught + "\n");
	}
}
