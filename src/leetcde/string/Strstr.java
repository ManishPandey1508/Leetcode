package leetcde.string;

public class Strstr {

	public static void main(String[] args) {

		String h = "aaa";
		String n = "a";
		int res = new Strstr().new Solution().strStr(h, n);
		System.out.println("result " + res);

	}

	class Solution {
		public int strStr(String haystack, String needle) {

			if (needle.length() == 0)
                return 0;

			if (needle.length() > haystack.length())
				return -1;
			int count = -1;

			for (int i = 0; i < haystack.length(); i++) {

				if (haystack.charAt(i) == needle.charAt(0)
						&& haystack.substring(i, haystack.length()).length() >= needle.length()) {
					int j = 0;
					while (j < needle.length() && haystack.charAt(j + i) == needle.charAt(j)) {
						j++;
					}

					if (j == needle.length()) {
						count = i;
						break;
					}
				}

			}
			return count;
		}
	}
}