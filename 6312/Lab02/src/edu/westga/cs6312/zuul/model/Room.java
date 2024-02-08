package edu.westga.cs6312.zuul.model;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
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

public class Room {
    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
    }

    /**
     * Returns the Room's description
     * @return The description of the room.
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west) {
        if (north != null) {
        	this.northExit = north;
        }
        if (east != null) {
        	this.eastExit = east;
        }
        if (south != null) {
        	this.southExit = south;
        }
        if (west != null) {
        	this.westExit = west;
        }
    }
    
    /**
     * Return the room that is reached if we go from this room in a direction
     * "direction." If there is no room in that direction, return null.
     * @param direction the exit's direction
     * @return the room in the given direction
     */
    public Room getExit(String direction) {
		if (direction.equals("north")) {
			return this.northExit;
		} else if (direction.equals("east")) {
			return this.eastExit;
		} else if (direction.equals("south")) {
			return this.southExit;
		} else if (direction.equals("west")) {
			return this.westExit;
		}
    	return null;	
    }
    
    /**
     * Return a description of the room's exits,
     * for example, "Exits: north west".
     * @return A description of the available exits.
     */
    public String getExitString() {
    	String exitString = "Exits: ";
    	if (this.northExit != null) {
    		exitString += "north ";
    	}
       	if (this.eastExit != null) {
    		exitString += "east ";
    	}
    	if (this.southExit != null) {
    		exitString += "south ";
    	}
    	if (this.westExit != null) {
    		exitString += "west ";
    	}
    	return exitString;
    }
    
    /**
     * Return a long description of this room, of the form:
     * You are in the kitchen.
     * Exits: north west
     * @return A description of the room, including exits.
     */
    public String getLongDescription() {
     return "You are " + this.description + ".\n" + this.getExitString();
    }

}
