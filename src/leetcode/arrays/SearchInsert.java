/*Given a sorted array and a target value, return the index if the target is found. If not, return the index 
 * where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0*/

package leetcode.arrays;

public class SearchInsert {

	public static void main(String[] args) {

		int[] nums = { 1, 3, 5, 6 };

		int index = new SearchInsert().new Solution().searchInsert(nums, 0);

		System.out.println("Index is "+ index);
		
	}

	class Solution {
		public int searchInsert(int[] nums, int target) {

			int index =  binarySearch(nums, 0, nums.length-1, target);
			
			
			return index;
			
			
		}

		public int binarySearch(int[] nums, int low, int high, int val) {
			if (high >= low) {
				int mid = low + (high - low) / 2;

				// If the element is present at the middle itself
				if (nums[mid] == val)
					return mid;

				// If element is smaller than mid, then it can only be present
				// in left subarray
				if (nums[mid] > val)
					return binarySearch(nums, low, mid - 1, val);

				// Else the element can only be present in right subarray
				return binarySearch(nums, mid + 1, high, val);
			}

			// if We reach here means element is not present in array
			return low;

		}

	}

}