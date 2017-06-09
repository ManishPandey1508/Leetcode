/*54. Spiral Matrix
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

import leetcode.utils.ArrayUtills;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		
		List<Integer> res= new SpiralMatrix().new Solution().spiralOrder(matrix);
			System.out.println(res);
//			ArrayUtills.printArray(res.toArray());

	}

	class Solution {
		public List<Integer> spiralOrder(int[][] matrix) {

			List<Integer> res = new ArrayList<>();

			if (matrix.length == 0) {
				return res;
			}

			int rowBegin = 0;
			int rowEnd = matrix.length - 1;
			int colBegin = 0;
			int colEnd = matrix[0].length - 1;

			while (rowBegin <= rowEnd && colBegin <= colEnd) {

				for (int i = colBegin; i <= colEnd; i++) {
					res.add(matrix[rowBegin][i]);
				}
				rowBegin++;

				for (int i = rowBegin; i <= rowEnd; i++) {
					res.add(matrix[i][colEnd]);
				}
				colEnd--;
				if (rowBegin <= rowEnd) {
					for (int i = colEnd; i >= colBegin; i--) {
						res.add(matrix[rowEnd][i]);
					}
				}
				rowEnd--;

				if (colBegin <= colEnd) {
					for (int i = rowEnd; i >= rowBegin; i--) {
						res.add(matrix[i][colBegin]);
					}
				}
				colBegin++;

			}
			return res;
		}
	}
}