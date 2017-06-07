package leetcode.arrays;

import java.util.Stack;

public class LargestRectangleHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1};
		int area = new LargestRectangleHistogram().new Solution().maxArea(nums);
		System.out.println("Area is "+ area);
	}

	class Solution {
		int h;
		int pos;
		int areaMax;
		int tempH;
		int tempP;
		int tempArea;
		// To store Heights
		Stack<Integer> hstack = new Stack<Integer>();

		// To Store Positions
		Stack<Integer> pstack = new Stack<Integer>();

		public int maxArea(int[] height) {

			for (int i = 0; i < height.length; i++) {
				// Push to position stack and Height stack if incoming height is
				// more than top most
				// element of height stack
				if (hstack.isEmpty() || height[i] > hstack.peek()) {
					hstack.push(height[i]);
					pstack.push(i);
				} // If height is less than top value of Height Stack pop all
					// positions and height greater than incoming height and
					// position
				else if (height[i] < hstack.peek()) {
					while (!hstack.isEmpty() && height[i] < hstack.peek()) {
						tempH = hstack.pop();
						tempP = pstack.pop();
						tempArea = tempH * (i - tempP);
						areaMax = Math.max(tempArea, areaMax);
					}

					hstack.push(height[i]);
					pstack.push(tempP);

				}				
			}
			while (!hstack.isEmpty()){
				tempH = hstack.pop();
				tempP = pstack.pop();
				tempArea = tempH * (height.length - tempP);
				areaMax = Math.max(tempArea, areaMax);
			}
			
			return areaMax;

		}

	}
}
