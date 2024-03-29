package edu.westga.cs6312.zuul.view;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two strings: a command word and a second
 * word (for example, if the command was "take map", then the two strings
 * obviously are "take" and "map").
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the command word is null.
 *
 * If the command had only one word, then the second word is null.
 * 
 * Original Author: David J. Barnes and Michael Kolling
 * MODIFIED BY:
 * 
 * Created on: 2008.03.30
 * MODIFIED ON:
 * 
 * @author William Pevytoe
 * 
 * @version 1/9/2024
 */

public class Command {
    private String commandWord;
    private String secondWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     * @param firstWord The first word of the command. Null if the command
     *                  was not recognised.
     * @param secondWord The second word of the command.
     */
    public Command(String firstWord, String secondWord) {
    	this.commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     * @return The command word.
     */
    public String getCommandWord() {
        return this.commandWord;
    }

    /**
     * This method returns the second word
     * 
     * @return The second word of this command. Returns null if there was no
     * second word.
     */
    public String getSecondWord() {
        return this.secondWord;
    }

    /**
     * This method determines if the command word is unknown or not
     * @return true if this command was not understood.
     */
    public boolean isUnknown() {
        return (this.commandWord == null);
    }

    /**
     * This method determines whether there is a second word or not
     * @return true if the command has a second word.
     */
    public boolean hasSecondWord() {
        return (this.secondWord != null);
    }
}
