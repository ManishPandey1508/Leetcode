/*62. Unique Paths
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.*/

package leetcode.arrays;

public class UniquePaths {

	public static void main(String[] args) {
		
		int m = 3,n =3;
		
		int res = new UniquePaths().new Solution().uniquePaths(m, n);
		
		System.out.println("Total Unique Path from Top Left to Bottom right is :  "+res);
		

	}

	class Solution {
		public int uniquePaths(int m, int n) {
			int[][] res = new int[m][n];

			for (int i = 0; i < m; i++) {

				for (int j = 0; j < n; j++) {
					// Initialize first row and first column with 1 
					if(i==0 || j==0){
						res[i][j] =1;
					}
					else{
						res[i][j]= res[i][j-1]+res[i-1][j];
					}
				}

			}
			return res[m-1][n-1];
		}
	}
}
