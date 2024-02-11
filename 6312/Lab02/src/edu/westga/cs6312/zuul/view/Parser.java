package edu.westga.cs6312.zuul.view;

import java.util.Scanner;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author David J. Barnes and Michael Kolling
 * MODIFIED BY:
 * 
 * @version 2008.03.30
 * MODIFIED ON:
 */

public class Parser {
    private CommandWords commands;
    private Scanner reader;

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() {
    	this.commands = new CommandWords();
    	this.reader = new Scanner(System.in);
    }

    /**
     * Returns the command
     * 
     * @return The next command from the user.
     */
    public Command getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = this.reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
        }
        
        if (tokenizer.hasNext()) {
        	word2 = tokenizer.next();
        }
        tokenizer.close();

        if (this.commands.isCommand(word1)) {
            return new Command(word1, word2);
        } else {
            return new Command(null, word2); 
        }
    }
    
    /**
     * Print out a list of valid command words.
     */
    public void showCommands() {
     this.commands.showAll();
    }
    
    /**
     * Calls a list of valid command words.
     * 
     * @return A string containing all valid command words
     */
    public String getCommands() {
    	return this.commands.getCommandList();
    }
}