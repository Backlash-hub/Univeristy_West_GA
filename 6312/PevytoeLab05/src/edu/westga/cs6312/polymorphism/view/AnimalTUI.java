package edu.westga.cs6312.polymorphism.view;

import java.util.ArrayList;
import java.util.Scanner;

import edu.westga.cs6312.polymorphism.model.Animal;

/**
 *  Gathers user data to create the list of animals 
 *
 * @author William Pevytoe
 * 
 * @version 2/1/2024
 */
public class AnimalTUI {
	private Scanner input;
	private ArrayList<Animal> animals;
	
	/**
	 * 0 - parameter constructor that initializes the scanner and arraylist
	 */
	public AnimalTUI() {
		this.input = new Scanner(System.in);
		this.animals = new ArrayList<>();
	}
	
	/**
	 * Runs the program
	 */
	public void run() {
		int numberSelection = 0;
		System.out.println("--Welcome to Animal Creator--");
		while (numberSelection != 3) {
			this.displayMenu();
			System.out.println("\nPlease make selection: ");
			String userSelection = this.input.nextLine();
			numberSelection = Integer.parseInt(userSelection);
			if (numberSelection == 1) {
				this.addAnimal();
			} else if (numberSelection == 2) {
				this.printList();
			} else if (numberSelection != 3) {
				System.out.println("Not a valid option");				
			}
		}
		System.out.println("Goodbye");	
	}
	
	private void displayMenu() {
		System.out.println("\n1 -- Add animal");
		System.out.println("2 -- Print list of animals");
		System.out.println("3 -- Quit");
	}
	
	private void addAnimal() {
		System.out.println("Please choose an Animal");
		String userAnimalSelection = this.input.nextLine();
		Animal newAnimal = Animal.getNewAnimal(userAnimalSelection);
		if (newAnimal != null) {
			this.animals.add(newAnimal);
			System.out.println("New " + userAnimalSelection + " was added.");
		} else {
			System.out.println("Sorry, " + userAnimalSelection + " cannot be added to the list.");
		}		
	}
	
	private void printList() {
		System.out.println("\nAnimals in the list:");

        if (this.animals.isEmpty()) {
            System.out.println("No animals found.");
        } else {
            for (Animal animal : this.animals) {
                System.out.println(animal);
            }
        }
	}
}
