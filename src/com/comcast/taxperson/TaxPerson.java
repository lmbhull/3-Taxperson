package com.comcast.taxperson;

import java.text.DecimalFormat;

/**
 * 
 * @author lindahull
 * Date: 2016-05-11
 * 
 * Calculate the total cost of an item, including tax, based on whether it is considered a necessary 
 * or luxury item: basic necessities tax 1%, luxury item tax 9%. All transactions are measured in cents.
 */
public class TaxPerson {

	public static void main(String[] args) {
		testBothItemTypes(0.00);
		
	}

	private static double necessityRate = 0.01;
	private static double luxuryRate = 0.09;
	
	/**
	 * Calculate total cost, given type of item and the cost.
	 * @param isLuxuryItem
	 * @param cost
	 * @return double
	 */
	public static double calculateTotalCost(boolean isLuxuryItem, double cost) {
		
		double taxRate = 1 + necessityRate;
		if (isLuxuryItem) {
			taxRate = 1 + luxuryRate;
		}
		return (cost * taxRate);
	}
	
	public static void testBothItemTypes(double cost) {
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("Given cost of $" + df.format(cost));
		System.out.println("Total cost=$" + df.format(calculateTotalCost(true, cost)));
		System.out.println("Total cost=$" + df.format(calculateTotalCost(false, cost)));
	}
}
