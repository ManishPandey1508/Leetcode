package leetcde.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {

		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> res = new GroupAnagrams().new Solution().groupAnagrams(strs);
		System.out.println("Result" + res);

	}

	class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {

			HashMap<String, ArrayList<String>> map = new HashMap<>();
			if (strs == null || strs.length == 0)
				return new ArrayList<List<String>>();

			for (int i = 0; i < strs.length; i++) {
				char[] ch = strs[i].toCharArray();
				Arrays.sort(ch);
				String key = String.valueOf(ch);
				if (!map.containsKey(key)) {
					map.put(key, new ArrayList<String>());
				}
				map.get(key).add(strs[i]);
			}

			return new ArrayList<List<String>>(map.values());
		}
	}
}
