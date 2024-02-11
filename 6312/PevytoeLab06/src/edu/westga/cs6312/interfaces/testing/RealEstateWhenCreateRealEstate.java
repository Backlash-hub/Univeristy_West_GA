package edu.westga.cs6312.interfaces.testing;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.interfaces.model.RealEstate;

/**
 * Testing the RealEstate parameter constructors and toString method
 * 
 * @author William Pevytoe
 * 
 * @version 2/6/2024
 */
class RealEstateWhenCreateRealEstate {

	/**
	 * Testing the RealEstate 3 parameter constructor
	 */
	@Test
	public void testCreateRealEstate3ParamterConstructorWisconsin1850Point05And15000Point5() {
		RealEstate newEstate = new RealEstate("Wisconsin", 1850.05, 15000.50);
		assertEquals("Location: Wisconsin, Land Area: 1850.05 sq ft, Structure Area: 15000.5 sq ft", newEstate.toString());
	}
	
	/**
	 * Testing the RealEstate 3 parameter constructor
	 */
	@Test
	public void testCreateRealEstate3ParamterConstructorOrchardBeach123Point45and789Point12() {
		RealEstate newEstate = new RealEstate("Orchard Beach", 123.45, 789.12);
		assertEquals("Location: Orchard Beach, Land Area: 123.45 sq ft, Structure Area: 789.12 sq ft", newEstate.toString());
	}
	
	/**
	 * Testing the RealEstate 2 parameter constructor
	 */
	@Test
	public void testCreateRealEstate2ParameterConstructorJerkville7500Point89() {
		RealEstate newEstate = new RealEstate("Jerkville", 7500.89);
		assertEquals("Location: Jerkville, Land Area: 7500.89 sq ft, Structure Area: 0.0 sq ft", newEstate.toString());	
	}
	
	/**
	 * Testing the RealEstate 2 parameter constructor
	 */
	@Test
	public void testCreateRealEstate2ParameterConstructorLalaLand15Point00() {
		RealEstate newEstate = new RealEstate("LalaLand", 15.00);
		assertEquals("Location: LalaLand, Land Area: 15.00 sq ft, Structure Area: 0.0 sq ft", newEstate.toString());
	}
	
	/**
	 * Testing the RealEstate 3 parameter constructor with
	 * -1 for structure area
	 */
	@Test
	public void testCreateRealEstateParameterConstructorNegative1StructureArea() {
		assertThrows(IllegalArgumentException.class, () -> {
			new RealEstate("Jerkville", 7500.89, -1);
		});	
	}
	

	
	/**
	 * Testing the RealEstate 2 parameter constructor with null for location
	 * should throw IllegalArgumentException
	 */
	@Test
	public void testCreateRealEstate2ParameterConstructorNullLocation() {
		assertThrows(IllegalArgumentException.class, () -> {
			new RealEstate(null, 15.00);
		});
	}
	
	/**
	 * Testing the RealEstate 2 parameter constructor with 0 for land area
	 * should throw IllegalArgumentException
	 */
	@Test
	public void testCreateRealEstate2ParameterConstructor0LandArea() {
		assertThrows(IllegalArgumentException.class, () -> {
			new RealEstate("JollyWorld", 0);
		});
	}
	
}
