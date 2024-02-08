package edu.westga.cs6312.zuul.view;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * Original Author: David J. Barnes and Michael Kolling
 * MODIFIED BY:
 * 
 * Created on: 2008.03.30
 * MODIFIED ON:
 * 
 * @author William Pevytoe
 * 
 * @version 1/10/2024
 */

public class CommandWords {
    private static final String[] VALID_COMMANDS = {
        "go", "quit", "help", "look"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords() {
    }

    /**
     * Check whether a given String is a valid command word. 
     * @param	aString	The String that is possibly holding a command
     * 
     * @return true if a given string is a valid command,
     * 			false if it isn't.
     */
    public boolean isCommand(String aString) {
    	for (String current : VALID_COMMANDS) {
            if (current.equals(aString)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Print all valid commands to System.out.
     */
    public void showAll() {
     for (String command : VALID_COMMANDS) {
     System.out.print(command + " ");
     }
     System.out.println();
    }
    
    /**
     * Gets the list of valid commands the user has available 
     * 
     * @return commandString as the list of commands.
     */
    public String getCommandList() {
    	String commandString = ""; 
    	for (String command : VALID_COMMANDS) {
    	     commandString += command + " ";
    	     }
    	 return commandString;
    }
}
