package leetcode.arrays;

public class BestTimeToBuyAndSellStockTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 100, 180, 260, 310, 40, 535, 695 };
		System.out.println("Max Profits" + new BestTimeToBuyAndSellStockTwo().new Solution().maxProfit(prices));
	}

	class Solution {
		public int maxProfit(int[] prices) {
			if(prices.length == 0){
				return 0;
			}
			
			int min = prices[0];
			int currentProfit = 0;
			int maxProfit = 0;
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] > min && prices[i] > prices[i - 1]) {
					currentProfit = Math.max(currentProfit, prices[i] - min);
				}
				else{
					min = prices[i];
					maxProfit += currentProfit;
					currentProfit = 0 ;
				}
			}
			return maxProfit+ currentProfit;
		}

	}
}
