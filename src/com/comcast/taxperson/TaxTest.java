package com.comcast.taxperson;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TaxTest {

	@Test
	public void test() {
		// 0 cents
		assertEquals(0, TaxPerson.calculateTotalCost(false, 0));
		assertEquals(0, TaxPerson.calculateTotalCost(true, 0));
		
		// 50 cents
		assertEquals(50, TaxPerson.calculateTotalCost(false, 50));
		assertEquals(54, TaxPerson.calculateTotalCost(true, 50));
		
		// 100 cents
		assertEquals(101, TaxPerson.calculateTotalCost(false, 100));
		assertEquals(109, TaxPerson.calculateTotalCost(true, 100));
		
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
}
