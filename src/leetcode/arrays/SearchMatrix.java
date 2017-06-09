/*74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

*/

package leetcode.arrays;

public class SearchMatrix {

	public static void main(String[] args) {

		int[][] matrix = {
		           {1,   3,  5,  7},
		           {10, 11, 16, 20},
		           {23, 30, 34, 50}
		};
		
		boolean found = new SearchMatrix().new Solution().searchMatrix(matrix, 3);
		
		System.out.println("Found : "+ found);
		
	}

	class Solution {
		public boolean searchMatrix(int[][] matrix, int target) {
			
			if(matrix.length ==0)return false;

			int row_num = matrix.length;
			int col_num = matrix[0].length;

			int begin = 0, end = (row_num * col_num) - 1;

			while (begin <= end) {
				int mid = (begin + end) / 2;
				int mid_value = matrix[mid / col_num][mid % col_num];
				if (mid_value == target) {
					return true;
				} else if (mid_value > target) {
					end = mid - 1;
				} else {
					begin = mid + 1;
				}
			}
		return false;
		}
	}

}
