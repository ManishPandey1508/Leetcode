/*You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.*/
package leetcode.dynamicProgramming;

public class ClimbingStairs {

	public static void main(String[] args) {

		int res = new ClimbingStairs().new Solution().climbStairs(4);
		System.out.println("Result " + res);

	}

	class Solution {

		public int climbStairs(int n) {
			int[] sums = new int[n+1];
			sums[0] = 1;
			sums[1] = 1;
			return helper(n, sums);
		}

		public int helper(int n, int[] sums) {	
			if (n == 0 || n == 1)
				return sums[0];
			else {
				for (int i = 2; i <= n; i++) {
					sums[i] = sums[i - 1] + sums[i - 2];
				}
			}
			return sums[n];

		}
	}
}
