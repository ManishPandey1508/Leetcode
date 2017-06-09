/*64. Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes
the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
package leetcode.arrays;

public class MinPathSum {

	public static void main(String[] args) {
		
		int[][] grid = {{1,2,3},{4,8,2},{1,5,3}};
		int minPathSum = new MinPathSum().new Solution().minPathSum(grid);
		System.out.println("Minimum Path Sum "+ minPathSum);

	}

	class Solution {
		public int minPathSum(int[][] grid) {

			for (int i = 0; i < grid.length; i++) {// Rows

				for (int j = 0; j < grid[0].length; j++) {// Columns

					if (i == 0 && j != 0) {

						grid[i][j] = grid[i][j] + grid[i][j - 1];

					} else if (i != 0 && j == 0) {
						
						grid[i][j] = grid[i][j]+grid[i-1][j];
						
					} else if (i != 0 && j != 0) {
						grid[i][j] = grid[i][j]+Math.min(grid[i][j-1],grid[i-1][j]);
					} else {
						grid[i][j]=grid[i][j];
					}
				}

			}

		return grid[grid.length -1][grid[0].length -1];
		}
	}
}
