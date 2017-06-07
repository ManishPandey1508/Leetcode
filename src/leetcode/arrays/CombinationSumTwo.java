/*40. Combination Sum II
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]*/
package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {

	public static void main(String[] args) {

		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };

		List<List<Integer>> list = new CombinationSumTwo().new Solution().combinationSum(candidates, 8);

		System.out.println(list);

	}

	class Solution {
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			List<List<Integer>> list = new ArrayList();

			Arrays.sort(candidates);

			backtrackCobination(list, new ArrayList<>(), candidates, target, 0);

			return list;
		}

		public void backtrackCobination(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain,
				int start) {
			if (remain < 0)
				return;
			if (remain == 0)
				list.add(new ArrayList<>(tempList));
			else {
				for (int i = start; i < candidates.length; i++) {
					if (i > start && candidates[i] == candidates[i - 1])
						continue; // skip duplicates
					tempList.add(candidates[i]);
					backtrackCobination(list, tempList, candidates, remain - candidates[i], i + 1);
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	}
}
