/*Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.*/
package leetcde.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

	public static void main(String[] args) {

		String num = "234";
		List<String> res = new LetterCombinationOfPhoneNumber().new Solution().letterCombinations(num);
		System.out.println("Result  "+ res);
		
	}

	class Solution {
		public List<String> letterCombinations(String digits) {

			if (digits == null || digits.length() == 0)
				return new ArrayList<String>();

			HashMap<Character, String> mapping = new HashMap<>();

			mapping.put('1', "");
			mapping.put('2', "abc");
			mapping.put('3', "def");
			mapping.put('4', "ghi");
			mapping.put('5', "jkl");
			mapping.put('6', "mno");
			mapping.put('7', "pqrs");
			mapping.put('8', "tuv");
			mapping.put('9', "wxyz");
			// Initialize res with first Value

			ArrayList<String> res = new ArrayList<>();
			char[] temp = mapping.get(digits.charAt(0)).toCharArray();
			for (int i = 0; i < temp.length; i++) {
				res.add(temp[i] + "");
			}

			for (int i = 1; i < digits.length(); i++) {
				temp = mapping.get(digits.charAt(i)).toCharArray();

				ArrayList<String> tempRes = new ArrayList<>();

				for (String string : res) {
					for (int j = 0; j < temp.length; j++) {
						tempRes.add(string + temp[j]);
					}
				}
			res = tempRes;
			}
			return res;
		}
	}
}
