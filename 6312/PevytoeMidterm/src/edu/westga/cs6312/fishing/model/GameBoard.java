package edu.westga.cs6312.fishing.model;

/**
 * This will keep track of the state of the game
 * 
 * @author William Pevytoe
 * 
 * @version 2/14/2024
 */
public class GameBoard {
	private FishingHole[] fishingHoles;
	private Angler theFisher;
	private int currentLocation;
	
	/**
	 * 0 - Parameter constructor that sets up the game board
	 */
	public GameBoard() {
	      this.setUpFishingHoles();
	      
	}
	
	private void setUpFishingHoles() {
		this.theFisher = new Angler();
		this.currentLocation = 0;
		this.fishingHoles = new FishingHole[10];
        for (int position = 0; position < this.fishingHoles.length; position++) {
            this.fishingHoles[position] = new FishingHole(position);
		}
	}
	
	/**
	 * Getter method for the Angler object
	 * 
	 * @return the Angler object
	 */
	public Angler getAngler() {
		return this.theFisher;
	}
	
	/**
	 * Getter method for the current angler location
	 * 
	 * @return the current hole location for the Angler
	 */
	public FishingHole getFishingHoleLocation() {
		return this.fishingHoles[this.currentLocation];
		
	}
	
	/**
	 * String that represents the GameBoard Object
	 * 
	 * @return string that represents the GameBoard Object
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
        builder.append("GameBoard:\n");
        for (FishingHole hole : this.fishingHoles) {
            builder.append(hole.toString()).append("\n");
        }
        builder.append("\nThe Angler has: " + this.theFisher.toString()).append("\n");
        return builder.toString();
	}
	
	/**
	 * Move the Angler to the next fishing hole UP (position 0 being top)
	 */
	public void moveUp() {
		if (this.currentLocation == 0) {
			this.currentLocation = this.fishingHoles.length - 1;
		} else {
			this.currentLocation--;
		}
	}
	
	/**
	 * Move the Angler to the next fishing hold down (negative position 0 bing top)
	 */
	public void moveDown() {
        if (this.currentLocation == this.fishingHoles.length - 1) {
            this.currentLocation = 0;
        } else {
            this.currentLocation++;
        }		
	}
	
	/**
	 * Allows the Angler to fish in the current location
	 */
	public void fishInCurrentLocation() {
		FishingHole currentLocation = this.fishingHoles[this.currentLocation];
		currentLocation.toFish(this.theFisher);
	}
}
