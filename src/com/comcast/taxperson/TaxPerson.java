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

	private static float NECESSITY_RATE = 1;
	private static float LUXURY_RATE = 9;
	
	/**
	 * Calculate total cost, given type of item and the cost.
	 * @param isLuxuryItem
	 * @param cost
	 * @return double 
	 */
	public static int calculateTotalCost(boolean isLuxuryItem, int cost) throws Exception{
		if (cost<=0) {
			throw new Exception("The cost must be greater than 0");
		}
		float taxRate = NECESSITY_RATE/100;
		if (isLuxuryItem) {
			taxRate = LUXURY_RATE/100;
		}
		float taxAmount = Math.round(taxRate * cost);
		return (int) (cost + taxAmount);
	}
}
