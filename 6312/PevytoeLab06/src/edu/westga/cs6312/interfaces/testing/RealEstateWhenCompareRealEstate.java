package edu.westga.cs6312.interfaces.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.interfaces.model.RealEstate;

/**
 * Testing the ability to compare RealEstate
 * 
 * @author William Pevytoe
 * 
 * @version 2/8/2024
 */
class RealEstateWhenCompareRealEstate {

	/**
	 * Testing to check if estate1 is greater than estate2
	 */
	@Test
    public void testCompareToWhenEstimateIsGreater() {
        RealEstate estate1 = new RealEstate("Location A", 1000, 500);
        RealEstate estate2 = new RealEstate("Location B", 2000, 1000);
        assertEquals(-1, estate1.compareTo(estate2));
    }

	/**
	 * Testing to check if estate1 is less than estate2
	 */
	@Test
    public void testCompareToWhenEstimateIsLesser() {
        RealEstate estate1 = new RealEstate("Location A", 1000, 500);
        RealEstate estate2 = new RealEstate("Location B", 200, 100);
        assertEquals(1, estate1.compareTo(estate2));
    }

	/**
	 * Testing to check if estate1 is equal to estate2
	 */
	@Test
    public void testCompareToWhenEstimateIsEqual() {
        RealEstate estate1 = new RealEstate("Location A", 1000, 500);
        RealEstate estate3 = new RealEstate("Location C", 1000, 500);
        assertEquals(0, estate1.compareTo(estate3));
    }
}
