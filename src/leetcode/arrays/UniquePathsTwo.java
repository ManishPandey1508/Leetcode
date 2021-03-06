/* 
63. Unique Paths II
 * 
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
		The total number of unique paths is 2.

		Note: m and n will be at most 100.*/

package leetcode.arrays;

public class UniquePathsTwo {

	public static void main(String[] args) {
		
		int[][] obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
		
		int res = new UniquePathsTwo().new Solution().uniquePathsWithObstacles(obstacleGrid);
		System.out.println("Result "+ res);

	}

	class Solution {
		public int uniquePathsWithObstacles(int[][] obstacleGrid) {

			if (obstacleGrid.length == 0)
				return 0;

			int row = obstacleGrid.length;
			int col = obstacleGrid[0].length;

			for (int i = 0; i < row; i++) {

				for (int j = 0; j < col; j++) {
	                if(obstacleGrid[i][j] == 1)
	                    obstacleGrid[i][j] = 0;
	                else if(i == 0 && j == 0)
	                    obstacleGrid[i][j] = 1;
	                else if(i == 0)
	                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] ;// For row 0, if there are no paths to left cell, then its 0,else 1
	                else if(j == 0)
	                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] ;// For col 0, if there are no paths to upper cell, then its 0,else 1
	                else
	                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];}
			}

		return obstacleGrid[row-1][col -1];
		}
	}
}
