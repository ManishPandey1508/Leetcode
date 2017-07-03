package leetcode.dynamicProgramming;

import java.util.ArrayList;

public class TargetSum {

	public static void main(String[] args) {

		int res = new TargetSum().new Solution().findTargetSumWays(new int[] {1000},-1000);
		System.out.println("Result  " + res);

	}

	class Solution {
		public int findTargetSumWays(int[] nums, int target) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<>();
			result.add(new ArrayList<Integer>());

			int sum = 0;
			int count = 0;

			for (int i : nums) {
				sum = sum + i;
			}

			if (target > sum)
				return 0;

			for (int i = 0; i < nums.length; i++) {
				ArrayList<ArrayList<Integer>> temp = new ArrayList<>();

				for (ArrayList<Integer> existSet : result) {
					temp.add(new ArrayList(existSet));
				}

				for (ArrayList<Integer> newSet : temp) {
					System.out.println(newSet);
					newSet.add(nums[i]);
				}
				result.addAll(temp);

			}

			for (ArrayList<Integer> p : result) {
				int localSum = 0;
				for (Integer sumP : p) {
					localSum = sumP + localSum;
				}
				if(2*localSum == target+sum){
				count++;	
				}
			}			
			System.out.println(result);
			return count;
		}
	}
}
