/*We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.*/
package leetcode.dynamicProgramming;

public class GuessTheNoGame {

	public static void main(String[] args) {
		
		int res = new GuessTheNoGame().new Solution().getMoneyAmount(2);
		System.out.println("Result "+ res);
	}

	class Solution {
		public int getMoneyAmount(int n) {
			if (n == 1)
				return 1;
			int[][] arr = new int[n + 1][n + 1];
			int res = helper(arr, 1, n);
			return res;
		}

		public int helper(int[][] arr, int s, int e) {
			if (s >= e)
				return 0;
			if (arr[s][e] != 0) {
				return arr[s][e];
			}
			int res = Integer.MAX_VALUE;
			for (int i = s; i <=e; i++) {
				int temp = i + Math.max(helper(arr, s, i - 1), helper(arr, i + 1, e));
				res = Math.min(res, temp);
			}
			arr[s][e] = res;
			return res;
		}
	}
}
