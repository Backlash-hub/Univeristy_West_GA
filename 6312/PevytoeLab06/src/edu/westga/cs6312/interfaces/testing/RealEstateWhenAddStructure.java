package edu.westga.cs6312.interfaces.testing;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.interfaces.model.RealEstate;

/**
 * Testing added a structure to a real estate property
 * 
 * @author William Pevytoe
 * 
 * @version 2/6/2024
 */
class RealEstateWhenAddStructure {
	
	/**
	 * Testing adding a structure to property
	 */
	@Test
	public void testAddingA3000Point95SqFtStructureToAPropert() {
		RealEstate newEstate = new RealEstate("Texas", 200.55);
		newEstate.buildStructure(3000.88);
		assertEquals("Location: Texas, Land Area: 200.55 sq ft, Structure Area: 3000.88 sq ft", newEstate.toString());
	}
	
	/**
	 * Testing adding a structure to property
	 */
	@Test
	public void testAddingA700Point88SqFtStructureToAPropert() {
		RealEstate newEstate = new RealEstate("JollyTown", 999999.99);
		newEstate.buildStructure(999999);
		assertEquals("Location: JollyTown, Land Area: 999999.99 sq ft, Structure Area: 999999.0 sq ft", newEstate.toString());
	}
	
	/**
	 * Testing adding a structure to property
	 */
	@Test
	public void testAddingA1Point1SqFtStructureToAPropert() {
		RealEstate newEstate = new RealEstate("JollyTown", 1.1);
		newEstate.buildStructure(1.1);
		assertEquals("Location: JollyTown, Land Area: 1.10 sq ft, Structure Area: 1.1 sq ft", newEstate.toString());
	}
	
	/**
	 * Testing adding a structure of negative value to property
	 * expecting a IllegalArgumentException error
	 */
	@Test
	public void testAddingANegative500SqFtStructureToAProperty() {
		assertThrows(IllegalArgumentException.class, () -> {
		RealEstate newEstate = new RealEstate("Frankfort", 9999.98);
		newEstate.buildStructure(-500);
		});				
	}
}
