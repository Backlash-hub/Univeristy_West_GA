package edu.westga.cs6312.zuul.controller;

import edu.westga.cs6312.zuul.view.Game;

/**
 * This class contains the entry point of the application
 * 
 * @author William Pevytoe
 * 
 * @version 1/9/2024
 */
public class ZuulDriver {

	/**
	 * The entry point of the application
	 * @param args	Used to accept command line argument
	 */
	public static void main(String[] args) {
		Game demo = new Game();
		demo.play();
	}
}
