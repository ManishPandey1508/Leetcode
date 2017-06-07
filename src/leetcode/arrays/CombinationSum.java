/*39. Combination Sum
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/
package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		
		int[] candidates = {2, 3, 6, 7};
		
		List<List<Integer>> list  = new CombinationSum().new Solution().combinationSum(candidates, 7);
		 
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
					tempList.add(candidates[i]);
					backtrackCobination(list, tempList, candidates,remain-candidates[i],i );
					tempList.remove(tempList.size() - 1);
				}
			}
			
		}

	}

}
