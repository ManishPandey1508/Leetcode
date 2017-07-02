/*Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*/
package leetcde.string;

import java.util.HashMap;

public class LongestSubString {

	public static void main(String[] args) {

		String s = "dvdf";
		int res = new LongestSubString().new Solution().lengthOfLongestSubstring(s);
		System.out.println("Result " + res);

	}

	class Solution {
		public int lengthOfLongestSubstring(String s) {

			if (s == null || s.length() == 0)
				return 0;

			HashMap<Character, Integer> stringTrack = new HashMap<>();

			int len = s.length();

			int max = 0;

			for (int i = 0, j = 0; i < len; i++) {
				if (stringTrack.containsKey(s.charAt(i))) {
					j = Math.max(j, stringTrack.get(s.charAt(i)) + 1);
				}
				stringTrack.put(s.charAt(i), i);
				max = Math.max(max, i - j + 1);

			}
			return max;
		}
	}
}
