/*You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 1, c = 4
Output: 
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
Example 2:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 2, c = 4
Output: 
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.*/

package leetcode.arrays;

public class ReshapeMatrix {

	public static void main(String[] args) {
		
		//int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		
		int[][] nums = {{1,2},{3,4}};
		int[][] res = new ReshapeMatrix().new Solution().matrixReshape(nums,4,1);
		
		
		System.out.println("ROW No "+ res.length);
		System.out.println("Columns  No "+ res[0].length);
		
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				
				System.out.println(res[i][j]);
			}
		}
		

	}

	class Solution {
		public int[][] matrixReshape(int[][] nums, int r, int c) {

			int m = nums.length;
			int n = nums[0].length;
			if (m * n != r * c) {
				return nums;
			}
			
			int row = 0;
			int col = 0;

			int[][] result = new int[r][c];

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					result[row][col] = nums[i][j];
					col++;
					 if(col==c){
						 row ++;
						 col =0;
					 }
					 
				}

			}
			return result;
		}
	}

}
