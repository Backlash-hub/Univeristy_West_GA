package edu.westga.cs6312.interfaces.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import edu.westga.cs6312.interfaces.model.RealEstate;

/**
 * Gathers user data to create the list of RealEstate Properties
 * 
 * @author William Pevytoe
 * 
 * @version 2/7/2024
 */
public class RealEstateTUI {
	private Scanner input;
	private ArrayList<RealEstate> realEstate;
	
	/**
	 * 0 - parameter constructor that initializes the scanner and arraylist
	 */
	public RealEstateTUI() {
		this.input = new Scanner(System.in);
		this.realEstate = new ArrayList<RealEstate>();
	}
	
	/**
	 * Runs the program
	 */
	public void run() {
		int numberSelection = 0;
		System.out.println("--Welcome to RealEstate Creator--");
		while (numberSelection != 3) {
			this.displayMenu();
			System.out.println("\nPlease make selection: ");
			String userSelection = this.input.nextLine();
			numberSelection = Integer.parseInt(userSelection);
			if (numberSelection == 1) {
				this.addEstate();
			} else if (numberSelection == 2) {
				this.printList();
			} else if (numberSelection != 3) {
				System.out.println("Not a valid option");				
			}
		}
		System.out.println("Goodbye");	
	}
	
	private void displayMenu() {
		System.out.println("\n1 -- Add Real Estate Property");
		System.out.println("2 -- Print list Real Estate Properties");
		System.out.println("3 -- Quit");
	}
	
	private void addEstate() {
		System.out.println("Please choose a location:");
		String userLocationSelection = this.input.nextLine();
		System.out.println("Please insert the square footage of the lot:");
		double userLandArea =  Double.parseDouble(this.input.nextLine());
		System.out.println("Please insert the square footage of the structure:");
		double userStructreArea =  Double.parseDouble(this.input.nextLine());
		RealEstate newEstate = new RealEstate(userLocationSelection, userLandArea, userStructreArea);
		this.realEstate.add(newEstate);
		System.out.println("New real estate property was added.");
	}
	
	private void printList() {
        if (this.realEstate.isEmpty()) {
            System.out.println("No Estates found.");
        } else {
        	System.out.println("\nEstates in the list:");
        	Collections.sort(this.realEstate);
            for (RealEstate theEstate : this.realEstate) {
                System.out.println(theEstate);
            }
        }
	}
}
