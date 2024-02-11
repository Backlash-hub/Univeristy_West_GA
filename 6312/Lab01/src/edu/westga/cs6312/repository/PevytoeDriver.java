package edu.westga.cs6312.repository;

import java.util.List;

/**
 * Testing Repository
 * 
 * @author William Pevytoe
 * 
 * @version 1/8/2024
 * 
 */
public class PevytoeDriver {

	/**
	 * Printing a list
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		System.out.println("I love Java!");
		List<String> myList = List.of("one", "two", "three");
		for (String current : myList) {
			System.out.println(current);
		}
	}
}
