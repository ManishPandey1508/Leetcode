// 

//73. Set Matrix Zeroes
//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
package leetcode.arrays;



public class MatrixZeroes {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1, 0 }, { 1, 1, 1, 0 }, { 1, 1, 0, 0 }, { 1, 0, 0, 0 } };
		new MatrixZeroes().new Solution().setZeroes(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				
				System.out.println(matrix[i][j]);
				
			}
		}

	}

	class Solution {
		public void setZeroes(int[][] matrix) {

			boolean fRow = false, fCol = false;

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {

					if (matrix[i][j] == 0) {
						if (i == 0)
							fRow = true;
						if (j == 0)
							fCol = true;
						matrix[0][j] = 0;
						matrix[i][0] = 0;
					}

				}
			}

			for (int i = 1; i < matrix.length; i++) {
				for (int j = 1; j < matrix[0].length; j++) {

					if (matrix[0][j] == 0 || matrix[i][0] == 0) {
						matrix[i][j] = 0;
					}

				}
			}

			if (fRow == true) {
				for (int i = 0; i < matrix[0].length; i++) {

					matrix[0][i] = 0;
				}
			}
			if (fCol == true) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][0] = 0;
				}
			}

		}
	}
}
