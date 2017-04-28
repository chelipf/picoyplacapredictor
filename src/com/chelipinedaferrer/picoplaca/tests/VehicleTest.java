package com.chelipinedaferrer.picoplaca.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.chelipinedaferrer.picoplaca.entities.Vehicle;

@RunWith(Parameterized.class)
public class VehicleTest {
	Vehicle vehicle;
	
    @Parameter(0)
    public String plateNumber;
    @Parameter(1)
    public int lastPlateNumber;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { "AAA-2233", 3 }, { "ZZZ-9999", 9 }, { "PCO-8631", 1 }, { "XYB-661", 1 } };
        return Arrays.asList(data);
    }
    
	@Before
	public void setUp() throws Exception {
		vehicle = new Vehicle();
		vehicle.setPlateNumber(plateNumber);
	}

	@Test
	public void testGetLastPlateNumber() {		
		int lastNumber = vehicle.getLastPlateNumber();
		assertTrue(0<= lastNumber && lastNumber <=9);
	}

	@Test
	public void testSetPlateNumber() {
		assertTrue(Vehicle.isPlateNumber(vehicle.getPlateNumber()));
		assertEquals(plateNumber, vehicle.getPlateNumber());
		assertEquals(lastPlateNumber, vehicle.getLastPlateNumber());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetPlateNumberException() {
		vehicle.setPlateNumber("XXXX-000");
	}
}
