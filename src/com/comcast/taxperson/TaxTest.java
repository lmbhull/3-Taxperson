package com.comcast.taxperson;

import static org.junit.Assert.*;
import org.junit.Test;

public class TaxTest {
	@Test
	public void testNegativeCostThrowsException() {
		verifyThrowsException(false, -1);
		verifyThrowsException(true, -1);
	}
	
	@Test
	public void testZeroCostThrowsException() {
		verifyThrowsException(false, 0);
		verifyThrowsException(true, 0);
	}
	
	@Test
	public void testAround50() throws Exception{
		// Edge cases around 50 cents, checking for correct rounding.
		assertEquals(49, TaxPerson.calculateTotalCost(false, 49));
		assertEquals(53, TaxPerson.calculateTotalCost(true, 49));
		assertEquals(51, TaxPerson.calculateTotalCost(false, 50));
		assertEquals(55, TaxPerson.calculateTotalCost(true, 50));
		assertEquals(52, TaxPerson.calculateTotalCost(false, 51));
		assertEquals(56, TaxPerson.calculateTotalCost(true, 51));
	}
	
	@Test
	public void testAround100() throws Exception{
		// Edge cases around 100 cents, checking for correct rounding.
		assertEquals(100, TaxPerson.calculateTotalCost(false, 99));
		assertEquals(108, TaxPerson.calculateTotalCost(true, 99));
		assertEquals(101, TaxPerson.calculateTotalCost(false, 100));
		assertEquals(109, TaxPerson.calculateTotalCost(true, 100));
		assertEquals(102, TaxPerson.calculateTotalCost(false, 101));
		assertEquals(110, TaxPerson.calculateTotalCost(true, 101));
	}
	
	@Test
	public void testLargeAmount() throws Exception{
		assertEquals(10099999, TaxPerson.calculateTotalCost(false, 9999999));
		assertEquals(10899999, TaxPerson.calculateTotalCost(true, 9999999));
	}
		
	@Test
	public void testOtherValues() throws Exception{
		// 40 cents
		assertEquals(40, TaxPerson.calculateTotalCost(false, 40));
		assertEquals(44, TaxPerson.calculateTotalCost(true, 40));
		
		// 61 cents
		assertEquals(62, TaxPerson.calculateTotalCost(false, 61));
		assertEquals(66, TaxPerson.calculateTotalCost(true, 61));
		
		// 62 cents
		assertEquals(63, TaxPerson.calculateTotalCost(false, 62));
		assertEquals(68, TaxPerson.calculateTotalCost(true, 62));
		
		// 500 cents
		assertEquals(505, TaxPerson.calculateTotalCost(false, 500));
		assertEquals(545, TaxPerson.calculateTotalCost(true, 500));
		
		// 1000 cents
		assertEquals(1010, TaxPerson.calculateTotalCost(false, 1000));
		assertEquals(1090, TaxPerson.calculateTotalCost(true, 1000));
		
		// 10000 cents
		assertEquals(10100, TaxPerson.calculateTotalCost(false, 10000));
		assertEquals(10900, TaxPerson.calculateTotalCost(true, 10000));
	}
	
	private void verifyThrowsException(boolean isLuxuryItem, int cost) {
	    try {
			TaxPerson.calculateTotalCost(isLuxuryItem, cost);
			fail("Cost of " +  cost + " should have thrown an exception.");
	    } catch(Exception e) {
	        // Exception occurred as expected.
	    	assertEquals("The cost must be greater than 0", e.getMessage());
	    }
	}
}
