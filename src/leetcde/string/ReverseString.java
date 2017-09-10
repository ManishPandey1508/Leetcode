package leetcde.string;

public class ReverseString {

	public static void main(String[] args) {

		String s = "the sky is blue";

		String res = new ReverseString().new Solution().reverseWords(s);
		System.out.println("---" + res + "----");

	}

	class Solution {
		public String reverseWords(String s) {
			String[] tmp = s.split("\\s");
			StringBuilder sb = new StringBuilder();

			for (int i = 1; i <= tmp.length; i++) {
				if (tmp[tmp.length - i].equals("")) {
					continue;
				}

				sb.append(tmp[tmp.length - i]);
				sb.append(" ");
			}

			return sb.toString().trim();
		}

	}
}
