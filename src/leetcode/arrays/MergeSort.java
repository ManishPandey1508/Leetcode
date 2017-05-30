/*88. Merge Sorted Array
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements 
from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/
package leetcode.arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] nums1 = new int[9];

		nums1[0] = 1;
		nums1[1] = 5;
		nums1[2] = 9;
		nums1[3] = 10;
		nums1[4] = 15;
		int nums2[] = { 2, 3, 8, 13 };
		new MergeSort().new Solution().merge(nums1, 5, nums2, 4);
	}

	class Solution {
		public void merge(int[] nums1, int m, int[] nums2, int n) {

			int i = m - 1;
			int j = n - 1;
			int k = m + n - 1;

			while (i >= 0 && j >= 0) {
				if (nums1[i] >= nums2[j]) {
					nums1[k] = nums1[i];
					i--;
				} else if (nums1[i] < nums2[j]) {
					nums1[k] = nums2[j];
					j--;
				}
				k--;
			}

			while (j >= 0) {

				nums1[k] = nums2[j];
				j--;
				k--;
			}

			for (int k2 = 0; k2 < nums1.length; k2++) {
				System.out.println(nums1[k2]);
			}

		}
	}

}
