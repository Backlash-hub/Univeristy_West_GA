package edu.westga.cs6312.mileage.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.mileage.model.Odometer;

class OdometerWhenCreateOdometer {

	@Test
	public void test0ParameterConstructorShouldHaveMileage0000() {
		Odometer theOdometer = new Odometer();
		assertEquals("Odometer with mileage 000.0", theOdometer.toString());
	}
	
	 @Test
	    public void test4ParameterConstructorShouldHaveMileage1234() {
	        Odometer theOdometer = new Odometer(1, 1, 1, 1);
	        assertEquals("Odometer with mileage 111.1", theOdometer.toString());
	    }

	    @Test
	    public void test4ParameterConstructorShouldHaveMileage9999() {
	        Odometer theOdometer = new Odometer(9, 9, 9, 9);
	        assertEquals("Odometer with mileage 999.9", theOdometer.toString());
	    }
	    
	    @Test
	    public void test4ParameterConstructorShouldHaveMileage() {
	        Odometer theOdometer = new Odometer(3, 4, 5, 6);
	        assertEquals("Odometer with mileage 345.6", theOdometer.toString());
	    }

}
