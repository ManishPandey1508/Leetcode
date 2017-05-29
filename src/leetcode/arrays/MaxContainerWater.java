/*Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
 * which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.*/

package leetcode.arrays;

public class MaxContainerWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] heights = {1,8, 6, 2, 5, 4, 8, 3, 7};
		int maxArea = new MaxContainerWater().new Solution().maxArea(heights);
		System.out.println("Max Area is "+ maxArea);

	}

	class Solution {
		
		public int maxArea(int[] height) {

			int low = 0;
			int high = height.length - 1;
			int maxArea = 0;
			while (low < high) {
				maxArea = Math.max(maxArea, ((high - low) * (Math.min(height[low], height[high]))));
				if (height[low] < height[high]) {
					low = low + 1;
				} else {
					high = high - 1;
				}

			}
			return maxArea;
		}
	}

}
