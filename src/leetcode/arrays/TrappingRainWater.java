/*42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

*/

package leetcode.arrays;

import java.util.Stack;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int MaxWater = new TrappingRainWater().new Solution().trap(height);
		System.out.println("maxWater" + MaxWater);
	}

	class Solution {
		public int trap(int[] height) {
			if (height == null || height.length <= 1) {
				return 0;
			}
			Stack<Integer> stack = new Stack<Integer>();
			int i = 0, maxWater = 0, maxBotWater = 0;
			while (i < height.length) {
				if (stack.isEmpty() || height[stack.peek()] > height[i]) {
					stack.push(i++);
				} else {
					int bot = stack.pop();
					if (stack.isEmpty())
						maxBotWater = 0;
					else {
						maxBotWater = (Math.min(height[i], height[stack.peek()]) - height[bot])
								* (i - stack.peek() - 1);
					}
					maxWater += maxBotWater;
				}

			}

			return maxWater;
		}
	}

}
