package leetcode.arrays;
/*118. Pascal's Triangle
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pascalsTriangle {

	public static void main(String[] args) {

		List<List<Integer>> res = new pascalsTriangle().new Solution().generate(5);
		
		  System.out.println(Arrays.asList(res));	
	}

	class Solution {
		public List<List<Integer>> generate(int numRows) {
			List<List<Integer>> allrows = new ArrayList<>();
			List<Integer> row = null, pre = null;
			for (int i = 0; i < numRows; ++i) {
				row = new ArrayList<>();
				for (int j = 0; j <= i; ++j) {

					if (j == 0 || j == i) {
						row.add(1);
					} else {
						row.add(pre.get(j-1) + pre.get(j));
					}
				}
				pre = row;
				allrows.add(row);
			}
			return allrows;
		}
	}
}
