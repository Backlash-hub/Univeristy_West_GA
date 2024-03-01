package edu.westga.cs6312.files.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.RealEstate;
import edu.westga.cs6312.files.model.RealEstateManager;

/**
 * Testing the RealEstateManager addProperty
 * 
 * @author William Pevytoe
 * 
 * @version 2/28/2024
 */
class RealEstateManagerAddProperty {

	/**
	 * Test the add property with zero properties
	 */
	@Test
	public void testRealEstateManagerWithZeroProperties() {
		RealEstateManager manager = new RealEstateManager();
		 assertThrows(NullPointerException.class, () -> manager.addProperty(null));
	}
	
	/**
	 * Test the add property with one property 
	 */
	@Test
	public void testRealEstateManagerAddOneProperty() {
		RealEstateManager manager = new RealEstateManager();
		RealEstate estate = new RealEstate("Location A", 10000, 2000);
		manager.addProperty(estate);
		assertEquals("Estate location: [ Location A ] Estate land area: [ 10000 ] Estate structure"
		+ " area: [ 2000 ]\n", manager.toString());
	}
	
	/**
	 * Test the add property with two property 
	 */
	@Test
	public void testRealEstateManagerAddTwoProperty() {
		RealEstateManager manager = new RealEstateManager();
		RealEstate estate1 = new RealEstate("Location A", 10000, 2000);
		RealEstate estate2 = new RealEstate("Location B", 500, 100);
		manager.addProperty(estate1);
		manager.addProperty(estate2);
		assertEquals("Estate location: [ Location A ] Estate land area: [ 10000 ] Estate structure"
		+ " area: [ 2000 ]\n"
		+ "Estate location: [ Location B ] Estate land area: [ 500 ] Estate structure"
		+ " area: [ 100 ]\n", manager.toString());
	}
}
