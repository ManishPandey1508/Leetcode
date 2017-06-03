/* 

33. Search in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.*/
package leetcode.arrays;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int[] nums = {1,3};
		int found = new SearchInRotatedSortedArray().new Solution().search(nums, 3	);
		System.out.println("Found is " + found);

	}

	class Solution {
		public int search(int[] nums, int target) {

			int pivot = 0;
			if(nums.length == 0){
			    return -1;
			}
			if(nums.length == 1){
			    if(nums[0]== target)
			    	return 0;
			    else 
			    	return -1;
			}
			
			// Finding the pivot point
			for (int i = 1; i < nums.length; i++) {

				if (nums[i] < nums[i - 1]) {
					pivot = i;
					break;
				}

			}
			int found = -1;

			System.out.println("Pivot is " + pivot);
			// Do the binary search in both part... as both are sorted.
			found = binarySearch(nums, pivot, nums.length, target);

			if (found == -1)
				found = binarySearch(nums, 0, pivot, target);

			return found;

		}

		public int binarySearch(int[] sortedArray, int start, int end, int key) {

			if (start < end) {
				int mid = start + (end - start) / 2;
				if (key < sortedArray[mid]) {
					return binarySearch(sortedArray, start, mid, key);

				} else if (key > sortedArray[mid]) {
					return binarySearch(sortedArray, mid + 1, end, key);

				} else {
					return mid;
				}
			}
			return -1;
		}

	}
}
