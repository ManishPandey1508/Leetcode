 

/*75. Sort Colors
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

*/

package leetcode.arrays;

import leetcode.utils.ArrayUtills;

public class SortColors {

	public static void main(String[] args) {
		 int nums[] = {0, 1,2, 1, 0, 1, 1, 2, 0, 0, 0, 1};
		 
		 new SortColors().new Solution().sortColors(nums);
		 ArrayUtills.printArray(nums);
		 
	}

	class Solution {
		public void sortColors(int[] nums) {

			int low = 0, high = nums.length - 1;
			int mid = 0, temp = 0;
			while (mid <=high) {
				switch (nums[mid]) {
				case 0:
				temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				mid++;
				low++;
					break;
				case 1:
					mid++;
					break;
				case 2:
				temp = nums[high];
				nums[high] = nums[mid];
				nums[mid] = temp;
				high--;
				
					break;
				
				}
			}

		}
	}
}
