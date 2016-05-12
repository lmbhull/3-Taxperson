package com.comcast.taxperson;

/**
 * 
 * @author Linda Hull
 * Date: 2016-05-11
 * 
 * Calculate the total cost of an item, including tax, based on whether it is considered a necessary 
 * or luxury item: basic necessities tax 1%, luxury item tax 9%. All transactions are measured in cents.
 */
public class TaxPerson {

	private static double NECESSITY_RATE = 0.01;
	private static double LUXURY_RATE = 0.09;
	
	/**
	 * Calculate total cost, given type of item and the cost.
	 * @param isLuxuryItem
	 * @param cost
	 * @return double
	 */
	public static int calculateTotalCost(boolean isLuxuryItem, int cost) {
		double taxRate = 1 + NECESSITY_RATE;
		if (isLuxuryItem) {
			taxRate = 1 + LUXURY_RATE;
		}
		return (int) (cost * taxRate);
	}
}
