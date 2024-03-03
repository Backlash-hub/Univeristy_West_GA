package edu.westga.cs6312.files.view;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import edu.westga.cs6312.files.model.RealEstate;
import edu.westga.cs6312.files.model.RealEstateManager;

/**
 * Gathers user data to create the RealEstates within the RealEstateManager
 * 
 * @author William Pevytoe
 * 
 * @version 2/28/2024
 */
public class RealEstateTUI {
	private Scanner input;
	private RealEstateManager manageEstates;
	
	/**
	 * 1 - Parameter constructor that initiates the scanner and RealEstateManager
	 * 
	 * @param manager is the RealEstateManager Object
	 */
	public RealEstateTUI(RealEstateManager manager) {
		this.input = new Scanner(System.in);
		this.manageEstates = manager;
	}
	
	/**
	 * Runs the program
	 */
	public void run() {
		System.out.println("Welcome to the propert manager application - now with files!");
		int choice;
        do {
            this.displayMenu();
            choice = this.getIntegerFromUser("Enter your choice: ");
            switch (choice) {
                case 1:
                    this.addProperties();
                    break;
                case 2:
                    this.displayProperties();
                    break;
                case 3:
                    this.saveProperties();
                    break;
                case 4:
                	System.out.println("Thank you for using our system");
                	break;
                default:
                    System.out.println("Invalid menu option. Please try again.\n");
            }
        } while (choice != 4);
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
		System.out.println("\n1 - Add properties from file");
		System.out.println("2 - Display sorted properties on console");
		System.out.println("3 - Save sorted properties to file");
		System.out.println("4 - Quit\n");
	}
	
	private void addProperties() {
	    System.out.println("Enter the file name:");
	    String fileName = this.input.nextLine();
	    try (Scanner inFile = new Scanner(new File(fileName))) {
	        System.out.println("The properties are:");
	        while (inFile.hasNextLine()) {
	            String line = inFile.nextLine();
	            String[] parts = line.split(", ");
	            if (parts.length == 3) {
	                String location = parts[0];
	                int landArea;
	                int structureArea;
	                try {
	                    landArea = Integer.parseInt(parts[1]);
	                    structureArea = Integer.parseInt(parts[2]);
	                } catch (NumberFormatException nfe) {
	                    continue;
	                }
	                RealEstate newEstate = new RealEstate(location, landArea, structureArea);
	                this.manageEstates.addProperty(newEstate);
	                System.out.println(newEstate);
	            }
	        }
	        System.out.println("Properties added successfully from file: " + fileName);
	    } catch (FileNotFoundException fnfe) {
	        System.out.println("File not found: " + fileName);
	    }
	}

	private void displayProperties() {
		System.out.println("\nSorted Properties:");
        for (RealEstate property : this.manageEstates.getProperties()) {
            System.out.println(property);
        }
	}
	
	private void saveProperties() {
	    System.out.println("Enter the file name:");
	    String fileName = this.input.nextLine();
	    try (PrintWriter outFile = new PrintWriter(fileName)) {
	        for (RealEstate property : this.manageEstates.getProperties()) {
	            outFile.println(property.toString());
	        }
	        System.out.println("Estates added to the " + fileName + " file");
	    } catch (FileNotFoundException fnfe) {
	        System.out.println("There was a problem with the file");
	    }
	}
}
