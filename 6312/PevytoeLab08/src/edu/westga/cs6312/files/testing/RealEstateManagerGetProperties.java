package edu.westga.cs6312.files.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.RealEstate;
import edu.westga.cs6312.files.model.RealEstateManager;

/**
 * Testing the RealEstateManager getProperties
 * 
 * @author William Pevytoe
 * 
 * @version 2/28/2024
 */
class RealEstateManagerGetProperties {

	/**
	 * Testing the getProperties method with 1 estate
	 */
	@Test
	public void testRealEstateManagerGetPropertiesWtihOneEstates() {
		RealEstateManager manager = new RealEstateManager();
        RealEstate estate1 = new RealEstate("Location1", 10000, 2000);
        manager.addProperty(estate1);
        assertEquals(1, manager.getProperties().size());
        assertEquals(estate1, manager.getProperties().get(0));
    
	}
	
	/**
	 * Testing the getProperties method with 2 estates
	 */
	@Test
	public void testRealEstateManagerGetPropertiesWtihTwoEstates() {
		RealEstateManager manager = new RealEstateManager();
        RealEstate estate1 = new RealEstate("Location1", 10000, 2000);
        RealEstate estate2 = new RealEstate("Location2", 20000, 3000);
        manager.addProperty(estate1);
        manager.addProperty(estate2);
        assertEquals(2, manager.getProperties().size());
        assertEquals(estate1, manager.getProperties().get(0));
        assertEquals(estate2, manager.getProperties().get(1));
	}
}
