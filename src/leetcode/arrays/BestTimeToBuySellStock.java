/*121. Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the
maximum profit.
*/

package leetcode.arrays;

public class BestTimeToBuySellStock {

	public static void main(String[] args) {
	int[] prices = {7, 1, 5, 3, 6, 4};
	
	int profit = new BestTimeToBuySellStock().new Solution().maxProfit(prices);

	System.out.println("Max Profit is "+ profit);
	}

	class Solution {
		public int maxProfit(int[] prices) {
			int min = prices[0];
			int profit = 0;

			for (int i = 0; i < prices.length; i++) {
				if (prices[i] < min) {
					min = prices[i];
				} else {

					if((prices[i] - min )> profit){
						profit = prices[i] - min;
					}
				}
			}

			return profit;
		}
	}
}
