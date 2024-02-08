package edu.westga.cs6312.zuul.view;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import edu.westga.cs6312.zuul.model.Room;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
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

public class Game {
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        this.createRooms();
        this.parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        Room outside;
        Room theatre;
        Room pub;
        Room lab;
        Room office;
      
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        outside.setExits(null, theatre, lab, pub);
        theatre.setExits(null, null, null, outside);
        pub.setExits(null, outside, null, null);
        lab.setExits(outside, office, null, null);
        office.setExits(null, null, null, lab);

        this.currentRoom = outside;
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() {            
    	this.printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = this.parser.getCommand();
            finished = this.processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm", Locale.US);
		System.out.println("The current time is: " + formatter.format(LocalTime.now()));
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        this.printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
        	this.printHelp();
        } else if (commandWord.equals("go")) {
        	this.goRoom(command);
        } else if (commandWord.equals("quit")) {
            wantToQuit = this.quit(command);
        } else if (commandWord.equals("look")) {
        	 this.look();
        }

        return wantToQuit;
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(this.parser.getCommands());
    }

    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     * @param	command		the user's command
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }
        String direction = command.getSecondWord();
        Room nextRoom = this.currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
            return;
        }
    	this.currentRoom = nextRoom;
        this.printLocationInfo();
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * 
     * @param	command		the user's command
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
    
    private void printLocationInfo() {
    	System.out.print(this.currentRoom.getLongDescription());
    }
    
    private void look() {
     System.out.println(this.currentRoom.getLongDescription());
    }
}
