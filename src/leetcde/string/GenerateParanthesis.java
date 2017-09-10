package leetcde.string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	public static void main(String[] args) {

		int n = 9;

		List<String> res = new GenerateParanthesis().new Solution().generateParenthesis(n);
		System.out.println("Result  " + res);
	}

	class Solution {
		public List<String> generateParenthesis(int n) {

			List<List<String>> lists = new ArrayList<>();
			ArrayList<String> temp1 = new ArrayList<>();
			temp1.add("");
			lists.add(temp1);

			for (int i = 1; i <= n; i++) {
				ArrayList<String> temp = new ArrayList<String>();

				for (int j = 0; j < i; j++) {

					for (String first : lists.get(j)) {

						for (String last : lists.get(i - j - 1)) {
							temp.add("(" + first + ")" + last);
						}

					}

				}
				lists.add(temp);
			}

			return lists.get(lists.size() - 1);
		}
	}

}
