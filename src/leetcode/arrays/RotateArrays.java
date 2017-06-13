/*You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

*/
package leetcode.arrays;

public class RotateArrays {

	public static void main(String[] args) {
		

		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		
		new RotateArrays().new Solution().rotate(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.println(matrix[i][j]);
			}
		}

	}

	class Solution {
		public void rotate(int[][] matrix) {

			for (int i = 0; i < matrix.length; i++) {

				for (int j = i; j < matrix[0].length; j++) {

					// after transpose, it will be swap(matrix[i][j],
					// matrix[j][i])

					int temp = matrix[j][i];
					matrix[j][i] = matrix[i][j];
					matrix[i][j] = temp;

				}

			}

			// Then flip the matrix horizontally. (swap(matrix[i][j],
			// matrix[i][matrix.length-1-j])

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length / 2; j++) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[i][matrix.length - 1 - j];
					matrix[i][matrix.length - 1 - j] = temp;
				}
			}

		}
	}
}
